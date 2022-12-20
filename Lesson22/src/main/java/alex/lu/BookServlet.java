package alex.lu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("==== Do Init ====");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==== Do Service ====");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("==== Do Get ====");
//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.println("Hello from my 1st servlet!");
//        outputStream.close();
        req.getRequestDispatcher("/book.jsp").forward(req,resp);

    }
}
