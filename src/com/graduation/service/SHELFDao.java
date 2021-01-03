package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.SHELF;

public class SHELFDao {

	public static SHELF getShelfBook(String uid, String pid) {
		SHELF es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from shelf where S_UID=? and S_BID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new SHELF(
						 	rs.getInt("SHELF_ID"),
						 	rs.getString("S_BFILENAME"),
						 	rs.getString("S_BWRITER"),
						 	rs.getString("S_BNAME"),
						 	rs.getInt("S_BID"),
						 	rs.getString("S_UID")
						 
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}	
		
		return es;	
	}

	public static int insert(SHELF shelf) {
        String sql = "insert into shelf values(null,?,?,?,?,?)";
		
		Object[] params = {
				
			 	shelf.getS_BFILENAME(),
			 	shelf.getS_BWRITER(),
			 	shelf.getS_BNAME(),
			 	shelf.getS_BID(),
			 	shelf.getS_UID()
				
				
		};
		
		return Basedao.exectuIUD(sql, params);
		
	}

	public static ArrayList<SHELF> getShelf(String id) {
		ArrayList<SHELF> list = new ArrayList<SHELF>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from shelf where S_UID=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 SHELF c = new SHELF(
						 rs.getInt("SHELF_ID"),
						 	rs.getString("S_BFILENAME"),
						 	rs.getString("S_BWRITER"),
						 	rs.getString("S_BNAME"),
						 	rs.getInt("S_BID"),
						 	rs.getString("S_UID")
						 
						 );
				 
				 
				
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;	}

	public static int getbookdel(int sid) {
		 String sql = "delete from shelf where SHELF_ID=?";
			
		   Object[] params={sid};
			
			return Basedao.exectuIUD(sql, params);
		
	}

	

}
