package set.techlead;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayDuplicates {
	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3,

			20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19,

			13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		removeDuplicatesWithNoextraSpace(randomIntegers);
	}


	// No additional space used but comparing adjacent elements. Going through
	// the array twice
	// Time complexity: O(N2)
	public static int[] removeDuplicatesWithNoextraSpace(int[] arr) {

		int end = arr.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						arr[shiftLeft] = arr[k];
					}
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = arr[i];
			System.out.println(whitelist[i]);
		}

		return whitelist;
	}

	// Improved solution as you iterate only once on the array
	// Time complexity: O(N)
	public static void removeDuplicatesIteratingOnce(int[] arr) {
		int end = arr.length;
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < end; i++) {
			set.add(arr[i]);
		}
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// Improved solution as you iterate only once on the array
	public static void removeDuplicatesIteratingOnceJava8(int[] arr) {
		int[] result = Arrays.stream(arr).distinct().toArray();
		Arrays.stream(result).forEach(System.out::println);

	}
}