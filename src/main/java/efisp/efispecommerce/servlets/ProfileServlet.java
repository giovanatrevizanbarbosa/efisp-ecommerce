package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.Encoder;
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

        UserDTO updatedUser;
        if (password != null && !password.isEmpty()) {
            String encodedPassword = Encoder.encode(password);
            updatedUser = new UserDTO(user.id(), name, email, encodedPassword);
        } else {
            updatedUser = new UserDTO(user.id(), name, email, user.password());
        }
        controller.update(user.id(), updatedUser);

        session.setAttribute("user", updatedUser);

        req.getRequestDispatcher("/pages/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
