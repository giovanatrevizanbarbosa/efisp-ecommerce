package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.TitleDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Title;

import java.util.List;
import java.util.UUID;

public class TitleService {

    IDao<Title> dao = Dao.getInstance(Title.class);

    protected TitleDTO toDTO(Title title) {
        return new TitleDTO(title.getId(), title.getName(), title.getPermissionLevel());
    }

    protected Title toEntity(TitleDTO titleDTO) {
        return new Title(titleDTO.id(), titleDTO.name(), titleDTO.level());
    }

    public TitleDTO getTitleById(UUID id) {
        return toDTO(dao.getById(id));
    }

    public List<TitleDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }

    public boolean add(TitleDTO title) {
        return dao.add(toEntity(title));
    }

    public boolean update(UUID id, TitleDTO title) {
        return dao.update(id, toEntity(title));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public TitleDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }


}
