package servlet;

import bo.UserBO;
import dto.UserDTO;
import utility.AppUtils;
import utility.ApplicationConst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("errorMessage", "");

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/jsp/login.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserBO userBO = new UserBO();
        UserDTO userDTO = userBO.doLogin(userName,password);

       if(userDTO == null){
           request.setAttribute("errorMessage", ApplicationConst.LOGIN_FAILED_ERROR_MESSAGE);
           RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/login.jsp");
           dispatcher.forward(request, response);
       }
       else if (userDTO.getGroupId() == 1){ //admin
           AppUtils.storeLoginedUser(request.getSession(), userDTO);
           response.sendRedirect(request.getContextPath() + "/GoAdminFunctionServlet");
       }
       else { //user
           AppUtils.storeLoginedUser(request.getSession(), userDTO);
           response.sendRedirect(request.getContextPath() + "/GoUserFunctionServlet");
       }




    }

}