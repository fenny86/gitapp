package EEIT56_23;

import java.sql.Blob;

public class PeopleBean_23 {
	private Integer userID;
	private String Name;
	private Integer age;
	private String Sex;
	private String Address;
	private String Star;//星座v
	private String Emotion;//感情狀況v
	private String Profession;//職業v
	private String Personality;//個性v
	private String Hobby;//興趣v
	private String Dream;//夢想v
	private String Introduction;//自介
	private Blob Images;//照片v
	private String Religion;//宗教v
	private String Sex_in;//性取向v
	private Double Income;//收入v
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getStar() {
		return Star;
	}
	public void setStar(String star) {
		Star = star;
	}
	public String getEmotion() {
		return Emotion;
	}
	public void setEmotion(String emotion) {
		Emotion = emotion;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;
	}
	public String getPersonality() {
		return Personality;
	}
	public void setPersonality(String personality) {
		Personality = personality;
	}
	public String getHobby() {
		return Hobby;
	}
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	public String getDream() {
		return Dream;
	}
	public void setDream(String dream) {
		Dream = dream;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public Blob getImages() {
		return Images;
	}
	public void setImages(Blob images) {
		Images = images;
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getReligion() {
		return Religion;
	}
	public void setReligion(String religion) {
		Religion = religion;
	}
	public String getSex_in() {
		return Sex_in;
	}
	public void setSex_in(String sex_in) {
		Sex_in = sex_in;
	}
	public Double getIncome() {
		return Income;
	}
	public void setIncome(Double income) {
		Income = income;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public PeopleBean_23() {
		
	}
	public PeopleBean_23(Integer userID, String name, Integer age, String sex, String address, String star, String emotion,
			String profession, String personality, String hobby, String dream, String introduction, Blob images,
			String religion, String sex_in, Double income) {
		super();
		this.userID = userID;
		Name = name;
		this.age = age;
		Sex = sex;
		Address = address;
		Star = star;
		Emotion = emotion;
		Profession = profession;
		Personality = personality;
		Hobby = hobby;
		Dream = dream;
		Introduction = introduction;
		Images = images;
		Religion = religion;
		Sex_in = sex_in;
		Income = income;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeoeleBean_23 [userID=");
		builder.append(userID);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", Age=");
		builder.append(age);
		builder.append(", Sex=");
		builder.append(Sex);
		builder.append(", Address=");
		builder.append(Address);
		builder.append(", Star=");
		builder.append(Star);
		builder.append(", Emotion=");
		builder.append(Emotion);
		builder.append(", Profession=");
		builder.append(Profession);
		builder.append(", Personality=");
		builder.append(Personality);
		builder.append(", Hobby=");
		builder.append(Hobby);
		builder.append(", Dream=");
		builder.append(Dream);
		builder.append(", Introduction=");
		builder.append(Introduction);
		builder.append(", Images=");
		builder.append(Images);
		builder.append(", Religion=");
		builder.append(Religion);
		builder.append(", Sex_in=");
		builder.append(Sex_in);
		builder.append(", Income=");
		builder.append(Income);
		builder.append("]");
		return builder.toString();
	}
	public PeopleBean_23(String name, Integer age, String sex, String address, String star, String emotion,
			String profession, String personality, String hobby, String dream, String introduction, Blob images,
			String religion, Double income) {
		super();
		Name = name;
		this.age = age;
		Sex = sex;
		Address = address;
		Star = star;
		Emotion = emotion;
		Profession = profession;
		Personality = personality;
		Hobby = hobby;
		Dream = dream;
		Introduction = introduction;
		Images = images;
		Religion = religion;
		Income = income;
	}
	public PeopleBean_23(Integer userID, String name, Integer age, String sex, String address) {
		super();
		this.userID = userID;
		Name = name;
		this.age = age;
		Sex = sex;
		Address = address;
	}
	public PeopleBean_23(String name, Integer age, String sex, String address, String star, String emotion,
			String profession, String personality, String hobby, String dream, String introduction, Blob images,
			String religion, String sex_in, Double income) {
		super();
		Name = name;
		this.age = age;
		Sex = sex;
		Address = address;
		Star = star;
		Emotion = emotion;
		Profession = profession;
		Personality = personality;
		Hobby = hobby;
		Dream = dream;
		Introduction = introduction;
		Images = images;
		Religion = religion;
		Sex_in = sex_in;
		Income = income;
	}
	public PeopleBean_23(Integer userID, String name, Integer age, String sex, String address, String star,
			String emotion, String profession, String personality, String hobby, String dream, String introduction,
			Blob images, String religion, String sex_in) {
		super();
		this.userID = userID;
		Name = name;
		this.age = age;
		Sex = sex;
		Address = address;
		Star = star;
		Emotion = emotion;
		Profession = profession;
		Personality = personality;
		Hobby = hobby;
		Dream = dream;
		Introduction = introduction;
		Images = images;
		Religion = religion;
		Sex_in = sex_in;
	}
	
	
	
	
	
	
	
	
	
	
}
