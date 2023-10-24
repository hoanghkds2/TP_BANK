
package repository;

import data_access.LoginDAO;


public class LoginRepository implements ILoginRepository {
    
    @Override
    public void login(String type){
        LoginDAO.Instance().login(type);
    }
}
