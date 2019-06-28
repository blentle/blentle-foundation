package top.blentle.foundation.review.datastructure;

import top.blentle.foundation.review.datastructure.heap.MaxHeap;

public class HeapSort {

	public static void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = (n - 1 - 1) / 2; i >= 0; i--)
			shiftDown(arr, n, i);
		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			shiftDown(arr, i, 0);
		}
	}

	// 交换堆中索引为i和j的两个元素
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 原始的shiftDown过程
	private static void shiftDown(Integer[] arr, int n, int k) {
		while (2 * k + 1 < n) {
			int j = 2 * k + 1;
			if (j + 1 < n && arr[j + 1] > arr[j])
				j += 1;
			if (arr[k] > arr[j])
				break;
			swap(arr, k, j);
			k = j;
		}
	}

	// 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
	// 该优化思想和我们之前对插入排序进行优化的思路是一致的
	private static void shiftDown2(Comparable[] arr, int n, int k) {
		Comparable e = arr[k];
		while (2 * k + 1 < n) {
			int j = 2 * k + 1;
			if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
				j += 1;

			if (e.compareTo(arr[j]) >= 0)
				break;

			arr[k] = arr[j];
			k = j;
		}

		arr[k] = e;
	}

	/**
	 * 普通建堆排序
	 *
	 * @param arr
	 */
	private static void heapSort1(Integer[] arr) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(arr.length);
		for (Integer s : arr)
			maxHeap.insert(s);
		//依次弹出最大的元素放入到数组中
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = maxHeap.popMax();
		}
	}

	/**
	 * heapify建堆
	 *
	 * @param arr
	 */
	private static void heapSort2(Integer[] arr) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = maxHeap.popMax();
		}
	}


	// 测试 HeapSort
	public static void main(String[] args) {
		int N = 1000000;
		Integer[] arr1 = SortTestUtil.generateNearlyOrderedArray(N, 10);
		Integer[] arr2 = SortTestUtil.generateNearlyOrderedArray(N, 10);
		Integer[] arr3 = SortTestUtil.generateNearlyOrderedArray(N, 10);
		long start1 = System.currentTimeMillis();
		heapSort1(arr1);
		long end1 = System.currentTimeMillis();

		long start2 = System.currentTimeMillis();
		heapSort2(arr2);
		long end2 = System.currentTimeMillis();
		long start3 = System.currentTimeMillis();
		sort(arr3);
		long end3 = System.currentTimeMillis();
		System.out.println("take1: " + (end1 - start1) + " ms");
		System.out.println("take2: " + (end2 - start2) + " ms");
		System.out.println("take3: " + (end3 - start3) + " ms");
	}
}
