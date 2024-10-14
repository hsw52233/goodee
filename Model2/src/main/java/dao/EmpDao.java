package dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

import vo.Dept;
import vo.Emp;

public class EmpDao {
	
	
		
	public List<Emp> selectDepListByPage(String word, int beginRow, int rowPerPage) throws Exception{	
		
			List<Emp> list = new ArrayList<>();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"c##scott",
					"1234");
			String sql = "";
			PreparedStatement stmt = null;
			if(word == null) {
				sql = "select empno, ename, deptno from emp"
						+ " offset ? rows fetch next ? rows only";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, beginRow);
				stmt.setInt(2, rowPerPage);
			}else {
				
				sql = "select empno, ename, deptno from emp" + " where ename like ?"
						+" offset ? rows fetch next ? rows only";
						
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, "%" + word + "%");
				stmt.setInt(2, beginRow);
				stmt.setInt(3, rowPerPage);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			
			
			
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
			
		}
	
	
}
