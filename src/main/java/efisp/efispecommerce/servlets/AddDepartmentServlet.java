package efisp.efispecommerce.servlets;

import efisp.efispecommerce.controllers.DepartmentController;
import efisp.efispecommerce.dto.DepartmentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/add-department")
public class AddDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/add-department.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentController departmentController = new DepartmentController();

        String name = req.getParameter("name");
        String description = req.getParameter("description");

        DepartmentDTO departmentDTO = new DepartmentDTO(UUID.randomUUID(), name, description);
        departmentController.addDepartment(departmentDTO);

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
