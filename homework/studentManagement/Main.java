package studentManagement;
/**
 * 演示手动的抛出异常
 */
public class Main {
	public static void main(String[] args) {
		
		System.out.println(" " );
		
		StudentManagement sManagement = new StudentManagement();
		sManagement.init();
		sManagement.showStudents();
		System.out.println("最高分："+sManagement.getHighestScoreStudent().getName()+"\t"
		+sManagement.getHighestScoreStudent().getGrade());
		System.out.println("通过名字找人："+sManagement.getStudentByName("lisi").getGender());
		sManagement.DeleteStudentBySerialNumber(1);
		sManagement.showStudents();
		Student tStudent=new Student(4,"zeng","M","1234","guilin",98);
		sManagement.addStudent(tStudent);
		sManagement.showStudents();
		sManagement.ModifyStudentInformationBySerialNumber(4);
		sManagement.showStudents();
	}
}
