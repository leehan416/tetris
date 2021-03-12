package jav;

public class Function { // 각종 함수 모음 클래스

	public static int valu = 1; // 블록설치시 2로 변경하여 설치

	public static void BlockSet() { // 블럭 세팅하는 함수
		// ToDoList : 가장 아래있는 블럭으로 세팅하는 함수로 다시 짜야함

		switch (DataBase.val) {
		case 0: { // ㅣ 자 블럭
			if ((DataBase.angle % 2) == 1) { // 0 or 180
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 3][DataBase.x] += valu;
			} else { // 90 or 270
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
			}
			return;
		}
		case 1: {// ㅁ 자 블럭
			DataBase.slot[DataBase.y][DataBase.x] += valu;
			DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			return;
		}
		case 2: {// ㄱ 자 블럭
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 2] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x - 1] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 2] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 3: {// ㅗ 자 블럭
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 4: {// ㄹ 자 블럭
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
		}
		}
	}

	public static void ZeroSet() { // 전부 제거하는 함수
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
		}
	}

	public static void Move(int val) { // 블럭 이동 함수
		String b = "b"; // 예외 발생용 변수
		boolean three = false; // 각도 변경시 블럭 겹치는지 판별시 사용
		MovingDel();
		try {
			switch (val) {
			case 37: { // 왼
				--DataBase.x;
				valu = Integer.parseInt(b); // 예외 발생
				break;
			}
			case 38: { // 위
				if (DataBase.angle < 3)
					DataBase.angle++;
				else
					DataBase.angle = 0;
				// --------------------------
				BlockSet();
				for (int y = 0; y < 10; y++) { // 블럭 돌릴때 다른 블럭에 간섭 있는지 확인
					for (int x = 0; x < 10; x++) {
						if (DataBase.slot[y][x] > 2) {
							three = true;
						}
					}
				}
				// -------------------------

				valu = Integer.parseInt(b);
				break;
			}
			case 39: { // 오른
				++DataBase.x;
				valu = Integer.parseInt(b);
				break;
			}
			case 40: { // 아래
				++DataBase.y;
				valu = Integer.parseInt(b);
				break;
			}
			}

		} catch (Exception e) { // 예외 처리
			try {
				if (three) { // 회전시에 다른 블럭 건들이면
					valu = Integer.parseInt(b); //예외처리
				} else {
					MovingDel();
					BlockSet();
				}
			} catch (Exception k) { // 벽 충돌
				try {
					switch (val) {
					case 37: { // 왼
						++DataBase.x;
						valu = Integer.parseInt(b);
						break;
					}
					case 38: { // 위
						if (DataBase.angle != 0)
							DataBase.angle--;
						else // 0
							DataBase.angle = 4;

						valu = Integer.parseInt(b);
						break;
					}
					case 39: { // 오른
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

	public static void MovingDel() { // 이동중인 블럭 제거
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (DataBase.slot[y][x] < 2) {
					DataBase.slot[y][x] = 0;
				} else {
					DataBase.slot[y][x] = 2;
				}
			}
		}
	}

	public static void Check() { // 10개 모였 는지 확인, 한줄 제거, 블럭 뗑기기 하는 함수
		for (int y = 0; y < 10; y++) {
			int sum = 0;
			for (int x = 0; x < 10; x++) { // 10 개 모였는지 검사
				if (DataBase.slot[y][x] > 1)
					sum++;
			}
			// --------------------------------------------------
			if (sum > 9) { // 모였으면
				for (int x = 0; x < 10; x++) {
					DataBase.slot[y][x] = 0; // 블럭 한줄 제거
				}
				// --------------------------------------------------
				for (int h = y; h > -1; h--) { // 블럭 떙기기
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

	public static void Down() { // 블럭 하강 함수
		MovingDel();
		try {
			++DataBase.y;
			BlockSet();
			for (int y = 0; y < 10; y++) { // 블럭 충돌 검사
				for (int x = 0; x < 10; x++) {
					if (DataBase.slot[y][x] >= 3) { // 충돌시
						MovingDel();
						OnEnter();
					}
				}
			}
		} catch (Exception e) { // 땅 or 벽 충돌
			try {
				BlockSet(); // 벽 충돌
				return;
			} catch (Exception l) {
			}
			OnEnter();
		}
	}

	public static void OnEnter() { // 충돌(접촉)시
		if (DataBase.y == 0) { // 블럭이 천장에 있으면
			GameOver();
			return;
		} else {
			--DataBase.y; // 충돌로 인해 문제가 발생하였으므로 y 를 이전으로 이동
			valu++;// 블럭 설치 위해 2로 변경
			BlockSet(); // 블럭 설치
			valu--;
			Check();
			DataBase.val = (int) main.random.nextInt(4); // 4
			DataBase.x = 4;
			DataBase.y = 0;
			DataBase.angle = 0;
		}
	}

	public static void GameOver() {
		DataBase.gameover = true;
	}
}
