package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDAO;
import Dto.VoteDTO;

public class VoteMemberController implements SubController{

	VoteDAO dao = new VoteDAO();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
			
		String flag = req.getParameter("flag");
		if(flag==null) {
			try {
				req.getRequestDispatcher("/WEB-INF/voteMember.jsp").forward(req, resp);
				return ;
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String v_jumin = req.getParameter("v_jumin");
			String v_name = req.getParameter("v_name");
			String m_no = req.getParameter("m_no");
			String v_time = req.getParameter("v_time");
			String v_area = req.getParameter("v_area");
			String v_confirm = req.getParameter("v_confirm");
			
			VoteDTO dto = new VoteDTO();
			dto.setV_jumin(v_jumin);
			dto.setV_name(v_name);
			dto.setN_no(m_no);
			dto.setV_time(v_time);
			dto.setV_area(v_area);
			dto.setV_confirm(v_confirm);
			
			 
			int result = dao.insertvoteinfo(dto);
			
			System.out.println("RESULT :" + result);
			System.out.println("DTO : " + dto);
			if(result > 0 )
			{
				try {
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
					return ;
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			else
			{
				try {
					req.getRequestDispatcher("/WEB-INF/voteMember.jsp").forward(req, resp);
					return ;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
	}

}
