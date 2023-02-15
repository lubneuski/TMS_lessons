package lu.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req .getParameter("model");
        Car car = new Car (id,brand,model);
        service.save(car);
        resp.sendRedirect("/all");
    }
}