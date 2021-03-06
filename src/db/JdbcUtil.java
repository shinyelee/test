package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB 관련 기본 기능 클래스.
// Connection(연결), Close(자원반환), Commit(작업완료), Rollback(취소) 등을 담당.
public class JdbcUtil {

	// Connection Pool에서 Connection 객체를 얻어와서 반환하는 메소드를 정의.
	public static Connection getConnection() {
		Connection con = null;
		
		try { // 톰캣 자체의 컨텍스트를 얻어옴.
			Context initCtx = new InitialContext();
			// Resource 정의에 관한 컨텍스트를 얻어옴. lookup 메소드의 반환 타입이 Object이므로 Context 타입으로 다운캐스팅해야 함.
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			// context.xml에서 정의한 DataSource 객체를 얻어옴.
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB");
			// Connection Pool에서 Connection 객체를 얻어옴.
			con = ds.getConnection();
			// Connection 객체에 트랜잭션을 적용.
			con.setAutoCommit(false);
			System.out.println("connect success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// Connection 객체 닫아주는 메소드 정의.
	public static void close(Connection con) {
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Statement 객체 닫아주는 메소드 정의.
	public static void close(Statement stmt) {
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ResultSet 객체 닫아주는 메소드 정의.
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 트랜잭션 중 실행된 작업을 완료시키는 메소드 정의.
	public static void commit(Connection con) {
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	// 트랜잭션 중 실행된 작업을 취소시키는 메소드 정의.
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
