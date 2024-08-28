package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.entitys.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private final List<User> users = new LinkedList<>();

    private User mapUserDTOToEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
    }

    public boolean addUser(UserDTO userDTO) {
        User user = mapUserDTOToEntity(userDTO);
        return users.add(user);
    }
}
