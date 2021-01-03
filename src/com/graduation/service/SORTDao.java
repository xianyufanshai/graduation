package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.SORT;

public class SORTDao {
	public static ArrayList<SORT> selectAll() {
		ArrayList<SORT> list = new ArrayList<SORT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from sort";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 SORT sort = new SORT(
						 	rs.getInt("SORT_ID"),
						 	rs.getString("SORT_NAME"),
						 	rs.getInt("SORT_PARENT_ID")
						 
						 );
				 
				 
				 list.add(sort);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static SORT selectById(int id) {

		SORT sort = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *  from sort  where SORT_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 sort = new SORT(
						 rs.getInt("SORT_ID"),
						 	rs.getString("SORT_NAME"),
						 	rs.getInt("SORT_PARENT_ID")
			
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return sort;
	}
	
	/**
	 * 添加分类
	 * @param cate
	 * @return
	 */
	
	public static int insert(SORT sort) {
		String sql = "insert into  sort values(null, ?, ?)";
		
		Object[] params = {
					sort.getSORT_NAME(), 
					sort.getSORT_PARENT_ID()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	
	

/**
 * 更新分类
 * @param 
 * @return
 */

public static int update(SORT sort) {
	String sql = "update sort set SORT_NAME=?, SORT_PARENT_ID=?  where SORT_ID = ?";
	
	Object[] params = {
				sort.getSORT_NAME(),
				sort.getSORT_PARENT_ID(),
				sort.getSORT_ID()
				};
	
	return Basedao.exectuIUD(sql, params);
}


public static int del(int id) {
	String sql = "delete from sort where SORT_ID=?";
	
	Object[] params = {id};
	
	return Basedao.exectuIUD(sql, params);
	
}
/**
 * 查询分类，子分类和父级分类
 * @param flag  flag="father" flag="child"
 * @return
 */

public static ArrayList<SORT> selectSort(String flag) {
	ArrayList<SORT> list = new ArrayList<SORT>();
	//声明结果集
	ResultSet rs = null;
	//获取连接对象
	Connection conn = Basedao.getconn();
	
	PreparedStatement ps = null;
	
	
	
	try {
		
		String sql = null;
		
		if(flag!=null && flag.equals("father")){
		
			sql = "select * from sort where SORT_PARENT_ID=0";
		}else{
			sql = "select * from sort where SORT_PARENT_ID!=0";
		}
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 SORT sort = new SORT(
					 	rs.getInt("SORT_ID"),
					 	rs.getString("SORT_NAME"),
					 	rs.getInt("SORT_PARENT_ID")
					 
					 );
			 
			 
			 list.add(sort);
			 
		 }
		 
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		Basedao.closeall(rs, ps, conn);
	}
	
	
	
	return list;
}


public static ArrayList<SORT> selectSortByName(String sname) {
	ArrayList<SORT> list = new ArrayList<SORT>();
	//声明结果集
	ResultSet rs = null;
	//获取连接对象
	Connection conn = Basedao.getconn();
	
	PreparedStatement ps = null;
	
	
	
	try {
		String sql = "select * from sort where SORT_PARENT_ID!=0 and SORT_NAME=?";
		ps = conn.prepareStatement(sql);
		 ps.setString(1,sname);
		rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 SORT sort = new SORT(
					 	rs.getInt("SORT_ID"),
					 	rs.getString("SORT_NAME"),
					 	rs.getInt("SORT_PARENT_ID")
					 
					 );
			 
			 
			 list.add(sort);
			 
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



