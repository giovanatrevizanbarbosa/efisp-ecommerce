package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.Encoder;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Administrator;

import java.util.List;
import java.util.UUID;

public class AdmService {

    IDao<Administrator> dao = Dao.getInstance(Administrator.class);
    TitleService titleService = new TitleService();


    private Administrator toEntity(AdmDTO admDTO) {
        return new Administrator(
                admDTO.id(),
                admDTO.name(),
                admDTO.email(),
                admDTO.password(),
                titleService.toEntity(admDTO.titleDTO())
        );
    }

    private Administrator toEntity(AdmDTO admDTO, String password) {
        return new Administrator(
                admDTO.id(),
                admDTO.name(),
                admDTO.email(),
                password,
                titleService.toEntity(admDTO.titleDTO())
        );
    }

    private AdmDTO toDTO(Administrator administrator) {
        return new AdmDTO(
                administrator.getId(),
                administrator.getName(),
                administrator.getEmail(),
                administrator.getPassword(),
                new TitleService().toDTO(administrator.getTitle())
        );
    }

    /**
     * Authenticate an Administrator.
     * @param email Administrator's email
     * @param password Administrator's password, in plain text, not encoded.
     * @return the Administrator if the authentication was successful and null otherwise
     */
    public AdmDTO authenticate(String email, String password) {
        String encodedPassword = Encoder.encode(password);
        for (Administrator administrator : dao.getAll()) {
            if (administrator.getEmail().equals(email) && administrator.getPassword().equals(encodedPassword)) {
                return toDTO(administrator);
            }
        }

        return null;
    }

    /**
     * Add a new Administrator to the database.
     * Password is encoded before being stored.
     * Title is added to the database automatically, if it doesn't exist.
     * @param admDTO the Administrator to be added
     * @return true if the Administrator was added successfully and false otherwise
     * @see Encoder#encode(String)
     */
    public boolean add(AdmDTO admDTO) {
        titleService.add(admDTO.titleDTO());
        return dao.add(toEntity(admDTO, Encoder.encode(admDTO.password())));
    }

    public boolean update(UUID id, AdmDTO admDTO) {
        titleService.add(admDTO.titleDTO());
        return dao.update(id, toEntity(admDTO));
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
