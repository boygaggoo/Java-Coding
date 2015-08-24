package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;




/*Implementation of CTCI 2.4*/
public class _7LinkedList_3 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter Singly spaced elements");
		String inputStringArray[]=scanner.nextLine().split(" ");
		_2linkedList linkedList=new _2linkedList();
		for (int i = 0; i < inputStringArray.length; i++) {
			linkedList.add(Integer.parseInt(inputStringArray[i]));
		}
		System.out.println("Enter Pivot");
		int pivot=Integer.parseInt(scanner.nextLine());
		scanner.close();
		_2linkedList dividedLinkedList=divideLinkedList(linkedList,pivot);
		for (int i = 0; i < dividedLinkedList.size(); i++) {
			System.out.print(dividedLinkedList.get(i)+" ");
		}
	}

	private static _2linkedList divideLinkedList(_2linkedList linkedList,
			int pivot) {
		_2linkedList mainList=new _2linkedList();
		int pivotCounter=0;
		for (int i = 0; i < linkedList.size(); i++) {
			int value=linkedList.get(i);
			if(value<pivot)
				mainList.add(value);
			else if(value==pivot)
				pivotCounter+=1;
		}
		for (int i = 0; i < pivotCounter; i++) {
			mainList.add(pivot);
		}
		for (int i = 0; i < linkedList.size(); i++) {
			int value=linkedList.get(i);
			if(value>pivot)
				mainList.add(value);
		}
		return mainList;	}
}
