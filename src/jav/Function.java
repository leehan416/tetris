package jav;

public class Function {
	public static Function instance = new Function();

	public Function() {
		instance = this;
	}

	public void ZeroSet() {

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.instance.slot[y][x] = 0;
			}
		}
	}

	public void Check() { // 10개 모였는지 확인하는 함수
		for (int y = 0; y > DataBase.instance.slot.length; y++) {
			int sum = 0;
			for (int x = 0; x > DataBase.instance.slot.length; x++) {
				if (DataBase.instance.slot[y][x] == 2)
					sum++;
			}
			if (sum <= 18) {
				for (int x = 0; x > DataBase.instance.slot.length; x++) {
					DataBase.instance.slot[y][x] = 0;
				}
			}
		}
	}

	public void BlockSet(int val, int x, int y) { // 블럭 세팅하는 함수
		// ToDoList : 가장 아래있는 블럭으로 세팅하는 함수로 다시 짜야함
		switch (val) {
		case 0: // ㅣ 자 블럭
			if (DataBase.instance.angle & 2 == 1) { // 0 or 90
				DataBase.instance.slot[y - 2][x] = 1;
				DataBase.instance.slot[y - 1][x] = 1;
				DataBase.instance.slot[y][x] = 1;
				DataBase.instance.slot[y + 1][x] = 1;
			} else {
				DataBase.instance.slot[y][x + 1] = 1;
				DataBase.instance.slot[y][x + 2] = 1;
				DataBase.instance.slot[y][x] = 1;
				DataBase.instance.slot[y][x - 1] = 1;
			}
			break;
		case 1: // ㅁ 자 블럭
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;
			break;
		case 2: // ㄱ 자 블럭
			switch (angle) {
			case 0:
				DataBase.instance.slot[y][x-3] = 1;
				DataBase.instance.slot[y][x -2] = 1;
				DataBase.instance.slot[y + 1][x] = 1;
				DataBase.instance.slot[y][x + 2] = 1;
				break;
			case 1:
				DataBase.instance.slot[y][x] = 1;
				DataBase.instance.slot[y][x + 1] = 1;
				DataBase.instance.slot[y + 1][x] = 1;
				DataBase.instance.slot[y][x + 2] = 1;
				break;
			case 2:

				break;
			case 3:

				break;
			}
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y][x + 2] = 1;
			DataBase.instance.slot[y + 1][x + 2] = 1;
			break;
		case 3: // ㅗ 자 블럭
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y + 1][x - 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;
			break;
		case 4: // ㄹ 자 블럭
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;
			DataBase.instance.slot[y + 2][x + 1] = 1;
			break;
		}

	}

	public void Down() {
		ZeroSet(); // 설치된 블럭은 제거 안하는 방향으로 변경할것
		try {
			BlockSet(DataBase.instance.val, DataBase.instance.x, ++DataBase.instance.y);
		} catch (Exception e) {
			BlockSet(DataBase.instance.val, DataBase.instance.x, --DataBase.instance.y);
			OnEnter();
			return;
		}

	public void OnEnter() { // 충돌(접촉)시
		DataBase.instance.x = 4;
		DataBase.instance.y = -1;

	}
}
