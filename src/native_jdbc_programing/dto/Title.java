package native_jdbc_programing.dto;

public class Title {
	private int tNo;
	private String tName;
	public Title() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format("Title [tNo=%s, tName=%s]", tNo, tName);
	}
	public final int gettNo() {
		return tNo;
	}
	public final void settNo(int tNo) {
		this.tNo = tNo;
	}
	public final String gettName() {
		return tName;
	}
	public final void settName(String tName) {
		this.tName = tName;
	}
	public Title(int tNo, String tName) {
		this.tNo = tNo;
		this.tName = tName;
	}
	public Title(int tNo) {
		this.tNo = tNo;
	}
	
}
