package cpsc457;

import cpsc457.doNOTmodify.Pair;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList<T> append(T t) {
        Node<T> node = new Node<>(t);
        if (size == 0){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
        return this;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }

        Node<T> current = head;
        for (int i = 0; i < size-1; i++) {
            current = current.next;
        }
        return current.data;
    }


    public void sort(Comparator<T> comp) {
	       new MergeSort<T>(comp).sort(this);
    }

    public void par_sort(Comparator<T> comp) {
	      new MergeSort<T>(comp).parallel_sort(this);
    }

    public static <T extends Comparable<T>> void par_sort(LinkedList<T> list) {
        list.par_sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
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


     public void msort(LinkedList<T> list){

          Node<T> current = list.head;
          Node<T> middle = current;

          LinkedList<T> firstHalf = new LinkedList<T>();
          LinkedList<T> secondHalf = new LinkedList<T>();

          firstHalf.append(list.head.data);

          while (current.next != null ){
              current = current.next;
              if (current.next != null) {
                  middle = middle.next;
                  firstHalf.append(middle.data);
                  current = current.next;
              }
          }

          while (middle.next != null){
              middle = middle.next;
              secondHalf.append(middle.data);
          }

          msort(firstHalf);
          msort(secondHalf);
     }



      public void merge(LinkedList<T> firstHalf, LinkedList<T> secondHalf){

          //Merging function
          //1- Keep comparing the head of the two link lists
          //2- Move the smallest node to the new merged link list
          //3- Move the head on the list that lost this node

          //4- Once one of the two lists is done, append the rest of the
          //	 second list to the tail of the new merged link list
      }

     public void parallel_sort(LinkedList<T> list) {
     }
 }


}
