package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.MemberDTO;
import Dto.PartyDTO;

public class VoteDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	 
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	public ArrayList<MemberDTO> getMemberList(){
		ArrayList<MemberDTO> list = new ArrayList();
		MemberDTO dto=null;
		try {
			
			Connection conn = getConnection();
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
			try{conn.close();}catch(Exception e1) {}	
		}
		return list;
		
	}
	
	public ArrayList<PartyDTO> getPartyList(){
		
		ArrayList<PartyDTO> list = new ArrayList();
		PartyDTO dto=null;
		
	try {
			
			Connection conn = getConnection();
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
			try{conn.close();}catch(Exception e1) {}	
		}
		return list;
	}
	

}
