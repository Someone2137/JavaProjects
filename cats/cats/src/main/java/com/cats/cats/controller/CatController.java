package com.cats.cats.controller;

import com.cats.cats.model.Cat;
import com.cats.cats.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {
    private CatService catService = new CatService();

    @GetMapping("getAllCats")
    public ResponseEntity<List<Cat>> getAllCats() {
        return ResponseEntity.ok().body(this.catService.readAll());
    }

    @PostMapping("postCat")
    public ResponseEntity<Cat> postCat(@RequestBody Cat cat) {
        this.catService.createCat(cat);
        return ResponseEntity.ok().body(this.catService.readCatById(cat.getId()));
    }

    @GetMapping("getCatById/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(this.catService.readCatById(id));
    }

    @DeleteMapping("deleteCatById/{id}")
    public ResponseEntity<String> deleteCatById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body("Deleted cat " + id);
    }

    @PutMapping("putCatById/{id}/{position}")
    public ResponseEntity<Cat> putCatById(@PathVariable(value = "id") Long id, @PathVariable(value = "position") Integer position){
        return ResponseEntity.ok().body(this.catService.updateCatById(id, position));
    }
}
