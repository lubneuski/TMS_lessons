package alex.lu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CarLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String metod = ((HttpServletRequest)request).getMethod();
        String head = ((HttpServletRequest)request).getHeader("Param");
        if ("GET".equalsIgnoreCase(metod)) {
            chain.doFilter(request, response);
        }
        if (head == null) {
            throw new ServletException("Enter 'Param'");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}