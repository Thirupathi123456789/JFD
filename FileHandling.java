package com.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		int input;
		
		System.out.println("\n Enter 1 to create new file: \n Enter 2 to write data to the file: \n Enter 3 to read data from a file: \n Enter 4 to append a file: ");
		input= sc.nextInt();
		System.out.println("\n Enter file name\n");
		String fileName= sc.next();
		
		switch(input) {
		case 1:
			
			File myFile= new File("C:\\Users\\91918\\Desktop\\FileHandling\\"+fileName+".txt");
			try {
				
				if(myFile.createNewFile())
					System.out.println("File created successfully..");
				else
					System.out.println("\n File already exists..\n you may perform other CRUD operations or you can choose another file name");} 
			
			catch(IOException e) {
				System.out.println("File creation error...");
				e.printStackTrace();}
			
			break;
			
		case 2:
			// write data to file
			FileWriter writer= new FileWriter("C:\\Users\\91918\\Desktop\\FileHandling\\"+fileName+".txt");
			//Scanner text=new Scanner(System.in);
			//System.out.println("Enter the information you want to write to the file\n");
			//String info=text.nextLine();
			//writer.write(info);
			writer.write("Welcome to File Handling..:)");
			writer.close();
			System.out.println("You have successfully written data to that file");
			
			break;
						
						
			
		case 3:
			// reading data from file using nio.File
			List<String> list= Collections.emptyList();
			
			try 
			{
				list=Files.readAllLines(Paths.get("C:\\Users\\91918\\Desktop\\FileHandling\\"+fileName+".txt"),StandardCharsets.UTF_8);
				//System.out.println((list));
				Iterator<String> itr=list.iterator();
				while(itr.hasNext())
				System.out.println(itr.next());

			}
			
			catch(IOException e) 
			{
				System.out.println("FileReader error...\t please check your file exists or not.");}
			
			break;
			
		case 4:
			
			//Append data to file
			
			try {
				
				FileWriter fileAppend= new FileWriter("C:\\Users\\91918\\Desktop\\FileHandling\\"+fileName+".txt", true);	
				Scanner txt=new Scanner(System.in);
				System.out.println("Enter the information you want to append to the file\n");
				String info= txt.nextLine();
				fileAppend.append("\n");
				fileAppend.append(info);
				fileAppend.close();
				System.out.println("Data has been appended successfully.");
				}
			catch(IOException e) {
				System.out.println("File append error..");}
			
			break;
		}
	}
}