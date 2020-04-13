package DAOImplementation;
import DAOinterface.DAO;
import ModelObject.CustomerInfo;
import DatabaseConnection.Database;

public class DAOimplementation implements DAO{
    
    CustomerInfo customer;
    DAOimplementation dao;
    Boolean state;
    Database db = new Database();
    
    public DAOimplementation(){
        
    }
    
    public DAOimplementation(CustomerInfo _customer){
        this.customer = _customer;
    }
      
    public CustomerInfo getCustomer(){
        return customer;
    }

    @Override
    public Boolean LoginCheck(CustomerInfo customer) {
        dao = new DAOimplementation(customer);
        state =db.LoginCheck(dao);
        return state;
    }

    @Override
    public Boolean RegisterCheck(CustomerInfo customer) {
        dao = new DAOimplementation(customer);
        state = db.RegisterCustomer(dao);  
        return state;
    }
    
}
