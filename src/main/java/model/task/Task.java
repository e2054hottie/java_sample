package model.task;

import model.Default;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Task extends Default {
    private String name;
    private Timestamp deadline;//締め切り
    private Integer frequency; //頻度
    private boolean compleated; //タスクの完了
    private String memo;
    private Integer userId;
    private Integer categoryId;

    public Task(Integer id, String name, Timestamp deadline, Integer frequency, String memo, Integer userId, Integer categoryId, Timestamp createdAt, Timestamp updatedAt){
        super(id, createdAt, updatedAt);
        this.compleated = false;
        this.name = name;
        this.deadline = deadline;
        this.frequency = frequency;
        this.memo = memo;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public void insert() {
        model.task.Repository.insert(this);
    }

    public static ArrayList<Task> indexTasks(User user) {
        return Repository.indexTasks(user);
    }

    public void update(){
        Repository.update(this);
    }

    public Task search(){
        Task task = Repository.search(this);
        return task;
    }

    public void delete(){
        Repository.delete(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isCompleated() {
        return compleated;
    }

    public boolean getCompleated() {
        return compleated;
    }

    public void setCompleated(boolean compleated) {
        this.compleated = compleated;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

}
