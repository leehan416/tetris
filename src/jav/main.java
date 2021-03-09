package jav;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class main { // 구동에 필요한 것 들을 관리하는 클래스

	static void print() { // 출력 함수
		int width = 40;
		frame.getGraphics().clearRect(0, 0, 500, 500);
		for (int h = 0; h < DataBase.slot.length; h++) {
			for (int w = 0; w < DataBase.slot.length; w++) {
				if (DataBase.slot[h][w] > 0) {
					frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
					frame.getGraphics().fillRect((w * width) + width, (h * width) + width, width, width);
				} else if (DataBase.slot[h][w] == 0) {
					frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
				}
			}
		}
	}

	public static JFrame frame = new JFrame("Tetris");

	public static void main(String[] args) {
		Function.ZeroSet();
		Function.BlockSet();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 480);
		frame.setVisible(true);

		// --------------------------------------------------

		class key implements KeyListener { // 키입력

			public void keyPressed(KeyEvent e) {
				Function.Move(e.getKeyCode());
				print();
			}

			public void keyReleased(KeyEvent e) { }
			public void keyTyped(KeyEvent e) { }
		}

		frame.setVisible(true);
		frame.addKeyListener(new key());
		frame.setFocusable(true);

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			print();
			Function.Down();
		}
	}
}
