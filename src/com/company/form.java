package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form extends JFrame{
    private JPanel panel1;
    private JButton buttonRight;
    private JButton buttonLeft;
    private JButton buttonDown;
    private JButton buttonUp;
    private JScrollPane sq;
    private JTable table1;

    public form(){

       GameField gf = new GameField();
       start(gf);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play(gf, Direct.up);
            }
        });
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play(gf, Direct.down);
            }
        });
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play(gf, Direct.left);
            }
        });
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play(gf, Direct.right);
            }
        });

    }

    public static void main(String[] args) {
        new form();
    }

    private void play(GameField gf, Direct direct) {
        Shift shift = new Shift();
        shift.shiftAllLine(gf,direct);

        boolean endGame = !(gf.PutCell());

        if (!endGame){
            int[][] data = gf.getGameFiled();

            JTableUtils.writeArrayToJTable(table1, data);
        }
        else{
            JOptionPane.showMessageDialog(null, "Game Over");
        }
    }

    private void start(GameField gf){
        gf.init();
        int[][] data = gf.getGameFiled();
        JTableUtils.writeArrayToJTable(table1, data);
        setContentPane(panel1);
        table1.setTableHeader(null);
        setVisible(true);
    }

}
