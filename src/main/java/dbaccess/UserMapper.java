package dbaccess;

import dto.UserDTO;

import java.sql.*;
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

    public UserDTO doLogin(String username, String password){
        try{
            Statement stmt = getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs!=null && rs.next()){
                return extractUserFromResultSet(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkUserName(String username){
        try{
            Statement stmt = getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs!=null && rs.next()){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    public boolean insertUser(UserDTO userDTO ){
        String SQL_INSERT = "INSERT INTO users(username,password,firstname,lastname,sex,address,email,mobilephone,groupid) " +
                "VALUES (?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getPassword());
            preparedStatement.setString(3, userDTO.getFirstName());
            preparedStatement.setString(4, userDTO.getLastName());
            preparedStatement.setString(5, userDTO.getSex());
            preparedStatement.setString(6, userDTO.getAddress());
            preparedStatement.setString(7, userDTO.getEmail());
            preparedStatement.setString(8, userDTO.getMobilePhone());
            preparedStatement.setString(9, String.valueOf(userDTO.getGroupId()));

            int row = preparedStatement.executeUpdate();

            if(row == 1)
                return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void updateUserInfo(UserDTO userDTO){
        String SQL_INSERT = "UPDATE users set firstname=?,lastname=?,sex=?,address=?,email=?,mobilephone=? where username=?";
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, userDTO.getFirstName());
            preparedStatement.setString(2, userDTO.getLastName());
            preparedStatement.setString(3, userDTO.getSex());
            preparedStatement.setString(4, userDTO.getAddress());
            preparedStatement.setString(5, userDTO.getEmail());
            preparedStatement.setString(6, userDTO.getMobilePhone());
            preparedStatement.setString(7, userDTO.getUsername());

            int row = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateUserPassword(String username, String password){
        String SQL_INSERT = "UPDATE users set password=? where username=?";
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);

            int row = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<UserDTO> getAllUser(){
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        try{
            Statement stmt = getConnection().createStatement();
            String query = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs!=null && rs.next()){
                userDTOList.add(extractUserFromResultSet(rs));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDTOList;
    }

    public void deleteUser(String username){
        String sql = "delete from users where username = '" + username + "'";

        try {
             Statement stmt = getConnection().createStatement();
             stmt.executeUpdate(sql);
             System.out.println("Record deleted successfully" + username + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private UserDTO extractUserFromResultSet(ResultSet rs) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setAddress(rs.getString("address"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setFirstName(rs.getString("firstname"));
        userDTO.setGroupId(rs.getInt("groupid"));
        userDTO.setLastName(rs.getString("lastname"));
        userDTO.setMobilePhone(rs.getString("mobilephone"));
        userDTO.setSex(rs.getString("sex"));
        userDTO.setUsername(rs.getString("username"));
        return userDTO;
    }
}
