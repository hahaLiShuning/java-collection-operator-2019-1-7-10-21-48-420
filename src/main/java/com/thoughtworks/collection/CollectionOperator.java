package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = left;;) {
            result.add(i);
            i = left < right ? i + 1 : i - 1;
            if (left < right) {
                if (i > right) break;
            } else {
                if (i < right) break;
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = left;;) {
            if (i % 2 == 0) {
                result.add(i);
            }
            i = left < right ? i + 1 : i - 1;
            if (left < right) {
                if (i > right) break;
            } else {
                if (i < right) break;
            }
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int item : array) {
            if (item % 2 == 0) {
                result.add(item);
            }
        }
        return result;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : firstArray) {
            set.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : secondArray) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : firstArray) {
            result.add(i);
        }
        for (Integer i : secondArray) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
