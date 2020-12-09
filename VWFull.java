import java.util.Arrays;
import java.util.Scanner; //scanner import

public class VWFull{ //main class
  
    public static void main(String [] args){ //main method
    int choice = 0; //variables used later
    double balance = 1232.94;
    String[] friendsList = new String[25]; //declaring arrays
    double[][] transactions = new double[friendsList.length][2]; //2d array

    
    do{
      printMenu(); /* Menu Choices: 1: send money; 2. request money; 3. view balance; 4. quit */
      choice = getInt();   //get users choice
      switch (choice){
        case 1: getBalance(balance); // show the user their balance so they know what they can send locally
                System.out.println("Your new balance after the transaction is: " + sendMoney(balance, friendsList, transactions));
                    
                break;
        case 2: System.out.println("Your new balance after the transaction is: " + requestMoney(balance, friendsList, transactions)); //request money from a friend
                break; //calling methods
        case 3: getBalance(balance);
                break;
        case 4: addFriends(friendsList);
                break;
        case 5: searchFriends(friendsList);
                break;
        case 6: viewFriends(friendsList);
                break;
        case 7: displayReport(friendsList, transactions);
                break;
        case 8: System.out.println("Goodbye");
                break;
        default: System.out.println("You entered an invalid value -- try again");
                break;
      }
    }while(choice != 8); //runs until 4 is entered
  }  
    public static int getInt(){ //gets user choice for menu and verifies its an int then returns value to main method
        Scanner input = new Scanner(System.in);
        int answer;
        do{
            System.out.println("Enter the number corresponding to the menu choice you want: ");
            boolean check = input.hasNextInt(); //validates input is int and uses that for menu choice
            if(check){
                answer = input.nextInt();
                return answer;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = input.next();
            }
        }
        while(true);


    }

    public static void addFriends(String[] friendsList){
        Scanner friendsName = new Scanner(System.in);
        System.out.println("Enter the name of the friend you would like to enter: ");
        String friend = friendsName.nextLine();
        
        for(int i = 0; i < friendsList.length; i++) { // searches for if friend entered is already entered and if it
            // is then, program will continue, if not it will add name

            if(friendsList[i] == null){ //when there is an empty space, the friend will be entered, unless name is already entered
                friendsList[i] = friend;
                break;
            }
            else if(friendsList[i].equals(friend)){
                break;
            }
            else{
                continue;
            }


        }
    }

    public static void searchFriends(String [] friendsList){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of the friend you are searching for?");
        String friendsName; 
        friendsName = input.nextLine();
        
        
        for(int i = 0; i<friendsList.length; i++){ //searches for if the friends name is already in list and if it is the index will print, else it will say friend was not found
            if(friendsList[0] == null){
                System.out.println("There are no friends entered.");
                break;
            }
            else if(friendsList[i] == null){
                System.out.println(friendsName + " was not found in the list.");
                break;
            }
            else if(friendsList[i].equals(friendsName)){
                System.out.println(friendsName + " is found at index[" + i + "].");
                break;
            }
            else{
                continue;
            }
        }
                
        
    }

    public static void viewFriends(String[] friendsList){
        for(int i = 0; i<friendsList.length; i++){
            if(friendsList[0] == null){ //prints friends name and location until null is found
                System.out.println("There are no friends entered.");
                break;
            }
            else if(friendsList[i] !=null){
                System.out.println(friendsList[i] + " was found at index[" + i + "].");
            }
            else if(friendsList[i] == null){
                break;
            }
            else{
                continue;
            }
        }
    }

    public static void displayReport(String[] friendsList, double[][] transactions){
        int index = 1;
        
        for(int i = 0; i<friendsList.length; i++){
            if(friendsList[0] == null){ //displays transactions with corresponding friend
                System.out.println("There are no friends entered yet.");
                break;
            }
            else if(friendsList[i] != null){
                
                System.out.println("Friend " + i + " is " + friendsList[i]);
                System.out.println("The amount sent to " + friendsList[i] + " is " + transactions[i][i]);
                System.out.println("The amount requested from " + friendsList[i] + " is " + transactions[i][index]);
            }
            
            else{
                break;
            }
        }
    }
    
    public static void printMenu(){ //method to print statements of menu options
        System.out.println("Menu Choices");
        System.out.println("1: send money");
        System.out.println("2: request money");
        System.out.println("3: view balance");
        System.out.println("4: add friends");
        System.out.println("5: search friends");
        System.out.println("6: view friends");
        System.out.println("7: display report");
        System.out.println("8: quit");


    }

    public static void getBalance(double balance){ //method to show current balance
        System.out.println("Your current balance is: " + balance);


    }

    public static double requestMoney(double balance, String[] friendsList, double[][] transactions){ //method to add money to balance and return to main method and also verify the user input was a double
        Scanner input = new Scanner(System.in);
        Scanner friendsName = new Scanner(System.in);8

        double transactionAmount;
        int index = 0;
        double newBalance;

        System.out.println("Enter the name of the friend you would like to request money from: ");
        String friend = friendsName.nextLine();


        for(int i = 0; i < friendsList.length; i++) { // searches for if friend entered is already entered and if it
                                                       // is then, program will continue, if not it will add name
            
            if(friendsList[i] == null){
                friendsList[i] = friend;
                index = i; //index is updated to location of friend in array
                break;
            }
            else if(friendsList[i].equals(friend)){
                index = i;
                break;
            }
            else{
                continue;
            }

            
        }

        do{
            System.out.println("Enter the amount of money you would like to recieve from " + friend);
            boolean check = input.hasNextDouble();
            if(check){
                transactionAmount = input.nextDouble();
                transactions[index][1] = transactionAmount; //based on index from friends location, the transaction location in array will be updated with amount entered by user
                newBalance = balance + transactionAmount;
                return newBalance;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = input.next();
            }
        }
        while(true);


    }
    
    public static double sendMoney(double balance, String[] friendsList, double[][] transactions){ //method to subtract money from balance and return to main method and verify the user input was a double.
        Scanner input = new Scanner(System.in);
        Scanner friendsName = new Scanner(System.in);

        double transactionAmount;
        int index = 0;
        double newBalance;

        System.out.println("Enter the name of the friend you would like to give money to: ");
        String friend = friendsName.nextLine();


        for(int i = 0; i<friendsList.length; i++){
            
            if(friendsList[i] == null){
                friendsList[i] = friend; //checks if name is already entered and if not, name will be added
                index = i;
                break;
            }
            else if(friendsList[i].equals(friend)){
                index = i;
                break;
            }
            else{
                continue;
            }

            
        }

        do{
            System.out.println("Enter the amount of money you would like to give " + friend);
            boolean check = input.hasNextDouble();
            if(check){
                transactionAmount = input.nextDouble();
                transactions[index][0] = transactionAmount;  //based on index from friends location, the transaction location in array will be updated with amount entered by user
                newBalance = balance - transactionAmount;
                return newBalance;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = input.next();
            }
        }
        while(true);

    }

        
      

    
}