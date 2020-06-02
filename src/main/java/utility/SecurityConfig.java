package utility;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_ADMIN = "Admin";
    public static final String ROLE_USER = "User";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Cấu hình cho vai trò "ADMIN".
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/DeleteUserServlet");
        urlPatterns1.add("/GoAdminFunctionServlet");
        urlPatterns1.add("/GoCreateUserServlet");
        urlPatterns1.add("/InsertUserServlet");
        urlPatterns1.add("/ListUserServlet");
        urlPatterns1.add("/SearchUserServlet");

        mapConfig.put(ROLE_ADMIN, urlPatterns1);

        // Cấu hình cho vai trò "MANAGER".
        List<String> urlPatterns2 = new ArrayList<String>();

        urlPatterns2.add("/ViewUserServlet");
        urlPatterns2.add("/UpdateUserServlet");
        urlPatterns2.add("/GoUserFunctionServlet");

        mapConfig.put(ROLE_USER, urlPatterns2);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
