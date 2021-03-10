package jav;

public class Function { // 각종 함수 모음 클래스

	public static int valu = 1; // 블록설치시 2로 변경하여 설치

	public static void ZeroSet() { // 전부 제거하는 함수
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
		}
	}

	public static void Move(int val) { // 블럭 이동 함수
		MovingDel();
		try {
			switch (val) {
			case 37: { // 왼
				--DataBase.x;
				break;
			}
			case 38: { // 위
				if (DataBase.angle < 4)
					DataBase.angle++;
				else
					DataBase.angle = 0;
				break;
			}
			case 39: { // 오른
				++DataBase.x;
				break;
			}
			case 40: { // 아래
				++DataBase.y;
				break;
			}
			}
			BlockSet();
		} catch (Exception e) {
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

	public static void Check() { // 10개 모였 는지 확인, 한줄 제거, 블럭 밀기 하는 함수
		for (int y = 0; y < 10; y++) {
			int sum = 0;
			for (int x = 0; x < 10; x++) {
				if (DataBase.slot[y][x] > 1)
					sum++;
			}

			// --------------------------------------------------
			if (sum > 9) {
				for (int x = 0; x < 10; x++) {
					DataBase.slot[y][x] = 0;
				}
				// --------------------------------------------------
				for (int h = 9; h > 0; h--) {
					for (int x = 9; x > 0; x--) {
						if (DataBase.slot[h][x] > 1) {
							DataBase.slot[h + 1][x] = DataBase.slot[h][x];// =2
							DataBase.slot[h][x] = 0;
						}
					}
				}
			}
		}
	}

	public static void BlockSet() { // 블럭 세팅하는 함수
		// ToDoList : 가장 아래있는 블럭으로 세팅하는 함수로 다시 짜야함

		switch (DataBase.val) {
		case 0: { // ㅣ 자 블럭
			if ((DataBase.angle % 2) == 1) { // 0 or 180
				DataBase.slot[DataBase.y - 2][DataBase.x] += valu;
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			} else { // 90 or 270
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
			}
			break;
		}
		case 1: {// ㅁ 자 블럭
			DataBase.slot[DataBase.y][DataBase.x] += valu;
			DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			break;
		}
		case 2: {// ㄱ 자 블럭
			switch (DataBase.angle) {
			case 0: {

				break;
			}
			case 1: {

				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			}

			break;
		}
		case 3: {// ㅗ 자 블럭

			switch (DataBase.angle) {
			case 0: {

				break;
			}
			case 1: {

				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			}
		}
		case 4: {// ㄹ 자 블럭
			switch (DataBase.angle) {
			case 0: {

				break;
			}
			case 1: {

				break;
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
		} catch (Exception e) { // 땅 충돌
			OnEnter();
		}
	}

	public static void OnEnter() { // 충돌(접촉)시
		--DataBase.y;
		valu++;
		BlockSet();
		valu--;
		Check();
		DataBase.x = 4;
		DataBase.y = -1;

	}
}
