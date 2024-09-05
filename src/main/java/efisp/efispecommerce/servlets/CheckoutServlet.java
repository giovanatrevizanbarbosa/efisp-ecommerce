package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.AddressController;
import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.ItemController;
import efisp.efispecommerce.controllers.OrderController;
import efisp.efispecommerce.dto.*;
import efisp.efispecommerce.models.enums.PaymentMethod;
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
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartController cartController = new CartController();
        ItemController itemController = new ItemController();
        HttpSession session = req.getSession(false);
        UserDTO user = (UserDTO) session.getAttribute("user");

        var street = req.getParameter("street");
        var number = req.getParameter("number");
        var city = req.getParameter("city");
        var zipcode = req.getParameter("zipcode");
        var state = req.getParameter("state");

        var paymentMethod = PaymentMethod.valueOf(req.getParameter("payment-method"));

        var cart = (CartDTO) session.getAttribute("cart");
      
        List<ItemDTO> cartItems = itemController.getItemsByCartId(cart.id());

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

        OrderController orderController = new OrderController();
        AddressController addressController = new AddressController();

        AddressDTO addressDTO = new AddressDTO(UUID.randomUUID(), street, number, city, zipcode, state);
        addressController.addAddress(addressDTO);

        UUID orderId = UUID.randomUUID();
        OrderDTO order = new OrderDTO(orderId, user, cart.items().values().stream().toList(), paymentMethod, addressDTO);
        orderController.add(order);

        cartController.checkout(cart.id(), orderId);
        cartGenerate(req, resp);

        assert user != null;
        session.setAttribute("cart", cartController.getCartByOwnerEmail(user.email()));
        req.getRequestDispatcher(req.getContextPath() + "/home").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartController cartController = new CartController();
        ItemController itemController = new ItemController();
        HttpSession session = req.getSession(false);

        var cart = (CartDTO) session.getAttribute("cart");

        if(cart != null){
            List<ItemDTO> cartItems = itemController.getItemsByCartId(cart.id());
            req.setAttribute("cartItems", cartItems);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(req, resp);
    }

    public void cartGenerate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartController cartController = new CartController();
        HttpSession session = req.getSession();

        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user != null) {
            CartDTO cart = new CartDTO(UUID.randomUUID(), user.email(), new HashMap<>());
            cartController.addCart(cart);
            session.setAttribute("cart", cartController.getCartByOwnerEmail(user.email()));
        }

    }
}
