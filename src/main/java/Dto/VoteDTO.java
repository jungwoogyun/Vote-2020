package Dto;

public class VoteDTO {
	private String n_no;
	private String v_name;
	private String v_jumin;
	private String v_time;
	private String v_area;
	private String v_confirm;
	
	
	@Override
	public String toString() {
		return "VoteDTO [n_no=" + n_no + ", v_name=" + v_name + ", v_jumin=" + v_jumin + ", v_time=" + v_time
				+ ", v_area=" + v_area + ", v_confirm=" + v_confirm + "]";
	}
	
	public String getN_no() {
		return n_no;
	}
	public void setN_no(String n_no) {
		this.n_no = n_no;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_jumin() {
		return v_jumin;
	}
	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	
	//getter and setter 
	
}
