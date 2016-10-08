package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _056MergeIntervals {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {
		Interval a=new Interval(1,4);
		Interval b=new Interval(0,5);
		//1,3],[2,6],[8,10],[15,18
		List<Interval> intervals =new ArrayList<>();
		//intervals.add(a);
		//intervals.add(b);
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		intervals=(merge(intervals));
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).start+"///"+intervals.get(i).end);
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start==o2.start)
					return o1.end-o2.end;
				else
					return o1.start-o2.start;
			}
		});
		List<Interval> outputList=new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr=intervals.get(i);
			if(outputList.isEmpty())
			{
				outputList.add(curr);
			}
			else{
				Interval prev=outputList.get(outputList.size()-1);
				if(curr.start<=prev.end)
				{
					outputList.remove(outputList.size()-1);
					prev.end=Math.max(prev.end, curr.end);
					outputList.add(prev);
				}
				else{
					outputList.add(curr);
				}
			}
		}
		return outputList;
	}
}
