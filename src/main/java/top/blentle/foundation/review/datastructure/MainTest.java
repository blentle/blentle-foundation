package top.blentle.foundation.review.datastructure;

import top.blentle.foundation.review.datastructure.heap.MaxHeap;

import java.util.Random;

public class MainTest {
	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr1 = SortTestUtil.generateNearlyOrderedArray(n, 20);
		Integer[] arr2 = SortTestUtil.generateNearlyOrderedArray(n, 20);
		Integer[] arr3 = SortTestUtil.generateNearlyOrderedArray(n, 20);
		heapSort3(arr1);
		heapSort3(arr2);
		heapSort3(arr3);

		long start1 = System.currentTimeMillis();
		heapSort1(arr1);
		long end1 = System.currentTimeMillis();

		long start2 = System.currentTimeMillis();
		heapSort2(arr2);
		long end2 = System.currentTimeMillis();

		long start3 = System.currentTimeMillis();
		heapSort3(arr3);
		long end3 = System.currentTimeMillis();
		System.out.println("take1: " + (end1 - start1) + " ms");
		System.out.println("take2: " + (end2 - start2) + " ms");
		System.out.println("take3: " + (end3 - start3) + " ms");
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


	private static void heapSort3(Integer[] arr) {
		int count = arr.length;
		//因为这里数组第一个元素是从0开始,所以第一个非叶子节点的index 是 (count - 1)/2
		for (int i = (count - 2) / 2; i >= 0; i--)
			shiftDown(arr, count, i);
		//构建完后,开始原地排序
		for (int j = (count - 1); j > 0; j--) {
			swap(arr, 0, j);
			shiftDown(arr, j, 0);
		}
	}

	/**
	 * 数组元素大小
	 *
	 * @param arr
	 * @param count
	 * @param index
	 */
	private static void shiftDown(Integer[] arr, int count, int index) {
		while (count > ((index * 2) + 1)) {
			int t = (index * 2) + 1;
			if (t + 1 < count && (arr[t] < arr[t + 1]))
				t += 1;
			//如果index序号节点比t序号的节点小，才交换,否则什么也不作, 退出循环
			if (arr[index] > arr[t])
				break;
			swap(arr, index, t);
			index = t;
		}
	}

	private static void shiftDown2(Integer[] arr, int count, int index) {
		int tmp = arr[index];
		while (count > ((index << 1) + 1)) {
			int left = (index << 1) + 1;
			int t = left;
			if (((t + 1) < count) && (arr[t] < arr[t + 1]))
				t += 1;
			//如果index序号节点比t序号的节点小，才交换,否则什么也不作, 退出循环
			if (arr[index] > arr[t])
				break;
			arr[index] = t;
			index = t;
		}
		arr[index] = tmp;
	}

	private static void swap(Integer[] arr, int index, int t) {
		Integer tmp = arr[index];
		arr[index] = arr[t];
		arr[t] = tmp;
	}
}
