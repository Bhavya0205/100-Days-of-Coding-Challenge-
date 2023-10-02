/* 
Scheduling a course

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

// A BFS based solution to check if we can finish
// all tasks or not. This solution is mainly based
// on Kahn's algorithm.
import java.util.*;

public class Code8 {

	// class to store dependencies as a pair
	static class pair {
		int first, second;

		pair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
	}

	// Returns adjacency list representation from a list
	// of pairs.
	static ArrayList<ArrayList<Integer> >
	make_graph(int numTasks, Vector<pair> prerequisites)
	{
		ArrayList<ArrayList<Integer> > graph
			= new ArrayList<ArrayList<Integer> >(numTasks);

		for (int i = 0; i < numTasks; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (pair pre : prerequisites)
			graph.get(pre.second).add(pre.first);

		return graph;
	}

	// Finds in-degree of every vertex
	static int[] compute_indegree(
		ArrayList<ArrayList<Integer> > graph)
	{
		int degrees[] = new int[graph.size()];

		for (ArrayList<Integer> neighbors : graph)
			for (int neigh : neighbors)
				degrees[neigh]++;

		return degrees;
	}

	// Main function to check whether possible to finish all
	// tasks or not
	static boolean canFinish(int numTasks,
							Vector<pair> prerequisites)
	{
		ArrayList<ArrayList<Integer> > graph
			= make_graph(numTasks, prerequisites);
		int degrees[] = compute_indegree(graph);

		for (int i = 0; i < numTasks; i++) {
			int j = 0;
			for (; j < numTasks; j++)
				if (degrees[j] == 0)
					break;

			if (j == numTasks)
				return false;

			degrees[j] = -1;
			for (int neigh : graph.get(j))
				degrees[neigh]--;
		}

		return true;
	}

	public static void main(String args[])
	{
		int numTasks = 4;
		Vector<pair> prerequisites = new Vector<pair>();

		prerequisites.add(new pair(1, 0));
		prerequisites.add(new pair(2, 1));
		prerequisites.add(new pair(3, 2));

		if (canFinish(numTasks, prerequisites)) {
			System.out.println(
				"Possible to finish all tasks");
		}
		else {
			System.out.println(
				"Impossible to finish all tasks");
		}
	}
}

// This code is contributed by adityapande88.
