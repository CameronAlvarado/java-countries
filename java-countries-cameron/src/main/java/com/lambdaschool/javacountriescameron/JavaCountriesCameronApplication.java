package com.lambdaschool.javacountriescameron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesCameronApplication
{
    static CountryList ourCountList; // why are we making a new country list here?

    public static void main(String[] args)
    {
        ourCountList = new CountryList();
        SpringApplication.run(JavaCountriesCameronApplication.class, args);
    }

}
