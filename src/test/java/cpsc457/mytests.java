package cpsc457;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class mytests {


    /*****************************************
     * Custom Tests by jared
     *****************************************/
    @Test
    public void testGet() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(25);
        list.append(32);
        list.append(53);
        assertTrue(list.get(2) == 53);
        assertTrue(list.get(0) == 25);
        assertTrue(list.get(1) == 32);
        assertTrue(list.get(-1) == null);
        assertTrue(list.get(3) == null);
    }

    @Test
    public void testClear() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(25);
        list.clear();
        assertTrue(list.isEmpty());
        assertTrue(list.get(0) == null);
    }

    @Test
    public void testSize() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(25);
        assertTrue(list.size() == 1);
        list.append(26);
        assertTrue(list.size() == 2);
        list.append(2);
        list.append(222);
        assertTrue(list.size() == 4);
    }

    @Test
    public void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(list.isEmpty());
        list.append(25);
        assertTrue(!list.isEmpty());
    }

    @Test
    public void testSort_ordered_pair_int() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(22);
        list.append(14);

        LinkedList.sort(list);
        assertTrue(list.get(0) == 14);
        assertTrue(list.get(1) == 22);

    }

    @Test
    public void testSort_reverse_pair_int() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(14);
        list.append(22);

        LinkedList.sort(list);
        assertTrue(list.get(0) == 14);
        assertTrue(list.get(1) == 22);

    }

    @Test
    public void testSort_odd_ordered_int() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(1);
        list.append(14);
        list.append(22);


        LinkedList.sort(list);
        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 14);
        assertTrue(list.get(2) == 22);

    }

    @Test
    public void testSort_odd_reversed_int() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(14);
        list.append(13);
        list.append(12);

        LinkedList.sort(list);
        assertTrue(list.get(0) == 12);
        assertTrue(list.get(1) == 13);
        assertTrue(list.get(2) == 14);
      }

      @Test
      public void testSort_same_int() {
          LinkedList<Integer> list = new LinkedList<Integer>();

          list.append(14);
          list.append(14);
          list.append(15);
          list.append(15);


          LinkedList.sort(list);
          assertTrue(list.get(0) == 14);
          assertTrue(list.get(1) == 14);
          assertTrue(list.get(2) == 15);
        }

        @Test
        public void testSort_one_item() {
            LinkedList<Integer> list = new LinkedList<Integer>();

            list.append(14);

            LinkedList.sort(list);
            assertTrue(list.get(0) == 14);

          }

}
