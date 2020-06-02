package bo;

import dbaccess.UserMapper;
import dto.UserDTO;
import utility.ApplicationConst;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserBO {

    public UserDTO doLogin(String username, String password) {
        UserDTO userDTO = null;
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            userDTO = mapper.doLogin(username, password);
        } catch (Exception e) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception e) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
            }
        }
        return userDTO;
    }

    public List<String> doValidateUser(String username, String password, String confirmPassword) {
        List<String> resultList = new ArrayList<String>();
        UserMapper mapper = null;

        if ("".equals(username))
            resultList.add("Username " + ApplicationConst.CAN_NOT_BE_EMPTY);

        if ("".equals(password))
            resultList.add("Password " + ApplicationConst.CAN_NOT_BE_EMPTY);

        if ("".equals(confirmPassword))
            resultList.add("confirmPassword " + ApplicationConst.CAN_NOT_BE_EMPTY);

        if (!password.equals(confirmPassword) && !"".equals(password))
            resultList.add(ApplicationConst.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCH);

        if (!"".equals(username)) {
            try {
                mapper = new UserMapper();
                if (!mapper.checkUserName(username))
                    resultList.add(ApplicationConst.USERNAME_EXIST);
            } catch (Exception e) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
            } finally {
                try {
                    mapper.closeConnection();
                } catch (Exception e) {
                    Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
                }
            }
        }

        return resultList;
    }

    public boolean doCreateNewUser(String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilephone) {
        UserDTO userDTO = new UserDTO(username,password,firstname,lastname,sex,address,email,mobilephone,2);
        UserMapper mapper = null;
        boolean result = false;
        try {
            mapper = new UserMapper();
            result = mapper.insertUser(userDTO);
        } catch (Exception e) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception e) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
            }
        }
        return result;
    }

    public List<UserDTO> doGetAllUser(){
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            userDTOList = mapper.getAllUser();
        } catch (Exception e) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception e) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
            }
        }
        return userDTOList;
    }

    public void doDeleteUser(String[] usernameList){
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            for (String s: usernameList) {
                mapper.deleteUser(s);
            }
        } catch (Exception e) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception e) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e.toString());
            }
        }
    }
}
