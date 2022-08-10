package controller.task;

import model.category.Category;
import model.task.Task;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/task/read")
public class Read extends HttpServlet {
    private void orderByLimit(ArrayList<Task> tasks){
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task taskFirst, Task taskSecond) {
                return taskFirst.getDeadline().compareTo(taskSecond.getDeadline());
            }
        });
    }

    private void orderByComp(ArrayList<Task> tasks){
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task taskFirst, Task taskSecond) {

                return Boolean.compare(taskFirst.getCompleated(), taskSecond.getCompleated());

            }
        });
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);

        //タスク一覧を取得,並び替える
        ArrayList<Task> tasks = Task.indexTasks(user);
        if(!DefaultOrder.getOrderByDefault()) {
            if (OrderByComp.getOrderByComp()) orderByComp(tasks);
            if (OrderByLimit.getOrderByLimit()) orderByLimit(tasks);
        }
        req.setAttribute("tasks", tasks);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/top.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }
}