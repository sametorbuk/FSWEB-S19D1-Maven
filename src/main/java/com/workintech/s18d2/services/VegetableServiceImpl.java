package com.workintech.s18d2.services;


import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public ApiResponse<List<Vegetable>> decreasingAccordingToThePrice() {
        return new ApiResponse<>("Operation is successful" , vegetableRepository.getByPriceDesc());
    }

    @Override
    public ApiResponse<List<Vegetable>> increasingAccordingToThePrice() {
        return new ApiResponse<>("Operation is successful" , vegetableRepository.getByPriceAsc());
    }

    @Override
    public ApiResponse<List<Vegetable>> whichIncludingThisName(String name) {
        if(name == null){
            throw new PlantException("Name field can not be empty" , HttpStatus.BAD_REQUEST);
        }
        return new ApiResponse<>("Operation is successful" , vegetableRepository.whichIncludingThisName(name));
    }

    @Override
    public ApiResponse<Optional<Vegetable>> getById(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()){
            return new ApiResponse<>("Operation successful" ,vegetable );
        }
        throw new PlantException("There is no vegetable with this id" , HttpStatus.NOT_FOUND);

    }
}
