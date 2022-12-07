package bean;

import java.sql.Blob;
import java.sql.Timestamp;

// Alt + Shift + S -> S [toString]
// Alt + Shift + S -> O [Constructor]
// Alt + Shift + S -> R [get set]
public class Account 
{
	Integer id; //id
	String account; //帳號
	String name; //姓名
	String nickName; //姓名
	
	String password; //密碼
	String address; //地址
	String email; //郵件
	String phone; //電話
	String gender; //性別
	Integer age; //年齡
	Blob image; //圖片
	String fileName;
	
	


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	Timestamp registerDate; //註冊時間
	Timestamp lastConsumptionDate; //最後消費時間
	Timestamp lastLoginDate; //最後登入時間
	Integer consumption; //消費總額
	
	

	
	public Account(Integer id, String account, String password, Blob image) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.image = image;
	}


	public Account(Integer id, String account, String password) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
	}
	
	
	public Account() {
//		super();
	}




	// Alt + Shift + S -> S
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Blob getImage() {
		return image;
	}


	public void setImage(Blob image) {
		this.image = image;
	}


	public Timestamp getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}


	public Timestamp getLastConsumptionDate() {
		return lastConsumptionDate;
	}


	public void setLastConsumptionDate(Timestamp lastConsumptionDate) {
		this.lastConsumptionDate = lastConsumptionDate;
	}


	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public Integer getConsumption() {
		return consumption;
	}


	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}


	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", image=");
		builder.append(image);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", registerDate=");
		builder.append(registerDate);
		builder.append(", lastConsumptionDate=");
		builder.append(lastConsumptionDate);
		builder.append(", lastLoginDate=");
		builder.append(lastLoginDate);
		builder.append(", consumption=");
		builder.append(consumption);
		builder.append("]");
		return builder.toString();
	}


	// Alt + Shift + S -> O
	public Account(Integer id, String account, String name, String nickName, String password, String address,
			String email, String phone, String gender, Integer age, Blob image, String fileName, Timestamp registerDate,
			Timestamp lastConsumptionDate, Timestamp lastLoginDate, Integer consumption) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.image = image;
		this.fileName = fileName;
		this.registerDate = registerDate;
		this.lastConsumptionDate = lastConsumptionDate;
		this.lastLoginDate = lastLoginDate;
		this.consumption = consumption;
	}



	
	
}
