package com.test.psk.issue.vo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class mysqlTest {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://192.168.195.128:3306/license"; // jdbc:mysql://127.0.0.1:3306/��������
																						// �����
																						// ��Ű���̸�
	private static final String USER = "test"; // DB ����ڸ�
	private static final String PW = "test"; // DB ����� ��й�ȣ

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("����");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
	}

}
