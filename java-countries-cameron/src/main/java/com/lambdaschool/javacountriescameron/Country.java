package com.lambdaschool.javacountriescameron;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int mass;
    private int age;

    public Country(String name, int population, int mass, int age)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.mass = mass;
        this.age = age;
    }

    public Country(Country toClone) // why do we have this clone constructor?
    {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.mass = toClone.getMass();
        this.age = toClone.getAge();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getMass()
    {
        return mass;
    }

    public void setMass(int mass)
    {
        this.mass = mass;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", mass=" + mass +
                ", age=" + age +
                '}';
    }
}
