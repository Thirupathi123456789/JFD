package com.project;

import java.util.Scanner;

public class EmailValidation {

	public static void main(String[] args) {
		String m[]= {"thiru.com","abc@def.com","12345@abc.com"};
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter your mail id:");
		String st=sc.nextLine();
		int i=0,count=0;
		while(i<m.length) {
			boolean res=m[i].equalsIgnoreCase(st);
			i=i+1;
			if(res) {
				count=count+1;
				break;
				
			}
			else
				continue;
				
		}
		
		if(count>0)
			System.out.println("Authenticated");
		else
			System.out.println("mail id not found");
		
	}
	
}
