package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@WebServlet("/")
public class HomeServlet26 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("keyATT", new Car26("Audi"));

        req.setAttribute("text","TExT");
        req.setAttribute("car", new Car26("Lexus", 12L,true));

        ArrayList<Object> cars = new ArrayList<>();
        cars.add(new Car26("Fiat",8L,true));
        cars.add(new Car26("Subaru",12L,true));
        req.setAttribute("cars",cars);

        HashMap<Object, Object> maps = new HashMap<>();
        maps.put("mapKey", new Car26("Bentley",4L, false));
        req.setAttribute("carsMap", maps);

        req.setAttribute("tmp","request");
        req.getSession().setAttribute("tmp","session");
        getServletContext().setAttribute("tmp","application");

        req.getRequestDispatcher("/les26.jsp").forward(req,resp);
    }
}
