package com.database;
 
import java.sql.*;
 
 
/**
 * ���ݿ�������
 * @author Administrator
 *
 */
public class DBConnection {
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String user = "root";
	private static String password = "mysql";
 
	public static Connection getCon() {
		//�������ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		
		//��ȡ���ݿ�����
		try {
			con = DriverManager.getConnection(url, user, password);
			if(con !=null) {
				System.out.println("���ݿ����ӳɹ���");
			}
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		//����Connection����
		return con;
	}
		
	
}
