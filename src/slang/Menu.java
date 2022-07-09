package slang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public void run(SlangWords slangWord){
        int id =0 ;
        do {
            clearScreen();
            System.out.println("\t---Slang Word Dictionary---");
            System.out.println("1. Search by slang word\t\t\t6. Delete slang word");
            System.out.println("2. Search by definition\t\t\t7. Restore backup");
            System.out.println("3. View search history\t\t\t8. On this day slang word");
            System.out.println("4. Add new slang word\t\t\t9. Random game: guess the definition");
            System.out.println("5. Edit slang word\t\t\t10. Random game: guess the slang word");
            System.out.println("0. Exit");
            System.out.println("\t---------------------------------------------");
            if(id<0||id>10) {
                System.out.print("Invalid choice! Please enter your choice again: ");
            }
            else
            {
                System.out.print("Enter your choice: ");
            }

            Scanner sc = null;
            try {
            	sc = new Scanner(System.in);
                String choice = sc.next();
                if(isNumeric(choice)) {
                    id = Integer.parseInt(choice);
                }
                else{
                    id=-1;
                }
                switch (id) {
                    case 1:
                        clearScreen();
                        searchBySlang(slangWord);
                        break;
                    case 2:
                        clearScreen();
                        searchByDefinition(slangWord);
                        break;
                    case 3:
                        clearScreen();
                        viewHistory(slangWord);
                        break;
                    case 4:
                        clearScreen();
                        
                        break;
                    case 5:
                        clearScreen();
                        
                        break;
                    case 6:
                        clearScreen();
                        
                        break;
                    case 7:
                        clearScreen();
                        
                        break;
                    case 8:
                        clearScreen();
                        
                        break;
                    case 9:
                        clearScreen();
                        
                        break;
                    case 10:
                        clearScreen();
                        
                        break;
                    case 0:
                        clearScreen();                        
                        System.out.println("Thank you!");
                        
                        System.exit(0);
                    default:
                        break;
                }
        } 
            finally  {
            sc.close();
        }
        } while (id<0||id>10);
    }
	
	
	
	private void viewHistory(SlangWords slangWord) {
        
        if(slangWord.getHistorySlang().size()==0){
            System.out.println("No search history!");
        }
        else{
            clearScreen();
            System.out.println("Search history:");
            int i =1;
            for(String word : slangWord.getHistorySlang()) {
                System.out.println(i +". "+ word);
                i++;
            }
        }
        System.out.println("Press enter to continue...");
        try (Scanner sc = new Scanner(System.in)) {
			sc.nextLine();
		}
        run(slangWord);
    }
	
	
	private boolean isNumeric(String choice) {
        if(choice.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
	
	public static void clearScreen() {  
	        try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	     } catch (IOException | InterruptedException ex) {}
	    }
	
	
}
