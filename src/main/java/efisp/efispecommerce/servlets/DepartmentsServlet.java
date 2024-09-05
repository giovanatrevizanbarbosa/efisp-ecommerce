package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.DepartmentController;
import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/departments")
public class DepartmentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deparmentName = req.getParameter("name");
        ProductController productController = new ProductController();
        DepartmentController departmentController = new DepartmentController();

        DepartmentDTO departmentDTO = departmentController.getByName(deparmentName);

        if(departmentDTO != null) {
            List<ProductDTO> products = new LinkedList<>(productController.getByDepartment(departmentDTO.name()));

            String search = req.getParameter("search");

            if (search != null) {
                if (!search.trim().isEmpty()) {
                    LinkedList<ProductDTO> list = new LinkedList<>();
                    for (ProductDTO product : products) {
                        if (product.name().toUpperCase().contains(search.toUpperCase()) ||
                                product.brand().toUpperCase().contains(search.toUpperCase())) {
                            list.add(product);
                        }
                    }
                    products = list;
                }
            }

            req.getRequestDispatcher("/pages/department.jsp").forward(req, resp);

            req.setAttribute("search", search);
            req.setAttribute("products", products);
            req.setAttribute("department", departmentDTO);
        }

        req.getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
