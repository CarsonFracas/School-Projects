/* Carson Fracas
    10/15/20
    CSE 007: Grades
    The purpose of program to take user input for grades for CSE7, sort in descending order, prompt user for key
    find the index of key in array if found and then list how many comparisons were made in the process.
    Visual Studio Code*/

    import java.util.Arrays; //import array and scanner 
    import java.util.Scanner;
    
    public class Grades{ //main class

        public static void main(String[]args){ //main method
            
            Scanner input = new Scanner(System.in); //declaring scanners
            Scanner keyboard = new Scanner(System.in); //declaring scanners

            
            int amountEntered; //int used for scanner
            
            int[] array = new int[15]; //array length
          
            int key; //used to for key
            int keyIndex;
            
            
            do{ //checks if user input was an int or not and will repeat prompt until int is entered
                System.out.println("Enter 15 integers representing final grades in CSE7: ");
                boolean check = input.hasNextInt(); //boolean for next int
                if(check){
                    for(int i=0; i<array.length; i++){ //takes in 15 user entered values as grades
                        boolean secondCheck = input.hasNextInt();
                        if(secondCheck){
                            amountEntered = input.nextInt();
                            if(amountEntered >=0 && amountEntered <=100){ //checks if input was within 0-100
                                array[i] = amountEntered;
                            }
                            else{
                                System.out.println("Out of Range:"); //if it wasnt then this will print and i will go back one iteration
                                --i;
                            }
                        }
                        else{
                            System.out.println("Invalid Response. Enter int to continue"); //catches any error
                            String junk = input.next();
                        } 
                    }
                    System.out.println("Unsorted Array: "); //prints unsorted array
                    System.out.println(Arrays.toString(array));
                    sortedArray(array); //call to selection sorting method
                    System.out.println("Descending Array (Selection Sort): ");
                    System.out.println(Arrays.toString(array)); //prints sorted array in descending order
                    System.out.println("Your average score is: " + average(array)); //calls and prints the average of grades from average method
                    System.out.println("Enter a grade to search for: ");
                    key = input.nextInt(); //asks user for key
                    keyIndex = binarySearch(array, key); //calls binary search method
                    if(keyIndex == -1){ //if, else to check print results of key search
                        System.out.println(key + " was not found.");
                    }
                    else{
                        System.out.println("Found " + key + " at index[" + keyIndex + "] of your sorted array.");
                    
                    }
                    break;
                } 
                else{
                    System.out.println("Invalid Answer");
                    String junk = input.next();
                } 
            }
            while(true);
            
            
            

            

            



            
        }

        public static int[] sortedArray(int[] array){ //method to sort array
            int indexLargest;
            int placeHolder;

            for(int i = 0; i<array.length; i++){ //this is to sort the array in descending order. I chose selection sort because I have done it in a previous assignment and wanted more practice with it.
                indexLargest = i;
                for(int j = i+1; j<array.length; j++){
                    if(array[j] > array[indexLargest]){
                        indexLargest = j;
                    }
                }
                placeHolder = array[i]; //placeholder variable
                array[i] = array[indexLargest]; //new value for index as result from sort
                array[indexLargest] = placeHolder;
            }
            return array; //returns newly sorted array

        }


        public static int average(int[] array){ //average method to find average of grades
            int sum = 0;
            int average;
            for(int i = 0; i<array.length; i++){
                sum = sum + array[i];
            }
            average = sum/array.length;
            return average; //returns the average
        }

        public static int binarySearch(int [] array, int key){ //int method used for binarySearch
            int mid; //ints used for search
            int low; 
            int high;
            int counter = 0;
            
            low = 0; //used to start search
            high = array.length - 1;

            while(high>=low){
                mid = (high + low)/2; //divides array in half
                if(array[mid] > key){ //reverse normal operator from < to > because array is descending
                    low = mid + 1;
                    counter = counter + 1;
                }
                else if(array[mid] < key){ //same here
                    high = mid - 1;
                    counter = counter + 1;
                }
                else{
                    counter = counter + 1;
                    System.out.println("Comparisons made: " + countSum(counter)); //calls and prints results of counter from counter method
                    return mid; //return mid if key is found
                    
                }

            }
            System.out.println("Index was not found and made " + countSum(counter) + " comparisons");
            return -1; //key was not found
        }
        
        public static int countSum(int counter){ //counter method to caluculate how many comparisons were made.
            int countSum = counter;
            return countSum; //returns counter amount
        }

    }