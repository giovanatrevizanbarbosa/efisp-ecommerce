package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.service.AdmService;

import java.util.UUID;

public class AdmController {

    AdmService service = new AdmService();

    public boolean add(AdmDTO admDto) {
        return service.add(admDto);
    }

    public boolean update(UUID uuid, AdmDTO admDto) {
        return service.update(uuid, admDto);
    }

    public boolean delete(UUID uuid) {
        return service.delete(uuid);
    }

    public AdmDTO get(UUID uuid) {
        return service.getById(uuid);
    }

    public AdmDTO authenticate(String email, String password) {
        return service.authenticate(email, password);
    }

}
