package jav;

public class DataBase { // ������ ���� Ŭ����
	public static DataBase instance = new DataBase();
	public int val = 1; // ���� �� ���
	public int x = 4; // ���� x ��ǥ
	public int y = 1; // ���� y ��ǥ 
	public int angle; // ����
	
	public DataBase() {
		instance = this;
	}
	public int[][] slot = new int[10][10]; // 10,10 ���� ����
	public int roof; // ���� �ݺ���
}
