package search_sort;

public class MinMaxHeap {
	public static int left(int i) {
		return 2 * i +1;
	}
	public static int right(int i) {
		return 2 * i +2;
	}
	public static int[] swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + "-");
		}
	}
	public static void heapify(int[] arr) {
		int len = arr.length;
		int nonLeafNodesCount = len / 2;
		int leftIndex, rightIndex = 0;
		for (int i = nonLeafNodesCount ; i >= 0; i--) {
			leftIndex = left(i);
			rightIndex = right(i);
			if( leftIndex < len && arr[i] > arr[leftIndex]) {
				arr = swap(arr, i, leftIndex);
			}
			if( rightIndex < len && arr[i] > arr[rightIndex]) {
				arr = swap(arr, i, rightIndex);
			}
		}
		display(arr);
	}

	public static void main(String[] args) {
		int[] arr = { 7, 3, 4, 100, 2 };
		heapify(arr);

	}

}
