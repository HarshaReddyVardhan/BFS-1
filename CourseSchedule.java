
// Time Complexity (TC):
// O(V + E) → where V = numCourses, E = prerequisites.length
// Each course is processed once, and each prerequisite edge is traversed once.

// Space Complexity (SC):
// O(V + E)
// indegree[] array takes O(V) space.
// map (adjacency list) holds O(E) edges.
// Queue holds up to O(V) nodes in the worst case.

// Approach:
// Build an adjacency list and compute the in-degree of each course (number of prerequisites it depends on).
// Add all courses with 0 in-degree to a queue and use BFS to process them, reducing the in-degree of their dependent courses.
// If all courses are processed (count == numCourses), return true; otherwise, a cycle exists, and return false.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int [numCourses];
        for(int []edge : prerequisites){
            int in = edge[0];//dependent 
            int out = edge[1]; // independent
            if(! map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
            indegree[in]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;++i){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            List<Integer> li = map.get(q.poll());
            if(li == null) continue;
            for(int x : li){
                indegree[x]--;
                if(indegree[x] == 0){
                    count++;
                    q.add(x);
                }
            }
            if(count == numCourses)
                return true;
        }
        if(count == numCourses)
            return true;
        return false;
    }
}
