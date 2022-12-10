package bean;

public class MemberBean {
	int memberId;
	String memberAccount;
	String memberPassword;
	public MemberBean(int memberId, String memberAccount, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
	}
	public int getMemberId() {
		return memberId;
	}
	
	public MemberBean(String memberAccount, String memberPassword) {
		super();
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public MemberBean() {
		super();
	}
	

}
