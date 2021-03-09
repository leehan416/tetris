package jav;

public class Function { // ���� �Լ� ���� Ŭ����
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
			case 37: { // ��
				--DataBase.x;
				BlockSet();
				break;
			}
			case 38: { // ��
				break;
			}
			case 39: { // ����
				++DataBase.x;
				BlockSet();
				break;
			}
			case 40: { // �Ʒ�
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

	public void Check() { // 10�� �𿴴��� Ȯ���ϴ� �Լ�
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

	int valu = 1; // ��ϼ�ġ�� 2�� �����Ͽ� ��ġ

	public void BlockSet() { // �� �����ϴ� �Լ�
		// ToDoList : ���� �Ʒ��ִ� ������ �����ϴ� �Լ��� �ٽ� ¥����

		switch (DataBase.val) {
		case 0: { // �� �� ��
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
		case 1: {// �� �� ��
			DataBase.slot[DataBase.y][DataBase.x] += valu;
			DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			break;
		}
		case 2: {// �� �� ��
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
		case 3: {// �� �� ��

			break;
		}
		case 4: {// �� �� ��

			break;
		}
		}

	}

	public void Down() {
		MovingDel();
		try {
			try {
				// TODO �����浹 ������
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

	public void OnEnter() { // �浹(����)��
		--DataBase.y;
		valu++;
		BlockSet();
		valu--;
		Check();
		DataBase.x = 4;
		DataBase.y = -1;

	}
}
