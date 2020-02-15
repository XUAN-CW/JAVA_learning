package studentManagement;

import java.util.Scanner;

public class StudentManagement {
	private Student[] students;
	private int numberOfStudents;
	
	public StudentManagement() {
		super();
		setStudents(10);
		setNumberOfStudents(0);
	}
	
	public void init() {
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < students.length; i++) {
			int temp=input.nextInt();
			if(temp==0) {
				break;
			}
			students[i].setSerialNumber(temp);
			students[i].setName(input.next());
			students[i].setGender(input.next());
			students[i].setPhoneNumber(input.next());
			students[i].setAddress(input.next());
			students[i].setGrade(input.nextInt());
			this.numberOfStudents++;
		}
		input.close();
	}
	
	public void showStudents() {
		System.out.println("编号\t"+"姓名\t"+"性别\t"+"电话\t"+"通信地址\t"+"成绩\t");
		for (int i = 0;i<numberOfStudents; i++) {
			System.out.print(students[i].getSerialNumber()+"\t");
			System.out.print(students[i].getName()+"\t");
			System.out.print(students[i].getGender()+"\t");
			System.out.print(students[i].getPhoneNumber()+"\t");
			System.out.print(students[i].getAddress()+"\t");
			System.out.println("\t"+students[i].getGrade());
		}
	}
	
	public Student getHighestScoreStudent() {
		Student HighestScoreStudent =null;
		int highestScore=-1;
		for (int i = 0; i < numberOfStudents; i++) {
			if(highestScore<students[i].getGrade()) {
//				highestScore=students[i].getGrade();
				HighestScoreStudent=students[i];
			}
		}
		return HighestScoreStudent;
	}
	
	public Student getStudentByName(String nameOfStudent) {
		Student Student =null;
		for (int i = 0; i < numberOfStudents; i++) {
			if(students[i].getName().equals(nameOfStudent)) {
				Student=students[i];
				break;
			}
		}
		return Student;
	}
	
	public void addStudent(Student student) {
		if (numberOfStudents==students.length) {
			System.out.println("满");
		}
		else {
			students[numberOfStudents]=student;
			numberOfStudents++;
		}
	}
	
	public void DeleteStudentBySerialNumber(int SerialNumber) {
		Student Student =null;
		int i = 0;
		for (; i < numberOfStudents; i++) {
			if(students[i].getSerialNumber()==SerialNumber) {
				Student=students[i];
				break;
			}
		}
		if(Student ==null) {//没找到
			System.out.println("未找到");
		}
		else {
			for (int j = i; j < numberOfStudents; j++) {
				students[j]=students[j+1];
			}
			numberOfStudents--;
		}
	}
	
	public void ModifyStudentInformationBySerialNumber(int SerialNumber) {
		System.out.println("12222");
		Scanner input=new Scanner(System.in);
		int temp=input.nextInt();
		
		
		
//		Scanner input=new Scanner(System.in);
//		for (int i = 0; i < numberOfStudents; i++) {
//			if(students[i].getSerialNumber()==SerialNumber) {
//				System.out.println(students[i].getSerialNumber());
//				int temp=input.nextInt();
//				System.out.println("12222");
////				students[i].setSerialNumber(input.nextInt());
////				students[i].setName();
////				students[i].setGender(input.next());
////				students[i].setPhoneNumber(input.next());
////				students[i].setAddress(input.next());
////				students[i].setGrade(input.nextInt());
//				
//				break;
//			}
//		}
//		input.close();
		
		
		
		
//		Scanner input=new Scanner(System.in);
//		for (int i = 0; i < students.length; i++) {
//			int temp=input.nextInt();
//			if(temp==0) {
//				break;
//			}
//			students[i].setSerialNumber(temp);
//			students[i].setName(input.next());
//			students[i].setGender(input.next());
//			students[i].setPhoneNumber(input.next());
//			students[i].setAddress(input.next());
//			students[i].setGrade(input.nextInt());
//			this.numberOfStudents++;
//		}
//		input.close();
		
	}
	
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(int size) {
		Student[] s= new Student[size];
		for (int i = 0; i < s.length; i++) {
			s[i]=new Student();
		}
		this.students = s;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	
}
