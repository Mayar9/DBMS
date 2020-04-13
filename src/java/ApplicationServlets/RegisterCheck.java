package ApplicationServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAOImplementation.DAOimplementation;
import ModelObject.CustomerInfo;

public class RegisterCheck extends HttpServlet {

    DAOimplementation  dao = new DAOimplementation();
    CustomerInfo customer;
    String uname,password,fname;
    String lname,email,phone;
    Boolean state;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        uname=request.getParameter("uname");
        password=request.getParameter("psw");
        fname=request.getParameter("fname");
        lname=request.getParameter("lname");
        email=request.getParameter("email");
        phone=request.getParameter("phone");
        
        customer = new CustomerInfo(uname, password, fname, lname, email, phone);
        state = dao.RegisterCheck(customer);
        if(state){
            out.println("Welcome Here");
        }
        else{
            out.println("sorry you cann't register");
        }
    }

    

   

}
