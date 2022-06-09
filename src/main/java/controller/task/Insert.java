package controller.task;

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
        ArrayList<Task> tasks = Task.indexTasks(user);
        req.setAttribute("tasks", tasks);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/insert.jsp");
        dispatcher.forward(req, resp);
    }

//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        String name = req.getParameter("name");
//        Timestamp deadline = Timestamp.valueOf(req.getParameter("deadline"));
//        Integer frequency = Integer.valueOf(req.getParameter("frequency"));
//        String memo =  req.getParameter("memo");
//
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("currentUser");
//
//        Task task = new Task(
//                null,
//                name,
//                deadline,
//                frequency,
//                memo,
//                user.getId(),
//                null,
//                null,
//                null
//        );
//
//        task.insert();
//
//        resp.sendRedirect("/");
//    }
}