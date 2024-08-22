package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.dataInterface.DataReader;
import efisp.efispecommerce.models.dao.dataInterface.DataWriter;
import efisp.efispecommerce.models.entitys.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDao implements Dao<User>{

    private static UserDao instance;
    private DataWriter dataWriter;
    private DataReader dataReader;

    private UserDao() {
        dataWriter = new DataWriter("users");
        dataReader = new DataReader("users");
    }


    public static Dao<User> getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public boolean add(User user) {
        if (user != null)
            return dataWriter.writeCsv(user);

        throw new NullPointerException("User is null");
    }

    @Override
    public boolean update(long id, User user) {
        List<String[]> list = dataReader.readCsv();
        User[] users = new User[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String[] userString = list.get(i);
            if (Long.parseLong(userString[0]) == id) {
                users[i] = new User(Integer.parseInt(userString[0]), user.getName(), user.getEmail(), user.getPassword());
            } else {
                users[i] = new User(Integer.parseInt(userString[0]), userString[1], userString[2], userString[3]);
            }
        }

        return dataWriter.writeAllCsv(users);
    }

    @Override
    public boolean delete(long id) {
        List<String[]> list = dataReader.readCsv();
        User[] users = new User[list.size() - 1];
        int j = 0;

        for (String[] user : list) {
            if (Long.parseLong(user[0]) != id) {
                users[j] = new User(Integer.parseInt(user[0]), user[1], user[2], user[3]);
                j++;
            }
        }

        return dataWriter.writeAllCsv(users);
    }

    @Override
    public User getById(long id) {
        List<String[]> list = dataReader.readCsv();

        for (String[] user : list) {
            if (Long.parseLong(user[0]) == id) {
                return new User(Integer.parseInt(user[0]), user[1], user[2], user[3]);
            }
        }

        throw new RuntimeException("User not found");
    }

    @Override
    public List<User> getAll() {
        List<String[]> list = dataReader.readCsv();
        List<User> users = new LinkedList<>();

        for (String[] user : list) {
            if (user[0].equals("id")) {
                continue;
            }

            users.add(new User(Integer.parseInt(user[0]), user[1], user[2], user[3]));
        }

        return users;
    }
}
