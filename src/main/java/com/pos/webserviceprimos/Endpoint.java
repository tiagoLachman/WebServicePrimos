/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.webserviceprimos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tiago André Lachman
 */
@RestController
@RequestMapping("/AppWebConf2/resources")
public class Endpoint {

    @GetMapping("/servicoRest/{v}")
    public String servicoRest(@PathVariable("v") Integer v) {
        return primos(v).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private List<Integer> primos(int n) {
        List<Integer> primos = new ArrayList<>();
        if (n > 1) {
            primos.add(1);
        }
        for (int i = 2; i < n; i++) {
            if (ehPrimo(i)) {
                primos.add(i);
            }
        }
        return primos;
    }

    private boolean ehPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
