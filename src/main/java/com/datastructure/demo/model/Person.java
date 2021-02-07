package com.datastructure.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person> {

    private int age;

    private String name;

    public int compareTo(Person o) {
        if (o == null) {
            throw new IllegalArgumentException("not be null");
        }
        return this.age > o.age ? 1 : (this.age == o.age ? 0 : -1);
    }

}
