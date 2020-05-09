package Database;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import test.Controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
    	ConnectWithDatabase database=new ConnectWithDatabase("47.102.200.197", "root", "XUAN", "assignment");
        String sql = "SELECT `name` AS course,title AS homeworkTitle," +
                "content AS homeworkContent,startTime,deadline FROM assignment " +
                "JOIN studentLearning ON (studentLearning.studentNumber='"+"001"+"'" +
                " AND assignment.courseNumber=studentLearning.courseNumber) " +
                "JOIN course ON (course.courseNumber=assignment.courseNumber);";
        ResultSet rs = database.myExecuteQuery(sql);
//        System.out.println(database.resultSetToString(rs));


        String data=database.resultSetToString(rs);

        String homeworkTitle[]=null;
        String homeworkContent[]=null;
        String course[]=null;
        String startTime[]=null;
        String deadline[]=null;
        String columnDivider="\n-----";
        String itemDivider="\n-___-";
        String emptyResultSet="|-_-!|";
        String[] temp=data.split(columnDivider);
//        System.out.println(temp[2]);

//        String[] currColumn=temp[0].split(itemDivider);
//        System.out.println(currColumn[0].equals("name"));

        for(int i=0;i<temp.length;i++){
//            System.out.println(temp[i]);
            String[] currColumn=temp[i].split(itemDivider);
            System.out.println(currColumn[0]);
            if(currColumn[0].equals("title")){
                currColumn[0]="homeworkTitle";
                homeworkTitle=currColumn;
            }
            if(currColumn[0].equals("content")){
                currColumn[0]="homeworkContent";
                homeworkContent=currColumn;
            }
            if(currColumn[0].equals("name")){
                currColumn[0]="course";
                course=currColumn;
            }
            if(currColumn[0].equals("startTime")){
                currColumn[0]="startTime";
                startTime=currColumn;
            }
            if(currColumn[0].equals("deadline")){
                currColumn[0]="deadline";
                deadline=currColumn;
            }
        }
        int length = 0;
        length = Math.min(homeworkTitle.length , homeworkContent.length);
        length = Math.min(length , course.length);
        length = Math.min(length , startTime.length);
        length = Math.min(length , deadline.length);

//        System.out.println(length);


        for (int i = 1; i < length; i++) {
            System.err.println(deadline[i]);
        }


    	//    	c.PrintResultSet(c.getStudentCourses("001"));
//    	c.PrintResultSet(c.queryAssignment("001"));
//    	System.err.println(c.resultSetToString(c.queryAssignment("001")));
//    	c.resultSetToString(c.queryAssignment("001"));
//    	System.out.println();
//    	c.PrintResultSet(c.getTeacherCourse("101"));

//        ResultSet rs = c.queryAssignment("001");

//        ConnectWithDatabase database=new ConnectWithDatabase("47.102.200.197","root","XUAN","assignment");
//        ResultSet rs = database.myExecuteQuery(	 "SELECT * FROM (SELECT studentNumber as account," +
//                "`password` FROM students UNION ALL SELECT jobNumber as account," +
//                "`password`  FROM teachers) as a WHERE a.account='"+"001"+"';");
//
////        rs.next();
////        rs.first();
//        c.printResultSet(rs);
//                rs.next();
//        c.printResultSet(rs);
////        rs.first();
//        rs.beforeFirst();
//        c.printResultSet(rs);


//        String s="1a1122saddda111";
////        String[] t=s.split("a");
////        System.out.println(t.length);
////        for (int i=0;i<t.length;i++){
////            System.out.println(t[i]);
////        }


    }
}
