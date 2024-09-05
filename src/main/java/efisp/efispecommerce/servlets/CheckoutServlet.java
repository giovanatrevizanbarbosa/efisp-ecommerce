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

        StringBuilder itemsBuilder = new StringBuilder();
        for (ItemDTO item : cartItems) {
            itemsBuilder.append("<p><strong>Produto:</strong> ").append(item.productDTO().name()).append("</p>")
                    .append("<p><strong>Quantidade:</strong> ").append(item.quantity()).append(" unidad(es)</p>")
                    .append("<p><strong>Preço:</strong> R$").append(item.productDTO().price()).append("</p>")
                    .append("<hr>");
        }

        itemsBuilder.append("<p><strong>Total:</strong> R$").append(cart.totalPrice()).append("</p>")
                .append("<p><strong>Total de Itens:</strong> ").append(cart.totalItems()).append("</p>")
                .append("<p><strong>Forma de Pagamento:</strong> ").append(paymentMethod).append("</p>");

        String items = itemsBuilder.toString();

        String emailBody = "<!DOCTYPE html><html><head><style>body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 0; padding: 0; } .container { width: 80%; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); } h1 { color: #4CAF50; margin-bottom: 20px; } p { font-size: 16px; margin: 0 0 10px; } .section { margin-bottom: 20px; padding: 15px; border-radius: 8px; background-color: #f9f9f9; } .section h2 { color: #4CAF50; margin: 0 0 10px; } .order-details { border-top: 1px solid #ddd; padding-top: 10px; margin-top: 10px; } .order-details p { margin: 5px 0; } .footer { margin-top: 20px; font-size: 12px; color: #666; text-align: center; } hr { border: 0; border-top: 1px solid #ddd; margin: 10px 0; }</style></head><body><div class='container'><h1>Obrigado pelo seu pedido!</h1><p>Olá " + user.name() + ",</p><p>Seu pedido foi realizado com sucesso e está sendo processado. Abaixo estão os detalhes:</p><div class='section'><h2>Endereço de Entrega</h2><p><strong>Rua:</strong> " + street + "</p><p><strong>Número:</strong> " + number + "</p><p><strong>Cidade:</strong> " + city + "</p><p><strong>CEP:</strong> " + zipcode + "</p><p><strong>Estado:</strong> " + state + "</p></div><div class='section'><h2>Método de Pagamento</h2><strong>" + paymentMethod + "</strong></div><div class='section'><h2>Produto(s):</h2><div class='order-details'>" + items + "<p><strong>Total:</strong> R$" + cart.totalPrice() + "</p><p><strong>Total de Itens:</strong> " + cart.totalItems() + "</p></div></div><p>Atenciosamente,<br/>Equipe E-fisp</p><div class='footer'>Este é um e-mail automático. Por favor, não responda.</div></div></body></html>";

        if(user != null) {
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(user.email(), "E-fisp - Pedido realizado com sucesso!", emailBody);
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
        req.getRequestDispatcher("/home").forward(req, resp);
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


        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/checkout.jsp");
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
