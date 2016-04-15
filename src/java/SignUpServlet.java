/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pax
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "My First Servlet", urlPatterns = { "/signup" , "/signup.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class SignUpServlet extends HttpServlet {

    public SignUpServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("index.html");
        view.forward(request, response);    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Bazica bazica = new Bazica(response);
        if(!request.getParameter("name").equals("") && !request.getParameter("lastname").equals("") 
                && !request.getParameter("email").equals("")){
            
            bazica.saveNewUser(request.getParameter("name"), request.getParameter("lastname"), 
                request.getParameter("email"), request.getParameter("password"), request.getParameter("gender"),"","","");
            out.println("201");
            //sendEmail(request,response);
        }
        else
            out.println("404");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}