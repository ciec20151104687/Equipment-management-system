package cn.edu.imnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.UserService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String userValidateCode = request.getParameter("validateCode");
		String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
		PrintWriter out = response.getWriter();
		UserService user_service = new UserService();
		UserBean user = user_service.LoginValidate(userid, pwd);
		if (sessionValidateCode != null) {
			if (sessionValidateCode.equals(userValidateCode)) {	
				if(user!=null){
					request.setAttribute("user", user);
					//response.sendRedirect("EquipmentServlet");
					request.getRequestDispatcher("EquipmentServlet").forward(request, response);
				}else{
					out.print("<script type='text/javascript'>");
	    			out.print("alert('Mistake!Please try again!');");
	    			out.print("window.location='login.jsp';");
	    			out.print("</script>");
				}
			}else{
				out.print("<script type='text/javascript'>");
				out.print("alert('ValidateCode is null!');");
    			
    			out.print("window.location='login.jsp';");
    			out.print("</script>");
			}
		}else{
			out.print("<script type='text/javascript'>");
			out.print("alert('ValidateCode Mistake!');");
			out.print("window.location='login.jsp';");
			out.print("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
