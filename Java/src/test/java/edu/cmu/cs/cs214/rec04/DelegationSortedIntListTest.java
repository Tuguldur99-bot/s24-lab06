package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests for the DelegationSortedIntList class.
 *
 * @author Nora Shoemaker
 *
 */
public class DelegationSortedIntListTest {

    /** 
     * Uncomment the following code to test your implementation 
     * Select all and (CTRL + /) or (COMMAND + /)
     * Feel free to write more tests for your implementation. */

    private DelegationSortedIntList list1;
    private DelegationSortedIntList list2;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
    list1 = new DelegationSortedIntList();
    list2 = new DelegationSortedIntList();
    }

    /**
     * Tests for the add() method.
     */
    @Test
    public void testAdd() {
    // add 5 elements to our list.
    list1.add(1);
    list1.add(3);
    list1.add(2);
    list1.add(4);
    list1.add(2);
    // check that the total number of elements added is 5.
    assertTrue(list1.getTotalAdded() == 5);
    // helper function that prints out the contents of an IntegerList
    printList(list1);
    }

    /**
     * Test for the addAll() method.
     */
    @Test
    public void testAddAll() {
    // add 5 elements to our first list.
    list1.add(1);
    list1.add(3);
    list1.add(2);
    list1.add(4);
    list1.add(2);

    // check that the total number of elements added is 5.
    assertTrue(list1.getTotalAdded() == 5);

    //doesnt actually get removed because elements dont go up to 5
    list1.remove(5);
    //gets removed and added later
    list1.remove(1);
    assertEquals(list1.getTotalAdded(), 5);

    list1.add(2);
    
    
    // add 2 elements to a second list.
    list2.add(3);
    list2.add(0);

    // check that the total number of elements added is 2.
    assertTrue(list2.getTotalAdded() == 2);

    // add the first list (5 elements) to our second list (2 elements).
    list2.addAll(list1);
    

    // check that the total number of elements added to our second list is 7.
    assertTrue(list2.getTotalAdded() == 7);
    }


    /**
     * Tests for the remove() method.
     */
    @Test
    public void testRemove() {
    // add 5 elements to our list.
    list1.add(1);
    list1.add(2);
    list1.add(1);
    list1.add(2);
    list1.add(1);
    
    list1.remove(1);
    list1.remove(2);
    // helper function that prints out the contents of an IntegerList
    assertEquals(3, list1.size());
    printList(list1);
    }

    /**
     * Tests for the removeAll() method.
     */
    @Test
    public void testRemoveAll() {
    list1.add(1);
    list1.add(2);
    list1.add(1);
    list1.removeAll(list1);
    assertEquals(1, list1.size());

    // helper function that prints out the contents of an IntegerList
    printList(list1);
    }




    /**
     * A helper function that prints out the contents of an IntegerList.
     * @param list IntegerList to be printed out.
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}