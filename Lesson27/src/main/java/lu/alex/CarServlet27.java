package lu.alex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class CarServlet27 extends HttpServlet {

    CarService27 service = new CarServiceImpl27();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("cars27",service.getAll());
        req.getRequestDispatcher("index27.jsp").forward(req, resp);




//        String id = req.getParameter("id");
//        if (id == null || id.isBlank()){
//            Map<String, Cars26H> cars = getCars();
//            req.setAttribute("cars", cars);
//            req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req,resp);
//        }else{
//            if (getCars().containsKey(id)) {
//                Cars26H carId = getCars().get(id);
//                resp.getOutputStream().println("Id: " + id + " = " + carId.toString());
//            }else {
//                resp.getOutputStream().println("Car with this ID doesnt exist");
//            }
//        }
//        req.getRequestDispatcher("index27.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null || id.isBlank()){
            req.setAttribute("car27",service.getAll());
        }else {
            List<Car27> byID = service.getByID(id);
            req.setAttribute("car27", byID);
        }
        req.getRequestDispatcher("index27.jsp").forward(req, resp);
    }
}
