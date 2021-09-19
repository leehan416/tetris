package jav;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main {

    static void print() { // 출력 함수
        int width = 40;
        Ui.frame.getGraphics().clearRect(0, 0, 800, 1000);
        for (int h = 0; h < 17; h++) {
            for (int w = 0; w < 10; w++) {
                if (DataBase.slot[h][w] > 0) {
                    Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
                    Ui.frame.getGraphics().fillRect((w * width) + width, (h * width) + width, width, width);
                } else if (DataBase.slot[h][w] == 0) {
                    Ui.frame.getGraphics().drawRect((w * width) + width, (h * width) + width, width, width);
                }
            }
        }
        Ui.frame.getGraphics().drawRect(500, 40, 150, 150); // hold
        Ui.frame.getGraphics().drawRect(475, 200, 200, 490); // next block
        BlockController.nextBlockPrint();
        if (DataBase.hold != 0) //hold 출력
            BlockController.drawBlocks(DataBase.hold - 1, 530, 95);
    }

    public static Random random = new Random();
    public static Thread[] waitController = new WaitController[2];

    public static void main(String[] args) {
        // thread 초기 설정
        waitController[0] = new WaitController();
        waitController[1] = new WaitController();
        waitController[0].start();

        Function.zeroSet(); // 맵 초기화
        //Function.NewBlockSet();
        BlockController.blockSet(1);

        Ui ui = new Ui(); // 그래픽창 생성

        class key implements KeyListener { //키 입력

            public void keyPressed(KeyEvent e) {

                waitController[0].interrupt(); // 만약 스레드가 작동중이면 정지
                if (37 <= e.getKeyCode() && e.getKeyCode() <= 40) // move
                    Function.moveBlock(e.getKeyCode());
                else if ((e.getKeyCode() == 16) && (!Function.ishold))//shift
                    Function.holdBlock();
                else return;
                print();
                DataBase.ableToMove = false;
                waitController[1].start(); // 스래드 실행
                waitController[0] = waitController[1]; // 스레드 swap
                waitController[1] = new WaitController(); // 새로운 스레드 생성 => 이전 thread 사용 불가
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        }
        Ui.frame.setVisible(true);
        Ui.frame.addKeyListener(new key());
        Ui.frame.setFocusable(true);
        // --------------------------------------------------

        for (int a = 0; a < 4; a++) { // 초기 블럭 세팅
            if (a == 0) {
                DataBase.next[0] = (int) Main.random.nextInt(7);
                continue;
            }
            while (DataBase.next[a - 1] == DataBase.next[a]) { //이전 블럭과 다른 블럭 생성
                DataBase.next[a] = (int) Main.random.nextInt(7);
            }
        }
        Function.newBlockSet();
        while (true) {
            if (DataBase.gameOver) { //패배 했다면
                break; // 그만
            } else {
                print();
                try { //1 초당 1 프레임
                    int l = DataBase.cleared / 10; // 10개 제거할 때마다 빨라짐.
                    Thread.sleep(1000 - l * 100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                print();
                while (!DataBase.ableToMove) System.out.print("");
                Function.downBlock();
            }
        }
    }
}