package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.TitleController;
import efisp.efispecommerce.dto.TitleDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/add-title")
public class AddTitleServlet extends HomeServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/pages/add-title.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TitleController titleController = new TitleController();

        String name = req.getParameter("name");
        int level = Integer.parseInt(req.getParameter("level"));

        titleController.addTitle(new TitleDTO(UUID.randomUUID(), name, level));

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
