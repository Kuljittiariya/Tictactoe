/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;
/**
 *
 * @author Bnacha
 */
class Player extends Board{
    char playerTurn;
    public Player(char t, Board board){
        this.playerTurn = t;
        this.size = board.size; 
        this.table = board.table;
    }

    public boolean play(){
        Scanner scanner = new Scanner(System.in);
        boolean turn = true;
        int i,j;
        int row,column;
        for(i = 1;i <= size; i++)
            for(j = 1;j <= size; j++)
                if(table[i][j] == '_')
                    turn = false;
        if(turn == false){
            boolean check = true;
           
            do{
                System.out.println("Player " + playerTurn + " turn.");
                System.out.println("Enter your row location(1-size): ");
                column = scanner.nextInt();
               
                System.out.println("Enter your column location(1-size): ");
                row = scanner.nextInt();
               
                if(row>size || column>size){
                    System.out.println("Error! cannot locate, try again.");
                }
                else if(table[row][column] == '_'){
                    table[row][column] = playerTurn;
                    check = false;                 
                }
                else if(row<1 || column<1){
                    System.out.println("Invalid number, try again.");
                }
                    
            }while(check);
            
        }
        return turn; 
       }
    
    public boolean win(){
        boolean survey = true;
        int i,j;
        for(i=1;i<=size;i++)
        {
            for(j=1;j<=size;j++)
            {
                if(i==1 && j==1 && survey ==true) //for checking win across down start with table 1,1
                {
                    for(int a=1;a<=size && survey==true;a++)
                    {
                        if(table[a][a] != playerTurn)
                            survey = false;
                    }
                }
            }
            for(j=1;j<=size;j++)
            {
                if(i==1 && j==size-1 && survey ==false) //for checking win across up start with table 1,3
                {
                    survey = true;
                    for(int a=1;a<=size && survey==true;a++)
                    {
                        if(table[a][size-a] != playerTurn)
                            survey = false;
                    }
                }
            }
            for(j=1;j<=size;j++)
            {
                if(survey == false) //for checking win vertical line
                {
                    survey = true;
                    for(int a=1;a<=size && survey==true;a++)
                    {
                        if(table[a][j] != playerTurn)
                            survey = false;
                    }  
                } 
            }
            if(survey == false) //for checking win horizontal line
            {
                survey = true;
                for(int a=1;a<=size && survey==true;a++)
                {
                    if(table[i][a] != playerTurn)
                        survey = false;
                } 
            }
        }
        return survey;
    }
}