package cpsc457;


import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TimingTests {



    @Test
    public void test_sort_1e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<1e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }


    @Test
    public void test_sort_2e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<2e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }


    @Test
    public void test_sort_4e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<4e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }


    @Test
    public void test_sort_8e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<8e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }


    @Test
    public void test_sort_16e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<16e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }


    @Test
    public void test_par_sort_1e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<1e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.par_sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }

    @Test
    public void test_par_sort_2e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<2e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.par_sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }

    @Test
    public void test_par_sort_4e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<4e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.par_sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }

    @Test
    public void test_par_sort_8e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<8e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.par_sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }

    @Test
    public void test_par_sort_16e5() throws Exception {
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<16e5; i++) {
            list.append(r.nextInt());
        }

        long start = System.currentTimeMillis();
        LinkedList.par_sort(list);
        long end = System.currentTimeMillis();

        System.err.println();
        System.err.println("Processors: "+Runtime.getRuntime().availableProcessors());
        System.err.println(end - start + " ms");
        System.err.println();

        int i = 0;
        Integer prev = Integer.MIN_VALUE;

        for(Integer num : list) {
            assertTrue(num + " found before " + prev + " at index " + i, num >= prev);
            prev = num;
            i++;
        }
    }





}
