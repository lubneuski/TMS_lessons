package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;
import static alex.lu.CarStorage26H.getCars;

@WebServlet("/car")
public class CarServlet26H extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.isBlank()){
            Map<String, Cars26H> cars = getCars();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req,resp);
        }else{
            if (getCars().containsKey(id)) {
                Cars26H carId = getCars().get(id);
                resp.getOutputStream().println("Id: " + id + " = " + carId.toString());
            }else {
                resp.getOutputStream().println("Car with this ID doesnt exist");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        if (id == null || id.isBlank() || brand == null || brand.isBlank() || model == null || model.isBlank()) {
            resp.setStatus(400);
            resp.getOutputStream().println("Enter all parameters");
        } else if (getCars().containsKey(id)) {
            resp.setStatus(400);
            resp.getOutputStream().println("Car with this ID is already exist");
        } else {
            resp.setStatus(200);
            getCars().put(id, new Cars26H(brand,model));
            resp.sendRedirect("/car");
        }
    }
}