package cn.edu.imnu.service;

import java.util.List;

import cn.edu.imnu.bean.EquipmentBean;
import cn.edu.imnu.dao.EquipmentDao;

public class EquipmentService {

	public EquipmentBean DeleteEquipment(int id) {
		// TODO Auto-generated method stub
		EquipmentBean equipmentBean = new EquipmentBean();
		equipmentBean.setId(id);			
		EquipmentDao sd = new EquipmentDao();
		EquipmentBean rs = sd.Delete(equipmentBean);
		return rs;
	}


	public List<EquipmentBean> getEquipmentList(String user_id) {
		// TODO Auto-generated method stub
		EquipmentDao equipmentdao = new EquipmentDao();
		List<EquipmentBean> list = equipmentdao.getEquipmentStores(user_id);
		return list;
	}


	public EquipmentBean AddEquipment(String equipmentName, String equipmentId, String equipmentType, String str,
			String user_id) {
		// TODO Auto-generated method stub
		EquipmentBean equipmentBean = new EquipmentBean();
		equipmentBean.setEquipment_name(equipmentName);		
		equipmentBean.setEquipment_id(equipmentId);	
		equipmentBean.setEquipment_type(equipmentType);	
		equipmentBean.setPlace_id(str);	
		equipmentBean.setUser_id(user_id);	
		EquipmentDao sd = new EquipmentDao();
		EquipmentBean rs = sd.Add(equipmentBean);
		return rs;
	}

	public EquipmentBean ChangeEquipment(int id, String ce_name, String ce_id, String ce_type, String str) {
		// TODO Auto-generated method stub
		EquipmentBean equipmentBean = new EquipmentBean();
		equipmentBean.setId(id);
		equipmentBean.setEquipment_name(ce_name);
		equipmentBean.setEquipment_id(ce_id);
		equipmentBean.setEquipment_type(ce_type);
		equipmentBean.setPlace_id(str);
		EquipmentDao sd = new EquipmentDao();
		EquipmentBean rs = sd.Change(equipmentBean);
		return rs;
	}


	public List<EquipmentBean> getEquipmentList2() {
		// TODO Auto-generated method stub
		EquipmentDao equipmentdao = new EquipmentDao();
		List<EquipmentBean> list = equipmentdao.getEquipmentStores2();
		return list;
	}


	public List<EquipmentBean> EcharEquipment() {
		// TODO Auto-generated method stub
		EquipmentDao equipmentdao = new EquipmentDao();
		List<EquipmentBean> list = equipmentdao.getechar();
		return list;
	}


	public List<EquipmentBean> EcharEquipment2(String user_id) {
		// TODO Auto-generated method stub
		EquipmentDao equipmentdao = new EquipmentDao();
		List<EquipmentBean> list = equipmentdao.getechar2(user_id);
		return list;
	}





}
