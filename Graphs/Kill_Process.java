/*
 * 872 · Kill Process

In this problem, each process has a unique PID (process id) and PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.


1.The given kill id is guaranteed to be one of the given PIDs.
2.There is at least one PID in the list.

Example
Example 1:

Input: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
Output: [5, 10]
Explanation: Kill 5 will also kill 10.
     3
   /   \
  1     5
       /
      10
Example 2:

Input: PID = [1, 2, 3], PPID = [0, 1, 1], killID = 2
Output: [2]
 */



package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Kill_Process {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            int parent = ppid.get(i);
            if(!graph.containsKey(parent)){
                graph.put(parent, new ArrayList<>());
            }
            graph.get(parent).add(pid.get(i));
        }

        List<Integer> killList = new ArrayList<>();
        Stack<Integer> killStack = new Stack<>();
        killStack.push(kill);

        while(!killStack.isEmpty()){
            Integer curr = killStack.pop();
            killList.add(curr);
            if(graph.containsKey(curr)){
                for(int child: graph.get(curr)){
                    killStack.push(child);
                }
            }
        }
        return killList;
    }
}
