package edu.hyit.bm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import edu.hyit.bm.model.User;
import edu.hyit.bm.util.DbUtils;

public class UserDao {

	public User findByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstt = null;
		ResultSet rs = null;
		User result= null;
		try {
			conn = DbUtils.getConn();
			pstt = conn.prepareStatement("select * from bm_user where username = ?");
			pstt.setString(1,username);
			rs = pstt.executeQuery();
			while(rs.next()) {
				result = new User();
				result.setId(rs.getInt("id"));
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.free(rs, pstt, conn);
		}
		return null;
	}

}
