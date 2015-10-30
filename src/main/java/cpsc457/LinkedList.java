package cpsc457;

import cpsc457.doNOTmodify.Pair;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedList<T> implements Iterable<T> {
 
    public LinkedList() {
    }

    public LinkedList<T> append(T t) {
        return this;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {
    }

    public T get(int index) {
	return null;
    }

    public void sort(Comparator<T> comp) {
	new MergeSort<T>(comp).sort(this);
    }

    public void par_sort(Comparator<T> comp) {
	new MergeSort<T>(comp).parallel_sort(this);
    }

    public static <T extends Comparable<T>> void par_sort(LinkedList<T> list) {
	
    }

    public static <T extends Comparable<T>> void sort(LinkedList<T> list){
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Override
    public Iterator<T> iterator() {
	return null;
    }

    static class MergeSort<T> { // object method pattern;
     final Comparator<T> comp;

     public MergeSort(Comparator<T> comp) {
         this.comp = comp;
     }

     public void sort(LinkedList<T> list) {
     }

     public void parallel_sort(LinkedList<T> list) {
     }
 }

 
}