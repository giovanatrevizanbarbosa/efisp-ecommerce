package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.dto.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/add-item")
public class AddItemToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UUID productId = UUID.fromString(req.getParameter("id"));
        ProductController productController = new ProductController();

        ProductDTO productDto = productController.get(productId);

        if (productDto != null) {
            CartDTO cartDto = (CartDTO) session.getAttribute("cart");
            if (cartDto != null) {
                CartController cartController = new CartController();

                ItemDTO itemDto = new ItemDTO(UUID.randomUUID(), productDto, cartDto.id(), 1);
                if(cartController.addItemToCart(itemDto)){
                    cartDto = cartController.getCartById(cartDto.id());
                    session.setAttribute("cart", cartDto);
                    req.getRequestDispatcher("/cart").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("result", "addItemToCartError");
        }
        req.getRequestDispatcher("/cart").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}