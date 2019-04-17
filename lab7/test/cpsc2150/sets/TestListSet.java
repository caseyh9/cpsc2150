package cpsc2150.sets;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestListSet {
    ISet<Integer> MakeASet()
    {
        ISet<Integer> set = new ListSet<>();
        return set;
    }

    @Test
    public void test_add_toEmptySet(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Add 9 to the set
        set.add(9);
        // Check that set now has 1 element and contains 9
        assertTrue(set.contains(9) && set.getSize() == 1);
    }

    @Test
    public void test_add_SameValueTwice(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Add 5 to the set
        set.add(5);
        // Remove 5 from the set
        set.removePos(0);
        // Add 5 to the set again
        set.add(5);
        // Check that the set has only 1 element and contains 5
        assertTrue(set.contains(5) && set.getSize() == 1);
    }

    @Test
    public void test_add_5differentValues(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Add these to the set {12,-938,0,83,-182}
        set.add(12);
        set.add(-938);
        set.add(0);
        set.add(83);
        set.add(-182);
        // Check that set contains all of these and has size 5
        assertTrue(set.getSize() == 5);
        assertTrue(set.contains(12));
        assertTrue(set.contains(-938));
        assertTrue(set.contains(0));
        assertTrue(set.contains(83));
        assertTrue(set.contains(-182));
    }

    @Test
    public void test_contains_emptySet(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Check that it does not contain several values
        assertTrue(!set.contains(4));
        assertTrue(!set.contains(-82));
        assertTrue(!set.contains(0));
        assertTrue(!set.contains(71283));
        assertTrue(!set.contains(-237));
    }

    @Test
    public void test_contains_addMultiple(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Add 0 and check that it's in the set
        set.add(0);
        assertTrue(set.contains(0));
        // Remove 0 and check that it's not in the set
        set.removePos(0);
        assertTrue(!set.contains(0));
        // Add 0 again and check that it's in the set
        set.add(0);
        assertTrue(set.contains(0));
    }

    @Test
    public void test_contains_extremeValues(){
        // Create empty set
        ISet<Integer> set = MakeASet();
        // Add several values to the set
        set.add(0);
        set.add(8382);
        set.add(-823);
        set.add(6256);
        set.add(-939);
        // Check that each added value is in the set
        assertTrue(set.contains(0));
        assertTrue(set.contains(8382));
        assertTrue(set.contains(-823));
        assertTrue(set.contains(6256));
        assertTrue(set.contains(-939));
    }

    @Test
    public void test_equals_emptySets(){
        // Create 2 empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        // Check that the two sets are equal
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_equals_equalSets(){
        // Create 2 empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        // Fill the sets with the same values
        set1.add(5);
        set1.add(92);
        set1.add(-281);
        set2.add(5);
        set2.add(92);
        set2.add(-281);
        // Check that the two sets are equal
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_equals_unequalSets(){
        // Create 2 empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        // Fill the sets with different values
        set1.add(5);
        set1.add(0);
        set2.add(5);
        // Check that the two sets are not equal
        assertTrue(!set1.equals(set2));
    }

    @Test
    public void test_union_emptySets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> union = MakeASet();
        // Union set1 and set2
        set1.union(set2);
        // Check that set1 equals union
        assertTrue(union.equals(set1));
    }

    @Test
    public void test_union_equalSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> union = MakeASet();
        // Add values to set1 and set2
        set1.add(4);
        set1.add(78);
        set1.add(-34);
        set2.add(78);
        set2.add(8);
        set2.add(94);
        // Add the same values to union
        union.add(4);
        union.add(78);
        union.add(-34);
        union.add(8);
        union.add(94);
        // Union set1 and set2
        set1.union(set2);
        // Check that set1 equals union
        assertTrue(union.equals(set1));
    }

    @Test
    public void test_union_unequalsSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> union = MakeASet();
        // Add values to set1 and set2
        set1.add(4);
        set1.add(534);
        set1.add(-265);
        set2.add(534);
        set2.add(15);
        set2.add(6);
        // Add different values to union
        union.add(53);
        union.add(725);
        union.add(-34);
        union.add(8);
        union.add(94);
        // Union set1 and set2
        set1.union(set2);
        // Check that set1 equals union
        assertTrue(!union.equals(set1));
    }

    @Test
    public void test_intersect_nullSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> intersect = MakeASet();
        // Intersect set1 and set2
        set1.intersect(set2);
        // Check that set1 equals union
        assertTrue(intersect.equals(set1));
    }

    @Test
    public void test_intersect_equalSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> intersect = MakeASet();
        // Add values to set1 and set2
        set1.add(8);
        set1.add(43);
        set1.add(-33);
        set2.add(43);
        set2.add(-33);
        set2.add(9238);
        set2.add(23820);
        // Add the shared values to intersect
        intersect.add(43);
        intersect.add(-33);
        // Intersect set1 and set2
        set1.intersect(set2);
        // Check that set1 equals intersect
        assertTrue(intersect.equals(set1));
    }

    @Test
    public void test_intersect_unequalSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> intersect = MakeASet();
        // Add values to set1 and set2
        set1.add(8);
        set1.add(43);
        set1.add(-33);
        set2.add(43);
        set2.add(-33);
        set2.add(9238);
        set2.add(23820);
        // Add the shared values to intersect
        intersect.add(43);
        intersect.add(-33);
        intersect.add(238940728);
        // Intersect set1 and set2
        set1.intersect(set2);
        // Check that set1 equals intersect
        assertTrue(!intersect.equals(set1));
    }

    @Test
    public void test_difference_emptySets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> difference = MakeASet();
        // Subtract set2 from set1
        set1.difference(set2);
        // Check that set1 and difference are equal
        assertTrue(difference.equals(set1));
    }

    @Test
    public void test_difference_equalSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> difference = MakeASet();
        // Add elements to set1 and set2
        set1.add(4);
        set1.add(2);
        set1.add(9);
        set1.add(92);
        set2.add(82);
        set2.add(9);
        set2.add(92);
        // Put the difference in difference
        difference.add(4);
        difference.add(2);
        // Subtract set2 from set1
        set1.difference(set2);
        // Check that set1 and difference are equal
        assertTrue(difference.equals(set1));
    }

    @Test
    public void test_difference_unequalSets(){
        // Create empty sets
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> difference = MakeASet();
        // Add elements to set1 and set2
        set1.add(4);
        set1.add(2);
        set1.add(9);
        set1.add(92);
        set2.add(82);
        set2.add(9);
        set2.add(92);
        // Put the difference in difference
        difference.add(4);
        difference.add(2);
        difference.add(78);
        // Subtract set2 from set1
        set1.difference(set2);
        // Check that set1 and difference are equal
        assertTrue(!difference.equals(set1));
    }
}
