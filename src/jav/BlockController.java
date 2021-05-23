package jav;

public class BlockController {

	static int r = 30;

	public static void BlockSet(int valu) {
		switch (DataBase.val) {
		case 0: { // l자 블럭
			if ((DataBase.angle % 2) == 1) { // 0 or 180
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 2][DataBase.x] += valu;
			} else { // 90 or 270
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 2] += valu;
			}
			return;
		}
		case 1: {// ㅁ자 모양 블럭
			DataBase.slot[DataBase.y][DataBase.x] += valu;
			DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
			DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
			return;
		}
		case 2: {// ㄱ자 블럭
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y - 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				return;
			}
			case 3: {
				if (DataBase.y == 0)
					DataBase.y++;
				DataBase.slot[DataBase.y - 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 3: { // ㄱ 반대블럭
			switch (DataBase.angle) {
			case 0: {
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				return;
			}
			case 1: {
				if (DataBase.y == 0)
					DataBase.y++;
				DataBase.slot[DataBase.y - 1][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y - 1][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;
				return;
			}
			}
		}
		case 4: {// ㅗ자 블럭
			switch (DataBase.angle) {
			case 0: {
				if (DataBase.y == 0)
					DataBase.y++;
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				return;
			}
			case 1: {
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			case 2: {
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				return;
			}
			case 3: {
				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x - 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				return;
			}
			}
			return;
		}
		case 5: {// ㄹ자 블럭
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
		case 6: {
			if ((DataBase.angle % 2) == 1) { // 0 or 180

				DataBase.slot[DataBase.y - 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x + 1] += valu;

			} else {
				DataBase.slot[DataBase.y][DataBase.x + 1] += valu;
				DataBase.slot[DataBase.y][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x] += valu;
				DataBase.slot[DataBase.y + 1][DataBase.x - 1] += valu;

			}
		}
		}
	}

	public static void NextBlockPrint() {
		int x = 530;
		int y = 250;
		for (int i = 0; i < 4; i++) {
			DrawBlocks(DataBase.next[i], x, y + 100 * i );
		}
	}

	public static void DrawBlocks(int val,int x,int y) { 
		switch (val) {
			case 0: { // l자 블럭
				for (int a = 0; a < 4; a++) {
					Ui.frame.getGraphics().drawRect(x - 15 + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x - 15 + (a * r), y, r, r);
				}
				return;
			} case 1: {// ㅁ자 모양 블럭
				for (int a = 0; a < 2; a ++) {
					Ui.frame.getGraphics().drawRect(x+15 + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x+15 + (a * r), y, r, r);
					Ui.frame.getGraphics().drawRect(x+15 + (a * r), y + r, r, r);
					Ui.frame.getGraphics().fillRect(x+15 + (a * r), y + r, r, r);
				}
				return;
			} case 2: {// ㄱ자 블럭
				for (int a = 0; a < 3; a++) {
					Ui.frame.getGraphics().drawRect(x + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x + (a * r), y, r, r);
				}
				Ui.frame.getGraphics().drawRect(x + (2 * r), y + r, r, r);
				Ui.frame.getGraphics().fillRect(x + (2 * r), y + r, r, r);
				
				return;
			} case 3: { // ㄱ 반대블럭
				for (int a = 0; a < 3; a++) {
					Ui.frame.getGraphics().drawRect(x + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x + (a * r), y, r, r);
				}
				Ui.frame.getGraphics().drawRect(x, y + r, r, r);
				Ui.frame.getGraphics().fillRect(x, y + r, r, r);
				return;
			} case 4: {// ㅗ자 블럭
				for (int a = 0; a < 3; a++) {
					Ui.frame.getGraphics().drawRect(x + (a * r), y + r, r, r);
					Ui.frame.getGraphics().fillRect(x + (a * r), y + r, r, r);
				}
				Ui.frame.getGraphics().drawRect(x + r, y, r, r);
				Ui.frame.getGraphics().fillRect(x + r, y, r, r);
				return;
			} case 5: {// ㄹ자 블럭
				for (int a = 0 ; a < 2; a ++ ) {
					Ui.frame.getGraphics().drawRect(x + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x + (a * r), y, r, r);
					Ui.frame.getGraphics().drawRect(x + (2 * (a * r)), y + r, r, r);
					Ui.frame.getGraphics().fillRect(x + (2 * (a * r)), y + r, r, r);
				}
				return;
			} case 6: { // ㄹ 반대 블럭 
				for (int a = 0 ; a < 2; a ++ ) {
					Ui.frame.getGraphics().drawRect(x + (2 * (a * r)), y + r, r, r);
					Ui.frame.getGraphics().fillRect(x + (2 * (a * r)), y + r, r, r);
					Ui.frame.getGraphics().drawRect(x + (a * r), y, r, r);
					Ui.frame.getGraphics().fillRect(x + (a * r), y, r, r);
				}
				return;
			}
		}
	}
}
