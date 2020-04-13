package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.core.SqlCommand;
import DAOImplementation.DAOimplementation;
import ModelObject.CustomerInfo;


public class Database {
    
   private final String url = "jdbc:postgresql://localhost:5432/website";
   private final String user = "postgres";
   private final String password = "postgres";
      
   private Connection connection;
   private String sqlcommand;
   private PreparedStatement preparedstatement;
   private ResultSet result;
   private Boolean state;
   
   //private DAOimplementation dao;
   
//   Database(){
//       
//       //LoginCheck();
//       RegisterCustomer();
//   }
   
   private void connect(){
       try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is successfully");
            
       } catch (ClassNotFoundException | SQLException ex) {
           System.out.println("databaseconnection.dataBase.connect()error");
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
   public Boolean LoginCheck(DAOimplementation dao){
       
       connect();  
       try {
           sqlcommand = "SELECT LoginCheck(?,?)";
           preparedstatement = connection.prepareStatement(sqlcommand);
           preparedstatement.setString(1,dao.getCustomer().getUName());
           preparedstatement.setString(2,dao.getCustomer().getPassword());
           result = preparedstatement.executeQuery();
           
           while(result.next()){
               state=result.getBoolean(1);
           }
           
           System.out.println("login function work  successfully");
        //   System.out.println("Login success" + result.getBoolean(1)+"----->"+result.getBoolean(2));
//           System.out.println(state);
           return state;
       } catch (SQLException ex) {
           
            System.out.println("Something happened wrong");
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
       finally{
           stop();
       }
       
   }
   
   public Boolean RegisterCustomer(DAOimplementation daoimpl){
       try {
            connect();    
            sqlcommand = "SELECT CustomerRegister(?,?,?,?,?,?)";
            preparedstatement = connection.prepareStatement(sqlcommand);
//            System.out.println(daoimpl.getCustomer().getUName());
            preparedstatement.setString(1,daoimpl.getCustomer().getUName());
            preparedstatement.setString(2,daoimpl.getCustomer().getPassword());
            preparedstatement.setString(3,daoimpl.getCustomer().getFName());
            preparedstatement.setString(4,daoimpl.getCustomer().getLName());
            preparedstatement.setString(5,daoimpl.getCustomer().getEmail());
            preparedstatement.setString(6,daoimpl.getCustomer().getPhoneNumber());
            result = preparedstatement.executeQuery();
            while(result.next()){
                state = result.getBoolean(1);
            }
            System.out.println("New Customer has registered");
            return state;
       } catch (SQLException ex) {
           System.out.println("something wrong in registration");
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       } 
       finally{
           stop();
       }
       
   }
   
   private void stop(){
       try {
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public static void main(String[] args){
       Database db=new Database();
       
//       CustomerInfo customer1 = new CustomerInfo("mayar", "hassan123@");
//       CustomerInfo customer2 = new CustomerInfo("mohamed93", "123456");
//
//       DAOimplementation dao = new DAOimplementation(customer1);
//       Boolean state = db.LoginCheck(dao);

//        CustomerInfo customer1 = new CustomerInfo("mayar96", "hassan", "Mayar", "Hassan", "mayar@gmail.com", "0191813624");
//        DAOimplementation dao = new DAOimplementation(customer1);
//        Boolean state = db.RegisterCustomer(dao);
//        System.out.println(state);

   }
    
}
