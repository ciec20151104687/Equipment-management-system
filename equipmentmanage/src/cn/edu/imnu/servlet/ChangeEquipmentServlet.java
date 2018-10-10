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


@WebServlet("/ChangeEquipmentServlet")
public class ChangeEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeEquipmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String ce_name = request.getParameter("ce_name");
		String ce_id = request.getParameter("ce_id");
		String ce_type = request.getParameter("ce_type");
		String option = request.getParameter("option");
		String str = option.substring(option.indexOf("——")+2);
		
		HashMap<String,String> map = new HashMap<String,String>();
		EquipmentService equipment_service = new EquipmentService();
		EquipmentBean equipment = equipment_service.ChangeEquipment(id,ce_name,ce_id,ce_type,str);
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
