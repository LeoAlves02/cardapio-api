package com.leonardoalves.cardapio.controller;

import com.leonardoalves.cardapio.food.Food;
import com.leonardoalves.cardapio.food.FoodRepository;
import com.leonardoalves.cardapio.food.FoodRequestDTO;
import com.leonardoalves.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return repository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

}
