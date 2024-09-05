package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.TitleDTO;
import efisp.efispecommerce.models.service.TitleService;

import java.util.List;
import java.util.UUID;

public class TitleController {

    TitleService titleService = new TitleService();

    public void addTitle(TitleDTO titleDTO) {
        titleService.add(titleDTO);
    }

    public List<TitleDTO> getAllTitles() {
        return titleService.getAll();
    }

    public TitleDTO getTitleById(UUID id) {
        return titleService.getById(id);
    }

    public TitleDTO getTitleByName(String name) {
        return titleService.getByName(name);
    }


}
