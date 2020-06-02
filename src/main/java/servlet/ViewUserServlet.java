package servlet;

import bo.UserBO;
import dto.UserDTO;
import utility.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ViewUserServlet", urlPatterns = "/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO userDTO = AppUtils.getLoginedUser(request.getSession());

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/jsp/viewUser.jsp");
        request.setAttribute("username", userDTO.getUsername());
        request.setAttribute("password", "");
        request.setAttribute("newPassword", "");
        request.setAttribute("confirmNewPassword", "");
        request.setAttribute("firstname", userDTO.getFirstName());
        request.setAttribute("lastname", userDTO.getLastName());
        request.setAttribute("sex", userDTO.getSex());
        request.setAttribute("address", userDTO.getAddress());
        request.setAttribute("email", userDTO.getEmail());
        request.setAttribute("mobilephone", userDTO.getMobilePhone());
        request.setAttribute("updateMessage", "");
        dispatcher.forward(request, response);


    }


}
