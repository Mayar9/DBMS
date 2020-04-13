package ModelObject;

public class CustomerInfo {
    String fName,lName,uName;
    String password,email,phoneNumber;
    
    public CustomerInfo(String _uName,String _password,String _fName,
                String _lName,String _email, String _phoneNumber){
        this.uName = _uName;
        this.password = _password;
        this.fName = _fName;
        this.lName = _lName;
        this.email = _email;
        this.phoneNumber = _phoneNumber;
    }
    
    public CustomerInfo(String _uName,String _password){
        this.uName = _uName;
        this.password = _password;
    }
    
    public void setFName(String _fName){
        this.fName = _fName;
    }
    
    public void setLName(String _lName){
        this.lName = _lName;
    }
    
    public void setUName(String _uName){
        this.uName = _uName;
    }
    
    public void setPassword(String _password){
        this.password = _password;
    }
    
    public void setEmail(String _email){
        this.email = _email;
    }
    
    public void setPhoneNumber(String _phoneNumber){
        this.phoneNumber = _phoneNumber;
    }
    
    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }
    
    public String getUName(){
        return  uName;
    }
    
    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
}

