package dk.mercantec.messages.models;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by code on 22-02-2015.
 */
public class DbHelper {
    private static DbHelper instance = null;
    private ConnectionSource connectionSource;
    private Dao<Message, Integer> messageDao;

    protected DbHelper() {
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:messages.db");

            TableUtils.createTableIfNotExists(connectionSource, Message.class);

            messageDao = DaoManager.createDao(connectionSource, Message.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbHelper getInstance(){
        if (instance == null)
            instance = new DbHelper();
        return instance;
    }

    public Dao<Message, Integer> getMessageDao() {
        return messageDao;
    }
}
