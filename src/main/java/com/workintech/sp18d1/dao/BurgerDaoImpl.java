package com.workintech.sp18d1.dao;

import com.workintech.sp18d1.entity.BreadType;
import com.workintech.sp18d1.entity.Burger;
import com.workintech.sp18d1.exceptions.BurgerException;

import com.workintech.sp18d1.validation.BurgerValidation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private final EntityManager entityManager;
    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Burger save(Burger burger) {

        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> findAll = entityManager.createQuery("select b from Burger b", Burger.class);
        return findAll.getResultList();
    }

    @Override
    public Burger findById(long id) {
        Burger burger = entityManager.find(Burger.class,id);
        if(burger==null){
            throw new BurgerException("Burger is not found with given id: " +id, HttpStatus.NOT_FOUND);
        }
        return null;
    }
    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }
    @Transactional
    @Override
    public Burger remove(long id) {
        Burger burger = entityManager.find(Burger.class,id);
        if(burger==null){
            throw new BurgerException("id is not valid: " + id, HttpStatus.NOT_FOUND);
        }
        entityManager.remove(burger);
        return burger;
    }

    @Override
    public List<Burger> findByPrice(Long price) {
           TypedQuery<Burger> priceQuery= entityManager.createQuery("SELECT b from Burger b where b.price = :price", Burger.class);
           priceQuery.setParameter(Math.toIntExact(price), price);
        return priceQuery.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> breadQuery = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ", Burger.class);
        return breadQuery.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> contentQuery = entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%',:content,'%')", Burger.class);
        contentQuery.setParameter("content" , content);
        return contentQuery.getResultList();
    }
}