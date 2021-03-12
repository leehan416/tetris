package jav;

public class Function { // ���� �Լ� ���� Ŭ����

	public static int valu = 1; // ��ϼ�ġ�� 2�� �����Ͽ� ��ġ

	public static void BlockSet() { // �� �����ϴ� �Լ�
		// ToDoList : ���� �Ʒ��ִ� ������ �����ϴ� �Լ��� �ٽ� ¥����

		switch (DataBase.val) {
		case 0: { // �� �� ��
			if ((DataBase.angle % 2) == 1) { // 0 or 180
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 3][DataBase.x] += valu;
			} else { // 90 or 270
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
			}
			return;
		}
		case 1: {// �� �� ��
			DataBase.slot[DataBase.y][DataBase.x] += valu;
			DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			return;
		}
		case 2: {// �� �� ��
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 2] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x - 1] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 2] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 3: {// �� �� ��
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 4: {// �� �� ��
			if ((DataBase.angle % 2) == 1) { // 0 or 180
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x - 1] += valu;
			} else {
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			}
			return;
		}
		}
	}

	public static void ZeroSet() { // ���� �����ϴ� �Լ�
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				DataBase.slot[y][x] = 0;
			}
		}
	}

	public static void Move(int val) { // �� �̵� �Լ�
		String b = "b"; // ���� �߻��� ����
		boolean three = false; // ���� ����� �� ��ġ���� �Ǻ��� ���
		MovingDel();
		try {
			switch (val) {
			case 37: { // ��
				--DataBase.x;
				valu = Integer.parseInt(b); // ���� �߻�
				break;
			}
			case 38: { // ��
				if (DataBase.angle < 3)
					DataBase.angle++;
				else
					DataBase.angle = 0;
				// --------------------------
				BlockSet();
				for (int y = 0; y < 10; y++) { // �� ������ �ٸ� ���� ���� �ִ��� Ȯ��
					for (int x = 0; x < 10; x++) {
						if (DataBase.slot[y][x] > 2) {
							three = true;
						}
					}
				}
				// -------------------------

				valu = Integer.parseInt(b);
				break;
			}
			case 39: { // ����
				++DataBase.x;
				valu = Integer.parseInt(b);
				break;
			}
			case 40: { // �Ʒ�
				++DataBase.y;
				valu = Integer.parseInt(b);
				break;
			}
			}

		} catch (Exception e) { // ���� ó��
			try {
				if (three) { // ȸ���ÿ� �ٸ� �� �ǵ��̸�
					valu = Integer.parseInt(b); //����ó��
				} else {
					MovingDel();
					BlockSet();
				}
			} catch (Exception k) { // �� �浹
				try {
					switch (val) {
					case 37: { // ��
						++DataBase.x;
						valu = Integer.parseInt(b);
						break;
					}
					case 38: { // ��
						if (DataBase.angle != 0)
							DataBase.angle--;
						else // 0
							DataBase.angle = 4;

						valu = Integer.parseInt(b);
						break;
					}
					case 39: { // ����
						--DataBase.x;
						valu = Integer.parseInt(b);
						break;
					}
					case 40: { // �Ʒ�
						--DataBase.y;
						valu = Integer.parseInt(b);
						break;
					}
					}
				} catch (Exception r) {
					MovingDel();
					BlockSet();
				}
			}
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

	public static void Check() { // 10�� �� ���� Ȯ��, ���� ����, �� �ı�� �ϴ� �Լ�
		for (int y = 0; y < 10; y++) {
			int sum = 0;
			for (int x = 0; x < 10; x++) { // 10 �� �𿴴��� �˻�
				if (DataBase.slot[y][x] > 1)
					sum++;
			}
			// --------------------------------------------------
			if (sum > 9) { // ������
				for (int x = 0; x < 10; x++) {
					DataBase.slot[y][x] = 0; // �� ���� ����
				}
				// --------------------------------------------------
				for (int h = y; h > -1; h--) { // �� �����
					for (int w = 0; w < 10; w++) {
						try {
							DataBase.slot[h][w] = DataBase.slot[h - 1][w];
						} catch (Exception e) {
						}
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
		} catch (Exception e) { // �� or �� �浹
			try {
				BlockSet(); // �� �浹
				return;
			} catch (Exception l) {
			}
			OnEnter();
		}
	}

	public static void OnEnter() { // �浹(����)��
		if (DataBase.y == 0) { // ���� õ�忡 ������
			GameOver();
			return;
		} else {
			--DataBase.y; // �浹�� ���� ������ �߻��Ͽ����Ƿ� y �� �������� �̵�
			valu++;// �� ��ġ ���� 2�� ����
			BlockSet(); // �� ��ġ
			valu--;
			Check();
			DataBase.val = (int) main.random.nextInt(4); // 4
			DataBase.x = 4;
			DataBase.y = 0;
			DataBase.angle = 0;
		}
	}

	public static void GameOver() {
		DataBase.gameover = true;
	}
}
