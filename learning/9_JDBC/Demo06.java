package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 测试事务的基本概念和用法
 * @author 高淇 www.sxt.cn
 *
 */

/** 事务基本概念
 *	– 一组要么同时执行成功，要么同时执行失败的SQL语句。是数据库操作的一个执行单元！
 *	– 事务开始于：
 *		• 连接到数据库上，并执行一条DML语句(INSERT、UPDATE或DELETE)。
 *		• 前一个事务结束后，又输入了另外一条DML语句。
 *	– 事务结束于：
 *		• 执行COMMIT或ROLLBACK语句。
 *		• 执行一条DDL语句，例如CREATE TABLE语句；在这种情况下，会自动执行COMMIT语句。
 *		• 执行一条DCL语句，例如GRANT语句；在这种情况下，会自动执行COMMIT语句。
 *		• 断开与数据库的连接。
 *		• 执行了一条DML语句，该语句却失败了；在这种情况中，会为这个无效的DML语句执行ROLLBACK语句
 */

/**
 * 事务的四大特点（ACID）
 * – atomicity（原子性）
 * 		• 表示一个事务内的所有操作是一个整体，要 么全部成功，要么全失败；
 * – consistency（一致性）
 * 		• 表示一个事务内有一个操作失败时，所有的更改过的数据都必须回滚到修改前的状态；
 * – isolation（隔离性）
 * 		• 事务查看数据时数据所处的状态，要么是另一并发事务修改它之前的状态，
 * 		要么是另一事务修改它之后的状态，事务不会查看中间状态的数据。
 * – durability（持久性）
 * 		• 持久性事务完成之后，它对于系统的影响是永久性的。
 */





public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root","XUAN1998");
			
			conn.setAutoCommit(false); //JDBC中默认是true，自动提交事务
			
			ps1 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps1.setObject(1, "高淇");
			ps1.setObject(2, "123456");
			ps1.execute();
			System.out.println("插入一个用户,高淇");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			ps2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");	//插入成功 - 两个一起成功
			ps2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");//插入失败 - 两个一起失败
			ps2.setObject(1, "马士兵");
			ps2.setObject(2, "123456");
			ps2.execute();			
			System.out.println("插入一个用户,马士兵");
			
			conn.commit();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();	//回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps1!=null){
					ps1.close();
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
