package servlet;

import bo.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchUserServlet", urlPatterns = "/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserBO userBO = new UserBO();
        request.setAttribute("list", userBO.doGetAllUser());

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/jsp/searchUser.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobilephone = request.getParameter("mobilephone");

        UserBO userBO = new UserBO();
        request.setAttribute("userName", userName);
        request.setAttribute("role", role);
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("sex", sex);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("mobilephone", mobilephone);

        request.setAttribute("list", userBO.doSearchUser(userName,role,firstname,lastname,sex,address,email,mobilephone));



        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/jsp/searchUser.jsp");

        dispatcher.forward(request, response);
    }
}
