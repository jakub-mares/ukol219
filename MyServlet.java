import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/time-zone")
public class MyServlet extends HttpServlet {
    
    // metoda init se zavolá když server vytváří servlet
    public void init() throws ServletException {
        
    }

    // metoda destroy se zavolá když server vytváří servlet
    public void destroy() {
        
    }

    // metoda doGet se zavolá když přijde http GET požadavek
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String timeZone = request.getParameter("timeZone");
         
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            try {
                ZoneId zoneId = ZoneId.of(timeZone);
                ZonedDateTime now = ZonedDateTime.now(zoneId);
                out.println("<p>" + now + "</p>");
            } catch (DateTimeException e) {}
            out.println("</body>");
            out.println("</html>");
        }
   }
}