package edu.hyit.bm.service;

import java.util.List;

import edu.hyit.bm.dao.CategoryDao;
import edu.hyit.bm.model.BookCategory;

public class CategoryService {
	
	private CategoryDao categoryDao = new CategoryDao();

	public void save(BookCategory bookCategory) {
		if(bookCategory.getId()!=null) {
			categoryDao.update(bookCategory);
		}else {
			categoryDao.insert(bookCategory);
		}
	
	}

	public List<BookCategory> findAll() {
		return categoryDao.findAll();
	}

	public List<BookCategory> findByCategoryNameLike(String query) {
		return categoryDao.findByCategoryNameLike(query);
	}

	public void delete(Integer id) {
		categoryDao.delete(id);
	}

}
