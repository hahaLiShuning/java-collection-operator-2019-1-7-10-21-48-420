package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(x -> x * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(x -> letterList.get(x - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {

        return this.array.stream().map(x -> {
            int temp = x;
            String s = "";
            if (temp > 26) {
                while (temp > 26) {
                    int quotient = temp / 26;
                    int remainder = temp % 26;
                    int i, j;
                    if (quotient < 26) {
                        i = remainder == 0 ? quotient - 2 : quotient - 1;
                        j = remainder - 1 >= 0 ? remainder - 1 : 25;
                        s = s.concat(letterList.get(i).concat(letterList.get(j)));
                        break;
                    } else {
                        temp = quotient;
                    }
                }
            } else {
                s = letterList.get(x - 1);
            }
            return s;
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return this.array.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
