package servlet;

import bo.UserBO;
import dto.UserDTO;
import utility.ApplicationConst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoCreateUserServlet", urlPatterns = "/GoCreateUserServlet")
public class GoCreateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/jsp/createUser.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobilephone = request.getParameter("mobilephone");


        UserBO userBO = new UserBO();
        List<String> errorList = userBO.doValidateUser(userName, password, confirmPassword);
        if (errorList.size() != 0) {
            request.setAttribute("errorMessage", errorList);
            request.setAttribute("userName", userName);
            request.setAttribute("password", "");
            request.setAttribute("confirmPassword", "");
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("sex", sex);
            request.setAttribute("address", address);
            request.setAttribute("email", email);
            request.setAttribute("mobilephone", mobilephone);
            request.setAttribute("insertMessage", "");

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/createUser.jsp");
            dispatcher.forward(request, response);
        } else {

            if (userBO.doCreateNewUser(userName, password, firstname, lastname, sex, address, email, mobilephone))
                request.setAttribute("insertMessage", ApplicationConst.INSERT_USER_SUCCESS);
            else
                request.setAttribute("insertMessage", ApplicationConst.INSERT_USER_FAIL);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/createUser.jsp");
            dispatcher.forward(request, response);
        }

    }
}
