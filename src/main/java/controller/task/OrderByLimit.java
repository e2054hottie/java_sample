package controller.task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/obl")
public class OrderByLimit extends HttpServlet {
    private static boolean orderByLimit = false;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        orderByLimit = true;
        OrderByComp.setOrderByComp(false);
        DefaultOrder.setOrderByDefault(false);
        resp.sendRedirect("/task/read");
    }

    public static boolean getOrderByLimit(){
        return OrderByLimit.orderByLimit;
    }

    public static void setOrderByLimit(boolean b){
        orderByLimit = b;
    }
}
