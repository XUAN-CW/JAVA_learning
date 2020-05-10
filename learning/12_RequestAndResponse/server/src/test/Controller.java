package test;

import Database.ConnectWithDatabase;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 问题：使用tomcat产生的java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver问题
 * 解决方案：
 *     你可以在web-info文件夹下，创建目录lib，
 *     然后将你需要在服务器上使用的jar包，复制到里面。
 *     在配置项目的依赖，ctrl+alt+shift+s 打开项目设置，
 *     选择Moudles–>右侧Dependencies–>右侧小加号选择1.Jar or Directories
 *     选择你当前项目下的web-info下的lib目录。apply即可
 * 来源：https://blog.csdn.net/MRcheng12138/article/details/104564333
 */

public class Controller {
    HttpServletRequest request;
    HttpServletResponse response;
    ConnectWithDatabase database;
    public Controller(HttpServletRequest request,HttpServletResponse HSResponse){
        setRequest(request);
        setResponse(HSResponse);
        setDatabase("47.102.200.197","root","XUAN","assignment");
        response.addHeader("status","OK");//默认状态码为 OK
    }

    public void parse(){
        String operate=request.getHeader("operate");
        if (operate.equals("login")){
            login(request.getHeader("account"),request.getHeader("password"));
        }
        if (operate.equals("signUp")){
            signUp(request.getHeader("account"),request.getHeader("password"),request.getHeader("identity"));
        }
        if(operate.equals("find student assignment")){
            findStudentAssignment(request.getHeader("studentNumber"));
        }
        if(operate.equals("getTeacherAssignment")){
            getTeacherAssignment(request.getHeader("jobNumber"));
        }
    }

    private void login(String account,String password){
        //在学生表和教师表中查询账号 account
        ResultSet rs = database.myExecuteQuery(	 "SELECT * FROM (SELECT studentNumber as account," +
                "`password` FROM students UNION ALL SELECT jobNumber as account," +
                "`password`  FROM teachers) as a WHERE a.account='"+account+"';");
        System.out.println(account);
            if(null!=rs && isEmptyResultSet(rs)){
                response.addHeader("status","account does not exist");
            } else {
                try {
                    if (!password.equals(rs.getString(2))){
                        response.addHeader("status","incorrect password");
                    }else {
                        rs=database.myExecuteQuery("SELECT * FROM students WHERE " +
                                "studentNumber='"+account+"';");
                        if (isEmptyResultSet(rs)){
                            response.addHeader("identity","teacher");
                        }else {
                            response.addHeader("identity","student");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    private void signUp(String account,String password,String identity){
        ResultSet rs = database.myExecuteQuery(	 "SELECT * FROM (SELECT studentNumber as account," +
                "`password` FROM students UNION ALL SELECT jobNumber as account," +
                "`password`  FROM teachers) as a WHERE a.account='"+account+"';");
        if(null!=rs&&isEmptyResultSet(rs)){
            if (identity.equals("student")){
                database.myExecute("INSERT INTO students(studentNumber,`password`) VALUE('"+account+"','"+password+"');");
            }
            if (identity.equals("teacher")){
                database.myExecute("INSERT INTO teachers(jobNumber,`password`) VALUE('"+account+"','"+password+"');");
            }
        }
        else {
            response.addHeader("status","account already exists");
        }
    }

    public void findStudentAssignment(String studentNumber){
        String sql = "SELECT `name` AS course,title AS homeworkTitle," +
                "content AS homeworkContent,startTime,deadline FROM assignment " +
                "JOIN studentLearning ON (studentLearning.studentNumber='"+studentNumber+"'" +
                " AND assignment.courseNumber=studentLearning.courseNumber) " +
                "JOIN course ON (course.courseNumber=assignment.courseNumber);";
        ResultSet rs = database.myExecuteQuery(sql);
        String temp=database.resultSetToString(rs);
        System.out.println(temp);
        response.addHeader("data",temp);
    }

    public void getTeacherAssignment(String jobNumber){
        System.out.println(jobNumber);
        String sql = "SELECT title,content,course.courseNumber,`name`,assignmentNumber,startTime,deadline " +
                "FROM course  JOIN assignment ON (course.courseNumber=assignment.courseNumber and jobNumber='"+jobNumber+"');";
        ResultSet rs = database.myExecuteQuery(sql);
        String temp=database.resultSetToString(rs);
        System.out.println(temp);
        response.addHeader("data",temp);
    }






















    /**
     * 结果集的类型要是 ResultSet.TYPE_SCROLL_INSENSITIVE
     * 结果集可滚动，这样才能在调用 rs.next() 后恢复原样
     * @param rs
     * @return 默认为空
     */
    private boolean isEmptyResultSet(ResultSet rs){
        boolean result = true;
        try {
            result=!rs.next();
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setDatabase(String url, String account, String password, String databaseName) {
        this.database = new ConnectWithDatabase(url, account, password, databaseName);
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
