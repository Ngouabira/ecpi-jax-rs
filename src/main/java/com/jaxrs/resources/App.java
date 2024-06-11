package com.jaxrs.resources;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Category category = new Category();
        category.setName("Test 3");
        category.setDescription("Test 3");
        System.out.println("It's running");
        CategoryService categoryService = new CategoryService();
        categoryService.create(category);
    }
}
