package jav;

public class Function {
	public Function instance;
	public void Check() { // 10�� �𿴴��� Ȯ���ϴ� �Լ�
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

	public void BlockMoveDel() { // �̵��� ���� ����
		for (int y = 0;; y++) {
			for (int x = 0;; x++) {
				if (DataBase.slot[y][x] == 1) {

					DataBase.slot[y][x] = 0;
				}
			}
		}
	}

	public void BlockSet(int val, int x, int y) { // �� �����ϴ� �Լ�
		switch (val) {
		case 0: // �� �� ��
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 2][x] = 1;
			DataBase.slot[y + 3][x] = 1;

			break;
		case 1: // �� �� ��
			DataBase.slot[y][x] = 1;
			DataBase.slot[y][x + 1] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;

			break;
		case 2: // �� �� ��
			DataBase.slot[y][x] = 1;
			DataBase.slot[y][x + 1] = 1;
			DataBase.slot[y][x + 2] = 1;
			DataBase.slot[y + 1][x + 2] = 1;
			break;
		case 3: // �� �� ��
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x - 1] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;
			break;
		case 4: // �� �� ��
			DataBase.slot[y][x] = 1;
			DataBase.slot[y + 1][x] = 1;
			DataBase.slot[y + 1][x + 1] = 1;
			DataBase.slot[y + 2][x + 1] = 1;
			break;
		}
	}

	public void OnEnter() { // �浹(����)��

	}
}
