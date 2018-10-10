package cn.edu.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.Util.DBUtil;
import cn.edu.imnu.bean.EquipmentBean;

public class EquipmentDao {

	public List<EquipmentBean> getEquipmentStores(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from equipment,place where  equipment.place_id = place.place_id and equipment.user_id = ? order by equipment.id desc";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				EquipmentBean bean = new EquipmentBean();
				bean.setId(rs.getInt("id"));
				bean.setEquipment_name(rs.getString("equipment_name"));
				bean.setEquipment_id(rs.getString("equipment_id"));
				bean.setEquipment_img(rs.getString("equipment_img"));
				bean.setEquipment_place(rs.getString("campus")+rs.getString("building")+rs.getString("house_id"));
				bean.setMajor(rs.getString("major"));
				bean.setEquipment_type(rs.getString("equipment_type"));
				bean.setUser_id(rs.getString("user_id"));
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

	public EquipmentBean Add(EquipmentBean equipmentBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "insert into equipment(equipment_name,equipment_id,equipment_type,place_id,user_id) values(?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, equipmentBean.getEquipment_name());
			pstm.setString(2, equipmentBean.getEquipment_id());
			pstm.setString(3, equipmentBean.getEquipment_type());
			pstm.setString(4, equipmentBean.getPlace_id());
			pstm.setString(5, equipmentBean.getUser_id());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return equipmentBean;
	}

	public EquipmentBean Delete(EquipmentBean equipmentBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="delete from equipment where id=?";
		PreparedStatement pstm =null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, equipmentBean.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
				DBUtil.closeJDBC(null,pstm,conn);
		}
		return equipmentBean;
	}

	public EquipmentBean Change(EquipmentBean equipmentBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="UPDATE equipment SET equipment_name=?,equipment_id=?,equipment_type=?,place_id=? WHERE id=?";
		PreparedStatement pstm =null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, equipmentBean.getEquipment_name());
			pstm.setString(2, equipmentBean.getEquipment_id());
			pstm.setString(3, equipmentBean.getEquipment_type());
			pstm.setString(4, equipmentBean.getPlace_id());
			pstm.setInt(5, equipmentBean.getId());
			
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn,pstm,null);
		}
		return equipmentBean;
	}

	public List<EquipmentBean> getEquipmentStores2() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from equipment,place where  equipment.place_id = place.place_id  order by equipment.id desc";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				EquipmentBean bean = new EquipmentBean();
				bean.setId(rs.getInt("id"));
				bean.setEquipment_name(rs.getString("equipment_name"));
				bean.setEquipment_id(rs.getString("equipment_id"));
				bean.setEquipment_img(rs.getString("equipment_img"));
				bean.setEquipment_place(rs.getString("campus")+rs.getString("building")+rs.getString("house_id"));
				bean.setMajor(rs.getString("major"));
				bean.setEquipment_type(rs.getString("equipment_type"));
				bean.setUser_id(rs.getString("user_id"));
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

	public List<EquipmentBean> getechar() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="SELECT equipment_name, COUNT(equipment_id) FROM equipment GROUP BY equipment_name";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				EquipmentBean bean = new EquipmentBean();
				bean.setEquipment_name(rs.getString("equipment_name"));
				bean.setCount(rs.getString("COUNT(equipment_id)"));
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

	public List<EquipmentBean> getechar2(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="SELECT equipment_name, COUNT(equipment_id) FROM equipment where user_id=? GROUP BY equipment_name ";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				EquipmentBean bean = new EquipmentBean();
				bean.setEquipment_name(rs.getString("equipment_name"));
				bean.setCount(rs.getString("COUNT(equipment_id)"));
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

	

}
