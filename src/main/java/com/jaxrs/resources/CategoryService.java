package com.jaxrs.resources;

import javax.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Singleton
public class CategoryService implements CategoryInterface{

    private EntityManager em;
    private EntityManagerFactory emf;

    public CategoryService() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    @Override
    public List<Category> getAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @Override
    public Category get(int id) {
        return em.find(Category.class, id);
    }

    @Override
    public Category create(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    @Override
    public Category update(Category category) {
        em.getTransaction().begin();
        Category updatedCategory = em.merge(category);
        em.getTransaction().commit();
        return updatedCategory;
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
        em.getTransaction().commit();
    }
}
