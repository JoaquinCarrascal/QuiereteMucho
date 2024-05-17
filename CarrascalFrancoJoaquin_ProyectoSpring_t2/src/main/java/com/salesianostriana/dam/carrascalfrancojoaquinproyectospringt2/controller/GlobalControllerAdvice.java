package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleProductoNotFoundException(ProductNotFoundException ex) {
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("message", ex.getMessage());
        modelView.setViewName("empty-list");
        return modelView;
    }
}
