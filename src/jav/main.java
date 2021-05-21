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
	public static Random random = new Random();

	public static void main(String[] args) {

		Function.ZeroSet(); // 맵 초기화 
		Function.NewBlockSet();
		Function.BlockSet();
		Ui ui = new Ui(); // 그래픽창 생성 
		class key implements KeyListener { //키 입력 

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
			if (DataBase.gameover) { //패배 했다면 
				break; // 그만 
			} else {
				print();
				try { //1 초당 1 프레임 
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