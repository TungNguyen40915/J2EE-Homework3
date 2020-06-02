package servlet;

import bo.UserBO;
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
        String role = userBO.doLogin(userName,password);

       if("".equals(role)){
           request.setAttribute("errorMessage", ApplicationConst.LOGIN_FAILED_ERROR_MESSAGE);
           RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/login.jsp");
           dispatcher.forward(request, response);
       }
       else{
           RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
           dispatcher.forward(request, response);
       }




    }

}