package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection getConnection() { // Connection Pool에서 Connection 객체를 얻어와서 반환하는 메소드를 정의.
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext(); // 톰캣 자체의 컨텍스트를 얻어옴.
			Context envCtx = (Context)initCtx.lookup("java:comp/env"); // Resource 정의에 관한 컨텍스트를 얻어옴. lookup 메소드의 반환 타입이 Object이므로 Context 타입으로 다운캐스팅해야 함.
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB"); // context.xml에서 정의한 DataSource 객체를 얻어옴.
			con = ds.getConnection(); // Connection Pool에서 Connection 객체를 얻어옴.
			con.setAutoCommit(false); // Connection 객체에 트랜잭션을 적용.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) { // Connection 객체 닫아주는 메소드 정의.
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) { // Statement 객체 닫아주는 메소드 정의.
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs) { // ResultSet 객체 닫아주는 메소드 정의.
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection con) { // 트랜잭션 중 실행된 작업을 완료시키는 메소드 정의.
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void rollback(Connection con) { // 트랜잭션 중 실행된 작업을 취소시키는 메소드 정의.
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
