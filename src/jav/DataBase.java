package jav;

public class DataBase {
	public static DataBase instance = new DataBase();

	public DataBase() {
		instance = this;
	}

	public int[][] slot = new int[10][10]; // 10,10 ���� ����
	public int roof;
}
