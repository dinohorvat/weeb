
import Modeli.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Pax
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/login" , "/login.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class ServletLogin extends HttpServlet 
{
    public ServletLogin() {
        super();        
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("email"));
        
        PrintWriter out = response.getWriter();
        
        Bazica bazica = new Bazica(response);
        User user = (User)bazica.getUserByName(request.getParameter("email"));
        if(user == null){
            System.out.println("null je");
            out.println("404");
        }
        else
        {
            System.out.println(user.getPassword());
            if(user.getPassword().equals(request.getParameter("password")))
            {
                System.out.println("lepo");
                out.println("200");
            }
            else
            {
                System.out.println("nije lepo");
                out.println("401");
             }
        }
        
        
    }
}
