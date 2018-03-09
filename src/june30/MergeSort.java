package june30;

public class MergeSort {

	public static void main(String[] args) {
		int[] one = { 5, 10, 15, 20, 25, 30 };
		int[] two = { 1, 2, 3, 16, 19, 28, 34, 40 };
		int[] arr = { 11, 55, 44, 22, 0, 33 };
		int[] three = { 11, 55, 44, 22, 0, 33 };

//		 int[] x =merge(one,two);
//		quicksort(arr,0,arr.length-1);
//		for (int val : arr) {
//			System.out.print(val + " ");
//		}
		
		int[] y = mergesorted(three,0,three.length-1);
		for(int val:y){
			System.out.print(val+" ");
		}

	}

	public static int[] merge(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];
		int i = 0, k = 0, j = 0;
		while (k < result.length) {
			if (i < one.length && j < two.length) {
				if (one[i] < two[j]) {
					result[k] = one[i];
					i++;
				} else {
					result[k] = two[j];
					j++;
				}
			} else if (j >= two.length) {
				result[k] = one[i];
				i++;
			} else if (i >= one.length) {
				result[k] = two[j];
				j++;
			}
			k++;
		}
		return result;
	}

	public static int[] mergesorted(int[] three, int lo, int hi) {
		if (lo == hi) {
			int[] rr = new int[1];
			rr[0] = three[lo];
			return rr;
		}

		int mid = (lo + hi) / 2;
		int[] val1 = mergesorted(three, lo, mid);
		int[] val2 = mergesorted(three, mid + 1, hi);

		int[] y = merge(val1, val2);
		return y;
	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int pivot = arr[(lo + hi) / 2];
		int left = lo;
		int right = hi;

		while (left <= right) {
			if (arr[left] < pivot) {
				left++;
			}
			if (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}
}
