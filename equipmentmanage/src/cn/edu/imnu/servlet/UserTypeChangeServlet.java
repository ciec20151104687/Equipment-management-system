package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.UserService;
import net.sf.json.JSONObject;


@WebServlet("/UserTypeChangeServlet")
public class UserTypeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserTypeChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		System.out.println(id);
		System.out.println(type);
		UserService user_service = new UserService();
		UserBean user = user_service.usertypechange(id,type);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
