package jav;

public class main {
	static void print() { // 출력 함수
		for (int h = 0; h < DataBase.instance.slot.length; h++) {
			for (int w = 0; w < DataBase.instance.slot.length; w++) {
				if (DataBase.instance.slot[h][w] > 0) {
					System.out.print("■");
				} else if (DataBase.instance.slot[h][w] == 0) {

					System.out.print("□");
				}

				// System.out.print(DataBase.instance.slot[h][w]);
			}
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		Function.instance.ZeroSet();
		for (;;) {
			if (DataBase.instance.roof > 10) {
				break;
			}
			print();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			DataBase.instance.roof++;
		}
	}
}