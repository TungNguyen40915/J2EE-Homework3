package servlet;

import bo.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUserServlet", urlPatterns = "/ListUserServlet")
public class ListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserBO userBO = new UserBO();
        request.setAttribute("list", userBO.doGetAllUser());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("back") != null) {
            response.sendRedirect(request.getContextPath() + "/GoAdminFunctionServlet");
        } else if (request.getParameter("delete") != null) {
            String[] selectedUser = request.getParameterValues("selected");
            UserBO userBO = new UserBO();
            userBO.doDeleteUser(selectedUser);
            request.setAttribute("list", userBO.doGetAllUser());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userList.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("create") != null) {
            response.sendRedirect(request.getContextPath() + "/GoCreateUserServlet");
        }
    }
}
