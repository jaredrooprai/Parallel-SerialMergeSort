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

    public synchronized LinkedList<T> append(T t) {
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

    public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        if (size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public synchronized void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public synchronized T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public void sort(Comparator<T> comp) {
	       new MergeSort<T>(comp).sort(this);
    }

    public void par_sort(Comparator<T> comp) {
	      try {
			new MergeSort<T>(comp).parallel_sort(this);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	       return new Iterator<T>(){
            private Node<T> current = head;

            @Override
            public boolean hasNext(){
            	if (head == null){
            		return false;
            	}
                if (current.next == null){
                  return false;
                }
                else {
                  return true;
                }
            }

            @Override
            public T next(){
                T data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }

          };
    }






    static class MergeSort <T> { // object method pattern;

	     final Comparator<T> comp;

	     private int poolSize = 4;
   		 ExecutorService pool = Executors.newFixedThreadPool(poolSize);




	     public MergeSort(Comparator<T> comp) {
	         this.comp = comp;
	     }

	     public void sort(LinkedList<T> list) {
	    	  if (list.head != null){
	    		  list.head = msort(list).head;
	    	  }
	     }


	     public LinkedList<T> msort(LinkedList<T> list){
	          if (list.head.next == null){
	            return list;
	          }

	          Pair<LinkedList<T>, LinkedList<T>> splitted = split(list);

	          return merge( msort(splitted.fst()), msort(splitted.snd()) );
	     }


	     public Pair<LinkedList<T>,LinkedList<T>> split(LinkedList<T> list){
	          Node<T> current = list.head;
	          Node<T> middle = list.head;

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

	          Pair<LinkedList<T>, LinkedList<T>> splitted = new Pair<>(firstHalf, secondHalf);
	          return splitted;
	     }



	     public synchronized LinkedList<T> merge(LinkedList<T> firstHalf, LinkedList<T> secondHalf) {

	          LinkedList<T> merged = new LinkedList<T>();

	          while (firstHalf.head != null && secondHalf.head != null){
	              if (comp.compare(firstHalf.head.data, secondHalf.head.data) < 0){
	                  merged.append(firstHalf.head.data);
	                  firstHalf.head = firstHalf.head.next;
	              }
	              else {
	                merged.append(secondHalf.head.data);
	                secondHalf.head = secondHalf.head.next;
	              }
	          }

	          if (firstHalf.head == null){
	              while (secondHalf.head != null){
	                  merged.append(secondHalf.head.data);
	                  secondHalf.head = secondHalf.head.next;
	              }
	          }
	          else if (secondHalf.head == null) {
	            while (firstHalf.head != null){
	                merged.append(firstHalf.head.data);
	                firstHalf.head = firstHalf.head.next;
	            }
	          }

	          return merged;
	      }



	     public void parallel_sort(LinkedList<T> list) throws InterruptedException, ExecutionException {

		   	 if (list.head != null){

		   		 list.head = parallel_msort(list).head;

		   		 pool.shutdown();
				 try {
						pool.awaitTermination(20, TimeUnit.SECONDS);
				 } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 }

			 }


	     }


	     public LinkedList<T> parallel_msort (LinkedList<T> list) throws InterruptedException, ExecutionException{
	    	 if (list.head.next == null){
	    		 return list;
	    	 }

	    	 if (poolSize <= 0){

		          Pair<LinkedList<T>, LinkedList<T>> splitted = split(list);

		          return merge( parallel_msort(splitted.fst()), parallel_msort(splitted.snd()) );

	    	 }
	    	 else{
	    		 	 poolSize--;

					 Future<LinkedList<T>> future = pool.submit(new Callable<LinkedList<T>>(){

						  @Override
						  public LinkedList<T> call() throws Exception {

					          Pair<LinkedList<T>, LinkedList<T>> splitted = split(list);

					          return merge( parallel_msort(splitted.fst()), parallel_msort(splitted.snd()) );
						  }


					   });
					 poolSize++;

					 return future.get();
	    	 }

	     }
    }


}
