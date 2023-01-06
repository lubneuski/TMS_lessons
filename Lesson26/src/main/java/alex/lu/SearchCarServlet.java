package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static alex.lu.CarStorage.getCars;

@WebServlet("/search")
public class SearchCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id.isEmpty()){
            Map<String, Cars> cars= getCars();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/WEB-INF/storage.jsp").forward(req,resp);
        }else{
            if (getCars().containsKey(id)) {
                Cars carId = getCars().get(id);
                resp.getOutputStream().println("Id: "+id+" = "+carId.toString());
            }else {
                resp.getOutputStream().println("NotFound");
            }
        }
    }
}