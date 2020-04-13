package DAOinterface;

import ModelObject.CustomerInfo;

public interface DAO {
    
    public Boolean LoginCheck(CustomerInfo customer);
    
    public Boolean RegisterCheck(CustomerInfo customer);   
}
