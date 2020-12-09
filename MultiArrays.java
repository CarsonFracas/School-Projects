/* Carson Fracas
    10/29/20
    CSE 007: MultiArrays
    The purpose of program to practice creating multi dimension arrays and being able to manipulate them in various ways
    Visual Studio Code*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class MultiArrays{
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in); //premade variables from program
        int[][] user2D = declare2D(myScanner);
        int[][][] user3D = declare3D(myScanner);
        int[] largestElem = locateLargest(user2D);

        int[] longestRow = locateLongest(user3D);
        shuffle(user2D);
        print2D(user2D);
        print3D(user3D);
        int[][] myRaggedArray = {{1,2,3,4,5},{2,3,4,5},{3,4,5},{4,5},{5}}; //declared ragged array
        int[] longestRaggedRow;
        print2D(myRaggedArray);
        int[][][] myRaggedArray3d = 
        {{{7, 20,100,12,19,44}, {9, 22}, {15, 33}, {13, 21}, {15, 2}}, 
        {{4, 21}, {9, 22}, {15, 34}, {12, 20}, {14, 9}},
        {{6, 30}, {4, 10}, {11, 33}}};
        int[] longestRowRagged = locateLongest(myRaggedArray3d);

    }
    public static int[][] declare2D(Scanner scnr){
        Scanner scnr2 = new Scanner(System.in); //second scanner for second user input

        int numRows; //used in for loop
        int numCol;

        do{
            System.out.println("How many rows would you like in the array?"); //verifies input and stores answer
            boolean check = scnr.hasNextInt();
            if(check){
                numRows = scnr.nextInt();
                break;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = scnr.nextLine();
            }
        }
        while(true);

        do{
            System.out.println("How many columns would you like in the array?"); //verifies and stores
            boolean check = scnr2.hasNextInt();
            if(check){
                numCol = scnr2.nextInt();
                break;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = scnr2.nextLine();
            }
        }
        while(true);

        int[][] newDeclare2D = new int[numRows][numCol]; //declare 2d array with size based on user input

        for(int rows = 0; rows<numRows; rows++){ //for loop with rows
            for(int col = 0; col<numCol; col++){ //for loop with col
                newDeclare2D[rows][col] = (int)(Math.random()*100+1); //random number for elements between 1-100

            }
        }

        /*for(int i = 0; i<newDeclare2D.length; i++){   print statement if wanted
            for(int j = 0; j<newDeclare2D[i].length; j++){
                System.out.print(newDeclare2D[i][j] + " ");
            }
            System.out.println();
        }*/

        
        return newDeclare2D; //return array
        
    }
    public static int[][][] declare3D(Scanner scnr){
        Scanner scnr2 = new Scanner(System.in); //scanners for user input
        Scanner scnr3 = new Scanner(System.in);


        int numRows;
        int numCol;
        int num2D;

        do{
            System.out.println("How many 2D arrays would you like?"); //verifies and stores user input in variable
            boolean check = scnr3.hasNextInt();
            if(check){
                num2D = scnr3.nextInt();
                break;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = scnr3.nextLine();
            }
        }
        while(true);
        
        do{
            System.out.println("How many rows would you like in the array?"); //verifies and stores user input in variable
            boolean check = scnr.hasNextInt();
            if(check){
                numRows = scnr.nextInt();
                break;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = scnr.nextLine();
            }
        }
        while(true);

        do{
            System.out.println("How many columns would you like in the array?"); //verifies and stores user input in variable
            boolean check = scnr2.hasNextInt();
            if(check){
                numCol = scnr2.nextInt();
                break;
            }
            else{
                System.out.println("Invalid Answer.");
                String junk = scnr2.nextLine();
            }
        }
        while(true);


        int[][][] newDeclare3D = new int[num2D][numRows][numCol]; //creates 3d array

        for(int arraySize = 0; arraySize<num2D; arraySize++){ //for loop with num arrays
            for(int rows = 0; rows<numRows; rows++){ //for loop with rows
                for(int col = 0; col<numCol; col++){ //for loop with col
                    newDeclare3D[arraySize][rows][col] = (int)(Math.random()*100+1); //random values from 1-100

                }
            }
        }

        /*for(int size = 0; size<num2D; size++){    print statement if needed
            for(int i = 0; i<numRows; i++){
                for(int j = 0; j<numCol; j++){
                    System.out.print(Arrays.toString(newDeclare3D[i][j]));
                }
                System.out.println();
            }
            System.out.println();
        }*/
        

        return newDeclare3D; //return array
    }
    
    public static int[] locateLargest(int[][] a) {
        int maxValue = a[0][0]; //starts with first value as largest
        int[] largestIndex = new int[2]; //will store index of where the largest number is
        int index1 = 0; //used for each index
        int index2 = 0;

        
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                if(a[i][j]>maxValue){ //if the next value in the array is bigger then the previous, it will be updated and repeated
                    maxValue = a[i][j]; //stores new maxValue
                    index1 = i; //stores index of that new highest value
                    index2 = j;
                }
            }
        }
        System.out.println("The largest value is " + maxValue + " at index[" + index1 + "][" + index2 + "]"); //prints current highest value and index found at
        largestIndex[0] = index1; //stores in array the two index locations
        largestIndex[1] = index2;
        return largestIndex; //returns array
    }
    
    public static int[] locateLongest(int[][][] a) {
        int currentRow = 0;
        int longestRow = 0;
        int [] longestLocater = a[0][0]; //similar to locate largest 
        for(int i = 0; i<a.length; i++){//for rows
            for(int j = 0; j<a[i].length; j++){ //for col
                currentRow = a[i][j].length; //stores length of current iteration row
                if(currentRow > longestRow){ //if that current iteration is bigger than the previous biggest row
                    longestRow = currentRow; //it will then be updated as the new biggest row
                    longestLocater = a[i][j]; //stores said row
                }
                else{
                    continue;
                }
            }
        }
        System.out.println("The longest row in the 3D array was " + Arrays.toString(longestLocater)); //prints results
        return longestLocater; //returns the array w answer in it

    }
    
    public static void shuffle(int[][] m) {
        Random ran = new Random(); //used to change index of row for shuffle
        int index = 0;
        
        System.out.println("The shuffle is:");
        for(int i = m.length-1; i>=0; i--){ //starts with last value and works down to 0
            if(i>0){
                index = ran.nextInt(i)+1; //as long as i is above 0, the index variable will get a new value to associate with rows later on
            }
            else{
                index = i; //used for when i isnt above 0
            }
            for(int j = 0; j<m[index].length; ++j){ //prints new row order to show the shuffle
                System.out.print(m[index][j] + " ");
                m[index][j] = m[i][j]; //holds the new switch of row order
            }
            System.out.println();
        }
    }
    public static void print2D(int[][] m) {
        System.out.println("The 2D array printed is:");
        
        for(int row = 0; row<m.length; row++){ //for every row the content will print out until the end of row is reached, then a new line will be created and the process will repeat until all rows are printed.
            for(int col = 0; col<m[row].length; col++){
                System.out.print(m[row][col] + " ");
            }
            System.out.println();
        }
    
    }
    public static void print3D(int[][][] m) {
        System.out.println("The 3D array printed is:");
        
        for(int i = 0; i<m.length; i++){ //for loop for rows
            for(int j = 0; j<m[i].length; j++){ //for loop for col
                System.out.print(Arrays.toString(m[i][j])); //prints content of rows and col of first 3d array set
                for(int k =0; k<m[i][j].length; k++){ //for loop to iterate the 3d array
                    System.out.println(); //new line betweeen outputs
                    
                }
            }
            System.out.print("/"); //marks end of one 3d array
            System.out.println(); //gives space for next array set
        }
    }
    
        
    

}

