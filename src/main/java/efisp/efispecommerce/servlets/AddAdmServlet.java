package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.AdmController;
import efisp.efispecommerce.controllers.TitleController;
import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.TitleDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/add-adm")
public class AddAdmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TitleController titleController = new TitleController();

        List< TitleDTO > titles = titleController.getAllTitles();

        session.setAttribute("roles", titles);

        req.getRequestDispatcher("/pages/add-adm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdmController admController = new AdmController();
        TitleController titleController = new TitleController();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String title = req.getParameter("title");

        TitleDTO titleDTO = titleController.getTitleById(UUID.fromString(title));
        AdmDTO admDTO = new AdmDTO(UUID.randomUUID(), name, email, password, titleDTO);

        admController.add(admDTO);

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
