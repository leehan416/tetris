package jav;

public class DataBase {
	public static DataBase instance = new DataBase();
	public int val; // ���� �� ���
	public int x; // ���� x ��ǥ
	public int y; // ���� y ��ǥ 
	public int angle; // ����
	public DataBase() {
		instance = this;
	}

	public int[][] slot = new int[10][10]; // 10,10 ���� ����
	public int roof; // ���� �ݺ���
}
