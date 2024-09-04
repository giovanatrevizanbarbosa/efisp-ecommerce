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

        LinkedList<ProductDTO> products = new LinkedList<>(productController.getAll());
        LinkedList<DepartmentDTO> departments = new LinkedList<>(departmentController.getAll());

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

        req.setAttribute("search", search);
        req.setAttribute("products", products);
        req.setAttribute("departments", departments);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }
}
