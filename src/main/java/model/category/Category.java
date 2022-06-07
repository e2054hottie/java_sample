package model.category;

import model.Default;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Category extends Default {
    private String name;
    private Integer userId;

    public Category(Integer id, String name, Timestamp createdAt, Timestamp updatedAt, Integer userId) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.userId = userId;
    }

    //getメソッド
    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }

    //setメソッド
    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void insert() {
        Repository.insert(this);
    }

    public static ArrayList<Category> indexCategories(User user) {
        return Repository.indexCategories(user);
    }

}