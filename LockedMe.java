package com.mainproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	static String library;
	File folder_name;

	public LockedMe ()
	{
		library = System.getProperty("user.dir");
        folder_name = new File(library+"/files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("library: "+ folder_name.getAbsolutePath());
        System.out.println(folder_name.canRead());
        System.out.println(folder_name.length());
        System.out.println(folder_name.canWrite());
    }
	  private static final String WELCOME_PROMPT=	
	 		"\n**-------Welcome to LockedMe.com-----------**"+
			"\n**-----Thirupathi rao-----**";
	
		private static final String MAIN_MENU_PROMPT = 
				 "\n MAIN MENU - Select any of the following: \n"+
		                "1.List files in directory\n"+
						"2.Business Operation\n"+
		                "3.Close App\n";
		private static final String SECONDARY_MENU_PROMPT=
				  "\n  Select any of the following: \n"+
		          " a. Create file \n"+
				  " b. Search file \n"+
		          " c. Delete file \n"+
				  " d. Go Back";
		void showPrimarymenu()
		{
	      System.out.println(MAIN_MENU_PROMPT);
	      try
	      {
	    	  Scanner scan = new Scanner(System.in);
	    	  int choose_option = scan.nextInt();
	    	  switch(choose_option) {
	    	  case 1 : {
                  showFiles();
                  showPrimarymenu();
	    		  
	    	  }
	    	  case 2: {
	    		  showSecondaryMenu();
	    	  }
	    	  case 3: {
	    		  System.out.println("Thank You....!");
	    		  System.exit(0);
	    	  }
	    	  default: showPrimarymenu(); 
	    	  }
	      }
	      catch(Exception e) {
	    	  System.out.println("Print 1, 2 or 3");
	    	  showPrimarymenu();
	      }
		}
		 void showSecondaryMenu() {
		        System.out.println(SECONDARY_MENU_PROMPT);
		        try{
		            Scanner scanner = new Scanner(System.in);
		            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
		            char choose_option = input[0];

		            switch (choose_option){
		                case 'a' : {
		                    System.out.print("Adding a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim().toLowerCase();
		                    addFile(filename);
		                    break;
		                }
		                case 'b' : {		                    
		                    System.out.print("Searching a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim();
		                    searchFile(filename);
		                    break;
		                }
		                case 'c' : {
		                	System.out.print("Deleting a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim();
		                    deleteFile(filename);
		                    break;
		                }
		                case 'd' : {
		                    System.out.println("Going Back to MAIN menu");
		                    showPrimarymenu();
		                    break;
		                }
		                default : System.out.println("Please enter a, b, c or d");
		            }
		            showSecondaryMenu();
		        }
		        catch (Exception e){
		            System.out.println("Please enter a, b, c or d");
		            showSecondaryMenu();
		        }
		    }
		
	  void showFiles() {
			 if (folder_name.list().length==0)
		           System.out.println("The folder is empty");
		    else {
		            String[] list = folder_name.list();
		            System.out.println("The files in "+ folder_name +" are :");
		            Arrays.sort(list);
		            for (String str:list) {
		                System.out.println(str);
		            }
		        }			
		}
	  void addFile(String filename) throws IOException {
	        File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equalsIgnoreCase(file)) {
	                System.out.println("File " + filename + " already exists at " + folder_name);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ folder_name);
	     }
	  void searchFile(String filename) {
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
	                return;
	            }
	        }
	        System.out.println("File NOT found (FNF)");
	    }
			
	  void deleteFile(String filename) {
	        File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + folder_name);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
	    }		
					
		public static void main(String[] args) {
			System.out.println(WELCOME_PROMPT);
			LockedMe menu = new LockedMe ();
			menu.showPrimarymenu();
		}		 
}
