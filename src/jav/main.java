package jav;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class main { 

	static void print() { // 출력 함수 
		int width = 40;
		Ui.frame.getGraphics().clearRect(0, 0, 800, 1000);
		for (int h = 0; h < 17; h++) {
			for (int w = 0; w < 10; w++) {
				if (DataBase.slot[h][w] > 0) {
					Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
					Ui.frame.getGraphics().fillRect((w * width) + width, (h * width) + width, width, width);
				} else if (DataBase.slot[h][w] == 0) {
					Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
				}
			}
		}
		Ui.frame.getGraphics().drawRect(500, 40, 150, 150); // hold 
		Ui.frame.getGraphics().drawRect(475, 200, 200, 490); // next block 
		BlockController.NextBlockPrint();
		if (DataBase.hold != 0) //hold 출력  
			BlockController.DrawBlocks(DataBase.hold - 1,530, 95);
		
	}
	public static Random random = new Random();

	public static void main(String[] args) {

		Function.ZeroSet(); // 맵 초기화 
		//Function.NewBlockSet();
		BlockController.BlockSet(1);

		Ui ui = new Ui(); // 그래픽창 생성 
		
		class key implements KeyListener { //키 입력 

			public void keyPressed(KeyEvent e) {
				Function.Move(e.getKeyCode());
				print();
				if ((e.getKeyCode() == 16) && (!Function.ishold)) {
					Function.Hold();
				}
			}
			public void keyReleased(KeyEvent e) { }
			public void keyTyped(KeyEvent e) { }
		}
		Ui.frame.setVisible(true);
		Ui.frame.addKeyListener(new key());
		Ui.frame.setFocusable(true);
		// --------------------------------------------------
		
		for (int a = 0 ; a < 4 ;a ++) { // 초기 블럭 세팅 
			if (a == 0) {
				DataBase.next[0] = (int) main.random.nextInt(7);
				continue;
			}
			while (DataBase.next[a - 1] == DataBase.next[a] ) { //이전 블럭과 다른 블럭 생성 
				DataBase.next[a] = (int) main.random.nextInt(7);
			}
		}
		Function.NewBlockSet();
		while (true) {

			if (DataBase.gameover) { //패배 했다면 
				break; // 그만 
			} else {
				print();
				try { //1 초당 1 프레임 
					int l = DataBase.cleared / 10;
					Thread.sleep(1000 - l * 100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				print();
				Function.Down();
			}
		}
	}
}