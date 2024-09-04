package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.ProductController;
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductController controller = new ProductController();
        LinkedList<ProductDTO> products = new LinkedList<>(controller.getAll());

        req.setAttribute("products", products);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }
}
