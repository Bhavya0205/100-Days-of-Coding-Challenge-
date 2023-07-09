/* Combination Sum with a Twist

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60 */

import java.util.ArrayList;

public class Code4 {
    static void
Recurrence(int N, int K, ArrayList<Integer> sub_vector,
          boolean[] vis, ArrayList<ArrayList<Integer>> output,
          int last)
{
     
    // Base case
    if (N == 0 && K == 0)
    {
         
        // Push the current subset
        // in the array output[][]
        output.add(new ArrayList<>(sub_vector));
        return;
    }
 
    // If N or K is less than 0
    if (N <= 0 || K <= 0)
        return;
 
    // Traverse the range [1, 9]
    for(int i = last; i <= 9; i++)
    {
         
        // If current number is
        // not marked visited
        if (!vis[i])
        {
             
            // Mark i visited
            vis[i] = true;
 
            // Push i into the vector
            sub_vector.add(i);
 
            // Recursive call
            Recurrence(N - 1, K - i, sub_vector, vis,
                      output, i + 1);
 
            // Pop the last element
            // from sub_vector
            sub_vector.remove(sub_vector.size() - 1);
 
            // Mark i unvisited
            vis[i] = false;
        }
    }
}
 
// Function to check if required
// combination can be obtained or not
static void combinationSum(int N, int K)
{
     
    // If N * 9 is less than K
    if (N * 9 < K)
    {
        System.out.print("Impossible");
        return;
    }
 
    // Stores if a number can
    // be used or not
    boolean[] vis = new boolean[10];
 
    // Stores a subset of numbers
    // whose sum is equal to K
    ArrayList<Integer> sub_vector = new ArrayList<>();
 
    // Stores list of all the
    // possible combinations
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
 
    // Recursive function call to
    // find all combinations
    Recurrence(N, K, sub_vector, vis, output, 1);
 
    // Print the output[][] array
    for(int i = 0; i < output.size(); i++)
    {
        for(Integer x : output.get(i))
            System.out.print(x + " ");
             
        System.out.println();
    }
    return;
}
 
// Driver code
public static void main(String[] args)
{
    int N = 3, K = 9;
     
    combinationSum(N, K);
}
}

