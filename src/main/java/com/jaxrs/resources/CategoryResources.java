package com.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/v2/categories")
public class CategoryResources {


    CategoryService categoryService;

    public CategoryResources() {
        categoryService = new CategoryService();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> all() {

        return categoryService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category get(@PathParam("id") int id) {
        return categoryService.get(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
         categoryService.delete(id);
    }
}
