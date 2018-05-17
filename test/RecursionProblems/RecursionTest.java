package RecursionProblems;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

public class RecursionTest {

    int[] nums1 = {1, 2, 3};
    int[] nums2 = {};
    int[] nums3 = {-10, 8, 4, 6, -12, 3};
    int[] empty = {};
    @Test
    public void recursiveAdd() throws Exception {
        Assert.assertEquals(6, Recursion.recursiveAdd(nums1, nums1.length));
        Assert.assertEquals(0, Recursion.recursiveAdd(nums2, nums2.length));
        Assert.assertEquals(-1, Recursion.recursiveAdd(nums3, nums3.length));
    }

    @Test
    public void groupSum() throws Exception {
        Assert.assertEquals(true, Recursion.groupSum(0, nums1, 3));
        Assert.assertEquals(true, Recursion.groupSum(0, empty, 0));
        Assert.assertEquals(false, Recursion.groupSum(0, nums1, 7));
        Assert.assertEquals(false, Recursion.groupSum(1, nums1, 4));
    }


}