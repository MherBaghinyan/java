package com.sumac;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MyFunctions {

    public static void main(String args []) {

        MyFunctions func = new MyFunctions();
        int result = func.secondLargest(new int[] {5, 6, 7, 11, 3, 4, 3, 0});
        System.out.println(result);

    }

    /**
     *
     * find the second largest integer in an array.
     *
     * @param ia
     *            an array of integers
     *
     * @return the second largest number in ia or a default value of 0
     *
     */
    public int secondLargest(final int[] ia) {

//        List<Integer> list = Arrays.stream(ia).boxed()
//                .distinct()
//                .sorted(Comparator.comparing(Integer::intValue).reversed())
//                .collect(Collectors.toList());

        int [] bucket = new int[ia.length + 1];

        for (int item : ia) {
            bucket[item]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                ia[outPos++]=i;
            }
        }

        if(ia.length > 1) {
            return ia[ia.length - 2];
        }
        return 0;
    } // secondLargest

    /**
     *
     * Find all pairs of numbers chosen from ia, such that each pair of numbers adds
     * up to target.
     *
     * @param ia
     *            an array of integers
     *
     * @param target
     *            the target integer
     *
     * @return a List of Pairs of numbers that add up to a specified target
     *
     */
    public List<Pair> findPairs(int[] ia, int target) {

        Map<Integer, Integer> pairsMap = new HashMap<>();
        List<Pair> result = new ArrayList<>();

        Arrays.stream(ia).boxed().forEach(item -> {
            if(pairsMap.containsKey(item)) {
                result.add(new Pair(item, pairsMap.get(item)));
            } else {
                pairsMap.put(target - item, item);
            }
        });

        return result;
    } // findPairs

    public static class Pair {
        public final int first;
        public final int second;

        public Pair(int first, int second) {
            super();
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + first;
            result = prime * result + second;
            return result;
        } // hashCode

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (first != other.first)
                return false;
            if (second != other.second)
                return false;
            return true;
        } // equals

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    /**
     *
     * Find all pairs of numbers from pa, such that each both numbers in the pair
     * are divisible by the divisor.
     *
     * @param pa
     *            an array of pairs of integers
     *
     * @param divisor
     *            the divisor integer
     *
     * @return a List of Pairs of integers that are divisible by the divisor
     *         parameter
     *
     */
    public List<Pair> divisible(Pair[] pa, int divisor) {
        List<Pair> result = new ArrayList<>();
        for (Pair p : pa) {
            if ((p.first % divisor == 0) && (p.second % divisor == 0)) {
                result.add(p);
            }
        }
        return result;
    } // divisible


    @Test
    public void divisibleMethodWithReturnValuesTest() {

        Pair[] toBeTested = new Pair[]{new Pair(10, 20), new Pair(7, 25)};

        List<Pair> shouldBeEquals = new ArrayList<>();
        shouldBeEquals.add(new Pair(10, 20));

        // assert with return value
        assertEquals(shouldBeEquals, divisible(toBeTested, 5));
    }

    @Test
    public void divisibleMethodEmptyReturnTest() {

        Pair[] toBeTested = new Pair[]{new Pair(10, 20), new Pair(7, 25)};

        List<Pair> shouldBeEquals = new ArrayList<>();

        // assert returns empty list
        assertEquals(shouldBeEquals, divisible(toBeTested, 3));
    }

}


