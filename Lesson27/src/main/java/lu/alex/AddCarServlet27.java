package lu.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCarServlet27 extends HttpServlet {

    CarService27 service = new CarServiceImpl27();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req .getParameter("model");
        Car27 car27 = new Car27(id,brand,model);
        service.save(car27);
        resp.sendRedirect("/all");
    }
}
