package com.graduation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.graduation.dao.Basedao;
import com.graduation.entity.BOOK;
import com.graduation.entity.SORT;


public class BOOKDao {
	public static int insert(BOOK p) {
		String sql = "insert into book values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					p.getBOOK_NAME(),
					p.getBOOK_DESCRIPTION(),
					p.getBOOK_FID(),
					p.getBOOK_CID(),
					p.getBOOK_FILENAME(),
					p.getBOOK_WRITER(),
					p.getBOOK_CHECK()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static ArrayList<BOOK> selectAll(int cpage, int count,String keyword) {
		ArrayList<BOOK> list = new ArrayList<BOOK>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
              String sql = "";
			
			if(keyword!=null) {
				sql = "select * from book where BOOK_NAME like ? order by BOOK_ID  desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}else{
			
		 	
		   sql = "select * from book order by BOOK_ID  desc limit ?, ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cpage-1)*count);
			 ps.setInt(2, count);
			 
			} 
			 
			 
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 BOOK p = new BOOK(
						 rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static BOOK selectByID(int id) {

		BOOK p = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "select*from book  where BOOK_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setLong(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 p = new BOOK(
						 rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
	
		return p;
	}
	
	
	public static int update(BOOK p) {
		String sql = "update book set BOOK_NAME=?, BOOK_DESCRIPTION=?,BOOK_FID=?,BOOK_CID=?,BOOK_FILENAME=?,BOOK_WRITER=?,BOOK_CHECK=? where BOOK_ID = ?";
		Object[] params = {
				
				p.getBOOK_NAME(),
				p.getBOOK_DESCRIPTION(),
				p.getBOOK_FID(),
				p.getBOOK_CID(),
				p.getBOOK_FILENAME(),
				p.getBOOK_WRITER(),
				p.getBOOK_CHECK(),
				p.getBOOK_ID(),
				};
		
		return Basedao.exectuIUD(sql, params);
}
	
	
	
	public static int del(int id) {
		String sql = "delete from book where BOOK_ID=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	

	public static ArrayList<BOOK> selectAllByFid(int fid) {
		ArrayList<BOOK> list = new ArrayList<BOOK>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book where BOOK_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 BOOK p = new BOOK(
						 rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<BOOK> selectAllByCid(int cid) {
		ArrayList<BOOK> list = new ArrayList<BOOK>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book where BOOK_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 BOOK p = new BOOK(
						 rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}


	public static BOOK selectById(int id) {
		BOOK p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book where BOOK_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new BOOK(
						  rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
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
				sql = "select count(*) from book where BOOK_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else{
				sql = "select count(*) from book";
				
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


	public static ArrayList<BOOK> selectAll() {
		ArrayList<BOOK> list = new ArrayList<BOOK>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book order by BOOK_CHECK";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 BOOK p = new BOOK(
						 rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}


	public static BOOK selectBook(String keywords) {
		BOOK p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book where BOOK_NAME like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keywords+"%");
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new BOOK(
						  rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
	}


	public static ArrayList<BOOK> BookByUnm(String uname) {
		
			ArrayList<BOOK> list = new ArrayList<BOOK>();
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			
			
			try {
				String sql = "select * from book where  BOOK_WRITER like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1,"%"+uname+"%");
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 BOOK p = new BOOK(
							 rs.getInt("BOOK_ID"),
							 	rs.getString("BOOK_NAME"),
							 	rs.getString("BOOK_DESCRIPTION"),
							 	rs.getInt("BOOK_FID"),
							 	rs.getInt("BOOK_CID"),
							 	rs.getString("BOOK_FILENAME"),
							 	rs.getString("BOOK_WRITER"),
							 	rs.getInt("BOOK_CHECK")
							 );
					 
					 
					 list.add(p);
					 
				 }
				 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			
			return list;
		}
	public static BOOK selectNMBook(String uname) {
		BOOK p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from book where BOOK_WRITER like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+uname+"%");
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new BOOK(
						  rs.getInt("BOOK_ID"),
						 	rs.getString("BOOK_NAME"),
						 	rs.getString("BOOK_DESCRIPTION"),
						 	rs.getInt("BOOK_FID"),
						 	rs.getInt("BOOK_CID"),
						 	rs.getString("BOOK_FILENAME"),
						 	rs.getString("BOOK_WRITER"),
						 	rs.getInt("BOOK_CHECK")
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
	}

	
	}










