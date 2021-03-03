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
			}
				System.out.println("");
			
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Function.instance.ZeroSet();
		
		Function.instance.BlockSet(1,4,0);
		
		
		for (;;) {
			
			if (DataBase.instance.roof > 10) { // test
				break;
			}
			print();
			
			
			
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Function.instance.Down();
			
			
			
			
			
			
			
			
			
			
			DataBase.instance.roof++;
		}
	}
}