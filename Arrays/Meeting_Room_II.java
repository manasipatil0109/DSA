/*
 * Meeting Rooms II
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000

 */


package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Meeting_Room_II {


    /*
     * Solution 1 : took help
     */
    public static int minMeetingRooms(List<Interval> intervals) {
        
        if(intervals ==null)
            return 0;
        intervals.sort((a,b)->a.start-b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
        for(Interval i:intervals){
            if(!pq.isEmpty() && i.start>=pq.peek().end){
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }

    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,40));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        System.out.println(minMeetingRooms(intervals));
    }
    
}
