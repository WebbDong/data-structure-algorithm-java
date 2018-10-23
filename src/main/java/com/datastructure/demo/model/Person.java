package com.datastructure.demo.model;

import lombok.Data;

@Data
public class Person implements Comparable<Person> {

    private int age;

    private String name;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Person o) {
        if (o == null) {
            throw new IllegalArgumentException("not be null");
        }
        return this.age > o.age ? 1 : (this.age == o.age ? 0 : -1);
    }

}
