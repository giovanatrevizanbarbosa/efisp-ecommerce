package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID productId = UUID.fromString(req.getParameter("id"));
        ProductController productController = new ProductController();

        ProductDTO productDto = productController.get(productId);

        if (productDto != null) {
            req.setAttribute("product", productDto);
            req.getRequestDispatcher("/pages/product-details.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/cart").forward(req, resp);
        }
    }
}
