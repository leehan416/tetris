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

	public void BlockSet(int val, int x, int y) { // �� �����ϴ� �Լ�
		// ToDoList : ���� �Ʒ��ִ� ������ �����ϴ� �Լ��� �ٽ� ¥����
		switch (val) {
		case 0: // �� �� ��
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
		case 1: // �� �� ��
			DataBase.instance.slot[y][x] = 1;
			DataBase.instance.slot[y][x + 1] = 1;
			DataBase.instance.slot[y + 1][x] = 1;
			DataBase.instance.slot[y + 1][x + 1] = 1;
			break;
		case 2: // �� �� ��
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
		ZeroSet(); // ��ġ�� ���� ���� ���ϴ� �������� �����Ұ�
		try {
			BlockSet(DataBase.instance.val, DataBase.instance.x, ++DataBase.instance.y);
		} catch (Exception e) {
			BlockSet(DataBase.instance.val, DataBase.instance.x, --DataBase.instance.y);
			OnEnter();
			return;
		}

	public void OnEnter() { // �浹(����)��
		DataBase.instance.x = 4;
		DataBase.instance.y = -1;

	}
}
