package dao;

public class Factory {
	
	private static Factory instance = null;
	private static UserDAO userDAO = null;
    
    
    public static synchronized Factory getInstance(){
        if (instance == null){
          instance = new Factory();
        }
        return instance;
    }
    
    public static synchronized UserDAO getUserDAO(){
        if (userDAO == null){
        	userDAO = new UserDAO();
        }
        return userDAO;
  }
    
}
