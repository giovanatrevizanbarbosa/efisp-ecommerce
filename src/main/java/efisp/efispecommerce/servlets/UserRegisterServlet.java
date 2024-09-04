package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController controller = new UserController();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String url;

        if(controller.add(new UserDTO(UUID.randomUUID(), name, email, password))){
            req.setAttribute("result", "registered");
            url = "/pages/login.jsp";
        } else {
            req.setAttribute("result", "notRegistered");
            url = "/pages/register.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/register.jsp");
        dispatcher.forward(req, resp);
    }
}