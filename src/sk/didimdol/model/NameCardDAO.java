package sk.didimdol.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NameCardDAO implements INameCardDAO {

	
	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				//nothing...
			}
		}
	}

	@Override
	public void insertNameCard(NameCard card) {
		Connection con = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);//Ʈ������ ����
			String sql = "insert into namecard (id, name, email, age) "
					+ "values (namecard_seq.NEXTVAL, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, card.getName());
			stmt.setString(2, card.getEmail());
			stmt.setInt(3, card.getAge());
			
			stmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
	}

	@Override
	public void updateNameCard(NameCard card) {
		Connection con = null;
		try {
			con = getConnection();
			String sql = "update namecard set name=?, email=?, age=? "
					+ " where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, card.getName());
			stmt.setString(2, card.getEmail());
			stmt.setInt(3, card.getAge());
			stmt.setInt(4, card.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
	}

	@Override
	public void deleteNameCard(NameCard card) {
		Connection con = null;
		try {
			con = getConnection();
			String sql = "delete from namecard where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, card.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
	}

	@Override
	public NameCard selectNameCard(int id) {
		NameCard card = new NameCard();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select * from namecard where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				card.setId(rs.getInt("id"));
				card.setName(rs.getString("name"));
				card.setEmail(rs.getString("email"));
				card.setAge(rs.getInt("age"));
			}else {
				throw new RuntimeException("ã�� ���ڵ尡 �������� �ʽ��ϴ�.");
			}
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
		return card;
	}

	@Override
	public ArrayList<NameCard> selectAllNameCards() {
		ArrayList<NameCard> list = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select * from namecard order by id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				NameCard card = new NameCard(id, name, email, age);
				list.add(card);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
		return list;
	}
	
	public int selectNextId(int id) {
		int next_id = 0;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "SELECT next_id FROM ("
                       + "   SELECT id, LEAD(id,1,0) OVER(ORDER BY id) AS next_id "
                       + "   FROM namecard"
                       + "   )"
                       + "WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				next_id = rs.getInt(1);
			}else {
				sql = "SELECT min(id) FROM namecard";
				stmt=con.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.next();
				next_id = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
		return next_id;
	}

	@Override
	public int selectPreviousId(int id) {
		int next_id = 0;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "SELECT prev_id FROM ("
                       + "   SELECT id, LAG(id,1,0) OVER(ORDER BY id) AS prev_id "
                       + "   FROM namecard"
                       + "   )"
                       + "WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				next_id = rs.getInt(1);
			}else {
				sql = "SELECT MAX(id) FROM namecard";
				stmt=con.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.next();
				next_id = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			closeConnection(con);
		}
		return next_id;
	}

}
