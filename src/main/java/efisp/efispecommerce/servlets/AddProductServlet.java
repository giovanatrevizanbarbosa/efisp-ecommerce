package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.BrandController;
import efisp.efispecommerce.controllers.DepartmentController;
import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.ImageUploader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentController departmentController = new DepartmentController();
        BrandController brandController = new BrandController();

        req.setAttribute("departments", departmentController.getAll());
        req.setAttribute("brands", brandController.getAll());


        req.getRequestDispatcher("/pages/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        AdmDTO admDTO = (AdmDTO) session.getAttribute("admin");

        DepartmentController departmentController = new DepartmentController();
        BrandController brandController = new BrandController();
        ProductController productController = new ProductController();

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String departmentId = req.getParameter("department");
        String brandId = req.getParameter("brand");
        int stock = Integer.parseInt(req.getParameter("quantity"));

        String imagePath;
        try {
            Part filePart = req.getPart("photo");
            imagePath = ImageUploader.upload(req, filePart, "products");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        DepartmentDTO departmentDTO = departmentController.getById(UUID.fromString(departmentId));
        BrandDTO brandDTO = brandController.getById(UUID.fromString(brandId));

        ProductDTO productDTO = new ProductDTO(UUID.randomUUID(), name, Double.parseDouble(price), brandDTO.name(), description ,departmentDTO.name(), stock, imagePath);

        if(productController.add(productDTO, admDTO)){
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/add-product.jsp").forward(req, resp);
        }

    }
}
