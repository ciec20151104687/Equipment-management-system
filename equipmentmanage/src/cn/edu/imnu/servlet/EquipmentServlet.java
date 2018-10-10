package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.imnu.bean.EquipmentBean;
import cn.edu.imnu.bean.PlaceBean;
import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.EquipmentService;
import cn.edu.imnu.service.PlaceService;
import cn.edu.imnu.service.UserService;


@WebServlet("/EquipmentServlet")
public class EquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EquipmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		UserBean bean=(UserBean) request.getAttribute("user");
		
		session.setAttribute("SESSIONUSER", bean);
		
		
		String type = bean.getUser_type();		
	
		if("管理员".equals(type)) {
			UserService userservice = new UserService();
			List<UserBean> userlist = userservice.getuser();
			request.setAttribute("userlist", userlist);
			
			EquipmentService equipmentservice = new EquipmentService();
			List<EquipmentBean> list = equipmentservice.getEquipmentList2();
			request.setAttribute("list", list);	

			PlaceService placeservice = new PlaceService();
			List<PlaceBean> placelist = placeservice.getPlaceList2();			
			request.setAttribute("placelist", placelist);
			
			EquipmentService equipment_service = new EquipmentService();
			List<EquipmentBean> equipment = equipment_service.EcharEquipment();			
			request.setAttribute("echarlist", equipment);
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("用户".equals(type)){
			
			EquipmentService equipmentservice = new EquipmentService();
			List<EquipmentBean> list = equipmentservice.getEquipmentList(bean.getUser_id());			
			request.setAttribute("list", list);
			
			PlaceService placeservice = new PlaceService();
			List<PlaceBean> placelist = placeservice.getPlaceList(bean.getUser_id());			
			request.setAttribute("placelist", placelist);
			
			EquipmentService equipment_service = new EquipmentService();
			List<EquipmentBean> equipment = equipment_service.EcharEquipment2(bean.getUser_id());			
			request.setAttribute("echarlist", equipment);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
