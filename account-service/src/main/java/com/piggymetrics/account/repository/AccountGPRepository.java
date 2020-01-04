package com.piggymetrics.account.repository;

import com.piggymetrics.account.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;

//import org.springframework.data.jpa.repository.JpaRepository;


public class AccountGPRepository  {
	public void save(Account account) {
		System.out.println(account);

	}

	public Account findByName(String name){

		Account account = new Account();
		Connection connection = getConn();

		ResultSet rs = query(connection, "select * from account");
		try {
			while(rs.next()){

                String curName = rs.getString("name");
				account.setName(curName);

                break;

            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("waj----------------");
		return account;

	}

	private Connection getConn() {
		Connection conn = null;
		// jdbc协议:postgresql子协议://主机地址:数据库端口号/要连接的数据库名
		String url = "jdbc:postgresql://localhost:5432/testdb";
		// 数据库用户名
		String user = "test";
		// 数据库密码
		String password = "123456";

		// 1. 加载Driver类，Driver类对象将自动被注册到DriverManager类中
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public ResultSet query(Connection conn, String sql) {
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


}

