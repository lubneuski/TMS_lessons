package alex.lu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static alex.lu.CarStorage26H.getCars;

@WebServlet("/delete")
public class DeleteCarServlet26H extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.isBlank()) {
            resp.setStatus(400);
            resp.getOutputStream().println("Enter ID");
        } else if (getCars().containsKey((id))){
            resp.setStatus(200);
            getCars().remove(id);
            resp.sendRedirect("/car");
        } else {
            resp.setStatus(400);
            resp.getOutputStream().println("Car with this ID doesnt exist");
        }
    }
}