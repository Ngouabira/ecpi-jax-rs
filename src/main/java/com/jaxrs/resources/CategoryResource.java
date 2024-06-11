package com.jaxrs.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/v1/categories")
public class CategoryResource {

    private EntityManager em;
    private EntityManagerFactory emf;

    public CategoryResource() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category get(@PathParam("id") int id) {
        return em.find(Category.class, id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category create(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category update(Category category) {
        em.getTransaction().begin();
        Category updatedCategory = em.merge(category);
        em.getTransaction().commit();
        return updatedCategory;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
        em.getTransaction().commit();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public String hello() {
        return "hello";
    }


}
