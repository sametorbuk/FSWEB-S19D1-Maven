package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.response.ApiResponse;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FruitController {


    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }


     @GetMapping("/fruit")
    public List<Fruit> getAllFruitsAsc(){
        return fruitService.getByPriceAsc();
     }


     @GetMapping("/fruit/{id}")
    public Optional<Fruit> getById(@PathVariable long id){
        return fruitService.getById(id);
     }

     @GetMapping("/fruit/desc")
    public List<Fruit> getAllFruitsDesc(){
        return fruitService.getByPriceDesc();

     }


     @DeleteMapping("/fruit/{id}")
    public Fruit deleteById(@PathVariable long id){
        return fruitService.delete(id);
     }



     @PostMapping("/fruit")
    public Fruit saveFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
     }


     @GetMapping("/fruit/name/{name}")
    public List<Fruit> getFruitByName(@PathVariable String name){
     return fruitService.searchByName(name);
     }

}
