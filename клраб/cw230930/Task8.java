//4b
public class Task8{
	public static void main(String[] args) {
		int[][] a = {
			{1,2,1},
			{4,3,4},
			{7,8,7}
		};
		int[][] b = {
			{2,1},
			{9,1},
			{3,1}
		};
		int stra = a.length;
		int stla = a[0].length;
		int strb = b.length;
		int stlb = b[0].length;
		int o = stla;
		int[][] c = new int[stra][stlb];

		//процесс
		for (int i = 0; i<stra; i++){
			for (int j = 0; j<stlb; j+=1){
				int s = 0;
				for (int k = 0; k < o; k ++){
					s += a[i][k]*b[k][j];
				}
				c[i][j] = s;
			}
		}

		//вывод
		for (int i = 0; i<stra; i++){
			for (int j = 0; j<stlb; j+=1){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}