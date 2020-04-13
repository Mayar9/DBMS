package ApplicationServlets;

import ModelObject.CustomerInfo;
import DAOImplementation.DAOimplementation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCheck extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            
            String userName = request.getParameter("uname");
            String passwd = request.getParameter("psw");
            
            CustomerInfo customer= new CustomerInfo(userName, passwd);
            DAOimplementation dao = new DAOimplementation();
            Boolean state = dao.LoginCheck(customer);
            if(state){
                out.println("Welcome here");
            }
            else{
                out.println("sorry, try again");
            }


    }

  
   

}
