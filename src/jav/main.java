package jav;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class main {

	static void print() { // ��� �Լ�
		DataBase.instance.printData = "";
		for (int h = 0; h < DataBase.instance.slot.length; h++) {
			for (int w = 0; w < DataBase.instance.slot.length; w++) {
				if (DataBase.instance.slot[h][w] > 0) {
					DataBase.instance.printData += "��";
				} else if (DataBase.instance.slot[h][w] == 0) {
					DataBase.instance.printData += "��";
				}
			}
			DataBase.instance.printData += "\n";
			// System.out.println(DataBase.instance.printData);
		}
		DataBase.instance.printData += "\n";
	}

	public static JFrame frame = new JFrame("Tetris");

	public static void main(String[] args) {
		// Function.instance.ZeroSet();
		// Function.instance.BlockSet(DataBase.instance.val, DataBase.instance.x,
		// DataBase.instance.y);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLocationRelativeTo(null); // �ڵ����� ȭ�� �߾ӿ� ��ġ
		frame.setSize(1280, 720);
		frame.setVisible(true);
		// --------------------------------------------------
		frame.getGraphics().drawRect(10, 40, 80, 80);
		frame.getGraphics().drawRect(10, 40, 80, 80);
		frame.getGraphics().drawString("����ȣ", 640, 360);

		// --------------------------------------------------

		class key implements KeyListener {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 37) {// ��

				}
				if (e.getKeyCode() == 38) { // ��

				}
				if (e.getKeyCode() == 39) { // ����

				}
				if (e.getKeyCode() == 40) { // �Ʒ�1

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
			/*
			 * print(); f.remove(label); label.setText(DataBase.instance.printData);
			 * f.add(label);
			 */

			// public void paint() {

			// }
			// DrawRect(0,0,1,1);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Function.instance.Down();
			// DataBase.instance.roof++;
		}

	}
}
