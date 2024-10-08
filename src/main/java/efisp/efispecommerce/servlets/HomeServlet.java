package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.DepartmentController;
import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductController productController = new ProductController();
        DepartmentController departmentController = new DepartmentController();

        List<ProductDTO> products = new LinkedList<>(productController.getAll());
        List<DepartmentDTO> departments = new LinkedList<>(departmentController.getAll());

        String department = req.getParameter("department");
        String search = req.getParameter("search");

        if (department != null && !department.isEmpty()) {
            DepartmentDTO departmentDTO = departmentController.getByName(department);
            if (departmentDTO != null) {
                products = new LinkedList<>(productController.getByDepartment(departmentDTO.name()));
            }
        }

        if (search != null && !search.trim().isEmpty()) {
            LinkedList<ProductDTO> filteredProducts = new LinkedList<>();
            for (ProductDTO product : products) {
                if (product.name().toUpperCase().contains(search.toUpperCase()) ||
                        product.brand().toUpperCase().contains(search.toUpperCase())) {
                    filteredProducts.add(product);
                }
            }
            products = filteredProducts;
        }

        req.setAttribute("search", search);
        req.setAttribute("products", products);
        req.setAttribute("department", department);
        req.setAttribute("departments", departments);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }


}
