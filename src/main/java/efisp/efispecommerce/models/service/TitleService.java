package efisp.efispecommerce.models.service;

import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Title;

import java.util.List;

public class TitleService {

    IDao<Title> dao = Dao.getInstance(Title.class);

    public boolean getTitleById() {
        return true;
    }

    public List<Title> getAll() {
        return dao.getAll();
    }

    public boolean add(Title title) {
        return true;
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
