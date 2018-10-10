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

/**
 * Servlet implementation class AddPlaceServlet
 */
@WebServlet("/AddPlaceServlet")
public class AddPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String place_id = request.getParameter("place_id");
		String campus = request.getParameter("campus");
		String building = request.getParameter("building");
		String house_id = request.getParameter("house_id");
		String major = request.getParameter("major");

		HashMap<String,String> map = new HashMap<String,String>();
		PlaceService place_service = new PlaceService();
		PlaceBean place = place_service.AddPlace(user_id,place_id,campus,building,house_id,major);
		if(place == null) {
			map.put("status","ok");
		}else {
			map.put("status","err");
		}
		//JSONObject json = JSONObject.fromObject(map);
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
