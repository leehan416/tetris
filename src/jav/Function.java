package jav;

public class Function { // ���� �Լ� ���� Ŭ����
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

	
	public void Move() {
		
	}
	
	
	
	public void MovingDel() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (DataBase.instance.slot[y][x] < 2) {
					DataBase.instance.slot[y][x] = 0;
				} else {
					DataBase.instance.slot[y][x] = 2;
				}
			}
		}
	}

	public void Check() { // 10�� �𿴴��� Ȯ���ϴ� �Լ�
		for (int y = 0; y > 10; y++) {
			int sum = 0;
			for (int x = 0; x > 10; x++) {
				if (DataBase.instance.slot[y][x] == 2)
					sum++;
			}
			if (sum <= 10) {
				for (int x = 0; x > 10; x++) {
					DataBase.instance.slot[y][x] = 0;
				}
			}
		}
	}

	int valu = 1; // ��ϼ�ġ�� 2�� �����Ͽ� ��ġ

	public void BlockSet() { // �� �����ϴ� �Լ�
		// ToDoList : ���� �Ʒ��ִ� ������ �����ϴ� �Լ��� �ٽ� ¥����

		switch (DataBase.instance.val) {
		case 0: { // �� �� ��
			if ((DataBase.instance.angle & 2) == 1) { // 0 or 180
				DataBase.instance.slot[DataBase.instance.y - 2][DataBase.instance.x] += valu;
				DataBase.instance.slot[DataBase.instance.y - 1][DataBase.instance.x] += valu;
				DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x] += valu;
				DataBase.instance.slot[DataBase.instance.y + 1][DataBase.instance.x] += valu;
			} else { // 90 or 270
				DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x + 1] += valu;
				DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x + 2] += valu;
				DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x] += valu;
				DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x - 1] += valu;
			}
			break;
		}
		case 1: {// �� �� ��
			DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x] += valu;
			DataBase.instance.slot[DataBase.instance.y][DataBase.instance.x + 1] += valu;
			DataBase.instance.slot[DataBase.instance.y + 1][DataBase.instance.x] += valu;
			DataBase.instance.slot[DataBase.instance.y + 1][DataBase.instance.x + 1] += valu;
			break;
		}
		case 2: {// �� �� ��
			switch (DataBase.instance.angle) {
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

			++DataBase.instance.y;

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
		--DataBase.instance.y;
		valu++;
		BlockSet();
		valu--;
		Check();
		DataBase.instance.x = 4;
		DataBase.instance.y = -1;

	}
}
