package com.lambdaschool.javacountriescameron;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;

@RestController
@RequestMapping("/data")
public class CountryController
{
    // localhost:2020/data/names/all
    @GetMapping(value = "/names/all",
    produces = {"application/json"})
    public ResponseEntity<?> getAllNames()
    {
        JavaCountriesCameronApplication.ourCountList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesCameronApplication.ourCountList.countryList, HttpStatus.OK);
    }

    // localhost:2020/data/names/start/l
    @GetMapping(value = "/names/start/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryByLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCounts = JavaCountriesCameronApplication.ourCountList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCounts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCounts, HttpStatus.OK);
    }

    // localhost:2020/data/names/size/{number}
    @GetMapping(value = "/names/size/{number}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryNameSize(@PathVariable int number)
    {
        ArrayList<Country> rtnSize = JavaCountriesCameronApplication.ourCountList.findCountries(c -> c.getName().length() >= number);
        rtnSize.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnSize, HttpStatus.OK);
    }

    // localhost:2020/data/population/size/{number}
    @GetMapping(value = "/population/size/{number}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryPopSize(@PathVariable int number)
    {
        ArrayList<Country> rtnSize = JavaCountriesCameronApplication.ourCountList.findCountries(c -> c.getPopulation() >= number);
        return new ResponseEntity<>(rtnSize, HttpStatus.OK);
    }

    // localhost:2020/data/population/min
    @GetMapping(value = "/population/min",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryPopMin()
    {
        ArrayList<Country> minList = JavaCountriesCameronApplication.ourCountList.countryList;
        minList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(minList, HttpStatus.OK);
    }

    // localhost:2020/data/population/max
    @GetMapping(value = "/population/max",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryPopMax()
    {
        ArrayList<Country> maxList = JavaCountriesCameronApplication.ourCountList.countryList;
        maxList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(maxList, HttpStatus.OK);
    }

    // localhost:2020/data/age/age/{age}
    @GetMapping(value = "/age/age/{age}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountryAge(@PathVariable int age)
    {
        ArrayList<Country> rtnAge = JavaCountriesCameronApplication.ourCountList.findCountries(c -> c.getAge() >= age);
        return new ResponseEntity<>(rtnAge, HttpStatus.OK);
    }

    // localhost:2020/data/age/min
    @GetMapping(value = "/age/min",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryAgeMin()
    {
        ArrayList<Country> minList = JavaCountriesCameronApplication.ourCountList.countryList;
        minList.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        return new ResponseEntity<>(minList, HttpStatus.OK);
    }

    // localhost:2020/data/age/max
    @GetMapping(value = "/age/max",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryAgeMax()
    {
        ArrayList<Country> maxList = JavaCountriesCameronApplication.ourCountList.countryList;
        maxList.sort((c1, c2) -> (int)(c2.getAge() - c1.getAge()));
        return new ResponseEntity<>(maxList, HttpStatus.OK);
    }

//    // localhost:2020/data/population/median
//    @GetMapping(value = "/population/medain",
//            produces = {"application/json"})
//    public ResponseEntity<?> getCountryPopMed()
//    {
//        ArrayList<Country> maxList = JavaCountriesCameronApplication.ourCountList.countryList;
//        maxList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
//
//        ArrayList<Country> minList = JavaCountriesCameronApplication.ourCountList.countryList;
//        minList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
//
//        int medianList = (maxList.get(0).getPopulation() + minList.get(0).getPopulation()) / 2;
//
//        System.out.println(medianList);
//
//
//        return new ResponseEntity<>(medianList, HttpStatus.OK);
//    }
}
