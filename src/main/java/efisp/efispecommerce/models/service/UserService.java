package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private final IDao<User> users = Dao.getInstance(User.class);

    private User mapUserDTOToEntity(UserDTO userDTO) {
        return new User(userDTO.id(), userDTO.name(), userDTO.email(), userDTO.password());
    }

    public boolean addUser(UserDTO userDTO) {
        User user = mapUserDTOToEntity(userDTO);
        return users.add(user);
    }

    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOs = new LinkedList<>();
        for (User user : users.getAll()) {
            userDTOs.add(new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword()));
        }
        return userDTOs;
    }

    public UserDTO getUserById(Long id) {
        for (User user : users.getAll()) {
            if (user.getId().equals(id)) {
                return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
            }
        }

        return null;
    }

    public UserDTO getUserByEmail(String email) {
        for (User user : users.getAll()) {
            if (user.getEmail().equals(email)) {
                return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
            }
        }

        return null;
    }

    public UserDTO getUserByName(String name) {
        for (User user : users.getAll()) {
            if (user.getName().equals(name)) {
                return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
            }
        }

        return null;
    }

    public boolean updateUser(long id, UserDTO userDTO) {
        User user = mapUserDTOToEntity(userDTO);
        return users.update(id, user);
    }

    public boolean deleteUser(long id) {
        return users.delete(id);
    }
}
