/* Carson Fracas
    9/22/20
    CSE 007: HW4
    The purpose of this program is to calculate what day of the week a certain date falls on.
    Visual Studio Code*/

    //Scanner import
    import java.util.Scanner;
  

    //class name
    public class WhatDay{
        
        //main method
        public static void main(String[]args){
            
            //declaring scanners
            Scanner input = new Scanner(System.in);
            Scanner keyboard = new Scanner(System.in);
           

            //ints used for equations or comparisons
            int userMonth;
            int userDay;
            int userYear;
            int yearCode;
            int monthCode;
            int centuryCode;
            int lastTwoYear;
            int leapYearCode;
            int dayofWeekCode;
            String dayofWeek;
            
            
            
            //3 do while statements that will loop until the user inputs an int within the range given by each prompt.
            do{
                System.out.println("Enter an integer corresponding to a month between 1-12"); 
                userMonth = input.nextInt();
                
            }
           
            while (userMonth<1 || userMonth>12);

            do{
                System.out.println("Enter an integer corresponding to a day between 1-31"); 
                userDay = input.nextInt();
                
            }
           
            while (userDay<1 || userDay>31);

            do{
                System.out.println("Enter an integer corresponding to a year between 1700-2399"); 
                userYear = input.nextInt();
                
            }
           
            while (userYear<1700 || userYear>2400);
            
            //calculates the last 2 digits of year given by user
            lastTwoYear = userYear%100;

            //formula for year code
            yearCode = (lastTwoYear + (lastTwoYear/4))%7;
            System.out.println("Year code is: " + yearCode);
            System.out.println("Day entered is: " + userDay);
            

            //if, else if, else statements to assign month code based on int entered by user
            if (userMonth == 1){
                monthCode = 0;
            }
            else if(userMonth == 2){
                monthCode = 3;
            }
            else if(userMonth == 3){
                monthCode = 3;
            }
            else if(userMonth == 4){
                monthCode = 6;
            }
            else if(userMonth == 5){
                monthCode = 1;
            }
            else if(userMonth == 6){
                monthCode = 4;
            }
            else if(userMonth == 7){
                monthCode = 6;
            }
            else if(userMonth == 8){
                monthCode = 2;
            }
            else if(userMonth == 9){
                monthCode = 5;
            }
            else if(userMonth == 10){
                monthCode = 0;
            }
            else if(userMonth == 11){
                monthCode = 3;
            }
            else if(userMonth == 12){
                monthCode = 5;
            }
            else{
                monthCode = 100;
            }
            
            System.out.println("Month code is: " + monthCode);

            //if, else if, else statements to find century code based on user input.
            if(userYear>1699 && userYear<1800){
                centuryCode = 4;
            }
            else if(userYear>1799 && userYear<1900){
                centuryCode = 2;
            }
            else if(userYear>1899 && userYear<2000){
                centuryCode = 0;
            }
            else if(userYear>1999 && userYear<2100){
                centuryCode = 6;
            }
            else if(userYear>2099 && userYear<2200){
                centuryCode = 4;
            }
            else if(userYear>2199 && userYear<2300){
                centuryCode = 2;
            }
            else if(userYear>2299 && userYear<2400){
                centuryCode = 0;
            }
            else{
                centuryCode = 100;
            }
            System.out.println("Century Code is: " + centuryCode);
                

            //checks if year is divisible by 4 but not 100 then will assign leap year code to 1.
           if(userYear%4 == 0 && userYear%100 != 0){
               leapYearCode = 1;
           }
           else if(userYear%400 == 0){ // checks if year is divisible by 400.
               leapYearCode = 1;
           }
           else{
               leapYearCode = 0;
           }

           //checks if it is a leap year that it will only stay as 1 if it is between Janurary or February.
           if(leapYearCode == 1 && userMonth>2){
               leapYearCode = 0;
           }
           else{
               leapYearCode = leapYearCode;
           }
           
           System.out.println("Leap Year Code is: " + leapYearCode);

           //formula for day of week code
           dayofWeekCode = ((yearCode + monthCode + centuryCode + userDay - leapYearCode)%7);
           
           //if, else if, else statments to find what day of week it is based on formula outcome.
           if(dayofWeekCode == 0){
               dayofWeek = "Sunday";
           }
           else if(dayofWeekCode == 1){
               dayofWeek = "Monday";
           }
           else if(dayofWeekCode == 2){
               dayofWeek = "Tuesday";
           }
           else if(dayofWeekCode == 3){
               dayofWeek = "Wednesday";
           }
           else if(dayofWeekCode == 4){
               dayofWeek = "Thursday";
           }
           else if(dayofWeekCode == 5){
               dayofWeek = "Friday";
           }
           else if(dayofWeekCode == 6){
               dayofWeek = "Saturday";
           }
           else{
               dayofWeek = "Incorrect Value";
           }
           
           
           //prints what day of week the date entered fell on.
           System.out.println(userMonth + "/" + userDay + "/" + userYear + " is on a " + dayofWeek + "!");
                

                
                

                
           
                    
            

            
            
       
  

            

            




        }


    }