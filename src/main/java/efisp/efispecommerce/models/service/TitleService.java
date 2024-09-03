package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.TitleDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Title;

import java.util.List;
import java.util.UUID;

public class TitleService {

    IDao<Title> dao = Dao.getInstance(Title.class);

    protected TitleDTO mapEntityToDTO(Title title) {
        return new TitleDTO(title.getId(), title.getName(), title.getPermissionLevel());
    }

    protected Title mapDTOToEntity(TitleDTO titleDTO) {
        return new Title(titleDTO.id(), titleDTO.name(), titleDTO.level());
    }

    public Title getTitleById(UUID id) {
        return dao.getById(id);
    }

    public List<Title> getAll() {
        return dao.getAll();
    }

    public boolean add(TitleDTO title) {
        return dao.add(mapDTOToEntity(title));
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public boolean getById() {
        return true;
    }


}
