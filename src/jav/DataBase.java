package jav;

public class DataBase {
    public static int val = 0; // 블럭 종류변수
    public static int x = 4; // x
    public static int y = 1; // y
    public static int angle; // 각도
    public static boolean gameOver = false; // 패배 판별 변수
    public static int[][] slot = new int[17][10]; // 17,10맵
    public static int hold = 0; //블럭 저장하는 함수
    public static int[] next = new int[4]; // 다음 블럭 저장
    public static int cleared = 0; // 정리한 줄 => 10개 = 1 level
    // level 증가시 .1 초씩 빨라진다
    public static boolean ableToMove = true; // 이동 이후 잠깐의 여유를 주기 위한 컨트롤 변수

}