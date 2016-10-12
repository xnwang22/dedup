package com.myporject.sei;

import java.util.*;


/**
 * Created by robinwang on 10/11/16.
 */
public class DeDup {
    public static int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1,
            10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9,
            1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12,
            3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};


    public static void main(String[] args) {
        // using stream distinct
        int[] resultArrayFromStream = dedupUsingStream(randomIntegers);
        Arrays.stream(resultArrayFromStream).forEach(e->System.out.println(String.valueOf(e)));
        System.out.println("*****end using stream*****");

        // using stream hashset
        int[] resultArrayUsingHashSet = dedupUsingHashSet(randomIntegers);
        Arrays.stream(resultArrayUsingHashSet).forEach(e->System.out.println(String.valueOf(e)));
        System.out.println("*****end using hashset*****");

        // using stream linkedHashset
        int[] resultArrayUsingLinkedHashSet = dedupUsingLinkedHashSet(randomIntegers);
        Arrays.stream(resultArrayUsingLinkedHashSet).forEach(e->System.out.println(String.valueOf(e)));
        System.out.println("*****end using linkedhashset*****");

        // using Map
        int[] resultArrayUsingMap = dedupUsingMap(randomIntegers);
        Arrays.stream(resultArrayUsingMap).forEach(e->System.out.println(String.valueOf(e)));
        System.out.println("*****end using map*****");

    }
    /**
     * @param a input array
     * @return array without duplications
     */

    public static int[] dedupUsingStream(int[] a) {

        return Arrays.stream(a).distinct().toArray();
    }

    /**
     * @param a input array
     * @return array without duplications
     */
    public static int[] dedupUsingHashSet(int[] a) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        return set.stream().mapToInt(Number::intValue).toArray();
    }

    /**
     * @param a input array
     * @return array without duplications
     */
    public static int[] dedupUsingLinkedHashSet(int[] a) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        return set.stream().mapToInt(Number::intValue).toArray();
    }

    /**
     * @param a input array
     * @return array without duplications
     */
    public static int[] dedupUsingMap(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            Integer previous;
            if ((previous = map.put(Integer.valueOf(a[i]), 1)) != null)
                map.put(Integer.valueOf(a[i]), previous + 1);

        }

        return map.keySet().stream().mapToInt(Number::intValue).toArray();
    }
}
