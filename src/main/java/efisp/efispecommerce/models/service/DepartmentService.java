package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.entitys.Department;

import java.util.List;

public class DepartmentService {

    private final Dao<Department> dao = Dao.getInstance(Department.class);

    private Department mapDepartmentDTOToEntity(DepartmentDTO department){
        return new Department(department.id(), department.name(), department.description());
    }

    private DepartmentDTO mapDepartmentEntityToDTO(Department department){
        return new DepartmentDTO(department.getId(), department.getName(), department.getDescription());
    }

    public Department getDepartmentByName(String department) {
        return dao.getAll().stream().filter(d -> d.getName().equals(department)).findFirst().orElse(null);
    }

    public boolean add(DepartmentDTO department) {
        return dao.add(mapDepartmentDTOToEntity(department));
    }


    public List<DepartmentDTO> getAll() {
        return dao.getAll().stream().map(this::mapDepartmentEntityToDTO).toList();
    }

    public DepartmentDTO getById(long id) {
        return mapDepartmentEntityToDTO(dao.getById(id));
    }

    public Long getNextId() {
        return dao.getNextId();
    }
}
