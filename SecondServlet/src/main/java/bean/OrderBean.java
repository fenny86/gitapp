package bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

//訂單資料整理
public class OrderBean {
	public Set<OrderItemBean> getItems() {
		return items;
	}
	public void setItems(Set<OrderItemBean> items) {
		this.items = items;
	}
	int orderNumber;
	int memberId;
	String customerEmail;
	int customerPhone;
	String customerPhoneStr;
	String orderStatus;
	Date orderDate;
	String orderDateStr;
	Double orderPrice;
	Set<OrderItemBean> items = new LinkedHashSet<>();

	public String getCustomerPhoneStr() {
		return customerPhoneStr;
	}
	public void setCustomerPhoneStr(String customerPhoneStr) {
		this.customerPhoneStr = customerPhoneStr;
	}
	public OrderBean(int orderNumber, int memberId, String customerEmail,String customerPhoneStr,
			String orderStatus, Date orderDate, Double orderPrice) {
		super();
		this.orderNumber = orderNumber;
		this.memberId = memberId;
		this.customerEmail = customerEmail;
		this.customerPhoneStr = customerPhoneStr;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}
	public String getOrderDateStr() {
		return orderDateStr;
	}
	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}
	public OrderBean() {
		super();
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	

}
