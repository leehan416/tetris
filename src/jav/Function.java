package jav;

public class Function { // ���� �Լ� ���� Ŭ����

	public static int valu = 1; // ��ϼ�ġ�� 2�� �����Ͽ� ��ġ

	public static void ZeroSet() { // ���� �����ϴ� �Լ�
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
		}
	}

	public static void Move(int val) { // �� �̵� �Լ�
		MovingDel();
		try {
			switch (val) {
			case 37: { // ��
				--DataBase.x;
				break;
			}
			case 38: { // ��
				if (DataBase.angle < 4)
					DataBase.angle++;
				else
					DataBase.angle = 0;
				break;
			}
			case 39: { // ����
				++DataBase.x;
				break;
			}
			case 40: { // �Ʒ�
				++DataBase.y;
				break;
			}
			}
			BlockSet();
		} catch (Exception e) {
		}
	}

	public static void MovingDel() { // �̵����� �� ����
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

	public static void Check() { // 10�� �� ���� Ȯ��, ���� ����, �� �б� �ϴ� �Լ�
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

	public static void BlockSet() { // �� �����ϴ� �Լ�
		// ToDoList : ���� �Ʒ��ִ� ������ �����ϴ� �Լ��� �ٽ� ¥����

		switch (DataBase.val) {
		case 0: { // �� �� ��
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
		case 4: {// �� �� ��
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

	public static void Down() { // �� �ϰ� �Լ�
		MovingDel();
		try {
			++DataBase.y;
			BlockSet();
			for (int y = 0; y < 10; y++) { // �� �浹 �˻�
				for (int x = 0; x < 10; x++) {
					if (DataBase.slot[y][x] >= 3) { // �浹��
						MovingDel();
						OnEnter();
					}
				}
			}
		} catch (Exception e) { // �� �浹
			OnEnter();
		}
	}

	public static void OnEnter() { // �浹(����)��
		--DataBase.y;
		valu++;
		BlockSet();
		valu--;
		Check();
		DataBase.x = 4;
		DataBase.y = -1;

	}
}
