package cn.edu.imnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.UserService;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");	
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		Part p = request.getPart("img_url"); 
		//PrintWriter out = response.getWriter();
		p.write(request.getServletContext().getRealPath("/upload")+"/"+userid+".jpg");
		String url = request.getScheme()+"://"+request.getHeader("host")+request.getContextPath()+"/upload/"+userid+".jpg";
		
	    UserService user_service = new UserService();
	    UserBean user = user_service.RegisternValidate(userid,pwd,name,phone,email,url);
	   	
	    	if (user == null) {    			
	    			request.getAttribute(userid);	
	    			request.getAttribute(pwd);
	    			request.getAttribute(name);	
	    			request.getAttribute(phone);
	    			request.getAttribute(email);
	    			request.getAttribute(url);
	    			response.sendRedirect("login.jsp");
	    			//request.getRequestDispatcher("login.jsp").forward(request, response);
	    		  			
	    		} else {
	    			response.sendRedirect("register.jsp");
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
