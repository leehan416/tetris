package jav;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class main { // ������ �ʿ��� �� ���� �����ϴ� Ŭ����

	static void print() { // ��� �Լ�
		int width = 40;
		frame.getGraphics().clearRect(0, 0, 500, 500);
		// frame.setBackground(Color.blue);
		for (int h = 0; h < DataBase.instance.slot.length; h++) {
			for (int w = 0; w < DataBase.instance.slot.length; w++) {
				if (DataBase.instance.slot[h][w] > 0) {
					frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
					frame.getGraphics().fillRect((w * width) + width, (h * width) + width, width, width);
				} else if (DataBase.instance.slot[h][w] == 0) {
					frame.getGraphics().drawRect((w * width) +width, (h * width) + width, width, width);
				}
			}
		}
	}

	public static JFrame frame = new JFrame("Tetris");

	public static void main(String[] args) {
		Function.instance.ZeroSet();
		Function.instance.BlockSet();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 480);
		frame.setVisible(true);

		// --------------------------------------------------

		class key implements KeyListener { //Ű�Է�

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 37) {// ��
					Function.instance.MovingDel();
					try {
						--DataBase.instance.x;
						Function.instance.BlockSet();
						print();
					} catch (Exception E) {
						// TODO: handle exception
					}

				}
				if (e.getKeyCode() == 38) { // ��
					Function.instance.MovingDel();
					try {
						Function.instance.BlockSet();
						print();
					} catch (Exception E) {
						// TODO: handle exception
					}

				}
				if (e.getKeyCode() == 39) { // ����
					Function.instance.MovingDel();
					try {
						++DataBase.instance.x;
						Function.instance.BlockSet();
						print();
					} catch (Exception E) {
						// TODO: handle exception
					}

				}
				if (e.getKeyCode() == 40) { // �Ʒ�1
					Function.instance.MovingDel();
					try {
						++DataBase.instance.y;
						
						Function.instance.BlockSet();
						print();
					} catch (Exception E) {
						// TODO: handle exception
					}
				}
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		}

		frame.setVisible(true);
		frame.addKeyListener(new key());
		frame.setFocusable(true);

		while (true) {
			if (DataBase.instance.roof > 20) { // test
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			print();
			Function.instance.Down();
			//DataBase.instance.roof++;
		}
	}
}
