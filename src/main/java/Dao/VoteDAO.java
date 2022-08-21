package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.MemberDTO;
import Dto.PartyDTO;
import Dto.VoteDTO;

public class VoteDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	 
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	public VoteDAO(){	
		try {
			conn = getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> getMemberList(){
		ArrayList<MemberDTO> list = new ArrayList();
		MemberDTO dto=null;
		try {
			
		 
			ps = conn.prepareStatement("select * from tbl_member_202005");
			rs = ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					dto=new MemberDTO();
					dto.setM_no(rs.getString("m_no"));
					dto.setM_name(rs.getString("m_name"));
					dto.setP_code(rs.getString("p_code"));
					dto.setP_school(rs.getString("p_school"));
					dto.setM_jumin(rs.getString("m_jumin"));
					dto.setM_city(rs.getString("m_city"));
					list.add(dto);
				}
			}
			
		}catch(Exception e) {
			try{rs.close();}catch(Exception e1) {}
			try{ps.close();}catch(Exception e1) {}
		 
		}
		return list;
		
	}
	
	public ArrayList<PartyDTO> getPartyList(){
		
		ArrayList<PartyDTO> list = new ArrayList();
		PartyDTO dto=null;
		
	try {
			
		 
			ps = conn.prepareStatement("select * from tbl_party_202005");
			rs = ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					dto=new PartyDTO();
					dto.setP_code(rs.getString("p_code"));
					dto.setP_name(rs.getString("p_name"));
					dto.setP_indate(rs.getString("p_indate"));
					dto.setP_reader(rs.getString("p_reader"));
					dto.setP_tel1(rs.getString("p_tel1"));
					dto.setP_tel2(rs.getString("p_tel2"));
					dto.setP_tel3(rs.getString("p_tel3"));
					list.add(dto);
				}
			}
			
		}catch(Exception e) {
			try{rs.close();}catch(Exception e1) {}
			try{ps.close();}catch(Exception e1) {}
		 
		}
		return list;
	}
	
	public int insertvoteinfo(VoteDTO dto) {
		
		int result = 0;
		try {
			
		 
			ps = conn.prepareStatement("insert into tbl_vote_202005 values(?,?,?,?,?,?)");
			ps.setString(1, dto.getV_jumin());
			ps.setString(2, dto.getV_name());
			ps.setString(3, dto.getN_no());
			ps.setString(4, dto.getV_time());
			ps.setString(5, dto.getV_area());
			ps.setString(6, dto.getV_confirm());
		 
			result = ps.executeUpdate();
			
			 
			
		}catch(Exception e) {
			try{ps.close();}catch(Exception e1) {e1.printStackTrace();}
		 
			
		}
		return result;
	}
	
	public ArrayList<VoteDTO> getVoteList() {
		ArrayList<VoteDTO> list = new ArrayList();
		VoteDTO dto=null;
		try {
			
		 
			ps = conn.prepareStatement("select * from tbl_vote_202005 where v_area='제1투표장'");
			rs = ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					dto=new VoteDTO();
					dto.setN_no(rs.getString("m_no"));
					dto.setV_area(rs.getString("v_area"));
					dto.setV_confirm(rs.getString("v_confirm"));
					dto.setV_jumin(rs.getString("v_jumin"));
					dto.setV_name(rs.getString("v_name"));
					dto.setV_time(rs.getString("v_time"));
					list.add(dto);
				}
			}
			
		}catch(Exception e) {
			try{rs.close();}catch(Exception e1) {}
			try{ps.close();}catch(Exception e1) {}
		 
		}
		return list;
		
	}

}
