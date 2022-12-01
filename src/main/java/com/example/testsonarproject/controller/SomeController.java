package com.example.testsonarproject.controller;

import com.example.testsonarproject.service.SomeClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/plus")
    public ResponseEntity<?> plus(@RequestParam("x") int x, @RequestParam("y") int y) {
        return ResponseEntity
                .ok(SomeClass.plus(x, y));
    }

    @GetMapping("/minus")
    public ResponseEntity<?> minus(@RequestParam("x") int x, @RequestParam("y") int y) {
        return ResponseEntity
                .ok(SomeClass.minus(x, y));
    }


    @GetMapping("/multiply")
    public ResponseEntity<?> multiply(@RequestParam("x") int x, @RequestParam("y") int y) {
        return ResponseEntity
                .ok(SomeClass.multiply(x, y));
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam("x") int x, @RequestParam("y") int y) {
        try {
            int z = SomeClass.divide(x, y);
            return ResponseEntity
                    .ok(z);
        } catch (ArithmeticException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
