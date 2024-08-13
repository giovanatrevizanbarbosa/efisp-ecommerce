package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.entitys.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDao implements Dao<User>{

    private static UserDao instance;
    private final Map<Long, User> users;

    private UserDao() {
        users = new HashMap<>();
    }


    public static Dao<User> getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public boolean add(User user) {
        User user1 = new User(user.getId(), user.getName(), user.getEmail(), user.getPassword());
        return users.put((long) user.getId(), user1) == null;
    }

    @Override
    public boolean update(long id, User user) {
        User user1 = new User(user.getId(), user.getName(), user.getEmail(), user.getPassword());
        return users.replace(id, user1) != null;

    }

    @Override
    public boolean delete(long id) {
        return users.remove(id) != null;
    }

    @Override
    public User getById(long id) {
        User userFinded = users.get(id);

        if (userFinded != null) {
            return new User(userFinded.getId(), userFinded.getName(), userFinded.getEmail(), userFinded.getPassword());
        }

        throw new RuntimeException("User not found");
    }

    @Override
    public List<User> getAll() {
        List<User> usersList = new LinkedList<>();
        users.values().forEach(user -> usersList.add(new User(user.getId(), user.getName(), user.getEmail(), user.getPassword())));
        return usersList;
    }
}
