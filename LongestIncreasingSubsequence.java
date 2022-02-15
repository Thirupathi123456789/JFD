package com.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
 
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
    	
    	int n;
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Enter number of elements of array for which you want to find longest subsequence");
    	n=sc.nextInt();
    	int array[]= new int[50];
    	System.out.println("Enter the elements of array");
    	for(int i=0; i<n; i++) {
    		array[i]= sc.nextInt();
    	}

        ArrayList list = new ArrayList();
        ArrayList longestList = new ArrayList();
        int currntMax;
        int highCount = 0;
        for(int i = 0; i < array.length;i++)
        {
            currntMax = Integer.MIN_VALUE;
            for(int j = i;j < array.length; j++)
            {
                if(array[j] > currntMax)
                {
                    list.add(array[j]);
                    currntMax = array[j];
                }
            }
             

            if(highCount < list.size())
            {
                highCount = list.size();
                longestList = new ArrayList(list); 
            }  
            list.clear();
        }
        System.out.println();
         

        Iterator itr = longestList.iterator();
        System.out.println("The Longest subsequence");
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("Length of LIS: " + highCount);
    }
     
}
