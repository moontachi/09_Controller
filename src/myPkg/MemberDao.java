package myPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {

	private static MemberDao dao = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	private MemberDao(){

		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");

			conn = ds.getConnection(); 


		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (NamingException e) { 
			e.printStackTrace();
		}

	}

	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}

	public void insertData(String id,String passwd,String name){

		String sql = "insert into member (num, id, passwd, name, register) " 
				+ "values (m_seq.nextval, ?, ?, ?, default )";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException e) {

			}
		}

 
	} // insertData()
	
	public ArrayList<MemberBean> getSelectAll(){
		
		ArrayList<MemberBean> lists = new ArrayList<MemberBean>();
		String sql = "select * from member order by num asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				//String register = rs.getString("register"); // 날짜,시간 
				String register = String.valueOf(rs.getDate("register")); // 날짜
				
				MemberBean dto = new MemberBean(num, id, passwd, name, register);
				lists.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException e) {

			}
		}
		return lists;
	}
}








