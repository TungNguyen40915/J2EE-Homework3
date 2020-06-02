package servlet;

import bo.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="UpdateUserServlet", urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobilephone = request.getParameter("mobilephone");

        List<String> errors = new ArrayList<String>();

        if (!"".equals(password)){
            UserBO userBO = new UserBO();
            if (userBO.doLogin(username,password)==null){
                errors.add("Wrong old password");
            }
            // no need to validate username here
            else errors = userBO.doValidateUser("asdkjl21lkasdas546",newPassword,confirmNewPassword);
        }

        if (errors.size()!=0){
            request.setAttribute("errorMessage", errors);
            request.setAttribute("password", password);
            request.setAttribute("newPassword", newPassword);
            request.setAttribute("confirmNewPassword", newPassword);
            request.setAttribute("updateMessage", "");
        }
        else {
            UserBO userBO = new UserBO();

            userBO.doUpdateUserInfo(username,firstname,lastname,sex,address,email,mobilephone);
            if (!"".equals(newPassword)) userBO.doUpdateUserPassword(username,newPassword);

            request.setAttribute("updateMessage", "Update successfully");
        }
        request.setAttribute("username", username);
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("sex", sex);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("mobilephone", mobilephone);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/viewUser.jsp");
        dispatcher.forward(request, response);

    }
}
