package lu.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class CarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("car",service.getAll());
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = (req.getParameter("id"));
        if(id == null || id.isBlank() ){
            req.setAttribute("car",service.getAll());
        }else {
            List<Car> byID = service.getByID(id);
            req.setAttribute("car", byID);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
