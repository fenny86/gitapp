package bean;

import java.sql.Blob;
import java.sql.Date;

public class Active {
	private int activeID;
	private String activeName;
	private Blob activeImg;
	public Active(int activeID, String activeName, String activeDescription, String activeStartDate,
			String activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}
	public Active(String activeName, String activeDescription, String activeStartDate, String activeEndDate,
			String activeLocation, String activeHost) {
		super();
		this.activeName = activeName;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}
	public Active(String activeName, Blob activeImg, String activeDescription, String activeStartDate,
			String activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeName = activeName;
		this.activeImg = activeImg;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}
	private String activeDescription;
	private String activeStartDate;
	private String activeEndDate;
	private String activeLocation;
	private String activeHost;
	public Active(int activeID, String activeName, Blob activeImg, String activeDescription, String activeStartDate,
			String activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activeImg = activeImg;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}
	public Active() {
		super();
	}
	public int getActiveID() {
		return activeID;
	}
	public void setActiveID(int activeID) {
		this.activeID = activeID;
	}
	public String getActiveName() {
		return activeName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}
	public Blob getActiveImg() {
		return activeImg;
	}
	public void setActiveImg(Blob activeImg) {
		this.activeImg = activeImg;
	}
	public String getActiveDescription() {
		return activeDescription;
	}
	public void setActiveDescription(String activeDescription) {
		this.activeDescription = activeDescription;
	}
	public String getActiveStartDate() {
		return activeStartDate;
	}
	public void setActiveStartDate(String activeStartDate) {
		this.activeStartDate = activeStartDate;
	}
	public String getActiveEndDate() {
		return activeEndDate;
	}
	public void setActiveEndDate(String activeEndDate) {
		this.activeEndDate = activeEndDate;
	}
	public String getActiveLocation() {
		return activeLocation;
	}
	public void setActiveLocation(String activeLocation) {
		this.activeLocation = activeLocation;
	}
	public String getActiveHost() {
		return activeHost;
	}
	public void setActiveHost(String activeHost) {
		this.activeHost = activeHost;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Active [activeID=").append(activeID).append(", activeName=").append(activeName)
				.append(", activeImg=").append(activeImg).append(", activeDescription=").append(activeDescription)
				.append(", activeStartDate=").append(activeStartDate).append(", activeEndDate=").append(activeEndDate)
				.append(", activeLocation=").append(activeLocation).append(", activeHost=").append(activeHost)
				.append("]");
		return builder.toString();
	}
	

}
