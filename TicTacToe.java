/* Carson Fracas
    11/11/20
    CSE 007: TicTacToe
    The purpose of program is to create a tic tac toe game and use methods to replace numbers 1-9 with x and o.
    Visual Studio Code*/

    import java.util.Arrays; //import array and scanner 
    import java.util.Scanner;
    
    public class TicTacToe{

        public static void main(String[] args){
            
            Scanner input = new Scanner(System.in);
            
            String gameBoard[][] = new String[3][3]; //creates size of board
            gameBoard[0][0] = "1"; //gives values to each spot in array
            gameBoard[0][1] = "2";
            gameBoard[0][2] = "3";
            gameBoard[1][0] = "4";
            gameBoard[1][1] = "5";
            gameBoard[1][2] = "6";
            gameBoard[2][0] = "7";
            gameBoard[2][1] = "8";
            gameBoard[2][2] = "9";

            displayBoard(gameBoard); //calls method to print the board

            int playerCount = 1;
            int gameContinue = 0;

            do{ //asks user to continue playing until the winner is decided
                if(playerCount == 1){ //player 1
                    System.out.println("Player 1's turn. You are O's.");
                    checkForSpotO(gameBoard); //checks for empty spot
                    displayBoard(gameBoard); //displays new board
                    if(winO(gameBoard) == 1){ //checks for win or tie
                        System.out.println("Player 1 wins!");
                        gameContinue = 1;
                        break;
                    }
                    else if(winO(gameBoard) == 2){
                        System.out.println("You tied. Thanks for playing!");
                        gameContinue = 1;
                        break;
                    }
                    playerCount = 2;
                    
                }
                else if(playerCount == 2){ //player 2
                    System.out.println("Player 2's turn. You are X's.");
                    checkForSpotX(gameBoard); //checks for empty spot
                    displayBoard(gameBoard); //displays board
                    if(winX(gameBoard) == 1){ //checks for winner
                        System.out.println("Player 2 wins!");
                        gameContinue = 1;
                        break;
                    }
                    else if(winX(gameBoard) == 2){
                        System.out.println("You tied. Thanks for playing!");
                        gameContinue = 1;
                        break;
                    }
                    playerCount = 1;
                }
                else{
                    System.out.println("Error");
                }
            }
            while(gameContinue == 0);
            
        }
        
        /*Precondition: the double string array will be passed into diplayBoard method
        Postcondition: It is void so the method will print the results, nothing has changed to the input*/
        public static void displayBoard(String gameBoard[][]){ 
            for(int i = 0; i<gameBoard.length; i++){ //prints board with each value followed by space in between
                for(int j = 0; j<gameBoard[i].length; j++){
                    System.out.print(gameBoard[i][j] + "    ");
                }
                System.out.println();
                System.out.println();
            }
        }

        /*Precondition: the double string array will be passed into checkForSpotX method
        Postcondition: It will return the new double string array with the changes made*/
        public static String[][] checkForSpotX(String[][] gameBoard){
            Scanner input = new Scanner(System.in);

            String placeHolder;
            do{
                System.out.println("Select the number on the board to place your X.");
                placeHolder = input.next();
                System.out.println();

                for(int i = 0; i<gameBoard.length; i++){
                    for(int j = 0; j<gameBoard[i].length; j++){
                        if(gameBoard[i][j].equals(placeHolder)){ //if the location in array is equal to number entered by user, that value will be replaced with an X
                            gameBoard[i][j] = "X";
                            return gameBoard;
                            
                        }
                        
                        
                    }
                    
                    
                }
                if(gameBoard.equals(placeHolder) == false){ //if not, an error message will print and try again
                    System.out.println("That spot is out of range or already has an X or O.");
                }
                
            }
            while(true);
        }

        /*Precondition: the double string array will be passed into checkForSpotO method
        Postcondition: It will return the new double string array with the changes made*/
        public static String[][] checkForSpotO(String[][] gameBoard){
            Scanner input = new Scanner(System.in);

            String placeHolder;
            do{
                System.out.println("Select the number on the board to place your O.");
                placeHolder = input.next();
                System.out.println();

                for(int i = 0; i<gameBoard.length; i++){
                    for(int j = 0; j<gameBoard[i].length; j++){ 
                        if(gameBoard[i][j].equals(placeHolder)){  //if the location in array is equal to number entered by user, that value will be replaced with an X
                            gameBoard[i][j] = "O";
                            return gameBoard;
                            
                        }
                        
                        
                    }
                    
                    
                }
                if(gameBoard.equals(placeHolder) == false){
                    System.out.println("That spot is out of range or already has an X or O.");
                }
                
            }
            while(true);
        }

        /*Precondition: the double string array will be passed into winX method
        Postcondition: It will return the int corresponding with if the user won/tied/not anything yet. Nothing has changed the input*/
        public static int winX(String gameBoard[][]){
            int winningNum = 0; //0 is no win, 1 is win
            int tieCounter = 0;
            int moveCounter = 0;
            for(int i = 0; i<gameBoard.length; i++){
                if(gameBoard[i][0].equals("X") && gameBoard[i][1].equals("X") && gameBoard[i][2].equals("X")){
                    winningNum = 1; //checks for horizontal win
                    return winningNum;
                } 
                for(int j = 0; j<gameBoard[i].length; j++){
                    if(gameBoard[0][j].equals("X") && gameBoard[1][j].equals("X") && gameBoard[2][j].equals("X")){
                        winningNum = 1; //checks for vertical win
                        return winningNum;
                    }
                } 
            }
            if(gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][2].equals("X") || gameBoard[2][0].equals("X") &&gameBoard[1][1].equals("X") &&gameBoard[0][2].equals("X")){
                winningNum = 1;
                return winningNum; //checks for diagle win
            } 
            
            for(int i = 0; i<gameBoard.length; i++){
                for(int j = 0; j<gameBoard[i].length; j++){
                    if(gameBoard[i][j].equals("X") || gameBoard[i][j].equals("O")){ //if there is an x or o at each space the counter will go up by 1
                        tieCounter++;
                        
                    }
                    
                    
                }
 
                
            }
            
            if(tieCounter == 9){ //if there is 9 x or 0 without a winner, the game is a tie
                return 2;
            }
            else{
                return 0;
            }
            

            
        }

        /*Precondition: the double string array will be passed into winO method
        Postcondition: It will return the int corresponding with if the user won/tied/not anything yet. Nothing has changed the input*/
        public static int winO(String gameBoard[][]){
            int winningNum = 0; //0 is no win, 1 is win
            int tieCounter = 0;
            
            for(int i = 0; i<gameBoard.length; i++){
                if(gameBoard[i][0].equals("O") && gameBoard[i][1].equals("O") && gameBoard[i][2].equals("O")){
                    winningNum = 1;
                    return winningNum; //checks for horizontal win
                } 
                for(int j = 0; j<gameBoard[i].length; j++){
                    if(gameBoard[0][j].equals("O") && gameBoard[1][j].equals("O") && gameBoard[2][j].equals("O")){
                        winningNum = 1; //checks for vertical win
                        return winningNum;
                    }
                } 
            }
            if(gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][2].equals("O") || gameBoard[2][0].equals("O") &&gameBoard[1][1].equals("O") &&gameBoard[0][2].equals("O")){
                winningNum = 1;
                return winningNum; //checks for diagle win
            } 
            
            for(int i = 0; i<gameBoard.length; i++){
                for(int j = 0; j<gameBoard[i].length; j++){
                    if(gameBoard[i][j].equals("X") || gameBoard[i][j].equals("O")){ //if each space holds a x or a o, then the counter will go up 1
                        tieCounter++;
                        
                    }
                    
                    
                }
 
                
            }
            
            if(tieCounter == 9){ //if there is 9 x or 0 without a winner, the game is a tie
                return 2;
            }
            else{
                return 0;
            }
            

            
        }



    }