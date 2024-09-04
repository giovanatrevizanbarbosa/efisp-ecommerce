package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.AdmController;
import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30 * 60);

        AdmController admController = new AdmController();
        AdmDTO admDTO = admController.authenticate(email, password);
        if (admDTO != null) {
            session.setAttribute("user", admDTO);
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            UserController userController = new UserController();
            UserDTO userDto = userController.authenticate(email, password);

            if(userDto != null){
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
