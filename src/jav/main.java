package jav;

public class main {
	static void print() { // ��� �Լ�
		for (int h = 0; h > DataBase.slot.length; h++) {
			for (int w = 0; w > DataBase.slot.length; w++) {
				System.out.print(DataBase.slot[h][w]);
			}
		}
	}

	public static void main(String[] args) {
		for (;;) {
			print();
			//ToDoList : ������ ���� �����.
		}
	}
}
