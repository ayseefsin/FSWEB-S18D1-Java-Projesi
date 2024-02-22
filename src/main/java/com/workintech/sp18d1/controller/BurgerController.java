package com.workintech.sp18d1.controller;

import com.workintech.sp18d1.dao.BurgerDao;
import com.workintech.sp18d1.dao.BurgerDaoImpl;
import com.workintech.sp18d1.entity.BreadType;
import com.workintech.sp18d1.entity.Burger;
import com.workintech.sp18d1.validation.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SplittableRandom;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {

        this.burgerDao = burgerDao;
    }
    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> getAll(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger get(@PathVariable("id") long id ){
        return burgerDao.findById(id);
    }
    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger){
        return burgerDao.update(burger);

    }
    @DeleteMapping("/{id}")
    public Burger deleteById(@PathVariable("id") long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> getByBreadType(@PathVariable("breadType") String breadType){
        return burgerDao.findByBreadType(BreadType.valueOf(breadType));
    }
    @GetMapping("/price/{price}")
    public List<Burger> getByPrice(@PathVariable("price") Long price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content){
        return burgerDao.findByContent(content);
    }

}
