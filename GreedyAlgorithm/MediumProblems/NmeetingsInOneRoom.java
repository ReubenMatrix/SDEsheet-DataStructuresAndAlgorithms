package GreedyAlgorithm.MediumProblems;

/*
There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’,
start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting.
Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time.
Print the order in which these meetings will be performed.

Example:
Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
Output: 1 2 4 5
 */
import java.util.ArrayList;
import java.util.Comparator;

class Meeting {
    int start;
    int end;
    int index;

    Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class NmeetingsInOneRoom {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        int meetings = solution(start, end);
        System.out.println("No. Of Meetings That Can Be Held: "+meetings);
    }

    static int solution(int[] start, int[] end) {
        int n = start.length;

        ArrayList<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Meeting meet = new Meeting(start[i], end[i], i);
            meetingList.add(meet);
        }

        meetingList.sort(Comparator.comparingInt(m -> m.end));

        ArrayList<Integer> selectedMeet = new ArrayList<>();
        selectedMeet.add(meetingList.get(0).index);
        int prev = meetingList.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetingList.get(i).start > prev) {
                selectedMeet.add(meetingList.get(i).index);
                prev = meetingList.get(i).end;
            }
        }

        System.out.println("Order of Selected Meetings: ");
        for (Integer i : selectedMeet) {
            System.out.print(i+1 + " ");
        }
        System.out.println();

        return selectedMeet.size();
    }
    //Time Complexity:O(N logN)
    //Space Complexity:O(N)
}
