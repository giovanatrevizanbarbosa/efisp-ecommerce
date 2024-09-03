package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Administrator;

import java.util.List;
import java.util.UUID;

public class AdmService {

    IDao<Administrator> dao = Dao.getInstance(Administrator.class);
    TitleService titleService = new TitleService();


    private Administrator mapDTOToEntity(AdmDTO admDTO) {
        return new Administrator(
                admDTO.id(),
                admDTO.name(),
                admDTO.email(),
                admDTO.password(),
                titleService.getTitleById(admDTO.titleDTO().id())
        );
    }

    private AdmDTO toDTO(Administrator administrator) {
        return new AdmDTO(
                administrator.getId(),
                administrator.getName(),
                administrator.getEmail(),
                administrator.getPassword(),
                new TitleService().mapEntityToDTO(administrator.getTitle())
        );
    }

    public boolean add(AdmDTO admDTO) {
        titleService.add(admDTO.titleDTO());
        return dao.add(mapDTOToEntity(admDTO));
    }

    public boolean update(UUID id, AdmDTO admDTO) {
        titleService.add(admDTO.titleDTO());
        return dao.update(id, mapDTOToEntity(admDTO));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public AdmDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }

    public List<AdmDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }
}
