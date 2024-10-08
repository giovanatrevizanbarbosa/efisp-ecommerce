package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.Encoder;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.User;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class UserService {
    private final IDao<User> users = Dao.getInstance(User.class);
    private final AdmService admService = new AdmService();

    User toEntity(UserDTO userDTO) {
        return new User(userDTO.id(), userDTO.name(), userDTO.email(), userDTO.password());
    }

    User toEntity(UserDTO userDTO, String password) {
        return new User(userDTO.id(), userDTO.name(), userDTO.email(), password);
    }

    protected UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    /**
     * Authenticate a user.
     * @param email User's email
     * @param password User's password, in plain text, not encoded.
     * @return the User if the authentication was successful and null otherwise
     */
    public UserDTO authenticate(String email, String password) {
        String encodedPassword = Encoder.encode(password);
        for (User user : users.getAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(encodedPassword)) {
                return toDTO(user);
            }
        }

        return null;
    }

    /**
     * Add a new user to the database
     * The password is encoded before being stored
     * @param userDTO the user to be added
     * @return true if the user was added successfully and false otherwise
     * @see Encoder#encode(String)
     */
    public boolean addUser(UserDTO userDTO) {
        if (Objects.isNull(userDTO) || admService.containsEmail(userDTO.email())) return false;
        User user = toEntity(userDTO, Encoder.encode(userDTO.password()));
        return users.add(user);
    }

    public List<UserDTO> getAll() {
        return users.getAll().stream().map(this::toDTO).toList();
    }

    public UserDTO getUserById(UUID id) {
        return toDTO(users.getById(id));
    }

    public UserDTO getUserByEmail(String email) {
        for (User user : users.getAll()) {
            if (user.getEmail().equals(email)) {
                return toDTO(user);
            }
        }

        return null;
    }

    public UserDTO getUserByName(String name) {
        for (User user : users.getAll()) {
            if (user.getName().equals(name)) {
                return toDTO(user);
            }
        }

        return null;
    }

    public boolean updateUser(UUID id, UserDTO userDTO) {
        User user = toEntity(userDTO);
        return users.update(id, user);
    }

    public boolean deleteUser(UUID id) {
        return users.delete(id);
    }
}
