package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.BOOK;
import com.graduation.entity.COMMENT;

public class COMMENTDao {

	public static int insert(COMMENT com) {
      String sql = "insert into comment values(null, ?, ?,?,?,0)";
	
		Object[] params = {
					com.getCOMMENT_CONTENT(),
					com.getCOM_BID(),
					com.getCOM_UID(),
					com.getCOM_DATE(),
					
					};
		
		return Basedao.exectuIUD(sql, params);
	}

	public static ArrayList<COMMENT> getComByBid(int bid) {
		
			ArrayList<COMMENT> list = new ArrayList<COMMENT>();
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			
			
			try {
				String sql = "select * from comment where COM_BID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,bid);
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 COMMENT com = new COMMENT(
							 rs.getInt("COMMENT_ID"),
							 	rs.getString("COMMENT_CONTENT"),
							 	rs.getInt("COM_BID"),
							 	rs.getString("COM_UID"),
							 	rs.getString("COM_DATE"),
							 	rs.getInt("COM_CHECK")
							 );
					 
					 
					 list.add(com);
					 
				 }
				 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			
			return list;
		}
	
	
	
	
	
	public static ArrayList<COMMENT> SelectAll() {
		
		ArrayList<COMMENT> list = new ArrayList<COMMENT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from comment order by COM_DATE DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 COMMENT com = new COMMENT(
						 rs.getInt("COMMENT_ID"),
						 	rs.getString("COMMENT_CONTENT"),
						 	rs.getInt("COM_BID"),
						 	rs.getString("COM_UID"),
						 	rs.getString("COM_DATE"),
						 	rs.getInt("COM_CHECK")
						 );
				 
				 
				 list.add(com);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}

	public static int del(int comid) {
		String sql = "delete from comment where COMMENT_ID=?";
		
		Object[] params = {comid};
		
		return Basedao.exectuIUD(sql, params);
	}

	public static ArrayList<COMMENT> getMyComment(String uid) {
		ArrayList<COMMENT> list = new ArrayList<COMMENT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from comment where COM_UID=?";
			ps = conn.prepareStatement(sql);
			 ps.setInt(1,Integer.parseInt(uid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 COMMENT com = new COMMENT(
						 rs.getInt("COMMENT_ID"),
						 	rs.getString("COMMENT_CONTENT"),
						 	rs.getInt("COM_BID"),
						 	rs.getString("COM_UID"),
						 	rs.getString("COM_DATE"),
						 	rs.getInt("COM_CHECK")
						 );
				 
				 
				 list.add(com);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	}
	

	
	


