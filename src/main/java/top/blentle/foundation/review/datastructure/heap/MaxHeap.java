package top.blentle.foundation.review.datastructure.heap;

public class MaxHeap<T extends Comparable<T>> {

	/*
	 * 堆中有多少元素
	 */
	private int count;

	/*
	 * 存放堆数据的数组
	 */
	private Object[] data;

	/**
	 * 堆的容量
	 */
	private int capacity;


	public MaxHeap(int capacity) {
		/*
		 * 因为序号是从1 开始的，我们不用下标是0的这个位置的数
		 */
		this.data = new Object[capacity + 1];
		this.capacity = capacity;
	}

	/**
	 * 构建堆的构造方法
	 *
	 * @param data
	 */
	public MaxHeap(T[] data) {
		if (data == null || data.length < 1)
			throw new IllegalArgumentException("init data can't be null");
		int n = data.length;
		this.count = n;
		this.capacity = n;
		this.data = new Object[count + 1];
		for (int i = 0; i < n; i++)
			this.data[i + 1] = data[i];
		for(int i = n >>> 1 ; i >= 1 ; i--)
			shiftDown(i);
	}

	/**
	 * 返回堆中有多少数据
	 *
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 堆是否还有元素
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * 插入元素t到堆中
	 *
	 * @param t
	 */
	public void insert(T t) {
		if (count + 1 > capacity)
			throw new IndexOutOfBoundsException("can't insert a new element...");
		//把这个元素插入到数组的尾部,这时堆的性质可能被破坏
		data[count + 1] = t;
		//插入一个元素，元素的个数增加1
		count++;
		//移动数据,进行shiftUp操作,修正堆
		shiftUp(count);
	}

	/**
	 * 弹出最大的元素并返回
	 *
	 * @return
	 */
	public T popMax() {
		if (count <= 0)
			throw new IndexOutOfBoundsException("empty heap");
		T max = (T) data[1];
		//把最后一个元素补给根节点
		swap(1, count);
		//补完后元素个数减一
		count--;
		//下沉操作
		shiftDown(1);
		return max;
	}

	/**
	 * 下沉
	 *
	 * @param index
	 */
	private void shiftDown(int index) {
		//只要这个index对应的节点有左子节点(完全二叉树中不存在 一个节点只有 右子节点没有左子节点)
		while (count >= (index << 1)) {
			//比较左右节点谁大，当前节点跟谁换位置
			//左子节点的inedx
			int left = index << 1;
			//data[index]预交换的index的序号
			int t = left;
			//如果右子节点存在,且右子节点比左子节点大,则当前节点可能与右子节点交换
			if (((t + 1) <= count) && (((T) data[t]).compareTo((T) data[t + 1]) < 0))
				t += 1;
			//如果index序号节点比t序号的节点小，才交换,否则什么也不作, 退出循环
			if (((T) data[index]).compareTo((T) data[t]) >= 0)
				break;
			swap(index, t);
			index = t;
		}
	}

	private void shiftUp(int index) {
		while (index > 1 && ((((T) data[index]).
				compareTo((T) data[index >> 1]) > 0))) {
			swap(index, index >>> 1);
			index >>>= 1;
		}
	}

	/**
	 * 这里使用引用交换，防止基本类型值传递
	 *
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
		T tmp = (T) data[index1];
		data[index1] = data[index2];
		data[index2] = tmp;
	}

	public static void main(String[] args) {
		MaxHeap<Integer> mh = new MaxHeap<Integer>(11);
		mh.insert(66);
		mh.insert(44);
		mh.insert(30);
		mh.insert(27);
		mh.insert(17);
		mh.insert(25);
		mh.insert(13);
		mh.insert(19);
		mh.insert(11);
		mh.insert(8);
		mh.insert(45);
		Integer[] data = new Integer[11];
		for (int i = 0; i < 11; i++) {
			data[i] = mh.popMax();
		}
		for (Integer t : data) {
			System.err.println(t);
		}
	}
}
