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
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet("/task/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println(req.getParameter("limit"));
        Timestamp deadline = Timestamp.valueOf(req.getParameter("limit")+" 23:59:59");
        Integer frequency = Integer.valueOf(req.getParameter("frequency"));
        String memo =  req.getParameter("description");
        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        Task task = new Task(
                null,
                name,
                deadline,//deadline,
                frequency,//frequency,
                memo,
                user.getId(),
                categoryId,
                null,
                null
        );

        task.insert();

        resp.sendRedirect("/task/insertComp");
    }
}