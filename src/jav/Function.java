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

	public void BlockMoveDel() { // 이동을 위해 지움
		for (int y = 0;; y++) {
			for (int x = 0;; x++) {
				if (DataBase.instance.slot[y][x] == 1) {

					DataBase.instance.slot[y][x] = 0;
				}
			}
		}
	}

	public void BlockSet(int val, int x, int y) { // 블럭 세팅하는 함수
		switch (val) {
		case 0: // ㅣ 자 블럭
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 2][x] = 1;
			DataBase.instance.slot[y + 3][x] = 1;

			break;
		case 1: // ㅁ 자 블럭
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;

			break;
		case 2: // ㄱ 자 블럭
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
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (DataBase.instance.slot[y][x] <= 1) {
					//try {
						DataBase.instance.slot[y][x]--;
						DataBase.instance.slot[y + 1][x]++;
					//} catch (Exception e) {
						// 충돌
					//}
				}
			}
		}
	}

	public void OnEnter() { // 충돌(접촉)시

	}
}
