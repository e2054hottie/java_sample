package controller.task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/obc")
public class OrderByComp extends HttpServlet {
    private static boolean orderByComp =false;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderByComp = true;
        OrderByLimit.setOrderByLimit(false);
        DefaultOrder.setOrderByDefault(false);
        resp.sendRedirect("/task/read");
    }

    public static boolean getOrderByComp(){
        return OrderByComp.orderByComp;
    }

    public static void setOrderByComp(boolean b){
        orderByComp = b;
    }
}
