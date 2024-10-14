package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DeptDao;



@WebServlet("/deptList")
public class DeptListController extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		DeptDao deptDao = new DeptDao();
		
	
		//Model Layer
		
		List<Dept> list = new ArrayList<>();
		try {
			list = deptDao.selectDepList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //Model Layer 호출
		
		
		request.setAttribute("list", list);
		//deptList와 deptListView가 동일한 request/response를 사용하도록 포워딩
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEF-INF/view/deptListView.jsp");
		rd.forward(request, response);
		
		//View Layer
	}

	
	

}
