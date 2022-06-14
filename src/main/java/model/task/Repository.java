package model.task;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insert(Task task) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into tasks (name, dead_line,frequency,completed,memo, created_at, updated_at, category_id,user_id) values (?, ?, ?, ?, ?, ?, ?, ?,?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getName());
            stmt.setTimestamp(2, task.getDeadline());
            stmt.setInt(3, task.getFrequency());
            stmt.setBoolean(4, false);
            stmt.setString(5, task.getMemo());
            stmt.setTimestamp(6,currentTime);
            stmt.setTimestamp(7,currentTime);
            stmt.setInt(8, task.getCategoryId());
            stmt.setInt(9,task.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

    public static ArrayList<Task> indexTasks(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from tasks where user_id = ? order by category_id asc";

            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();

            ArrayList<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("dead_line"),
                        rs.getInt("frequency"),
                        rs.getString("memo"),
                        rs.getInt("user_id"),
                        rs.getInt("category_id"),
                        null,
                        null
                );
                tasks.add(task);
            }
            return tasks;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
