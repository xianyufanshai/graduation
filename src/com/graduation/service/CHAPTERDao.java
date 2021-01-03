package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.BOOK;
import com.graduation.entity.CHAPTER;
import com.graduation.entity.USER;


public class CHAPTERDao {
	public static int[] totalPage(int count, String keyword,int bid) {
		// 0 总记录数， 1， 页数
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "";
			if(keyword!=null) {
				sql = "select count(*) from chapter where CHAPTER_NAME like ? and C_BID=?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, bid);
			}else{
				sql = "select count(*) from chapter where C_BID=? ";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bid);
				
			}
		
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return arr;
	}

	
	public static ArrayList<CHAPTER> selectBookAll(int cpage, int count,String bid,String keyword) {
		ArrayList<CHAPTER> list = new ArrayList<CHAPTER>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
            String sql = "";
			
			if(keyword!=null) {
				sql = "select * from chapter where CHAPTER_NAME like ? and C_BID=? order by CHAPTER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, Integer.parseInt(bid));
				 ps.setInt(3, (cpage-1)*count);
				 ps.setInt(4, count);
			}else{
		       sql = "select * from chapter where C_BID=? order by CHAPTER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, Integer.parseInt(bid));
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			
			}
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 CHAPTER c = new CHAPTER(
						 	rs.getInt("CHAPTER_ID"),
						 	rs.getString("CHAPTER_NAME"),
						 	rs.getString("C_FILENAME"),
						 	rs.getString("C_BNAME"),
						 	rs.getInt("C_BID")
						 );
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	public static ArrayList<CHAPTER> selectAllByBid(int bid) {
		ArrayList<CHAPTER> list = new ArrayList<CHAPTER>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
		   String sql = "select * from chapter where C_BID=? order by CHAPTER_ID  ASC ";
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, bid);
			
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 CHAPTER c = new CHAPTER(
						 	rs.getInt("CHAPTER_ID"),
						 	rs.getString("CHAPTER_NAME"),
						 	rs.getString("C_FILENAME"),
						 	rs.getString("C_BNAME"),
						 	rs.getInt("C_BID")
						 );
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<CHAPTER> selectAll(int cpage, int count,String keyword) {
		ArrayList<CHAPTER> list = new ArrayList<CHAPTER>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from chapter where C_BNAME like ? order by CHAPTER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}else{
			
				sql = "select * from chapter  order by CHAPTER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 
				 ps.setInt(1, (cpage-1)*count);
				 ps.setInt(2, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 CHAPTER c = new CHAPTER(
						 	rs.getInt("CHAPTER_ID"),
						 	rs.getString("CHAPTER_NAME"),
						 	rs.getString("C_FILENAME"),
						 	rs.getString("C_BNAME"),
						 	rs.getInt("C_BID")
						 );
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}


	public static CHAPTER selectByID(String chid) {
		
			CHAPTER ch = null;
			
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			try {
				String sql = "select*from chapter  where CHAPTER_ID=?";
				
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, Integer.parseInt(chid));
				
				 
				 rs = ps.executeQuery();
				 
				 while(rs.next()) {
					  ch = new CHAPTER(
							 	rs.getInt("CHAPTER_ID"),
							 	rs.getString("CHAPTER_NAME"),
							 	rs.getString("C_FILENAME"),
							 	rs.getString("C_BNAME"),
							 	rs.getInt("C_BID")
							 );
					
				 }
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Basedao.closeall(rs, ps, conn);
			}
		
			return ch;
		}


	public static int insert(CHAPTER c) {
		String sql = "insert into chapter values(null, ?, ?,?,?)";
		
		
		Object[] params = {
					c.getCHAPTER_NAME(),
					c.getC_FILENAME(),
					c.getC_BNAME(),
					c.getC_BID(),
				
					};
		
		return Basedao.exectuIUD(sql, params);
	}


	public static int del(int cid) {
            String sql = "delete from chapter where CHAPTER_ID=?";
		
		
            Object[] params = {cid};
		
		return Basedao.exectuIUD(sql, params);
	}


	public static int update(CHAPTER c) {
		
			String sql = "update chapter set CHAPTER_NAME=?, C_FILENAME=?,C_BNAME=?,C_BID=? where CHAPTER_ID=?";
			Object[] params = {
					
					c.getCHAPTER_NAME(),
					c.getC_FILENAME(),
					c.getC_BNAME(),
					c.getC_BID(),
					c.getCHAPTER_ID()
					
				
					};
			
			return Basedao.exectuIUD(sql, params);
	}


}


