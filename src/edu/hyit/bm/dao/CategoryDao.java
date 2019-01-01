package edu.hyit.bm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.hyit.bm.model.BookCategory;
import edu.hyit.bm.util.DbUtils;

public class CategoryDao {

	public void insert(BookCategory bookCategory) {
		Connection conn = null;
		PreparedStatement pstt = null;
		try {
			conn = DbUtils.getConn();
			pstt = conn
					.prepareStatement("insert into bm_book_category (category_name,category_description) values (?,?)");
			pstt.setString(1, bookCategory.getCategoryName());
			pstt.setString(2, bookCategory.getDescription());
			pstt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.free(null, pstt, conn);
		}
	}

	public void update(BookCategory bookCategory) {
		Connection conn = null;
		PreparedStatement pstt = null;
		try {
			conn = DbUtils.getConn();
			pstt = conn.prepareStatement("update bm_book_category set category_name = ?,category_description = ? where id =?");
			pstt.setString(1, bookCategory.getCategoryName());
			pstt.setString(2, bookCategory.getDescription());
			pstt.setInt(3,bookCategory.getId());
			pstt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BookCategory> findAll() {
		Connection conn = null;
		PreparedStatement pstt = null;
		ResultSet rs = null;
		List<BookCategory> list = new ArrayList<>();
		try {
			conn = DbUtils.getConn();
			pstt = conn.prepareStatement("select * from bm_book_category");
			rs = pstt.executeQuery();
			while (rs.next()) {
				BookCategory bookCategory = new BookCategory();
				bookCategory.setId(rs.getInt("id"));
				bookCategory.setCategoryName(rs.getString("category_name"));
				bookCategory.setDescription(rs.getString("category_description"));
				list.add(bookCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.free(rs, pstt, conn);
		}
		return list;
	}

	/**
	 * 根据类型名称模糊查找
	 * @param query
	 * @return
	 */
	public List<BookCategory> findByCategoryNameLike(String query) {
		Connection conn = null;
		PreparedStatement pstt = null;
		ResultSet rs = null;
		List<BookCategory> list = new ArrayList<>();
		try {
			conn = DbUtils.getConn();
			pstt = conn.prepareStatement("select * from bm_book_category where category_name like ?");
			pstt.setString(1, "%"+query+"%");
			rs = pstt.executeQuery();
			while (rs.next()) {
				BookCategory bookCategory = new BookCategory();
				bookCategory.setId(rs.getInt("id"));
				bookCategory.setCategoryName(rs.getString("category_name"));
				bookCategory.setDescription(rs.getString("category_description"));
				list.add(bookCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.free(rs, pstt, conn);
		}
		return list;
	}

	public void delete(Integer id) {
		Connection conn = null;
		PreparedStatement pstt = null;
		try {
			conn = DbUtils.getConn();
			pstt = conn.prepareStatement("delete from bm_book_category where id = ?");
			pstt.setInt(1, id);
			pstt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.free(null, pstt, conn);
		}
	}
}
