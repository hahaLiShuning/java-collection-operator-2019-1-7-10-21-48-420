package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            leftBorder = leftBorder + rightBorder;
            rightBorder = leftBorder - rightBorder;
            leftBorder = leftBorder - rightBorder;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            if (i % 2 == 0) sum += i;
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            leftBorder = leftBorder + rightBorder;
            rightBorder = leftBorder - rightBorder;
            leftBorder = leftBorder - rightBorder;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            if (i % 2 != 0) sum += i;
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(x -> x * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x % 2 == 0 ? x : x * 3 + 2).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 != 0).mapToInt(x -> x * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        if (evenList.size() % 2 != 0) {
            return evenList.get(evenList.size() / 2);
        } else {
            return (evenList.get(evenList.size() / 2 - 1) + evenList.get(evenList.size() / 2)) / 2;
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.averagingDouble(x -> x));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for (Integer item : arrayList) {
            if (item % 2 == 0) {
                evenList.add(item);
            } else {
                oddList.add(item);
            }
        }
        evenList.sort(Comparator.comparingInt(Integer::intValue));
        oddList.sort(Comparator.comparingInt(Integer::intValue).reversed());
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List result = new ArrayList<Integer>();
        arrayList.stream().reduce((x, y) -> {
            result.add((x + y) * 3);
            return y;
        });
        return result;
    }
}
