package utility;

import dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();
        UserDTO loginedUser = AppUtils.getLoginedUser(request.getSession());

        if (servletPath.equals("/LoginServlet")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;
        if (loginedUser != null) {
            String userName = loginedUser.getUsername();
            List<String> roles = new ArrayList<String>();
            if(loginedUser.getGroupId() == 1)
                roles.add("Admin");
            else roles.add("User");
            wrapRequest = new UserRoleRequestWrapper(userName, roles, request);
        }
        if (SecurityUtils.isSecurityPage(request)) {
            if (loginedUser == null) {
                response.sendRedirect(wrapRequest.getContextPath() + "/LoginServlet");
                return;
            }
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/jsp/accessDenyPage.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        chain.doFilter(wrapRequest, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

}