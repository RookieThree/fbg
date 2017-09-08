package com.jiang.array;
/**
 * ц╟ещеепР
 * @author Administrator
 *
 */
public class Sort {
	public static void main(String[] args) {
		int[] arr = { 7, 3, 23, 54, 23, 12 };
		bubbleSort(arr);
		printArr(arr);
	}

	public static void bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int n = 0; n < arr.length - 1 - j; n++) {
				if (arr[n] > arr[n + 1]) {
					int temp = arr[n];
					arr[n] = arr[n + 1];
					arr[n + 1] = temp;
				}
			}
		}
	}

	public static void printArr(int[] arr) {
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (i==0) {
					System.out.print("[");
				}
				if (i>=0&&i<arr.length-1) {
					System.out.print(arr[i]+",");
				}
				if (i==arr.length-1) {
					System.out.print(arr[i]+"]");
				}
			}
		}
	}
}
