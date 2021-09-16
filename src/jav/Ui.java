package jav;

import javax.swing.JFrame;

public class Ui {

    public static JFrame frame = new JFrame("Tetris");

    Ui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 960); // canvas size set
        frame.setVisible(true);
        frame.setResizable(false); // 사이즈 재조정 불가능
        frame.setLocationRelativeTo(null); // 창이 가운데에 뜨도록 함
    }
}
