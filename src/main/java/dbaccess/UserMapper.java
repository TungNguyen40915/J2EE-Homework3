package dbaccess;

import dto.UserDTO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserMapper extends MapperDB{

    public UserMapper() throws Exception{
        super();
    }

    public List<UserDTO> getAllUsers(){
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        return userDTOList;
    }

    public String doLogin(String username, String password){
        String role = "";

        try{
            Statement stmt = getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs!=null && rs.next()){
                role = rs.getString("groupid");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }
}
