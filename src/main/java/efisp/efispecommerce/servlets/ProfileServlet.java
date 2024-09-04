package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserController controller = new UserController();
        UserDTO user = (UserDTO) session.getAttribute("user");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("new-password");

        if(password != null && !password.isEmpty()){
            controller.update(user.id(), new UserDTO(user.id(), name, email, password));
        } else {
            controller.update(user.id(), new UserDTO(user.id(), name, email, user.password()));
        }

        req.getRequestDispatcher("/pages/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
