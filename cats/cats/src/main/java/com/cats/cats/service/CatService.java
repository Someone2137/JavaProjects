package com.cats.cats.service;

import com.cats.cats.model.Cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatService {
    private Map<Long, Cat> catMap = new HashMap<>();

    public void createCat(Cat cat) {
        this.catMap.put(cat.getId(), cat);
    }

    public Cat readCatById(Long catId){
        return this.catMap.get(catId);
    }

    public List<Cat> readAll(){
        return new ArrayList<>(this.catMap.values());
    }

    public void deleteCatById(Long catId){
        this.catMap.remove(catId);
    }

    public Cat updateCatById(Long catId, Integer catPosition){
        this.catMap.get(catId).setPosition(catPosition);
        return this.catMap.get(catId);
    }
}
