package com.company;

import java.util.ArrayList;
import java.util.Random;

public class GameField {
     private  int[][] gameFiled = new int[4][4];
    private Random random = new Random();

    public void setGameFiled(int[][] gameFiled) {
        this.gameFiled = gameFiled;
    }

    public int[][] getGameFiled() {
        return gameFiled;
    }

    public  boolean PutCell(){
        ArrayList<int[]> emptyList = findEmpty();
        if (emptyList.isEmpty())
            return false;
        else{
            putNewCell(emptyList);
            return true;
        }
    }

    private  ArrayList<int[]> findEmpty(){
        ArrayList<int[]> emptyList = new ArrayList<>();
        for (int i = 0; i < gameFiled.length; i ++){
            for (int j = 0; j < gameFiled[0].length; j ++){
                if (gameFiled[i][j] == 0) {
                    int[] emptyXY = new int[2];
                    emptyXY[0] = i;
                    emptyXY[1] = j;
                    emptyList.add(emptyXY);
                }
            }
        }
        return emptyList;
    }

    private  void putNewCell(ArrayList<int[]> emptyList){
        int r1 = random.nextInt(emptyList.size());
        int[] a = emptyList.get(r1);
        gameFiled[a[0]][a[1]] = chooseCellValue();
    }


    private int chooseCellValue(){
        int luck = random.nextInt(100);
        if (luck <= 17) // вероятность поялвения 4
            return 4;
        else
            return 2;
    }

    public  void setLine(int i, int[] newLine){
        for (int j = 0; j < 4; j ++)
            gameFiled[j][i] = newLine[j];
    }

    public  int[] getLine (int i){
        int[] ret = new int[4];

        for (int j = 0; j < 4; j ++){
            ret[j] = gameFiled[j][i];
        }
        return ret;
    }

    public  void  setColumn (int i, int[] newColumn){
        gameFiled[i] = newColumn;
    }

    public  int[] getColumn (int i){
        return gameFiled[i];
    }





    public  void TestPrint(){
        for (int i = 0; i < gameFiled.length; i ++){
            for (int j = 0; j < gameFiled[i].length; j ++){
                System.out.print(gameFiled[i][j]);
            }
            System.out.println();
        }
    }

    public  void init(){
        for (int i = 0; i < 2; i ++){
            this.PutCell();
        }
    }

}
