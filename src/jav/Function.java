package jav;

public class Function {

	public static int valu = 1;
	public static boolean ishold = false;
	public static void BlockSet() {
		switch (DataBase.val) {
			case 0: { // l자 블럭
				if ((DataBase.angle % 2) == 1) { // 0 or 180
					DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				} else { // 90 or 270
					DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
					DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				}
				return;
			} case 1: {// ㅁ자 모양 블럭
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			} case 2: {// ㄱ자 블럭
				switch (DataBase.angle) {
					case 0: {
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
						return;
					} case 1: {
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu; 
						return;
					} case 2: {
						DataBase.slot[DataBase.y - 1][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						return;
					} case 3: {
						if (DataBase.y == 0)
							DataBase.y++;
						DataBase.slot[DataBase.y - 1][DataBase.x + 1] += valu;
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						return;
					}
				}
				return;
			} case 3: { // ㄱ 반대블럭
				switch (DataBase.angle) {
					case 0: {
						DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						return;
					} case 1: {
						if (DataBase.y == 0)
						DataBase.y++;
						DataBase.slot[DataBase.y - 1][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						return;
					} case 2: {
						DataBase.slot[DataBase.y - 1][DataBase.x + 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						return;
					} case 3: {
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
						return;
					}
				}
			} case 4: {// ㅗ자 블럭
				switch (DataBase.angle) {
					case 0: {
						if (DataBase.y == 0)
						DataBase.y++;
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						return;
					} case 1: {
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						return;
					} case 2: {
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
						return;
					} case 3: {
						DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x] += valu;
						DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
						DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
						return;
					}
				}
				return;
			} case 5: {// ㄹ자 블럭
				if ((DataBase.angle % 2) == 1) { // 0 or 180
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
					DataBase.slot[DataBase.y + 2][DataBase.x - 1] += valu;
				} else {
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				}
				return;
			} case 6: {
				if ((DataBase.angle % 2) == 1) { // 0 or 180

					DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
	
				} else {
					DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
					DataBase.slot[DataBase.y][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
					DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
					
					
				}
			}
		}
	}

	public static void ZeroSet() { // 맵 초기화 함수
		for (int y = 0; y < 17; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
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
					valu = Integer.parseInt(b); // 예외 발생
					break;
				} case 38: { // 위쪽 키
					if (DataBase.angle < 3)
						DataBase.angle++;
					else
						DataBase.angle = 0;
					valu = Integer.parseInt(b);
					break;
				} case 39: { // 오른 쪽
					++DataBase.x;
					valu = Integer.parseInt(b);
					break;
				} case 40: { // 아래 키
					++DataBase.y;
					valu = Integer.parseInt(b);
					break;
				}
			}
		} catch (Exception e) { 
			try {
				BlockSet();
				for (int y = 0; y < 17; y++) { // 블럭 겹쳤는지 검사
					for (int x = 0; x < 10; x++) {
						if (DataBase.slot[y][x] > 2) {
							three = true;
						}
					}
				}
				if (three) { // 블럭이 겹쳤으면
					valu = Integer.parseInt(b); // 예외 발생
				} else { // 겹친게 아니라면
					MovingDel();
					BlockSet();
				}
			} catch (Exception k) { // 겹치기 이전으로 상황 변경
				try {
					switch (val) {
						case 37: { // 왼
							++DataBase.x;
							valu = Integer.parseInt(b);
							break;
						} case 38: { // 위
							if (DataBase.angle != 0)
								DataBase.angle--;
							else // 0
								DataBase.angle = 4;
	
							valu = Integer.parseInt(b);
							break;
						} case 39: { // 오른
							--DataBase.x;
							valu = Integer.parseInt(b);
							break;
						}
						case 40: { // 아래
							--DataBase.y;
							valu = Integer.parseInt(b);
							break;
						}
					}
				} catch (Exception r) {
					MovingDel();
					BlockSet();
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
						} catch (Exception e) {
						}
					}
				}
			}
		}
	}

	public static void Down() { // 아래로 이동하는 함수
		MovingDel(); // 이동을 위해 제거
		try {
			++DataBase.y; // 이동
			BlockSet(); // 다시 블럭 세팅
			for (int y = 0; y < 17; y++) { // 블럭과 충돌 검사
				for (int x = 0; x < 10; x++) {
					if (DataBase.slot[y][x] >= 3) { // 충돌시
						MovingDel();
						OnEnter();
					}
				}
			}
		} catch (Exception e) { // 바닥 충돌 or 게임 패배 
			try {
				BlockSet(); // �� �浹
				return;
			} catch (Exception l) { }
			OnEnter(); // 충돌
		}
	}

	public static void OnEnter() { // 충돌 함수
		if (DataBase.y == 0) { // 만약 충돌 위치가 0 이면
			GameOver(); // 패배
			return;
		} else { // 그렇지 않다면
			--DataBase.y; // 충돌 이전 위치로 이동
			valu++;// 블럭 설치를 위해 변수 활
			BlockSet(); // 블럭 세팅
			valu--;
			Check();
			// ---------------------------------------------
			NewBlockSet();
		}
	}
	public static void Hold () {
		ishold = true;
		MovingDel();
		NewBlockSet();
	}
	
	public static void NewBlockSet() { // 새로운 블럭 생성
		if (ishold) {
			int a = 0;
			if (DataBase.hold != 0) {
				a = DataBase.hold;
				DataBase.hold = DataBase.val;
				DataBase.val = a;
			} else {
				DataBase.hold = DataBase.val;
				//---------------------------------
				//TODO 이 부분 최적화 해야함 
				DataBase.val = DataBase.next[0];
				for (int i = 0; i < DataBase.next.length; i ++) {
					try {
						DataBase.next [i] = DataBase.next[i+1];
					} catch(Exception k ) { break; }	
				}
				while (true) {
					DataBase.next[3] = (int) main.random.nextInt(7); // 6		
					if (DataBase.next[2] != DataBase.next[3])
						break;
				}
				//-------------------------------
			}
		} else {
			DataBase.val = DataBase.next[0];
			for (int i = 0; i < DataBase.next.length; i ++) {
				try {
					DataBase.next [i] = DataBase.next[i+1];
				} catch(Exception k ) { break; }	
			}
			while (true) {
				DataBase.next[3] = (int) main.random.nextInt(7); // 6		
				if (DataBase.next[2] != DataBase.next[3])
					break;
			}
		}
		DataBase.x = 4;
		DataBase.y = 0;
		DataBase.angle = 0;
	}

	public static void GameOver() { // 게임패배
		DataBase.gameover = true;
	}
}