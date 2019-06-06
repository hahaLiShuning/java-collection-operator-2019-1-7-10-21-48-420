package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer[] arr : this.array) {
            for (Integer i : arr) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer[] arr : this.array) {
            for (Integer i : arr) {
                if (!result.contains(i)) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
