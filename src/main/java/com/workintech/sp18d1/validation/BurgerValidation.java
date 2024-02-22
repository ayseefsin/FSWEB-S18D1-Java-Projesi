package com.workintech.sp18d1.validation;

import com.workintech.sp18d1.entity.Burger;
import com.workintech.sp18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkName(String name){
        if(name==null|| name.isEmpty()){
            throw new BurgerException("name cannot be null or empty! ", HttpStatus.BAD_REQUEST);
        }
    }
}
