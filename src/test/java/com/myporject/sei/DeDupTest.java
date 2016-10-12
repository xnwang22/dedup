package com.myporject.sei;

import com.myporject.sei.DeDup;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Created by robinwang on 10/11/16.
 */
public class DeDupTest {
    public int[] a = {1, 3, 5, 5, 8,1};

    @Test
    public void testDeDupUsingStream()
    {
       int[] result1 =  DeDup.dedupUsingStream(a);
        assertTrue(Arrays.equals(new int[]{1,3,5,8}, result1));
    }

    @Test
    public void testDeDupUsingHashSet()
    {
        int[] result =  DeDup.dedupUsingHashSet(a);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 3, 5, 8));
        Set<Integer> resultSet = Arrays.stream(result).boxed().collect(Collectors.toSet());
        assertTrue(expected.equals(resultSet));
    }

    @Test
    public void testDeDupUsingLinkedHashSet()
    {
        int[] result =  DeDup.dedupUsingLinkedHashSet(a);
        assertTrue(Arrays.equals(new int[]{1,3,5,8}, result));
    }

    @Test
    public void testDeDupUsingMap()
    {
        int[] result =  DeDup.dedupUsingMap(a);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 3, 5, 8));
        Set<Integer> resultSet = Arrays.stream(result).boxed().collect(Collectors.toSet());
        assertTrue(expected.equals(resultSet));
    }

}
