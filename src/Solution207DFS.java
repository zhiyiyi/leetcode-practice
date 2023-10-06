import java.util.ArrayList;
import java.util.List;

public class Solution207DFS {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(dfs(i, adjacencyList, visited, inStack)) return false;
        }
        return true;
    }

    private static boolean dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        inStack[node] = true;
        List<Integer> neighbors = adjacencyList.get(node);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if(dfs(neighbor, adjacencyList, visited, inStack)) return true;
            }
        }

        inStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] pre = {{0,1}, {2,1}, {2,3}, {0,4}, {0,5}, {4,5}};
        System.out.println(canFinish(numCourses, pre));
    }
}
