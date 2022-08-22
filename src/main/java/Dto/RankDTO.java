package Dto;

public class RankDTO {

	MemberDTO dto;
	Integer rank;
	Integer voteval;
	
	public Integer getVoteval() {
		return voteval;
	}
	public void setVoteval(Integer voteval) {
		this.voteval = voteval;
	}
	public MemberDTO getDto() {
		return dto;
	}
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
		
}
