package cn.edu.imnu.service;

import java.util.List;

import cn.edu.imnu.bean.PlaceBean;
import cn.edu.imnu.dao.PlaceDao;

public class PlaceService {

	public List<PlaceBean> getPlaceList(String user_id) {
		// TODO Auto-generated method stub
		PlaceDao placedao = new PlaceDao();
		List<PlaceBean> list = placedao.getPlaceStores(user_id);
		return list;
	}

	public List<PlaceBean> getPlaceList2() {
		// TODO Auto-generated method stub
		PlaceDao placedao = new PlaceDao();
		List<PlaceBean> list = placedao.getPlaceStores2();
		return list;
	}

	public PlaceBean ChangePlace(String user_id, String place_id, String campus, String building, String house_id, String major) {
		// TODO Auto-generated method stub
		PlaceBean placeBean = new PlaceBean();
		placeBean.setUser_id(user_id);
		placeBean.setPlace_id(place_id);
		placeBean.setCampus(campus);
		placeBean.setBuilding(building);
		placeBean.setHouse_id(house_id);
		placeBean.setMajor(major);
		PlaceDao sd = new PlaceDao();
		PlaceBean rs = sd.Change(placeBean);
		return rs;
	}

	public PlaceBean DeletePlace(String id) {
		// TODO Auto-generated method stub
		PlaceBean placeBean = new PlaceBean();
		placeBean.setPlace_id(id);			
		PlaceDao sd = new PlaceDao();
		PlaceBean rs = sd.Delete(placeBean);
		return rs;
	}

	public PlaceBean AddPlace(String user_id, String place_id, String campus, String building, String house_id,
			String major) {
		// TODO Auto-generated method stub
		PlaceBean placeBean = new PlaceBean();
		placeBean.setUser_id(user_id);
		placeBean.setPlace_id(place_id);
		placeBean.setCampus(campus);
		placeBean.setBuilding(building);
		placeBean.setHouse_id(house_id);
		placeBean.setMajor(major);
		PlaceDao sd = new PlaceDao();
		PlaceBean rs = sd.Add(placeBean);
		return rs;
	}



}
