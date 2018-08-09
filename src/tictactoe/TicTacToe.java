/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.InputMismatchException;
/**
 *
 * @author Modupe Okenla
 */
public class TicTacToe {
    //static String[] boardList = {"","","","","","","","",""};
    static public String player;
    static public String computer;
    public static void playerLetter() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter x or o: ");
            String l = input.nextLine();
            if ("x".equals(l)) {
                computer = "o";
                player = "x";
                break;
            } else if ("o".equals(l)) {
                computer = "x";
                player = "o";
                break;
            } else {
                System.out.println("Enter a valid letter");
            }
        }
    }
    public static void displayLetters() {
        System.out.println("You are " + player);
        System.out.println("Computer is " + computer);
    }
    public static String goesFirst() {
        int n = 0;
        String first = "";
        SecureRandom rand = new SecureRandom();
        n = rand.nextInt(2);
        if (n == 1) 
            first = "player";
        if (n == 0)
            first = "computer";
        return first;
    }
    public static void displayBoard(String[] boardList) {
        //String board = "  " + boardList[0] + "  |  " + boardList[1] + "  |  " + boardList[2] + "  " + '\n' + "  " + boardList[3] + "  |  " + boardList[4] + "  |  " + boardList[5] + "  " + '\n' + "  " + boardList[6] + "  |  " + boardList[7] + "  |  " + boardList[8] + "  " ;
        //System.out.println(board);
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%n%s%n%s\t%s\t%s\t%s\t%s\t%n%s%n%s\t%s\t%s\t%s\t%s\t%n",boardList[0],"|",boardList[1],"|",boardList[2],"_________________________________",boardList[3],"|",boardList[4],"|",boardList[5],"_________________________________",boardList[6],"|",boardList[7],"|",boardList[8]);
    }
    public static boolean isFree(String[] List,int j) {
        boolean free;
        if(!"".equals(List[j])) {
            free = false;
        } else {
            free = true; 
        }
        return free;
    }
    public static void handleexception() {
        try {
                Scanner input = new Scanner(System.in);
                input.nextInt();
        }
        catch(InputMismatchException e) {
                System.out.println("Enter a number");
        }
    }
    public static void playerMove(String[] boardList) throws Exception {
        Scanner input = new Scanner(System.in);
        while (true) {
           boolean looping = true;
           int n = 0;
           do {
               try{
                   System.out.println("Enter a number from 1 to 9 :");
                   n = input.nextInt();
                   looping = false;
               }
               catch(InputMismatchException inputMismatchException) {
                   System.err.println(inputMismatchException);
                   input.nextLine();
                   System.out.printf("You must enter integers. Please try again.%n%n");
               }
           } while(looping);
            if (n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9) {
                if(isFree(boardList , n-1)) {
                    boardList[n-1] = player;
                    break;
                } else {
                    System.out.println("Space is occupied");
                    continue;
                }
            }
            else {
                System.out.println("Enter a valid position");
                continue;
            }
        }
    }
    public static void compMove(String[] boardList) {
        if(boardList[0].equals(computer) && boardList[1].equals(computer) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(boardList[2].equals(computer) && boardList[1].equals(computer) && isFree(boardList,0)) {
            boardList[0] = computer;
        }  
        else if(boardList[0].equals(computer) && boardList[2].equals(computer) && isFree(boardList,1)) {
            boardList[1] = computer;
        } 
        else if(boardList[0].equals(computer) && boardList[3].equals(computer) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[0].equals(computer) && boardList[6].equals(computer) && isFree(boardList,3)) {
            boardList[3] = computer;
        }
        else if(boardList[3].equals(computer) && boardList[6].equals(computer) && isFree(boardList,0)) {
            boardList[0] = computer;
        }
        else if(boardList[6].equals(computer) && boardList[7].equals(computer) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[6].equals(computer) && boardList[8].equals(computer) && isFree(boardList,7)) {
            boardList[7] = computer;
        }
        else if(boardList[7].equals(computer) && boardList[8].equals(computer) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[2].equals(computer) && boardList[5].equals(computer) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[2].equals(computer) && boardList[8].equals(computer) && isFree(boardList,5)) {
            boardList[5] = computer;
        }
        else if(boardList[5].equals(computer) && boardList[8].equals(computer) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(boardList[1].equals(computer) && boardList[4].equals(computer) && isFree(boardList,7)) {
            boardList[7] = computer;
        }
        else if(boardList[4].equals(computer) && boardList[7].equals(computer) && isFree(boardList,1)) {
            boardList[1] = computer;
        }
        else if(boardList[1].equals(computer) && boardList[7].equals(computer) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[3].equals(computer) && boardList[5].equals(computer) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[3].equals(computer) && boardList[4].equals(computer) && isFree(boardList,5)) {
            boardList[5] = computer;
        }
        else if(boardList[4].equals(computer) && boardList[5].equals(computer) && isFree(boardList,3)) {
            boardList[3] = computer;
        }
        else if(boardList[0].equals(computer) && boardList[4].equals(computer) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[0].equals(computer) && boardList[8].equals(computer) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[4].equals(computer) && boardList[8].equals(computer) && isFree(boardList,0)) {
            boardList[0] = computer;
        } 
        else if(boardList[2].equals(computer) && boardList[4].equals(computer) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[2].equals(computer) && boardList[6].equals(computer) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[4].equals(computer) && boardList[6].equals(computer) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(boardList[0].equals(player) && boardList[1].equals(player) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(boardList[2].equals(player) && boardList[1].equals(player) && isFree(boardList,0)) {
            boardList[0] = computer;
        }  
        else if(boardList[0].equals(player) && boardList[2].equals(player) && isFree(boardList,1)) {
            boardList[1] = computer;
        } 
        else if(boardList[0].equals(player) && boardList[3].equals(player) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[0].equals(player) && boardList[6].equals(player) && isFree(boardList,3)) {
            boardList[3] = computer;
        }
        else if(boardList[3].equals(player) && boardList[6].equals(player) && isFree(boardList,0)) {
            boardList[0] = computer;
        }
        else if(boardList[6].equals(player) && boardList[7].equals(player) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[6].equals(player) && boardList[8].equals(player) && isFree(boardList,7)) {
            boardList[7] = computer;
        }
        else if(boardList[7].equals(player) && boardList[8].equals(player) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[2].equals(player) && boardList[5].equals(player) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[2].equals(player) && boardList[8].equals(player) && isFree(boardList,5)) {
            boardList[5] = computer;
        }
        else if(boardList[5].equals(player) && boardList[8].equals(player) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(boardList[1].equals(player) && boardList[4].equals(player) && isFree(boardList,7)) {
            boardList[7] = computer;
        }
        else if(boardList[4].equals(player) && boardList[7].equals(player) && isFree(boardList,1)) {
            boardList[1] = computer;
        }
        else if(boardList[1].equals(player) && boardList[7].equals(player) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[3].equals(player) && boardList[5].equals(player) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[3].equals(player) && boardList[4].equals(player) && isFree(boardList,5)) {
            boardList[5] = computer;
        }
        else if(boardList[4].equals(player) && boardList[5].equals(player) && isFree(boardList,3)) {
            boardList[3] = computer;
        }
        else if(boardList[0].equals(player) && boardList[4].equals(player) && isFree(boardList,8)) {
            boardList[8] = computer;
        }
        else if(boardList[0].equals(player) && boardList[8].equals(player) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[4].equals(player) && boardList[8].equals(player) && isFree(boardList,0)) {
            boardList[0] = computer;
        } 
        else if(boardList[2].equals(player) && boardList[4].equals(player) && isFree(boardList,6)) {
            boardList[6] = computer;
        }
        else if(boardList[2].equals(player) && boardList[6].equals(player) && isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(boardList[4].equals(player) && boardList[6].equals(player) && isFree(boardList,2)) {
            boardList[2] = computer;
        }
        else if(isFree(boardList,4)) {
            boardList[4] = computer;
        }
        else if(isFree(boardList,0) || isFree(boardList,2) || isFree(boardList,6) || isFree(boardList,8)) {
            while(true) {
                int [] options = {0,2,6,8};
                SecureRandom ran = new SecureRandom();
                int m = ran.nextInt(4);
                int n = options[m];
                if(isFree(boardList,n)) {
                    boardList[n] = computer;
                    break;
                }
            }
        }
        else if(isFree(boardList,1) || isFree(boardList,3) || isFree(boardList,5) || isFree(boardList,7)) {
            while(true) {
                int [] options = {1,3,5,7};
                SecureRandom ran = new SecureRandom();
                int m = ran.nextInt(4);
                int n = options[m];
                if(isFree(boardList,n)) {
                    boardList[n] = computer;
                    break;
                } 
            }
        } else {
            System.out.println("Board is full");
        }
    }
    public static boolean checkW(String[] boardList) {
        /*int count = 0;
        for (int j = 0 ; j < boardList.length ; j++) {
           if(isFree(boardList,j) == false) {
                count += 1;
            }
        }
        if (count == 9) {
            System.out.println("Board is full!"); */
        boolean win = false;
            if ((boardList[0].equals(computer) && boardList[1].equals(computer) && boardList[2].equals(computer)) || (boardList[0].equals(computer) && boardList[3].equals(computer) && boardList[6].equals(computer)) || (boardList[0].equals(computer) && boardList[4].equals(computer) && boardList[8].equals(computer)) || (boardList[3].equals(computer) && boardList[4].equals(computer) && boardList[5].equals(computer)) || (boardList[6].equals(computer) && boardList[7].equals(computer) && boardList[8].equals(computer)) || (boardList[1].equals(computer) && boardList[4].equals(computer) && boardList[7].equals(computer)) || (boardList[2].equals(computer) && boardList[5].equals(computer) && boardList[8].equals(computer)) || (boardList[2].equals(computer) && boardList[4].equals(computer) && boardList[6].equals(computer))) {
                win = true;
               
            } else if ((boardList[0].equals(player) && boardList[1].equals(player) && boardList[2].equals(player)) || (boardList[0].equals(player) && boardList[3].equals(player) && boardList[6].equals(player)) || (boardList[0].equals(player) && boardList[4].equals(player) && boardList[8].equals(player)) || (boardList[3].equals(player) && boardList[4].equals(player) && boardList[5].equals(player)) || (boardList[6].equals(player) && boardList[7].equals(player) && boardList[8].equals(player)) || (boardList[1].equals(player) && boardList[4].equals(player) && boardList[7].equals(player)) || (boardList[2].equals(player) && boardList[5].equals(player) && boardList[8].equals(player)) || (boardList[2].equals(player) && boardList[4].equals(player) && boardList[6].equals(player))) {
                win = true;
            }  else {
                win = false;
            } 
        return win;
    }
    public static boolean isFull(String[] list) {
        int count = 0;
        boolean full = false;
        for (int j = 0 ; j < list.length ; j++) {
           if(isFree(list,j) == false) {
                count += 1;
            }
        }
        if (count == 9) {
            full = true;
        }
        return full;
    }
    public static void checkWin(String[] boardList) {
        /*int count = 0;
        for (int j = 0 ; j < boardList.length ; j++) {
           if(isFree(boardList,j) == false) {
                count += 1;
            }
        }
        if (count == 9) {
            System.out.println("Board is full!"); */
            if ((boardList[0].equals(computer) && boardList[1].equals(computer) && boardList[2].equals(computer)) || (boardList[0].equals(computer) && boardList[3].equals(computer) && boardList[6].equals(computer)) || (boardList[0].equals(computer) && boardList[4].equals(computer) && boardList[8].equals(computer)) || (boardList[3].equals(computer) && boardList[4].equals(computer) && boardList[5].equals(computer)) || (boardList[6].equals(computer) && boardList[7].equals(computer) && boardList[8].equals(computer)) || (boardList[1].equals(computer) && boardList[4].equals(computer) && boardList[7].equals(computer)) || (boardList[2].equals(computer) && boardList[5].equals(computer) && boardList[8].equals(computer)) || (boardList[2].equals(computer) && boardList[4].equals(computer) && boardList[6].equals(computer))) {
                System.out.println("Computer wins");
            } else if ((boardList[0].equals(player) && boardList[1].equals(player) && boardList[2].equals(player)) || (boardList[0].equals(player) && boardList[3].equals(player) && boardList[6].equals(player)) || (boardList[0].equals(player) && boardList[4].equals(player) && boardList[8].equals(player)) || (boardList[3].equals(player) && boardList[4].equals(player) && boardList[5].equals(player)) || (boardList[6].equals(player) && boardList[7].equals(player) && boardList[8].equals(player)) || (boardList[1].equals(player) && boardList[4].equals(player) && boardList[7].equals(player)) || (boardList[2].equals(player) && boardList[5].equals(player) && boardList[8].equals(player)) || (boardList[2].equals(player) && boardList[4].equals(player) && boardList[6].equals(player))) {
                System.out.println("Player wins");
            } else {
                System.out.println("It's a tie");
            }
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Boolean isplaying = true;
        
        while(isplaying) {
            System.out.println("Welcome to tic tac toe");
            String boardList1[] = {"","","","","","","","",""};
            displayBoard(boardList1);
            
            playerLetter();
            displayLetters();
            String l = goesFirst();
            System.out.println(l + " goes first");
            while ( isFull(boardList1) == false) {
                if (l == "player") {
                    playerMove(boardList1);
                    displayBoard(boardList1);
                    if (checkW(boardList1)) {
                        break;
                    }
                    if(isFull(boardList1)) {
                        break;
                    }
                    System.out.println();
                    System.out.println();
                    
                    System.out.println("Computer's turn \n");
                    compMove(boardList1);
                    displayBoard(boardList1);
                    if (checkW(boardList1)) {
                        break;
                    }
                    if(isFull(boardList1)) {
                        break;
                    }
                } 
                if (l == "computer") {
                    System.out.println();
                    System.out.println();
                    System.out.println("Computer's turn \n");
                    compMove(boardList1);
                    displayBoard(boardList1);
                    if (checkW(boardList1)) {
                        break;
                    }
                    if(isFull(boardList1)) {
                        break;
                    }
                    playerMove(boardList1);
                    displayBoard(boardList1);
                    if (checkW(boardList1)) {
                        break;
                    }
                    if(isFull(boardList1)) {
                        break;
                    }
                }
            }
            checkWin(boardList1);
            while(true) {
                System.out.println("Do you want to play again: yes or no");
                String answer = input.nextLine();
                if("no".equals(answer) || "n".equals(answer)) {
                    isplaying = false;
                    break;
                } 
                if("yes".equals(answer) || "y".equals(answer)) {
                    break;
                }
                if (!"n".equals(answer) || !"yes".equals(answer) || !"y".equals(answer)) {
                    System.out.println("Please enter a valid option");
                }
            }
        }
    }
    
}
