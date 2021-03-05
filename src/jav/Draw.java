package jav;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw {
    public Draw() {
        JFrame frame = new JFrame();
        Screen screen = new Screen();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(screen);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class Screen extends JPanel {
        final int WIDTH = 400, HEIGHT = 500;

        public Screen() {
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        }

        @Override
        public void paint(Graphics g) {
            g.drawRect(40, 40, 60, 60);
        }
    }
}
