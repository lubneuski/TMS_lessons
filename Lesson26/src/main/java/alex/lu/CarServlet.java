package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;
import static alex.lu.CarStorage.getCars;

@WebServlet("/")
public class CarServlet extends HttpServlet {

    private CarStorage carStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Cars> car = getCars();
        req.setAttribute("cars", car);
        req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        getCars().put(id, new Cars(brand,model));
        req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req,resp);
    }
}