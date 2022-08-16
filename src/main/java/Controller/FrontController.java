package Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	HashMap<String,SubController> map;
	
	@Override
	public void init() throws ServletException {
		map = new HashMap();
		
		map.put("/main.do", null);
		map.put("/memberList.do", null);
		map.put("/voteMember.do", null);
		map.put("/voteList.do", null);
		map.put("/voteResult.do", null);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		SubController sub = map.get(url);
		sub.execute(req, resp);
	}
	
	
}
