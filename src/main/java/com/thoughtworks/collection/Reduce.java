package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().max(Integer::compareTo).get();
    }

    public double getMinimum() {
        return this.arrayList.stream().min(Integer::compareTo).get();
    }

    public double getAverage() {
        return this.arrayList.stream().mapToInt(x -> x).summaryStatistics().getAverage();
    }

    public double getOrderedMedian() {
        if (arrayList.size() % 2 == 0) {
            return (double) (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2;
        } else {
            return arrayList.get(arrayList.size() / 2);
        }
    }

    public int getFirstEven() {
        int result = 0;
        for (Integer i : this.arrayList) {
            if (i % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
