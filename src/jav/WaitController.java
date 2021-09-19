package jav;

public class WaitController extends Thread {
    // 이동 직후 잠깐의 여유를 주는 thread
    public void run() {
        try {
            Thread.sleep(500);
        } catch (Exception l) {
        }
        DataBase.ableToMove = true;
    }
}
