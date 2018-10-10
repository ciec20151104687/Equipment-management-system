package cn.edu.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.Util.DBUtil;

public class UserDao {

	public UserBean login(UserBean userbean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from  equipmentmanage.user where user_id=? and user_pwd = ?";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		UserBean resultBean = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userbean.getUser_id());
			pstm.setString(2, userbean.getUser_pwd());
			rs = pstm.executeQuery();
			while(rs.next()){
				resultBean = new UserBean();
				resultBean.setUser_id(rs.getString("user_id"));
				resultBean.setUser_type(rs.getString("user_type"));
				resultBean.setUser_name(rs.getString("user_name"));
				resultBean.setUser_head(rs.getString("user_head"));
				resultBean.setUser_phone(rs.getString("user_phone"));
				resultBean.setUser_email(rs.getString("user_email"));
				resultBean.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn,pstm,rs);
		}
		return resultBean;
	}

	public UserBean Register(UserBean userBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user(user_id,user_name,user_pwd,user_phone,user_email, user_head,user_type) values(?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		UserBean resultBean = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userBean.getUser_id());
			pstm.setString(2, userBean.getUser_name());
			pstm.setString(3, userBean.getUser_pwd());
			pstm.setString(4, userBean.getUser_phone());
			pstm.setString(5, userBean.getUser_email());
			pstm.setString(6, userBean.getUser_head());
			pstm.setString(7, "用户");
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return resultBean;
	}

	public UserBean getUserInfo(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from user where id=?";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		UserBean user = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				user = new UserBean();
				user.setUser_email(rs.getString("user_email"));
				user.setUser_head(rs.getString("user_head"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_type(rs.getString("user_type"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs,pstm,conn);
		}
		return user;
	}

	public List<UserBean> getUsername() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from user";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_head(rs.getString("user_head"));
				bean.setUser_type(rs.getString("user_type"));
				if("管理员".equals(rs.getString("user_type"))) {
					bean.setUser_typechange("取消管理员权限");
				}else if("用户".equals(rs.getString("user_type"))){
					bean.setUser_typechange("授予管理员权限");
				}
				list.add(bean);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs,pstm,conn);
		}
		return list;
	}

	public UserBean typechange(UserBean userBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="UPDATE user SET user_type=? WHERE id=?";
		PreparedStatement pstm =null;
		try {
			pstm = conn.prepareStatement(sql);
			if("管理员".equals(userBean.getUser_type())) {
				pstm.setString(1, "用户");
			}else if("用户".equals(userBean.getUser_type())) {
				pstm.setString(1, "管理员");
			}
			pstm.setInt(2, userBean.getId());
			
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn,pstm,null);
		}
		return userBean;
	}

	public UserBean ChangeInfo(UserBean userBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE equipmentmanage.user SET user_id=?,user_name=?,user_phone=?,user_email=? WHERE id = ? ";
		PreparedStatement pstm = null;
		UserBean resultBean = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userBean.getUser_id());	
			pstm.setString(2, userBean.getUser_name());
			pstm.setString(3, userBean.getUser_phone());
			pstm.setString(4, userBean.getUser_email());
			pstm.setInt(5, userBean.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		
		return resultBean;
	}

	public UserBean changePwd(UserBean userbean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE equipmentmanage.user SET user_pwd = ? WHERE id = ? ";
		PreparedStatement pstm = null;
		UserBean resultBean = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userbean.getUser_pwd());	
			pstm.setInt(2, userbean.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return resultBean;
	}


}
