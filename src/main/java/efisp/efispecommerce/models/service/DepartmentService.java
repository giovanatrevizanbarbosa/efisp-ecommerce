package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.entitys.Department;

import java.util.List;
import java.util.UUID;

public class DepartmentService {

    private final Dao<Department> dao = Dao.getInstance(Department.class);

    Department toEntity(DepartmentDTO department){
        return new Department(department.id(), department.name(), department.description());
    }

    private DepartmentDTO toDTO(Department department){
        return new DepartmentDTO(department.getId(), department.getName(), department.getDescription());
    }

    public DepartmentDTO getDepartmentByName(String department) {
        return dao.getAll().stream().filter(d -> d.getName().equals(department)).findFirst().map(this::toDTO).orElse(null);
    }

    public boolean add(DepartmentDTO department) {
        return dao.add(toEntity(department));
    }

    public boolean update(UUID id, DepartmentDTO department) {
        return dao.update(id, toEntity(department));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public List<DepartmentDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }

    public DepartmentDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }
}
