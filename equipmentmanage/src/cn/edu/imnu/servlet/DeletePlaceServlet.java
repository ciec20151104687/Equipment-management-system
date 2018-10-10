package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.bean.PlaceBean;
import cn.edu.imnu.service.PlaceService;
import net.sf.json.JSONObject;

@WebServlet("/DeletePlaceServlet")
public class DeletePlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		HashMap<String,String> map = new HashMap<String,String>();
		PlaceService place_service = new PlaceService();
		PlaceBean place = place_service.DeletePlace(id);
		if(place == null) {
			map.put("status","ok");
		}else {
			map.put("status","err");
		}
		JSONObject json = JSONObject.fromObject(map);
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
