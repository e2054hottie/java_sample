package controller.task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/obd")
public class DefaultOrder extends HttpServlet {
    private static boolean orderByDefault =false;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderByDefault = true;
        OrderByLimit.setOrderByLimit(false);
        OrderByComp.setOrderByComp(false);
        resp.sendRedirect("/task/read");
    }

    public static boolean getOrderByDefault(){
        return DefaultOrder.orderByDefault;
    }

    public static void setOrderByDefault(boolean b){
        orderByDefault = b;
    }
}
