package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ConnectWithDatabase {
	Connection conn = null;
	PreparedStatement ps = null;


	public ConnectWithDatabase(String url, String account, String password, String database) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + url, account, password);
			ps = conn.prepareStatement("USE " + database + ";");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	-- 查看学生 001 的当前课程
//	SELECT * FROM studentLearning WHERE studentNumber='001';
	public ResultSet getStudentCourses(String studentNumber) {
		ResultSet rs=null;
		String sql = "SELECT * FROM studentLearning WHERE studentNumber='"+studentNumber+"';";
		System.out.println(sql);
		try {
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
//	-- 查看学生 001 的作业
//	SELECT * FROM assignment JOIN studentLearning ON (studentLearning.studentNumber='001' AND assignment.courseNumber=studentLearning.courseNumber) JOIN course ON (course.courseNumber=assignment.courseNumber);
	public ResultSet queryAssignment(String studentNumber) {
		ResultSet rs=null;
		String sql = "SELECT * FROM assignment JOIN studentLearning ON "
				+ "(studentLearning.studentNumber='"+studentNumber+"' AND assignment.courseNumber=studentLearning.courseNumber) "
				+ "JOIN course ON (course.courseNumber=assignment.courseNumber);";
		try {
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
//	-- 查看 101 老师上的课
//	SELECT * FROM course WHERE jobNumber='101';
	public ResultSet getTeacherCourse(String jobNumber) {
		ResultSet rs=null;
		String sql = "SELECT * FROM course WHERE jobNumber='"+ jobNumber +"';";
		try {
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
//	-- 101 老师增加了作业
//	INSERT INTO assignment(courseNumber,title,content,startTime,deadline) VALUE ('2001','title1000','content1000',NOW(),date_add(NOW(), interval 1 week));
	public void addAssignment(String courseNumber,String title, String content,Timestamp startTime,Timestamp deadline) {
		String sql = "INSERT INTO assignment(courseNumber,title,content,startTime,deadline) VALUE "
				+ "('"+courseNumber+"','"+title+"','"+content+"',"+startTime+","+deadline+");";
		try {
			ps.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	-- 老师更改了作业提交时间
//	update assignment set deadline=date_add(NOW(), interval 1 month);
	public void updateAssignment(Timestamp deadline) {
		String sql = "update assignment set deadline=deadline;";
		try {
			ps.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//	-- 老师删除了作业
//	DELETE FROM assignment WHERE assignmentNumber=1;
	public void deleteAssignment(Timestamp deadline) {
		String sql = "update assignment set deadline="+deadline+";";
		try {
			ps.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	String columnDivider="|@_@|\n";
	String itemDivider="\n|^_^|\n";
	String emptyResultSet="|-_-!|";

	public void PrintResultSet(ResultSet rs) {
		if (rs != null) {
			ResultSetMetaData rsmd;
			try {
				rsmd = (ResultSetMetaData) rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.printf("%-15s", rsmd.getColumnName(i));
				}
				while (rs.next()) {
					System.out.println();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.printf("%-15s", rs.getString(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String resultSetToString(ResultSet rs) {
		String resultString=emptyResultSet;
		if (rs != null) {
			ResultSetMetaData rsmd;
			try {
				rsmd = (ResultSetMetaData) rs.getMetaData();
				String[] columns= new String[rsmd.getColumnCount()];
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					columns[i-1]=rsmd.getColumnName(i);
					columns[i-1]+=itemDivider;
				}
				while (rs.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//						System.out.printf("%-15s", rs.getString(i));
						columns[i-1]+=rs.getString(i)+columnDivider;
					}
				}
				resultString="";
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					resultString+=columns[i-1];
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

}
