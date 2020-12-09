/* Carson Fracas
    10/21/20
    CSE 007: Lab 7
    The purpose of program to use methods and allow user to choose what pattern pyramid they would like and size of it
    Visual Studio Code*/

    
    import java.util.Scanner;//scanner import
    
    public class PatternsChoice{ //main class

        public static void main(String[]args){ //main method
            
            Scanner input = new Scanner(System.in); //declaring scanners
            Scanner keyboard = new Scanner(System.in); //declaring scanners

            int sizePyramid;
            String choice = answer(); //calls choice method and stores answer from user
            
            if(choice.equals("A")){ //if statements to direct program to desired pyramid pattern.
                do{
                    System.out.println("What size would you like the pyramid A to be? ");
                    boolean check = input.hasNextInt(); //verifies the input
                    if(check){
                        sizePyramid = input.nextInt(); //determines size of pyramid
                        break;
                    }
                    else{
                        System.out.println("Invalid answer.");
                        String junk = input.next();
                    }
                }
                while(true);
                patternA(sizePyramid); //uses size and passes it to patternA method then prints results
            }
            else if(choice.equals("B")){
                do{
                    System.out.println("What size would you like the pyramid B to be? ");
                    boolean check = input.hasNextInt();
                    if(check){
                        sizePyramid = input.nextInt(); //determines size of pyramid
                        break;
                    }
                    else{
                        System.out.println("Invalid answer.");
                        String junk = input.next();
                    }
                }
                while(true);
                patternB(sizePyramid); //uses size and passes it to patternB method then prints results
            }
            else if(choice.equals("C")){
                do{
                    System.out.println("What size would you like the pyramid C to be? ");
                    boolean check = input.hasNextInt(); //verifies the input
                    if(check){
                        sizePyramid = input.nextInt(); //determines size of pyramid
                        break;
                    }
                    else{
                        System.out.println("Invalid answer.");
                        String junk = input.next();
                    }
                }
                while(true);
                patternC(sizePyramid); //uses size and passes it to patternC method then prints results
            }
            else if(choice.equals("D")){
                do{
                    System.out.println("What size would you like the pyramid D to be? ");
                    boolean check = input.hasNextInt(); //verifies the input
                    if(check){
                        sizePyramid = input.nextInt(); //determines size of pyramid
                        break;
                    }
                    else{
                        System.out.println("Invalid answer.");
                        String junk = input.next();
                    }
                }
                while(true);
                patternD(sizePyramid); //uses size and passes it to patternD method then prints results
            }
            
            
            else{
                System.out.println("Error. Restart");
            }
            
        }

        
        public static void patternA(int size){ //method to print patternA pyramid
            int rows = size;
            for(int i = 1; i<= rows; i++){
                for(int j = 1; j<=i; j++){
                    System.out.print(j + " ");
                }
                System.out.println(" ");
            }
        }

        public static void patternB(int size){ //method to print patternA pyramid
            int rows = size;
            for(int i = 1; i<=rows; i++){
                for(int j = rows; j>= i; j--){
                    System.out.print(rows - j + 1 + " ");
                }
                System.out.println(" ");
            }

        }
        
        public static void patternC(int size){ //method to print patternA pyramid
            int rows = size;
            for(int i = 1; i<=rows; i++){
                for(int count = rows; count>i; count--){
                    System.out.print(" ");
                }
                if(i != 10 && rows == 10){
                    System.out.print(" ");
                }
                for(int j = 1; j<=i; j++){
                    System.out.print(i - j + 1 + " ");
                }
                System.out.println(" ");
            }
            
        }

        public static void patternD(int size){ //method to print patternA pyramid
            int rows = size;
            for(int i= rows; i>0; i--){
                for(int j = i; j>0; j--){
                    System.out.print(j + " ");
                }
                System.out.println(" ");
            }

        }

        public static String answer(){ //method for user input of what pattern pyramid they want
            Scanner input = new Scanner(System.in); //declaring scanners

            String inputAnswer;
            do{ //validates user input and catches any exceptions
                System.out.println("Select the pattern pyramid you want: ");
                System.out.println("(A) (B) (C) (D)");
                boolean check = input.hasNext();
                if(check){
                    inputAnswer = input.next();
                    return inputAnswer;
                }
                else{
                    System.out.println("You have entered an invalid option. Try Again");
                    String junk = input.next();
                }
            }
            while(true);

        }
    }