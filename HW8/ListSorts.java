/* ListSorts.java */

import list.*;

public class ListSorts {

	private final static int SORTSIZE = 1000000;

	/**
	 * makeQueueOfQueues() makes a queue of queues, each containing one item of
	 * q. Upon completion of this method, q is empty.
	 *
	 * @param q
	 *            is a LinkedQueue of objects.
	 * @return a LinkedQueue containing LinkedQueue objects, each of which
	 *         contains one object from q.
	 **/
	public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
		// Replace the following line with your solution.
		LinkedQueue queueOfQueue = new LinkedQueue();
		while (!q.isEmpty()) {

			LinkedQueue elemQueueOfQueue = new LinkedQueue();
			Object o = new Object();
			try {
				o = q.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			elemQueueOfQueue.enqueue(o);
			queueOfQueue.enqueue(elemQueueOfQueue);
		}

		return queueOfQueue;
	}

	/**
	 * mergeSortedQueues() merges two sorted queues into a third. On completion
	 * of this method, q1 and q2 are empty, and their items have been merged
	 * into the returned queue.
	 *
	 * @param q1
	 *            is LinkedQueue of Comparable objects, sorted from smallest to
	 *            largest.
	 * @param q2
	 *            is LinkedQueue of Comparable objects, sorted from smallest to
	 *            largest.
	 * @return a LinkedQueue containing all the Comparable objects from q1 and
	 *         q2 (and nothing else), sorted from smallest to largest.
	 **/
	public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
		// Replace the following line with your solution.
		LinkedQueue merged = new LinkedQueue();
		try {
			while (!q1.isEmpty() && !q2.isEmpty()) {
				Comparable item1 = (Comparable) (q1.front());
				Comparable item2 = (Comparable) (q2.front());
				if (item1.compareTo(item2) <= 0) {
					merged.enqueue(q1.dequeue());
				} else {
					merged.enqueue(q2.dequeue());
				}
			}
			// if (q1.isEmpty()&&!q2.isEmpty()){
			// merged.append(q2);
			// }
			// if (!q1.isEmpty()&&q2.isEmpty()){
			// merged.append(q1);
			// }

			if (q1.isEmpty() || q2.isEmpty()) {
				merged.append(q1);
				merged.append(q2);
			}
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return merged;
	}

	/**
	 * partition() partitions qIn using the pivot item. On completion of this
	 * method, qIn is empty, and its items have been moved to qSmall, qEquals,
	 * and qLarge, according to their relationship to the pivot.
	 *
	 * @param qIn
	 *            is a LinkedQueue of Comparable objects.
	 * @param pivot
	 *            is a Comparable item used for partitioning.
	 * @param qSmall
	 *            is a LinkedQueue, in which all items less than pivot will be
	 *            enqueued.
	 * @param qEquals
	 *            is a LinkedQueue, in which all items equal to the pivot will
	 *            be enqueued.
	 * @param qLarge
	 *            is a LinkedQueue, in which all items greater than pivot will
	 *            be enqueued.
	 **/
	public static void partition(LinkedQueue qIn, Comparable pivot,
			LinkedQueue qSmall, LinkedQueue qEquals, LinkedQueue qLarge) {
		// Your solution here.
		try {
			int intpivot = (Integer) pivot;
			Comparable pivotOb = (Comparable) qIn.nth(intpivot + 1);

			while (qIn.size() >= 1) {

				Comparable ob = (Comparable) qIn.dequeue();

				if (pivotOb.compareTo(ob) > 0) {
					qSmall.enqueue(ob);
				}
				if (pivotOb.compareTo(ob) == 0) {
					qEquals.enqueue(ob);
				}
				if (pivotOb.compareTo(ob) < 0) {
					qLarge.enqueue(ob);
				}
			}
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * mergeSort() sorts q from smallest to largest using mergesort.
	 *
	 * @param q
	 *            is a LinkedQueue of Comparable objects.
	 **/
	public static void mergeSort(LinkedQueue q) {
		// Your solution here.
		try {
			LinkedQueue newQueue = new LinkedQueue();
			newQueue = ListSorts.makeQueueOfQueues(q);
			while (newQueue.size() >= 2) {
				LinkedQueue q1 = (LinkedQueue) (newQueue.dequeue());
				LinkedQueue q2 = (LinkedQueue) (newQueue.dequeue());
				q.enqueue(ListSorts.mergeSortedQueues(q1, q2));
			}
			if (newQueue.size() == 1) {
				q.append(newQueue);
			}
			while (q.size() >= 2) {
				LinkedQueue q1 = (LinkedQueue) (q.dequeue());
				LinkedQueue q2 = (LinkedQueue) (q.dequeue());
				q.enqueue(ListSorts.mergeSortedQueues(q1, q2));
			}

		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * quickSort() sorts q from smallest to largest using quicksort.
	 *
	 * @param q
	 *            is a LinkedQueue of Comparable objects.
	 **/
	public static void quickSort(LinkedQueue q) {
		// Your solution here.
		q = RecurQuickSort(q);

	}

	public static LinkedQueue RecurQuickSort(LinkedQueue q) {

		if (q.size() > 1) {
			LinkedQueue qSmall = new LinkedQueue();
			LinkedQueue qEquals = new LinkedQueue();
			LinkedQueue qLarge = new LinkedQueue();
			Comparable pivot = (int) (q.size() * Math.random());
			partition(q, pivot, qSmall, qEquals, qLarge);
			if ((qSmall.size() <= 1) && (qLarge.size() <= 1)) {
				q.append(qSmall);
				q.append(qEquals);
				q.append(qLarge);
			} else {
				q.append(RecurQuickSort(qSmall));
				q.append(qEquals);
				q.append(RecurQuickSort(qLarge));
			}

		}
		return q;
	}

	/**
	 * makeRandom() builds a LinkedQueue of the indicated size containing
	 * Integer items. The items are randomly chosen between 0 and size - 1.
	 *
	 * @param size
	 *            is the size of the resulting LinkedQueue.
	 **/
	public static LinkedQueue makeRandom(int size) {
		LinkedQueue q = new LinkedQueue();
		for (int i = 0; i < size; i++) {
			q.enqueue(new Integer((int) (size * Math.random())));
		}
		return q;
	}

	/**
	 * main() performs some tests on mergesort and quicksort. Feel free to add
	 * more tests of your own to make sure your algorithms works on boundary
	 * cases. Your test code will not be graded.
	 **/
	public static void main(String[] args) {

		LinkedQueue q = makeRandom(10);
		System.out.println(q.toString());
		mergeSort(q);
		System.out.println(q.toString());

		LinkedQueue q1 = makeRandom(10);
		System.out.println(q1.toString());
		quickSort(q1);
		System.out.println(q1.toString());

		LinkedQueue q2 = new LinkedQueue ();
		Entry e1 = new Entry (3, "hex");
		Entry e2 = new Entry (7, "boo");
		Entry e3 = new Entry (3, "spa");
		Entry e4 = new Entry (3, "bra");
		Entry e5 = new Entry (7, "ape");

		q2.enqueue(e1);
		q2.enqueue(e2);
		q2.enqueue(e3);
		q2.enqueue(e4);
		q2.enqueue(e5);
		System.out.println(q2.toString());
		mergeSort(q2);
		System.out.println(q2.toString());


		LinkedQueue q3 = new LinkedQueue ();
		Entry e31 = new Entry (3, "hex");
		Entry e32 = new Entry (7, "boo");
		Entry e33 = new Entry (3, "spa");
		Entry e34 = new Entry (3, "bra");
		Entry e35 = new Entry (7, "ape");

		q3.enqueue(e31);
		q3.enqueue(e32);
		q3.enqueue(e33);
		q3.enqueue(e34);
		q3.enqueue(e35);
		System.out.println(q3.toString());
		quickSort(q3);
		System.out.println(q3.toString());


/*		Timer stopWatch = new Timer();
		q = makeRandom(SORTSIZE);
		stopWatch.start();
		mergeSort(q);
		stopWatch.stop();
		System.out.println("Mergesort time, " + SORTSIZE + " Integers:  "
				+ stopWatch.elapsed() + " msec.");

		stopWatch.reset();
		q = makeRandom(SORTSIZE);
		stopWatch.start();
		quickSort(q);
		stopWatch.stop();
		System.out.println("Quicksort time, " + SORTSIZE + " Integers:  "
				+ stopWatch.elapsed() + " msec.");*/

	}

}
