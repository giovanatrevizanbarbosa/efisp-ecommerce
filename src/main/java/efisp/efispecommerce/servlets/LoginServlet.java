package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.AdmController;
import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30 * 60);

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AdmController admController = new AdmController();
        AdmDTO admDTO = admController.authenticate(email, password);
        if (admDTO != null) {
            session.setAttribute("user", admDTO);
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            UserController userController = new UserController();
            UserDTO userDto = userController.authenticate(email, password);

            if(userDto != null){
                CartController cartController = new CartController();
                CartDTO cartDto = cartController.getCartByOwnerEmail(email);

                if(cartDto == null){
                    cartDto = new CartDTO(UUID.randomUUID(), userDto.email(), new HashMap<>());
                    cartController.addCart(cartDto);
                }

                session.setAttribute("cart", cartDto);
                session.setAttribute("user", userDto);
                req.getRequestDispatcher("/home").forward(req, resp);
            } else {
                session.invalidate();
                req.setAttribute("result", "loginError");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/login.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/login.jsp");
        dispatcher.forward(req, resp);
    }
}
