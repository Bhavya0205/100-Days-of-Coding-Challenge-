/* 

Number of Pairs Satisfying Inequality


You are given two 0-indexed integer arrays nums1 and nums2, each of size n, and an integer diff. Find the number of pairs (i, j) such that:

0 <= i < j <= n - 1 and
nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
Return the number of pairs that satisfy the conditions.

 

Example 1:

Input: nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
Output: 3
Explanation:
There are 3 pairs that satisfy the conditions:
1. i = 0, j = 1: 3 - 2 <= 2 - 2 + 1. Since i < j and 1 <= 1, this pair satisfies the conditions.
2. i = 0, j = 2: 3 - 5 <= 2 - 1 + 1. Since i < j and -2 <= 2, this pair satisfies the conditions.
3. i = 1, j = 2: 2 - 5 <= 2 - 1 + 1. Since i < j and -3 <= 2, this pair satisfies the conditions.
Therefore, we return 3.
Example 2:

Input: nums1 = [3,-1], nums2 = [-2,2], diff = -1
Output: 0
Explanation:
Since there does not exist any pair that satisfies the conditions, we return 0.
 

Constraints:

n == nums1.length == nums2.length
2 <= n <= 105
-104 <= nums1[i], nums2[i] <= 104
-104 <= diff <= 104
 */

// Java implementation of the approach
import java.util.HashSet;

public class Code9 {

	// Function to return the count
	// of unique pairs in the array
	static int getPairs(int a[], int n)
	{
		HashSet<Integer> visited1 = new HashSet<Integer>();

		// un[i] stores number of unique elements
		// from un[i + 1] to un[n - 1]
		int un[] = new int[n];

		// Last element will have no unique elements
		// after it
		un[n - 1] = 0;

		// To count unique elements after every a[i]
		int count = 0;
		for (int i = n - 1; i > 0; i--) {

			// If current element has already been used
			// i.e. not unique
			if (visited1.contains(a[i]))
				un[i - 1] = count;
			else
				un[i - 1] = ++count;

			// Set to true if a[i] is visited
			visited1.add(a[i]);
		}

		HashSet<Integer> visited2 = new HashSet<Integer>();

		// To know which a[i] is already visited
		int answer = 0;
		for (int i = 0; i < n - 1; i++) {

			// If visited, then the pair would
			// not be unique
			if (visited2.contains(a[i]))
				continue;

			// Calculating total unique pairs
			answer += un[i];

			// Set to true if a[i] is visited
			visited2.add(a[i]);
		}
		return answer;
	}

	// Driver code
	public static void main(String[] args)
	{
		int a[] = { 1, 2, 2, 4, 2, 5, 3, 5 };
		int n = a.length;

		// Print the count of unique pairs
		System.out.println(getPairs(a, n));
	}
}

