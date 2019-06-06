package com.thoughtworks.collection;

import java.util.List;
import java.util.NoSuchElementException;

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
        for (Integer i : this.arrayList) {
            if (i % 2 == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean flag = true;
        if (this.arrayList.size() != arrayList.size()) {
            flag = false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != this.arrayList.get(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        for (Integer i : this.arrayList) {
            singleLink.addTailPointer(i);
        }
        if (this.arrayList.size() % 2 == 0) {
            int firstVal = (int)singleLink.getNode(this.arrayList.size() / 2);
            int secondVal = (int)singleLink.getNode(this.arrayList.size() / 2 + 1);
            return (firstVal + secondVal) / 2.0;
        } else {
            Integer node = (Integer) singleLink.getNode(this.arrayList.size() / 2 + 1);
            return node.doubleValue();
        }
    }

    public int getLastOdd() {
        for (int i = this.arrayList.size() - 1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 != 0) {
                return this.arrayList.get(i);
            }
        }
        throw new NoSuchElementException();
    }

    public int getIndexOfLastOdd() {
        for (int i = this.arrayList.size() - 1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 != 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }
}
