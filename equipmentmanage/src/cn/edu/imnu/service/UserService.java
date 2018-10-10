package cn.edu.imnu.service;

import java.util.List;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.dao.UserDao;

public class UserService {

	public UserBean LoginValidate(String userid, String pwd) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setUser_id(userid);
		userBean.setUser_pwd(pwd);
		UserDao sd = new UserDao();
		UserBean rs = sd.login(userBean);
		return rs;
	}

	public UserBean RegisternValidate(String userid, String pwd, String name, String phone, String email, String url) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setUser_id(userid);		
		userBean.setUser_pwd(pwd);
		userBean.setUser_name(name);
		userBean.setUser_phone(phone);
		userBean.setUser_email(email);
		userBean.setUser_head(url);
		UserDao sd = new UserDao();
		UserBean rs = sd.Register(userBean);
		return rs;
	}

	public List<UserBean> getuser() {
		// TODO Auto-generated method stub
		UserDao equipmentdao = new UserDao();
		List<UserBean> list = equipmentdao.getUsername();
		return list;
		
	}

	public UserBean usertypechange(int id, String type) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setId(id);	
		userBean.setUser_type(type);	
		UserDao sd = new UserDao();
		UserBean rs = sd.typechange(userBean);
		return rs;
	}

	public UserBean ChangePassword(String pwd, int id) {
		// TODO Auto-generated method stub
		UserBean userbean = new UserBean();
		userbean.setId(id);
		userbean.setUser_pwd(pwd);
		UserDao ld = new UserDao();
		UserBean rs = ld.changePwd(userbean);
		
		return rs;
	}

	public UserBean ChangeUserInfo(int id, String userid, String name, String phone, String email) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setUser_id(userid);		
		userBean.setUser_name(name);
		userBean.setUser_phone(phone);
		userBean.setUser_email(email);
		userBean.setId(id);
		UserDao sd = new UserDao();
		UserBean rs = sd.ChangeInfo(userBean);
	
		return rs;
	}

	public UserBean SearchNewInfo(int id) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		userBean.setId(id);		
		UserDao sd = new UserDao();
		UserBean rs = sd.getUserInfo(id);
		return rs;
	}


}
