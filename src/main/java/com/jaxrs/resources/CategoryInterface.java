package com.jaxrs.resources;

import java.util.List;

public interface CategoryInterface {

    public List<Category> getAll();
    public Category get(int id);
    public Category create(Category category);
    public Category update(Category category);
    public void delete(int id);
}
