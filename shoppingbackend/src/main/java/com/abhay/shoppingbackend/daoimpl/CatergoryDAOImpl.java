package com.abhay.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.abhay.shoppingbackend.dao.CategoryDAO;
import com.abhay.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CatergoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static {
		Category category = new Category();

		//adding 1st category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is a TV");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		//adding 2nd category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is a phone");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);

		//adding 3rd category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a laptop");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		//enhanced for loop
		for(Category category: categories) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
