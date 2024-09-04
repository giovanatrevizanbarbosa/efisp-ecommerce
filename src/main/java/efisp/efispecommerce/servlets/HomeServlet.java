package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    ProductController productController;

    public HomeServlet() {
        productController = new ProductController();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productController.getAll();
        String search = req.getParameter("search");

        if (search != null) {
            if (!search.trim().isEmpty()) {
                products = products.stream()
                        .filter(product -> product.name().toUpperCase().contains(search.toUpperCase()) ||
                                product.brand().toUpperCase().contains(search.toUpperCase()))
                        .toList();
            }
        }
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }
}
