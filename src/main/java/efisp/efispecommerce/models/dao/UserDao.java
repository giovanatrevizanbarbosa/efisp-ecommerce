package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.dataInterface.DataReader;
import efisp.efispecommerce.models.dao.dataInterface.DataWriter;
import efisp.efispecommerce.models.dao.dataInterface.Writable;
import efisp.efispecommerce.models.entitys.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDao implements Dao<User>{

    private static UserDao instance;
    private DataWriter dataWriter;
    private DataReader dataReader;

    public boolean add(Writable<User> user) {
        if (user != null){
            dataWriter.writeCsv(user);
            return true;
        }

        throw new NullPointerException("User is null");
    }

    public boolean update(Writable<User> old, Writable<User> newWritable) {
        return true;
    }


    private UserDao() {
        dataWriter = new DataWriter("users", );
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
        if (user != null){
            dataWriter.writeCsv(user);
            return true;
            }

        throw new NullPointerException("User is null");
    }



    @Override
    public boolean update(long id, User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
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
        return null;
    }
}
