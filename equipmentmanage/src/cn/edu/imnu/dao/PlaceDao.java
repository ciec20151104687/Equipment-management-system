package cn.edu.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.Util.DBUtil;
import cn.edu.imnu.bean.PlaceBean;

public class PlaceDao {

	public List<PlaceBean> getPlaceStores(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from place where user_id = ? order by place_id asc";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<PlaceBean> list = new ArrayList<PlaceBean>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				PlaceBean bean = new PlaceBean();
				bean.setCampus(rs.getString("campus"));
				bean.setBuilding(rs.getString("building"));
				bean.setHouse_id(rs.getString("house_id"));
				bean.setMajor(rs.getString("major"));
				bean.setPlace_id(rs.getString("place_id"));
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

	public List<PlaceBean> getPlaceStores2() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="select * from place order by place_id asc";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<PlaceBean> list = new ArrayList<PlaceBean>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				PlaceBean bean = new PlaceBean();
				bean.setCampus(rs.getString("campus"));
				bean.setBuilding(rs.getString("building"));
				bean.setHouse_id(rs.getString("house_id"));
				bean.setMajor(rs.getString("major"));
				bean.setPlace_id(rs.getString("place_id"));
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

	public PlaceBean Change(PlaceBean placeBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="UPDATE place SET campus=?, building=?, house_id=?, major=? WHERE place_id=?";
		PreparedStatement pstm =null;
		try {
			pstm = conn.prepareStatement(sql);		
			
			pstm.setString(1, placeBean.getCampus());
			pstm.setString(2, placeBean.getBuilding());
			pstm.setString(3, placeBean.getHouse_id());
			pstm.setString(4, placeBean.getMajor());
			pstm.setString(5, placeBean.getPlace_id());
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn,pstm,null);
		}
		return placeBean;
	}

	public PlaceBean Delete(PlaceBean placeBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="delete from place where place_id=?";
		PreparedStatement pstm =null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, placeBean.getPlace_id());
			pstm.executeUpdate();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
				DBUtil.closeJDBC(null,pstm,conn);
		}
		return placeBean;
	}

	public PlaceBean Add(PlaceBean placeBean) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "insert into place(place_id,campus,building,house_id,major,user_id) values(?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, placeBean.getPlace_id());
			pstm.setString(2, placeBean.getCampus());
			pstm.setString(3, placeBean.getBuilding());
			pstm.setString(4, placeBean.getHouse_id());
			pstm.setString(5, placeBean.getMajor());
			pstm.setString(6, placeBean.getUser_id());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return placeBean;
	}

}
