package jav;

public class Function {

	public static boolean ishold = false;

	public static void ZeroSet() { // 맵 초기화 함수
		for (int y = 0; y < 17; y++) {
			for (int x = 0; x < 10; x++) { DataBase.slot[y][x] = 0; }
		}
	}

	public static void Move(int val) { // 이동 함수
		String b = "b"; // 예외 발생변수
		boolean three = false; // 블럭 겹침 검사 함수
		MovingDel();
		try {
			switch (val) {
				case 37: { // 왼쪽 키
					--DataBase.x;
					int a = Integer.parseInt(b); // 예외 발생
					break;
				} case 38: { // 위쪽 키
					if (DataBase.angle < 3)
						DataBase.angle++;
					else
						DataBase.angle = 0;
					int a  = Integer.parseInt(b);
					break;
				} case 39: { // 오른 쪽
					++DataBase.x;
					int a  = Integer.parseInt(b);
					break;
				} case 40: { // 아래 키
					++DataBase.y;
					int a = Integer.parseInt(b);
					break;
				}
			}
		} catch (Exception e) {
			try {
				BlockController.BlockSet(1); // 블럭 세팅
				for (int y = 0; y < 17; y++) { // 블럭 겹쳤는지 검사
					for (int x = 0; x < 10; x++) {
						if (DataBase.slot[y][x] > 2) {
							three = true;
						}
					}
				}
				if (three) { // 블럭이 겹쳤으면
					int a  = Integer.parseInt(b); // 예외 발생
				} else { // 겹친게 아니라면
					MovingDel();
					BlockController.BlockSet(1); // 블럭 세팅
				}
			} catch (Exception k) { // 겹치기 이전으로 상황 변경
				try {
					switch (val) {
					case 37: { // 왼
						++DataBase.x;
						int a  = Integer.parseInt(b);
						break;
					}
					case 38: { // 위
						if (DataBase.angle != 0)
							DataBase.angle--;
						else // 0
							DataBase.angle = 4;

						int a  = Integer.parseInt(b);
						break;
					}
					case 39: { // 오른
						--DataBase.x;
						int a  = Integer.parseInt(b);
						break;
					}
					case 40: { // 아래
						--DataBase.y;
						int a  = Integer.parseInt(b);
						break;
					}
					}
				} catch (Exception r) {
					MovingDel();
					BlockController.BlockSet(1); // 블럭 세팅
				}
			}
		}
	}

	public static void MovingDel() { // 이동을 위해 제거 (1인 데이터 제거)
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

	public static void Check() { // 한줄이 다 찼는지 검사하는 함수
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
						} catch (Exception e) { }
					}
				}
				DataBase.cleared ++;
			}
		}
	}

	public static void Down() { // 아래로 이동하는 함수
		MovingDel(); // 이동을 위해 제거
		try {
			++DataBase.y; // 이동
			BlockController.BlockSet(1); // 블럭 세팅
			for (int y = 0; y < 17; y++) { // 블럭과 충돌 검사
				for (int x = 0; x < 10; x++) {
					if (DataBase.slot[y][x] >= 3) { // 충돌시
						MovingDel();
						OnEnter();
					}
				}
			}
		} catch (Exception e) { // 바닥 충돌
			try {
				MovingDel();
				BlockController.BlockSet(1); // 블럭 세팅
				return;
			} catch (Exception l) { }
			OnEnter(); // 충돌
		}
	}

	public static void OnEnter() { // 충돌 함수
		MovingDel();
		if (ishold) {
			ishold = false;
		}
		if (DataBase.y == 0) { // 만약 충돌 위치가 0 이면
			GameOver(); // 패배
			return;
		} else { // 그렇지 않다면
			--DataBase.y; // 충돌 이전 위치로 이동
			BlockController.BlockSet(2); // 블럭 세팅
			Check();
			// ---------------------------------------------
			NewBlockSet();
		}
	}
	static boolean first = false; // 이전 hold 가 0 이었는
	public static void Hold() {
		ishold = true;
		MovingDel();
		int a = 0;
		if (DataBase.hold == 0) {
			DataBase.hold = DataBase.val + 1;
			first = true;
		} else {
			a = DataBase.hold - 1;
			DataBase.hold = DataBase.val + 1;
			DataBase.val = a;
		}
		NewBlockSet();
	}

	public static void NewBlockSet() { // 새로운 블럭 생성
		if (!ishold || first) {
			if (first)
				first = false;
			DataBase.val = DataBase.next[0];
		 // ------------------------------------------------		
			for (int i = 0; i < DataBase.next.length; i++) { //next 에 있는 변수들 땡기기 
				try {
					DataBase.next[i] = DataBase.next[i + 1];
				} catch (Exception k) { break; }
			}
			while (true) { // 이전 턴과 다른 변수 생성 
				DataBase.next[3] = (int) main.random.nextInt(7); // 6
				if (DataBase.next[2] != DataBase.next[3])
					break;
			}
		}
		//---------------------------------------------------
		DataBase.x = 4;
		DataBase.y = 0;
		DataBase.angle = 0;
	}

	public static void GameOver() { // 게임패배
		DataBase.gameover = true;
	}
}