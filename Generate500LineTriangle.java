public class Generate500LineTriangle {
	public static void main (String[] args) {
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print((int) ((Math.random() * 200) - 100) + "    ");
			}
			System.out.print("\n");
		}
	}
}