package jav;

public class DataBase {
	public static DataBase instance = new DataBase();

	public DataBase() {
		instance = this;
	}

	public int[][] slot = new int[10][10]; // 10,10 ½½·Ô »ý¼º
	public int roof;
}
