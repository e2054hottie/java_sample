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

@WebServlet("/task/update")
public class Update extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);

        ArrayList<Task> tasks = Task.indexTasks(user);
        req.setAttribute("tasks", tasks);

        int id = Integer.parseInt(req.getParameter("taskid"));
        System.out.println("taskidは"+id);

        Task task = new Task(
                id,
                null,
                null,
                null,
                null,
                user.getId(),
                null,
                null,
                null
        );

        task = task.search();
        if (task == null) {
            System.out.println("taskはありません");
        }
        req.setAttribute("currenttask",task);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/update.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String description = req.getParameter("memo");
        Timestamp limit = new Timestamp(Date.valueOf(req.getParameter("dead_line")).getTime());
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Integer id = Integer.parseInt(req.getParameter("taskid"));
        User user = (User) req.getSession().getAttribute("currentUser");
        Integer userId = user.getId();

        Task task = new Task(
                id,
                name,
                limit,
                0,
                description,
                userId,
                categoryId,

                null,
                null
        );

        task.update();

        resp.sendRedirect("/task/read");
    }
}