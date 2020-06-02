package bo;

import dbaccess.UserMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserBO {

    public String doLogin(String username, String password){
        String role = "";
        UserMapper mapper = null;
        try{
            mapper = new UserMapper();
            role = mapper.doLogin(username,password);
        }catch (Exception e){
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE,null,e.toString());
        }finally {
            try{
                mapper.closeConnection();
            }catch (Exception e){
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE,null,e.toString());
            }
        }
        return role;
    }
}
