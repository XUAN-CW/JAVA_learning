package studentManagement;
/**
 * ��ʾ�ֶ����׳��쳣
 */
public class Main {
	public static void main(String[] args) {
		
		System.out.println(" " );
		
		StudentManagement sManagement = new StudentManagement();
		sManagement.init();
		sManagement.showStudents();
		System.out.println("��߷֣�"+sManagement.getHighestScoreStudent().getName()+"\t"
		+sManagement.getHighestScoreStudent().getGrade());
		System.out.println("ͨ���������ˣ�"+sManagement.getStudentByName("lisi").getGender());
		sManagement.DeleteStudentBySerialNumber(1);
		sManagement.showStudents();
		Student tStudent=new Student(4,"zeng","M","1234","guilin",98);
		sManagement.addStudent(tStudent);
		sManagement.showStudents();
		sManagement.ModifyStudentInformationBySerialNumber(4);
		sManagement.showStudents();
	}
}
