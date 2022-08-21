package Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDAO;
import Dto.MemberDTO;
import Dto.VoteDTO;

public class VoteListController implements SubController{
	VoteDAO dao = new VoteDAO();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		 
		
		
		ArrayList<VoteDTO> dto = dao.getVoteList();
		ArrayList<MemberDTO> mdto = dao.getMemberList();
		req.setAttribute("vlist", dto);
		req.setAttribute("mlist", mdto);
		
		
		try {
			req.getRequestDispatcher("/WEB-INF/voteList.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
