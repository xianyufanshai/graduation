package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.USER;



public class USERDao {
	/**
	 * 加入数所库
	 * @param u
	 * @return
	 */
	public static int insert(USER u) {
			String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
			
			Object[] params = {
						u.getUSER_ID(),
						u.getUSER_NAME(), 
						u.getPWD(),
						u.getSEX(),
						u.getEMAIL(),
						u.getSTATUS()};
			
			return Basedao.exectuIUD(sql, params);
	}
	
	/**
	 * 删除一个用户
	 * @param id
	 * @return
	 */
	public static int del(String id) {
		
		String sql = "delete from user where USER_ID=? and status!=1";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static int update(USER u) {
		String sql = "update user set USER_NAME=?, PWd=?,SEX=?,EMAIL=?,STATUS=? where USER_ID = ?";
		
		Object[] params = {
				
				u.getUSER_NAME(), 
				u.getPWD(),
				u.getSEX(),
				u.getEMAIL(),
				u.getSTATUS(),
				u.getUSER_ID(), };
		
		return Basedao.exectuIUD(sql, params);
}

	public static int selectByName(String username) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from user where USER_NAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return count;
	}
	
	
	/**
	 * 获取总记录数和总页数
	 * @param count
	 * @return
	 */
	
	public static int[] totalPage(int count, String keyword) {
		// 0 总记录数， 1， 页数
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from user where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else{
				sql = "select count(*) from user";
				
				ps = conn.prepareStatement(sql);
				
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
	//查询所有用户
	
	public static ArrayList<USER> selectAll(int cpage, int count,String keyword) {
		ArrayList<USER> list = new ArrayList<USER>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from user where USER_NAME like ? order by USER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}else{
			
				sql = "select * from user order by USER_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 
				 ps.setInt(1, (cpage-1)*count);
				 ps.setInt(2, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 USER u = new USER(
						 	rs.getString("USER_ID"),
						 	rs.getString("USER_NAME"),
						 	rs.getString("PWD"),
						 	rs.getString("SEX"),
						 	rs.getString("EMAIL"),
						 	rs.getInt("STATUS")
						 
						 );
				 
				 
				 list.add(u);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	/**
	 * 通过ID查找用户
	 * @param cpage
	 * @param count
	 * @param keyword
	 * @return
	 */
	public static USER selectByID(String id) {

		USER u = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "select*from user  where USER_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 u = new USER(
								 	rs.getString("USER_ID"),
								 	rs.getString("USER_NAME"),
								 	rs.getString("PWD"),
								 	rs.getString("SEX"),
								 	rs.getString("EMAIL"),
								 	rs.getInt("STATUS")
								 
						 );
				
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
	
		return u;
	}
	
	public static int selectByNM(String name, String pwd){
		int count =0; 
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from user where USER_ID=? and PWD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
	}
	/**
	 * 通过用户名和密码查询用户信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	
	public static USER selectAdmin(String name, String pwd) {
	USER u = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from user  where USER_ID=? and PWD=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			 ps.setString(2, pwd);
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 u = new USER(
								 	rs.getString("USER_ID"),
								 	rs.getString("USER_NAME"),
								 	rs.getString("PWD"),
								 	rs.getString("SEX"),
								 	rs.getString("EMAIL"),
								 	rs.getInt("STATUS")
								 
						 );
				
	 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return u;
		
		
	}
	public static int selectByUserName(String username) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from user where USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return count;
	}

	public static ArrayList<USER> selectAll() {
		ArrayList<USER> list = new ArrayList<USER>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			
			
			 String sql = "select * from user";
				 ps = conn.prepareStatement(sql);
 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 USER u = new USER(
						 	rs.getString("USER_ID"),
						 	rs.getString("USER_NAME"),
						 	rs.getString("PWD"),
						 	rs.getString("SEX"),
						 	rs.getString("EMAIL"),
						 	rs.getInt("STATUS")
						 
						 );
				 
				 
				 list.add(u);
				 
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
