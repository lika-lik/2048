package com.company;

import java.util.ArrayList;

public class Shift {

    private  ArrayList<Integer> getListWithoutZero(int[] line){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < line.length; i ++) {
            if (line[i] != 0)
                list.add(line[i]);
        }
        return list;
    }

    private  ArrayList<Integer> SumSameCells (int[] line){
        ArrayList<Integer> lineWithoutZero = getListWithoutZero(line);
        for (int i = 0; i < lineWithoutZero.size()-1; i ++){
            if (lineWithoutZero.get(i) == lineWithoutZero.get(i+1)){
                lineWithoutZero.set(i, lineWithoutZero.get(i)*2);
                lineWithoutZero.remove(i+1);
            }
        }
        return lineWithoutZero;
    }

    private  int[] shiftOneLine (int[] lineStart, Direct direction){
        ArrayList<Integer> listSum = SumSameCells(lineStart);
        int[] res = new int[4];
        if (direction == Direct.left || direction == Direct.up){
            for (int i = 0; i < listSum.size(); i ++){
                res[i] = listSum.get(i);
            }
        }
        else {
            for (int i = lineStart.length-1, j = 0;
                   j < listSum.size(); i--, j++ )   {
                res[i] = listSum.get(j);
            }
        }
        return res;
    }

    public void shiftAllLine(GameField gameField, Direct direction){
        int[] line;
        switch (direction){
            case up:
            case down:
                for (int i = 0; i < 4; i ++){
                    line = gameField.getLine(i);
                    int[] res = this.shiftOneLine(line, direction);
                    gameField.setLine(i, res);
                }
                break;
            case right:
            case left:
                for (int i = 0; i < 4; i ++){
                    line = gameField.getColumn(i);
                    int[] res = this.shiftOneLine(line, direction);
                    gameField.setColumn(i, res);
                }
                break;
        }
    }
}
