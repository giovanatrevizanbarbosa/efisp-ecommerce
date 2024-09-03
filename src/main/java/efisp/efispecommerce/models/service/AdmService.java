package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;

import java.util.List;

public class AdmService {

    IDao<Administrator> dao = Dao.getInstance(Administrator.class);
    TitleService titleService = new TitleService();


    private Administrator mapDTOToEntity(AdmDTO admDTO) {
        return new Administrator(
                admDTO.id(),
                admDTO.name(),
                admDTO.email(),
                admDTO.password(),
                titleService
                        .getAll()
                        .stream()
                        .filter
                                (
                                    title -> title
                                            .getName()
                                            .equals(admDTO.title())
                                )
                        .findFirst()
                        .orElse(new Title(0L, "", 0))
        );
    }

    private AdmDTO toDTO(Administrator administrator) {
        return new AdmDTO(
                administrator.getId(),
                administrator.getName(),
                administrator.getEmail(),
                administrator.getPassword(),
                administrator.getTitle().getName()
        );
    }

    public boolean add(AdmDTO admDTO) {
        return dao.add(mapDTOToEntity(admDTO));
    }

    public boolean update(long id, AdmDTO admDTO) {
        return dao.update(id, mapDTOToEntity(admDTO));
    }

    public boolean delete(long id) {
        return dao.delete(id);
    }

    public AdmDTO getById(long id) {
        return toDTO(dao.getById(id));
    }

    public List<AdmDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }

    public Long getNextId() {
        return dao.getNextId();
    }
}
