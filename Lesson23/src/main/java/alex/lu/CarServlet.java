//2:08-listener

package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static alex.lu.CarStorage.getCars;

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    private CarStorage carStorage;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        System.out.println("==== Do Service ====");
        LocalDateTime time = LocalDateTime.now();
        Cookie[] cookies = req.getCookies();
        resp.addCookie(new Cookie("mycook", time.format(DateTimeFormatter.ofPattern("dd-MM-yyy_HH:mm:ss"))));
        if (cookies !=null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " " + cookie.getValue());
            }
        }
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream sos = resp.getOutputStream();
        sos.println("All Cars Info: ");
        getCars().forEach((key, value)->{
            try {
                sos.println(key+" "+value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        String id = req.getParameter("id");
        Cars carId = getCars().get(id);
        sos.println(id+" "+carId);

//        req.getRequestDispatcher("/redir.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String car = req.getParameter("car");
        String model = req.getParameter("model");
        getCars().put(id, new Cars(car,model));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String car = req.getParameter("car");
        String model = req.getParameter("model");
        getCars().put(id, new Cars(car,model));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream sos = resp.getOutputStream();
        String id = req.getParameter("id");
        getCars().remove(id);
        sos.println();
    }
}