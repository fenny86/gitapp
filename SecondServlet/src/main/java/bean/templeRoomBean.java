package bean;

public class templeRoomBean {

	private String templeId;      // 編號
	private int singleroom;		  //單人房
	private int doubleroom;		  //雙人房
	private int tripleroom;		  //三人房
	private int quadrupleroom;	  //四人房
	private int dormitoryroom;	  //通舖
	
	public templeRoomBean(String templeId, int singleroom, int doubleroom, int tripleroom, int quadrupleroom,
			int dormitoryroom) {
		super();
		this.templeId = templeId;
		this.singleroom = singleroom;
		this.doubleroom = doubleroom;
		this.tripleroom = tripleroom;
		this.quadrupleroom = quadrupleroom;
		this.dormitoryroom = dormitoryroom;
	}

	
	
	public templeRoomBean() {
		super();
	}



	@Override
	public String toString() {
		return "templeRoomBean [templeId=" + templeId + ", singleroom=" + singleroom + ", doubleroom=" + doubleroom
				+ ", tripleroom=" + tripleroom + ", quadrupleroom=" + quadrupleroom + ", dormitoryroom=" + dormitoryroom
				+ "]";
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public int getSingleroom() {
		return singleroom;
	}

	public void setSingleroom(int singleroom) {
		this.singleroom = singleroom;
	}

	public int getDoubleroom() {
		return doubleroom;
	}

	public void setDoubleroom(int doubleroom) {
		this.doubleroom = doubleroom;
	}

	public int getTripleroom() {
		return tripleroom;
	}

	public void setTripleroom(int tripleroom) {
		this.tripleroom = tripleroom;
	}

	public int getQuadrupleroom() {
		return quadrupleroom;
	}

	public void setQuadrupleroom(int quadrupleroom) {
		this.quadrupleroom = quadrupleroom;
	}

	public int getDormitoryroom() {
		return dormitoryroom;
	}

	public void setDormitoryroom(int dormitoryroom) {
		this.dormitoryroom = dormitoryroom;
	}
	
	
	
}
