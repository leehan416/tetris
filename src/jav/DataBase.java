package jav;

public class DataBase { // 데이터 모음 클래스
	public static DataBase instance = new DataBase();
	public int val = 1; // 현재 블럭 모양
	public int x = 4; // 현재 x 좌표
	public int y = 1; // 현재 y 좌표 
	public int angle; // 각도
	
	public DataBase() {
		instance = this;
	}
	public int[][] slot = new int[10][10]; // 10,10 슬롯 생성
	public int roof; // 현재 반복수
}
