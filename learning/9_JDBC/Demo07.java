package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;


/**
 * 测试时间处理(java.sql.Date,Time,Timestamp)
 * @author 高淇 www.sxt.cn
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root","XUAN1998");
			
				
				ps = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,?)");
				ps.setObject(1, "高淇");
				ps.setObject(2, "123456");
				Timestamp stamp = new Timestamp(System.currentTimeMillis());  //如果需要插入指定日期，可以使用Calendar、DateFormat
				
				ps.setTimestamp(3, stamp);
				ps.execute();
				
				
			
			
			
			System.out.println("插入一个用户,高淇");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
