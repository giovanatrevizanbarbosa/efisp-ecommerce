package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.ItemController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        CartController cartController = new CartController();

        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");

        ItemController itemController = new ItemController();
        List<ItemDTO> cartItems = itemController.getItemsByCartId(cartDTO.id());
        cartDTO = cartController.getCartById(cartDTO.id());

        double subtotal = cartDTO.totalPrice();
        double shipping = Double.parseDouble(String.format(Locale.US,"%.2f", subtotal * 0.1));
        double total = subtotal + shipping;

        session.setAttribute("subtotal", subtotal);
        session.setAttribute("shipping", shipping);
        session.setAttribute("total", total);

        req.setAttribute("cart", cartDTO);
        req.setAttribute("cartItems", cartItems);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/cart.jsp");
        dispatcher.forward(req, resp);
    }
}
