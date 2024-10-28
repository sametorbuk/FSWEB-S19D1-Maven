package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.response.ApiResponse;

import java.util.List;
import java.util.Optional;


public interface VegetableService {

    ApiResponse<List<Vegetable>> decreasingAccordingToThePrice();

    ApiResponse<List<Vegetable>> increasingAccordingToThePrice();

    ApiResponse<List<Vegetable>> whichIncludingThisName(String name);

    ApiResponse<Optional<Vegetable>> getById(Long id);
}
