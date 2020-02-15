package studentManagement;

public class Student {
	private int grade;
	private int serialNumber;
	private String name;
	private String gender;
	private String phoneNumber;
	private String address;
	
	public  Student() {
		super();
	}
	
	public  Student(int serialNumber,String name,String gender,
			String phoneNumber,String address,int grade) {
		super();
		this.grade=grade;
		this.serialNumber=serialNumber;
		this.gender=gender;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.address=address;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String string) {
		this.gender = string;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
