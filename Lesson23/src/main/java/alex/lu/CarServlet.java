package alex.lu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    private static Map<String, CarList> cars = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        cars.put("1", new CarList("Volvo","S90"));
        cars.put("2", new CarList("Toyota","Avensis"));
        cars.put("3", new CarList("Geely","Atlas"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime time = LocalDateTime.now();
        Cookie[] cookies = req.getCookies();
        resp.addCookie(new Cookie("mycook", time.format(DateTimeFormatter.ofPattern("dd-MM-yyy_HH:mm:ss"))));
        if (cookies !=null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " " + cookie.getValue());
            }
        }

        ServletOutputStream sos = resp.getOutputStream();
        sos.println("All Cars Info: ");
        Set<String> keys = cars.keySet();
            for (String key:keys){
                CarList carList = cars.get(key);
                sos.println(key+" "+carList);
            }

        String id = req.getParameter("id");
        CarList carId = cars.get(id);
        sos.println(id+" "+carId);

//        req.getRequestDispatcher("/redir.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String car = req.getParameter("car");
        String model = req.getParameter("model");
        cars.put(id, new CarList(car,model));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String car = req.getParameter("car");
        String model = req.getParameter("model");
        cars.put(id, new CarList(car,model));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream sos = resp.getOutputStream();
        String id = req.getParameter("id");
        cars.remove(id);
        sos.println();
    }
}