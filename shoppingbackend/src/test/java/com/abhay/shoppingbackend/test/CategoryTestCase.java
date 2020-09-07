package com.abhay.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhay.shoppingbackend.dao.CategoryDAO;
import com.abhay.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext ctx;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.abhay.shoppingbackend");
		ctx.refresh();
		
		categoryDAO = (CategoryDAO)ctx.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		
//		category.setName("Laptop");
//		category.setDescription("This is a Laptop");
//		category.setImageURL("CAT_666.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(1);
//		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
//	}

//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(1);
//		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
//	}
//	
//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());
//	}
	
	@Test
	public void testCRUDCategory() {
		//ADD Operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is a Laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is a Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		//Fetching and Updating the category		
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
	
		//Deleting the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
	
		//Fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());
	}
}
