package lu.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateCarServlet27 extends HttpServlet {

    CarService27 service = new CarServiceImpl27();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req .getParameter("model");
        service.update(new Car27(id, brand, model));
        req.getRequestDispatcher("/all").forward(req,resp);
    }
}
