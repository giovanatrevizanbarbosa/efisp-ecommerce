package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.ItemController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
        System.out.println(cartDTO);
        if(cartDTO != null){
            ItemController itemController = new ItemController();
            List<ItemDTO> cartItems = itemController.getItemsByCartId(cartDTO.id());

            req.setAttribute("cart", cartDTO);
            req.setAttribute("cartItems", cartItems);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/cart.jsp");
        dispatcher.forward(req, resp);
    }
}
