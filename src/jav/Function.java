package jav;

import javax.xml.crypto.Data;

public class Function {

    public static boolean ishold = false;

    public static void zeroSet() { // 맵 초기화 함수
        for (int y = 0; y < 17; y++) {
            for (int x = 0; x < 10; x++) {
                DataBase.slot[y][x] = 0;
            }
        }
    }

    public static void moveBlock(int val) { // 이동 함수
        String b = "b"; // 예외 발생변수
        boolean three = false; // 블럭 겹침 검사 함수
        movingDel();
//        if (!DataBase.ableToMove)
//            DataBase.ableToMove = true;


        try {
            switch (val) {
                case 37: { // 왼쪽 키
                    DataBase.ableToMove = false;
                    --DataBase.x;
                    int value = Integer.parseInt(b); // 예외 발생
                    break;
                }
                case 38: { // 위쪽 키 => 방향 전환
                    DataBase.ableToMove = false;
                    if (DataBase.angle < 3)
                        DataBase.angle++;
                    else
                        DataBase.angle = 0;
                    int value = Integer.parseInt(b);
                    break;
                }
                case 39: { // 오른 쪽
                    DataBase.ableToMove = false;
                    ++DataBase.x;
                    int value = Integer.parseInt(b);
                    break;
                }
                case 40: { // 아래 키
                    ++DataBase.y;
                    int value = Integer.parseInt(b);
                    break;
                }
            }
        } catch (Exception e) {
            //   waitSet();
            try {
                try {
                    BlockController.blockSet(1); // 블럭 세팅
                } catch (Exception p) {
                    if (val == 38) { // 만약 회전중 발생한 문제라면
                        movingDel(); // 맵의 이동중인 블럭 제거
                        if (DataBase.x > 5) // 만약에 오른쪽 벽에서 문제가 생겼다면
                            if (DataBase.val == 0) // l자 블럭일 경우
                                DataBase.x -= 2; // -2 만큼 이동
                            else DataBase.x--; // -1 만큼 이동
                        else DataBase.x++; //만일 왼쪽 벽에서 문제가 생겼다면 오른쪽으로 +1 만큼 이동
                        BlockController.blockSet(1); // 블럭 세팅
                    } else { // 회전중이 아니라면
                        int a = Integer.parseInt("/"); // 예외 발생
                    }
                }
                for (int y = 0; y < 17; y++) { // 블럭 겹쳤는지 검사
                    for (int x = 0; x < 10; x++) {
                        if (DataBase.slot[y][x] > 2) {
                            three = true;
                        }
                    }
                }
                if (three) { // 블럭이 겹쳤으면
                    int a = Integer.parseInt(b); // 예외 발생
                } else { // 겹친게 아니라면
                    movingDel();
                    BlockController.blockSet(1); // 블럭 세팅
                }
            } catch (Exception k) { // 겹치기 이전으로 상황 변경
                // DataBase.ableToMove = true;
                try {
                    switch (val) {
                        case 37: { // 왼
                            ++DataBase.x;
                            int a = Integer.parseInt(b);
                            break;
                        }
                        case 38: { // 위
                            if (DataBase.angle != 0)
                                DataBase.angle--;
                            else // 0
                                DataBase.angle = 4;

                            int a = Integer.parseInt(b);
                            break;
                        }
                        case 39: { // 오른
                            --DataBase.x;
                            int a = Integer.parseInt(b);
                            break;
                        }
                        case 40: { // 아래
                            --DataBase.y;
                            int a = Integer.parseInt(b);
                            break;
                        }
                    }
                } catch (Exception r) {
                    movingDel();
                    BlockController.blockSet(1); // 블럭 세팅
                }
            }
        }
    }

//    public static void waitSet() {
//        if (DataBase.ableToMove)
//            return;
//        try {
//            Thread.sleep(500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       // DataBase.ableToMove = true;
//        System.out.println("pass here");
//    }


    public static void movingDel() { // 이동을 위해 제거 (1인 데이터 제거)
        for (int y = 0; y < 17; y++) {
            for (int x = 0; x < 10; x++) {
                if (DataBase.slot[y][x] < 2)
                    DataBase.slot[y][x] = 0;
                else {
                    DataBase.slot[y][x] = 2;
                }
            }
        }
    }

    public static void check() { // 한줄이 다 찼는지 검사하는 함수
        for (int y = 0; y < 17; y++) {
            int sum = 0;
            for (int x = 0; x < 10; x++) { // 10 개 찼는지 검사
                if (DataBase.slot[y][x] > 1)
                    sum++;
            }
            // --------------------------------------------------
            if (sum > 9) {// 다 차있으면
                for (int x = 0; x < 10; x++) {
                    DataBase.slot[y][x] = 0; // 줄 제거
                }
                // --------------------------------------------------
                for (int h = y; h > -1; h--) { // 떙기기
                    for (int w = 0; w < 10; w++) {
                        try {
                            DataBase.slot[h][w] = DataBase.slot[h - 1][w];
                        } catch (Exception e) {
                        }
                    }
                }
                DataBase.cleared++;
            }
        }
    }

    public static void downBlock() { // 아래로 이동하는 함수
        movingDel(); // 이동을 위해 제거
        try {
            ++DataBase.y; // 이동
            BlockController.blockSet(1); // 블럭 세팅
            for (int y = 0; y < 17; y++) { // 블럭과 충돌 검사
                for (int x = 0; x < 10; x++) {
                    if (DataBase.slot[y][x] >= 3) { // 충돌시
                        movingDel();
                        onEnter();
                    }
                }
            }
        } catch (Exception e) { // 바닥 충돌
            try {
                movingDel();
                BlockController.blockSet(1); // 블럭 세팅
                return;
            } catch (Exception l) {
            }
            onEnter(); // 충돌
        }
    }

    public static void onEnter() { // 충돌 함수
        movingDel();
        if (ishold) {
            ishold = false;
        }
        if (DataBase.y == 0) { // 만약 충돌 위치가 0 이면
            gameOver(); // 패배
            return;
        } else { // 그렇지 않다면
            --DataBase.y; // 충돌 이전 위치로 이동
            BlockController.blockSet(2); // 블럭 세팅
            check();
            // ---------------------------------------------
            newBlockSet();
        }
    }

    static boolean first = false; // 이전 hold 가 0 이었는

    public static void holdBlock() {
        ishold = true;
        movingDel();
        int a = 0;
        if (DataBase.hold == 0) {
            DataBase.hold = DataBase.val + 1;
            first = true;
        } else {
            a = DataBase.hold - 1;
            DataBase.hold = DataBase.val + 1;
            DataBase.val = a;
        }
        newBlockSet();
    }

    public static void newBlockSet() { // 새로운 블럭 생성
        if (!ishold || first) {
            if (first)
                first = false;
            DataBase.val = DataBase.next[0];
            // ------------------------------------------------
            for (int i = 0; i < DataBase.next.length; i++) { //next 에 있는 변수들 땡기기
                try {
                    DataBase.next[i] = DataBase.next[i + 1];
                } catch (Exception k) {
                    break;
                }
            }
            while (true) { // 이전 턴과 다른 변수 생성
                DataBase.next[3] = (int) Main.random.nextInt(7); // 6
                if (DataBase.next[2] != DataBase.next[3])
                    break;
            }
        }
        //---------------------------------------------------
        DataBase.x = 4;
        DataBase.y = 0;
        DataBase.angle = 0;
    }

    public static void gameOver() { // 게임패배
        DataBase.gameOver = true;
    }


//    public static void waitforsec(float) {
//    }
//


}