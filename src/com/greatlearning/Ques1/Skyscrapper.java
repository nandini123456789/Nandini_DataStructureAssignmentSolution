package com.greatlearning.Ques1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Skyscrapper {
	static int floors;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of floors");
		floors=sc.nextInt();
		int[] floorArray= new int[floors];
	
		for (int i=0;i<floors;i++) {
			System.out.println("enter the floor size given on day : "+(i+1));
			floorArray[i]=sc.nextInt();
		}
		System.out.println("The order of construction is as follows");	    
		
	    int temp=floors;
		Stack<Integer> floorstack =new Stack<>();
		for (int j=0;j<temp;j++) {
			System.out.println("Day: "+(j+1));
			floorstack.push(floorArray[j]);
			int day=temp-j;
			floorstack= floorpopArray(floorstack, day );
		}
	}

	public static Stack<Integer> floorpopArray(Stack<Integer> floorstack, int i) {
		Stack<Integer> temp=new Stack<>();
		ArrayList<Integer> arrtemp=new ArrayList<>();
		while (!floorstack.isEmpty()) {
			// System.out.println("initialfloorstack" + floorstack);
			 int a=floorstack.pop();
			 if (a>=floors) {
				 arrtemp.add(a);
			     floors--;
			     }
			 else {
				 temp.push(a);
			 }
		 }
		 floorstack=temp;
		 //10System.out.println("floors: " +floors +"i:"+i  );
		 if (i==1) {
			 while (!floorstack.isEmpty())
			   arrtemp.add(floorstack.pop()); 
		 }
		 //System.out.println("floorstack" + floorstack);
		 Collections.sort(arrtemp, Collections.reverseOrder());
		 System.out.println(arrtemp);
		 return floorstack;
	}

}
