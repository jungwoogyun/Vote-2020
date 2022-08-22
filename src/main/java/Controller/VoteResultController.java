package Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDAO;
import Dto.MemberDTO;
import Dto.RankDTO;
public class VoteResultController implements SubController{

	
	VoteDAO dao = new VoteDAO();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		ArrayList<MemberDTO> mlist = dao.getMemberList();
		
		//HashMap<MemberDTO, String> rank = new HashMap();
		
		RankDTO [] rankarr = new RankDTO[mlist.size()];
		
		for(int i=0;i<mlist.size();i++)
		{
			int  voteresult = Integer.parseInt(dao.getTotalVote(mlist.get(i).getM_no())) ;
			rankarr[i] = new RankDTO();
			rankarr[i].setDto(mlist.get(i));
			rankarr[i].setVoteval(voteresult);
			
		}
		
		RankDTO tmp =null;
		for(int i=0;i<rankarr.length-1;i++)
		{
			for(int j=i+1;j<rankarr.length;j++)
			{
				if(rankarr[i].getVoteval()<rankarr[j].getVoteval())
				{
					tmp = rankarr[i];
					rankarr[i] = rankarr[j];
					rankarr[j] = tmp;
					
				}
			}
			
		}
		
		
		
		 
		
		try {
			
		 
			req.setAttribute("rank",rankarr);
			req.getRequestDispatcher("/WEB-INF/voteResult.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
