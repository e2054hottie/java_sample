package model.category;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insert(Category category) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into categories (name, created_at, updated_at, user_id) values (?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);
            stmt.setInt(4, category.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

    public static ArrayList<Category> indexCategories(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from categories where user_id = ?";

            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();

            ArrayList<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        null,
                        null,
                        null
                );
                categories.add(category);
            }
            return categories;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}