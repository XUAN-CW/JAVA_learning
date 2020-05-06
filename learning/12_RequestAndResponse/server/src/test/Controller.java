package test;

import Database.ConnectWithDatabase;

import javax.servlet.http.HttpServletRequest;

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
    String result="OK";
    HttpServletRequest request;
    public Controller(HttpServletRequest request){
        setRequest(request);
    }

    public void parse(){
        String identity=request.getHeader("identity");
        System.out.println(identity);
        if (null!=identity){
            if (identity.equals("student")){
                toStudent();
            }else {
                toTeacher();
            }
        }
    }


    public void toStudent(){
        ConnectWithDatabase c=new ConnectWithDatabase("47.102.200.197", "root", "XUAN", "assignment");
        String operate = request.getHeader("operate");
        System.out.println(operate);
        if (operate.equals("getStudentCourses")){
            String studentNumber=request.getHeader("studentNumber");
            System.out.println(studentNumber);
            result=c.resultSetToString(c.getStudentCourses(studentNumber));
        }
        if (operate.equals("queryAssignment")){
            String studentNumber=request.getHeader("studentNumber");
            System.out.println(studentNumber);
            result=c.resultSetToString(c.queryAssignment(request.getHeader("studentNumber")));
        }
    }

    public void toTeacher(){
        String operate = request.getHeader("operate");
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
