package com.workintech.sp18d1.exceptions;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BurgerErrorResponse {
    private String message;
    private HttpStatus status;
    private Long timestamp;

}
