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

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userid = request.getParameter("userid");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		UserService user_service = new UserService();
		UserBean userchange = user_service.ChangeUserInfo(id,userid,name,phone,email);
		UserService newinfo_service = new UserService();
		UserBean user = newinfo_service.SearchNewInfo(id);
		
		if(user!=null && userchange!=null){
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			out.print("<script type='text/javascript'>");
			out.print("alert('Mistake!Please try again!');");
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
