package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDAO;
import Dto.MemberDTO;
import Dto.PartyDTO;

public class MemberListController implements SubController{

	VoteDAO dao = new VoteDAO();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		//DAO
		ArrayList<MemberDTO> mlist = dao.getMemberList();
		ArrayList<PartyDTO> plist = dao.getPartyList();
		//view
		
		req.setAttribute("mlist", mlist);
		req.setAttribute("plist", plist);
		try {
			req.getRequestDispatcher("/WEB-INF/memberList.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
