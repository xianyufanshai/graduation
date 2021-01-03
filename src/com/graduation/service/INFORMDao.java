package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.BOOK;
import com.graduation.entity.INFORM;


public class INFORMDao {

	public static ArrayList<INFORM> selectAll() {
			ArrayList<INFORM> list = new ArrayList<INFORM>();
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			
			
			try {
				String sql = "select * from inform order by I_DATE DESC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 INFORM sort = new INFORM(
							 	rs.getInt("INFORM_ID"),
							 	rs.getString("I_NAME"),
							 	rs.getString("I_CONTENT"),
							 	rs.getString("I_DATE"),
							 	rs.getString("I_UID")
							 
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

	public static int insert(INFORM in) {
	
			String sql = "insert into inform values(null, ?, ?,?,?)";
			
			
			Object[] params = {
						in.getI_NAME(),
						in.getI_CONTENT(),
						in.getI_DATE(),
						in.getI_UID(),
						
						};
			
			return Basedao.exectuIUD(sql, params);
	}

	public static int del(int inid) {
			String sql = "delete from inform where INFORM_ID=?";
			
			Object[] params = {inid};
			
			return Basedao.exectuIUD(sql, params);
			
		
	}
		

}
