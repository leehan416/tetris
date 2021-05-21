package jav;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class main { 

	static void print() { // 출력 함수 
		int width = 40;
		Ui.frame.getGraphics().clearRect(0, 0, 500, 500);
		for (int h = 0; h < DataBase.slot.length; h++) {
			for (int w = 0; w < DataBase.slot.length; w++) {
				if (DataBase.slot[h][w] > 0) {
					Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
					Ui.frame.getGraphics().fillRect((w * width) + width, (h * width) + width, width, width);
				} else if (DataBase.slot[h][w] == 0) {
					Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
				}
			}
		}
	}

	//public static JFrame frame = new JFrame("Tetris");
	public static Random random = new Random();

	public static void main(String[] args) {

		Function.ZeroSet(); // �ʱ�ȭ
		DataBase.val = (int) main.random.nextInt(5); // 4
		DataBase.x = 4;
		DataBase.y = 0;
		DataBase.angle = 0;
		Function.BlockSet();
		Ui ui = new Ui(); // 그래픽창 생성 
		class key implements KeyListener { // Ű�Է�

			public void keyPressed(KeyEvent e) {
				Function.Move(e.getKeyCode());
				print();
			}

			public void keyReleased(KeyEvent e) { }

			public void keyTyped(KeyEvent e) { }
		}
		Ui.frame.setVisible(true);
		Ui.frame.addKeyListener(new key());
		Ui.frame.setFocusable(true);
		// --------------------------------------------------*/
		while (true) {
			if (DataBase.gameover) { // �й��
				break;
			} else {
				print();
				try { // �ʴ� 1 ������
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				print();
				Function.Down();
			}
		}
	}
}