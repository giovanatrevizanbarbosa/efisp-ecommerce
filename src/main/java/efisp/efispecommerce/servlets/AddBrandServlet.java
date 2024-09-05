package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.BrandController;
import efisp.efispecommerce.dto.BrandDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/add-brand")
public class AddBrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/add-brand.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandController brandController = new BrandController();

        String name = req.getParameter("name");

        brandController.addBrand(new BrandDTO(UUID.randomUUID(), name));

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
