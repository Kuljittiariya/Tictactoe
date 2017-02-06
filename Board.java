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
public class Board {
    char[][] table;
    int size;
    
    public Board(){
        this.size = 3;
        this.table = new char[size+1][size+1];
    }
    
    public Board(int x){
        this.size = x;
        this.table = new char[x+1][x+1];
    }
    
    public void print(){
        int i;
        int j;
        for(i = 1;i <= size; i++){
            for(j = 1;j <= size; j++){
                if(table[i][j] != '_')
                    System.out.print(table[i][j] + " ");
                else
                    System.out.print("_" + " ");
            }
            System.out.println();
        }
        
    }
}
