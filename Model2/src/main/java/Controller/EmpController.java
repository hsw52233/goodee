package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.EmpDao;

@WebServlet("/empList")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 분석
		
		String word = request.getParameter("word");
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerpage = 3;
		int beginRow = (currentPage - 1) * rowPerpage;
		
		// 모델 호출
		
		EmpDao empDao = new EmpDao();
		
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			list = empDao.selectDepListByPage(word, beginRow, rowPerpage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 뷰 포워딩
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("word", word);
		request.getRequestDispatcher("/empListView.jsp").forward(request, response);
		
	}

	

}
