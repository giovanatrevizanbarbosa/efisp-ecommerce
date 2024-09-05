package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.ItemController;
import efisp.efispecommerce.dto.ItemDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/remove-item")
public class RemoveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UUID itemId = UUID.fromString(req.getParameter("itemId"));

        ItemController itemController = new ItemController();
        ItemDTO itemDTO = itemController.getItemById(itemId);

        if(itemDTO != null){
            CartController cartController = new CartController();
            cartController.removeItemFromCart(itemDTO);


            session.setAttribute("cart", cartController.getCartById(itemDTO.cartId()));
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
