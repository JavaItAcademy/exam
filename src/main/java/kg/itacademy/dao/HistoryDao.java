package kg.itacademy.dao;

import kg.itacademy.model.History;
import kg.itacademy.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryDao {
    //private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
    private final String user = "gruppa22";
    private final String password = "4e56qwe56";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }



    public static int nextId = 0;
    private static final Map<Integer, History> historyMap = new HashMap<>();

    public void addHistory(History history){
        history.setId(nextId++);
        historyMap.put(history.getId(), history);
    }

    public ArrayList<History> getAllHistory() {
        return new ArrayList<History>(historyMap.values());
    }


}