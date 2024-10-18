package org.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        //Store task enqueue time, processing time and index
        int[][] sortedTasks = new int[tasks.length][3];
        for(int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        //sort based on enqueue time
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));
        int[] taskProcessingOrder = new int[tasks.length];
        long currTime = 0;
        int taskIndex = 0, ansIndex = 0;
        //min heap to store task, sort based on processing time
        PriorityQueue<int[]> nextTask = new PriorityQueue<>((a,b) -> (a[1]!=b[1] ? (a[1]-b[1]) : (a[2]-b[2])));
        while(taskIndex < tasks.length || !nextTask.isEmpty()) {
            if(nextTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                //When the heap is empty, try updating currTime to next task's enqueue time
                currTime = sortedTasks[taskIndex][0];
            }
            //Push all tasks into heap whose enqueueTime <= currTime
            while(taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) {
                nextTask.add(sortedTasks[taskIndex]);
                taskIndex++;
            }
            int[] temp = nextTask.poll();
            //Complete this task and increment curr time
            currTime += temp[1];
            taskProcessingOrder[ansIndex++] = temp[2];
        }
        return taskProcessingOrder;
    }
}
