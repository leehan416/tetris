package jav;

import javax.swing.*;
import java.awt.event.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sun.java2d.loops.DrawRect;

public class main {

	static void print() { // 출력 함수
		DataBase.instance.printData = "";
		for (int h = 0; h < DataBase.instance.slot.length; h++) {
			for (int w = 0; w < DataBase.instance.slot.length; w++) {
				if (DataBase.instance.slot[h][w] > 0) {
					DataBase.instance.printData += "■";
				} else if (DataBase.instance.slot[h][w] == 0) {
					DataBase.instance.printData += "□";
				}
			}
			DataBase.instance.printData += "\n";
			//System.out.println(DataBase.instance.printData);
		}
		DataBase.instance.printData += "\n";
	}

	public static void main(String[] args) {
		Function.instance.ZeroSet();
		Function.instance.BlockSet(DataBase.instance.val, DataBase.instance.x, DataBase.instance.y);

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.setLocationRelativeTo(null); //자동으로 화면 중앙에 배치
		f.setSize(500, 500);
		f.setVisible(true);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 300, 50);
		
		class key implements KeyListener {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 37) {
					f.remove(label);
					label.setText("왼족 누름");
					f.add(label);
				}
				if (e.getKeyCode() == 38) {
					f.remove(label);
					label.setText("위 누름");
					f.add(label);
				}
				if (e.getKeyCode() == 39) {
					f.remove(label);
					label.setText("오른 누름");
					f.add(label);
				}
				if (e.getKeyCode() == 40) {
					f.add(label);
					label.setText("아래 누름");
					f.add(label);
				}
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		}

		f.setVisible(true);
		f.addKeyListener(new key());
		f.setFocusable(true);

		while (true) {
		if (DataBase.instance.roof > 20) { // test
				break;
			}
			/*print();
			f.remove(label);
			label.setText(DataBase.instance.printData);
			f.add(label);
			*/
		
	//	public void paint() {
			
			
	//	}
	//	DrawRect(0,0,1,1);
		
		
		try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Function.instance.Down();
			DataBase.instance.roof++;
		}

	}
}
