package Database;

public class Main {
    public static void main(String[] args) {
    	ConnectWithDatabase c=new ConnectWithDatabase("47.102.200.197", "root", "XUAN", "assignment");
    	c.PrintResultSet(c.getStudentCourses("001"));
//    	c.PrintResultSet(c.queryAssignment("001"));
//    	System.err.println(c.resultSetToString(c.queryAssignment("001")));
//    	c.resultSetToString(c.queryAssignment("001"));
//    	System.out.println();
//    	c.PrintResultSet(c.getTeacherCourse("101"));
    }
}
