package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.DepartmentController;
import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

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

        String search = req.getParameter("search");

        if (search != null) {
            if (!search.trim().isEmpty()) {
                products = products.stream()
                        .filter(product -> product.name().toUpperCase().contains(search.toUpperCase()) ||
                                product.brand().toUpperCase().contains(search.toUpperCase()))
                        .toList();
            }
        }

        req.setAttribute("search", search);
        req.setAttribute("products", products);
        req.setAttribute("departments", departments);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }
}
