package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.ItemController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.EmailSender;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserDTO user = (UserDTO) session.getAttribute("user");
        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");

        ItemController itemController = new ItemController();
        List<ItemDTO> cartItems = itemController.getItemsByCartId(cartDTO.id());

        String items = "";
        for (ItemDTO item : cartItems) {
             items += "Produto: " + item.productDTO().name() + "\n"
                    + "Quantidade: " + item.quantity() + "\n"
                    + "Preço: " + item.productDTO().price() + "\n";
        }

        if(user != null) {
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(user.email(), "E-fisp - Pedido realizado com sucesso!", items);
        }
        req.getRequestDispatcher(req.getContextPath() + "/home").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/checkout.jsp");
        dispatcher.forward(req, resp);
    }
}
