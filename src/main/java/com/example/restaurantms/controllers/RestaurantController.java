package com.example.restaurantms.controllers;


import com.example.restaurantms.entities.Restaurant;
import com.example.restaurantms.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private String title = "Hello, i'm the restaurant Micro Service";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping
    public List<Restaurant> getListCandid() {
        return restaurantService.getAll();
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") int id,
                                                       @RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.updateRestaurant(id, restaurant), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRestaurant(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(restaurantService.deleteRestaurant(id), HttpStatus.OK);
    }

}
