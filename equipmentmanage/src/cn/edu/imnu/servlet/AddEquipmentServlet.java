package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.bean.EquipmentBean;
import cn.edu.imnu.service.EquipmentService;
import net.sf.json.JSONObject;


@WebServlet("/AddEquipmentServlet")
public class AddEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public AddEquipmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String EquipmentName = request.getParameter("EquipmentName");
		String EquipmentId = request.getParameter("EquipmentId");	
		String EquipmentType = request.getParameter("EquipmentType");
		String option = request.getParameter("option");
		String user_id = request.getParameter("user_id");
		String str = option.substring(option.indexOf("——")+2);

		System.out.println(user_id);
		HashMap<String,String> map = new HashMap<String,String>();
		
		EquipmentService equipment_service = new EquipmentService();
		EquipmentBean equipment = equipment_service.AddEquipment(EquipmentName,EquipmentId,EquipmentType, str, user_id);
		
		if(equipment == null) {
			map.put("status","ok");
		}else {
			map.put("status","err");
		}
		JSONObject json = JSONObject.fromObject(map);
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
