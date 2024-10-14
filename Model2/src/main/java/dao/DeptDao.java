package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;



import vo.Dept;

public class DeptDao {
	
	public List<Dept> selectDepList() throws Exception{
		List<Dept> list = new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"c##scott",
				"1234");
		PreparedStatement stmt = conn.prepareStatement(
				"select deptno, dname, loc from dept");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Dept d = new Dept();
			
			d.setDeptno(rs.getInt("deptno"));
			d.setDname(rs.getString("dname"));
			d.setLoc(rs.getString("loc"));
			list.add(d);
			
			System.out.println(d.getDeptno());
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;

	}
	
	

}
