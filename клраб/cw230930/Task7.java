//4a
public class Task7{
	public static void main(String[] args) {
		int[][] a = {
			{0,1,2,3,4},
			{1,2,3,4,5},
			{2,3,4,5,6},
			{3,4,5,6,7},
			{4,5,6,7,8},
			{5,6,7,8,9},
		};
		int[][] b = {
			{10,10,10,10,10},
			{10,10,10,10,10},
			{10,10,10,10,10},
			{10,10,10,10,10},
			{10,10,10,10,10},
			{10,10,10,10,10},
		};
		int str = a.length;
		int stl = a[0].length;
		int[][] c = new int[str][stl];
		for (int i = 0; i<str; i++){
			for (int j = 0; j<stl; j+=1){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		for (int i = 0; i<str; i++){
			for (int j = 0; j<stl; j+=1){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}