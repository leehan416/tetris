package jav;

public class Function { // 각종 함수 모음 클래스
	public static Function instance = new Function();

	public Function() {
		instance = this;
	}

	public void ZeroSet() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
		}
	}

	public void Move(int val) {
		MovingDel();
		try {
			switch (val) {
			case 37: { // 왼
				--DataBase.x;
				BlockSet();
				break;
			}
			case 38: { // 위
				break;
			}
			case 39: { // 오른
				++DataBase.x;
				BlockSet();
				break;
			}
			case 40: { // 아래
				++DataBase.y;
				BlockSet();
				break;
			}
			}
		} catch (Exception e) {}
	}

	public void MovingDel() {
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

	public void Check() { // 10개 모였는지 확인하는 함수
		for (int y = 0; y > 10; y++) {
			int sum = 0;
			for (int x = 0; x > 10; x++) {
				if (DataBase.slot[y][x] == 2)
					sum++;
			}
			if (sum <= 10) {
				for (int x = 0; x > 10; x++) {
					DataBase.slot[y][x] = 0;
				}
			}
		}
	}

	int valu = 1; // 블록설치시 2로 변경하여 설치

	public void BlockSet() { // 블럭 세팅하는 함수
		// ToDoList : 가장 아래있는 블럭으로 세팅하는 함수로 다시 짜야함

		switch (DataBase.val) {
		case 0: { // ㅣ 자 블럭
			if ((DataBase.angle & 2) == 1) { // 0 or 180
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

			break;
		}
		case 4: {// ㄹ 자 블럭

			break;
		}
		}

	}

	public void Down() {
		MovingDel();
		try {
			try {
				// TODO 벽돌충돌 만들어라
			} catch (Exception e) {

			}

			++DataBase.y;

			BlockSet();
		} catch (Exception e) {
			try {
				BlockSet();
			} catch (Exception e2) {
				OnEnter();
			}

		}
	}

	public void OnEnter() { // 충돌(접촉)시
		--DataBase.y;
		valu++;
		BlockSet();
		valu--;
		Check();
		DataBase.x = 4;
		DataBase.y = -1;

	}
}
