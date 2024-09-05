package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.service.DepartmentService;

import java.util.List;
import java.util.UUID;

public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController() {
        service = new DepartmentService();
    }

    public boolean addDepartment(DepartmentDTO departmentDto) {
        return service.add(departmentDto);
    }

    public boolean updateDepartment(UUID id, DepartmentDTO departmentDto) {
        return service.update(id, departmentDto);
    }

    public boolean deleteDepartment(UUID id) {
        return service.delete(id);
    }

    public DepartmentDTO getById(UUID id) {
        return service.getById(id);
    }

    public Department getByName(String name) {
        return service.getDepartmentByName(name);
    }

    public List<DepartmentDTO> getAll() {
        return service.getAll();
    }
}
