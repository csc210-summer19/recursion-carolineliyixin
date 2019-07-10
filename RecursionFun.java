/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Yixin Li
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}

		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if ((n + "").length() <= 3) {
			return n + "";
		} else {
			String i = (n + "").substring(0, (n + "").length() - 3);
			System.out.print(i);
			String last = "," + ((n + "").substring((n + "").length() - 3));
			System.out.print(last);
			return intWithCommas(Integer.parseInt(i)) + last;
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (index >= len / 2) {
			return;
		} else {
			int temp = x[index];
			int lastindex = len - index - 1;
			x[index] = x[lastindex];
			x[lastindex] = temp;
			index++;
			reverseArray(x, index, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int result = arrayRange(a, 0, a[0], a[0]);
		return result;
	}

	private int arrayRange(int[] a, int num, int large, int small) {
		if (num == a.length) {
			return large - small;
		}
		if (a[num] > large) {
			large = a[num];
		}
		if (a[num] < small) {
			small = a[num];
		}
		num++;
		return arrayRange(a, num, large, small);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 0) {
			return true;
		}
		boolean result = isSorted(nums, 1);
		return result;
		// Need to send down 0 to keep track of the index

	}

	private boolean isSorted(int[] nums, int i) {
		if (i == nums.length) {
			return true;
		}
		if (nums[i - 1] > nums[i]) {
			return false;
		} else {
			i++;
			return isSorted(nums, i);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		boolean result = found(search, strs, 0);
		return result;
	}

	private boolean found(String search, String[] strs, int index) {
		if (index == strs.length) {
			return false;
		}
		if (strs[index].equals(search)) {
			return true;
		}
		index++;
		return found(search, strs, index);
	}
}
