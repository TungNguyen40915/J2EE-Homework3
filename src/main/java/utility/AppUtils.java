package utility;

import dto.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

    public static void storeLoginedUser(HttpSession session, UserDTO loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static UserDTO getLoginedUser(HttpSession session) {
        UserDTO loginedUser = (UserDTO) session.getAttribute("loginedUser");
        return loginedUser;
    }
}
