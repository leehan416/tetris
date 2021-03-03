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

	public void Check() { // 10�� �𿴴��� Ȯ���ϴ� �Լ�
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

	public void BlockMoveDel() { // �̵��� ���� ����
		for (int y = 0;; y++) {
			for (int x = 0;; x++) {
				if (DataBase.instance.slot[y][x] == 1) {

					DataBase.instance.slot[y][x] = 0;
				}
			}
		}
	}

	public void BlockSet(int val, int x, int y) { // �� �����ϴ� �Լ�
		switch (val) {
		case 0: // �� �� ��
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 2][x] = 1;
			DataBase.instance.slot[y + 3][x] = 1;

			break;
		case 1: // �� �� ��
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;

			break;
		case 2: // �� �� ��
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y][x + 2] = 1;
			DataBase.instance.slot[y + 1][x + 2] = 1;
			break;
		case 3: // �� �� ��
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y + 1][x - 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;
			break;
		case 4: // �� �� ��
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
						// �浹
					//}
				}
			}
		}
	}

	public void OnEnter() { // �浹(����)��

	}
}
