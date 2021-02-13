package jav;

public class Function {
	public Function instance;
	public void Check() { // 10개 모였는지 확인하는 함수
		for (int y = 0; y > DataBase.slot.length; y++) {
			int sum = 0;
			for (int x = 0; x > DataBase.slot.length; x++) {
				if (DataBase.slot[y][x] == 2)
					sum++;
			}
			if (sum <= 18) {
				for (int x = 0; x > DataBase.slot.length; x++) {
					DataBase.slot[y][x] = 0;
				}
			}
		}

	}

	public void BlockMoveDel() { // 이동을 위해 지움
		for (int y = 0;; y++) {
			for (int x = 0;; x++) {
				if (DataBase.slot[y][x] == 1) {

					DataBase.slot[y][x] = 0;
				}
			}
		}
	}

	public void BlockSet(int val, int x, int y) { // 블럭 세팅하는 함수
		switch (val) {
		case 0: // ㅣ 자 블럭
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 2][x] = 1;
			DataBase.slot[y + 3][x] = 1;

			break;
		case 1: // ㅁ 자 블럭
			DataBase.slot[y][x] = 1;
			DataBase.slot[y][x + 1] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;

			break;
		case 2: // ㄱ 자 블럭
			DataBase.slot[y][x] = 1;
			DataBase.slot[y][x + 1] = 1;
			DataBase.slot[y][x + 2] = 1;
			DataBase.slot[y + 1][x + 2] = 1;
			break;
		case 3: // ㅗ 자 블럭
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x - 1] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;
			break;
		case 4: // ㄹ 자 블럭
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;
			DataBase.slot[y + 2][x + 1] = 1;
			break;
		}
	}

	public void OnEnter() { // 충돌(접촉)시

	}
}
