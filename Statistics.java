/* Carson Fracas
    10/30/20
    CSE 007: MultiArrays
    The purpose of program to create a random array based on user input and use methods to manipulate the array.
    Visual Studio Code*/

    import java.util.Random;
    import java.util.Scanner;
    import java.util.Arrays;
    
    public class Statistics{
         public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in); 
            int length;
            int realLength;
            Random ran = new Random();

            do{
                System.out.println("Enter a length between 10 and 20: ");
                boolean check = myScanner.hasNextInt();
                if(check){
                    length = myScanner.nextInt();
                    if(length >=10 && length<=20){
                        realLength = length;
                        break;
                    }
                    else{
                        System.out.println("The int was not between 10-20, try again");
                        String junk2 = myScanner.nextLine();
                    }
                }
                else{
                    System.out.println("You did not enter an int, try again.");
                    String junk = myScanner.nextLine();
                }
            }
            while(true);

            int[] randomArray = new int[realLength];
            for(int i = 0; i<randomArray.length; i++){
                randomArray[i] = ran.nextInt(100);
            }

            insertionSearch(randomArray); //sorts array with insertion sort
            System.out.println(Arrays.toString(randomArray)); //prints sorted array
            
            int mean = findMean(randomArray); //calls findMean() method
            System.out.println("Mean: " + mean); //prints mean

            int median = findMedian(randomArray); //calls findMedian() method
            System.out.println("Median: " + median); //prints median

            int mode = findMode(randomArray); //calls findMode() method
            System.out.println("Mode: " + mode); //prints mode

            int range = findRange(randomArray); //calls findRange() method
            System.out.println("Range: " + range); //prints range

        
         }

         public static void insertionSearch(int[]array){ //I made this in a program before the test, This is from Zybook
            int i;
            int j;
            int temp;
            
    
            for(i = 1; i<array.length; ++i){
                j = i;
                
                while(j>0 && array[j]<array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    --j;
                }
            }
            
        } 

        public static int findMean(int[]array){
            int count = 0;
            int iCount = 0;
            for(int i = 0; i<array.length; i++){
                count = count + array[i]; //adds every value one at time to the previous number to get total value of all values added together
                iCount++;
            }
            int mean = count/iCount; //divides added values by the number of values in array
            return mean;
        }

        public static int findMedian(int[]array){
        
            int mid;
            
    
            if(array.length %2 == 0){
                mid = ((array.length/2) + (array.length/2 - 1))/2; //this takes the middle value, then adds it to the middle value - 1 and divides by 2 to find median when there is an equal amount of values.
            }
            else{
                mid = array.length/2; //if the array isnt equal the median is the array divided by 2
            }

            int median = array[mid]; //median is the index of mid
            return median;

          
            
        } 

        public static int findMode(int[] array){
            int count = 1;
            int highestCount = 0;
            int index = 0;
            for(int i = 1; i<array.length; i++){
                if(array[i] == array[i-1]){ //checks if the index is equal to the one before
                    count++; //if it is the count will go up and will repeat until it is not equal
                }
                else{
                    if(count > highestCount){ //if count is higher than the highest frequency
                        highestCount = count; //count is the newest high count
                        index = array[i-1]; //holds index of value found at highest count
                        count = 1; //resets count
                    }
                    else{
                        count = 1; //resets count
                    }
                }
            }
            int mode = index; //mode is the value found at highesat frequency
            return mode;
        }

        public static int findRange(int[] array){
            int lastNum = array[array.length-1]; //value at the last index
            int firstNum = array[0]; //value at first index
            int range = lastNum - firstNum; //values subtracted to find range
            return range;
        }
            
        
    
    }
    
    