public class Helper{
	public void println(Object s){
		System.out.println(s);
	}
	public void print(Object s){
		System.out.print(s);
	}
	public void clean(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e){
			println("");
		}
	}
	public void output(int[][] m){
		int rows = m.length;
		int cols = m[0].length;
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				print(m[i][j] + " ");
			}
			println("");
		}
	}
	public void mult(int[][] a, int[][] b){
		int stra = a.length;
		int stla = a[0].length;
		int strb = b.length;
		int stlb = b[0].length;
		if (stla==strb){
			int o = stla;
			int[][] c = new int[stra][stlb];
			for (int i = 0; i<stra; i++){
				for (int j = 0; j<stlb; j+=1){
					int s = 0;
					for (int k = 0; k < o; k ++){
						s += a[i][k]*b[k][j];
					}
					c[i][j] = s;
				}
			}
			output(c);
		}
		println("Это невозможно");
		
	}
	public int[][] transpose(int[][] array){
		int colsCount = array[0].length;
		int rowsCount = array.length;
		int[][] newarr = new int[colsCount][rowsCount];
		for (int i = 0; i < rowsCount; i++){
			for (int j = 0; j < colsCount; j++){
				newarr[j][i] = array[i][j]; 
			}
		}
		return newarr;
	}

	public void rank(int[][] a1){
		int row = a1.length;
		int col = a1[0].length;
		int[][] a = new int[row][col];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				a[i][j] = a1[i][j] * 1;
			}
		}
		int j = 0;
		for (int i = 0; i < row; i++){
			if (i + j == col){
				break;
			}
			if (a[i][i + j] == 0){
				boolean f = true;
				for (int j1 = i + 1; j1 < row; j1++){
					if (a[j1][i + j] != 0){
						int buf = 0;
						for (int i1 = 0; i1 < col; i1++){
							buf = a[i][i1];
							a[i][i1] = a[j1][i1];
							a[j1][i1] = buf;
						}
						f = false;
						break;
					}
				}
				if (f){
					j += 1;
					i -= 1;
					continue;
				}
			}
			for (int j1 = i + 1; j1 < row; j1++){
				if (a[j1][i+j] == 0){
					continue;
				}
				int ac = a[i][i+j];
				int az = a[j1][i+j];
				for (int s1 = i + j; s1 < col; s1++){
					a[j1][s1] = a[j1][s1] * ac - a[i][s1] * az;
				}
			}
		}
		int c = 0;
		for (int i = 0; i < row; i++){
			for (int q = 0; q < col; q++){
				if (a[i][q] != 0){
					c += 1;
					break;
				}
			}
		}
		println(c);
	}

	public void solve(int[][] slay){
		int rows = slay.length;
		int cols = slay[0].length;
		boolean flag = true;
		for (int i = 0; i < rows; i++){
			if (slay[i][i] == 0){
				boolean f = true;
				for (int j = i + 1; j < rows; j++){
					if (slay[j][i] != 0){
						int buf = 0;
						for (int i1 = 0; i1 < cols; i1++){
							buf = slay[i][i1];
							slay[i][i1] = slay[j][i1];
							slay[j][i1] = buf;
						}
						f = false;
						break;
					}
				}
				if (f){
					println("Никак.");
					flag = false;
				}
			}
			for (int j = i+1; j<rows; j++){
				if (slay[j][i] == 0){
					continue;
				}
				int im = slay[i][i];
				int jm = slay[j][i];
				for (int c = i; c < cols; c ++){
					slay[j][c] = slay[j][c]*im - slay[i][c]*jm;
				}
			}
		}
		if (flag){
			for (int i = rows - 1; i > 0; i--){
				for (int j = i - 1; j >= 0; j--){
					if (slay[j][i]==0){
						continue;
					}
					int im = slay[i][i];
					int jm = slay[j][i];
					for (int c = 0; c < cols; c++){
						slay[j][c] = slay[j][c]*im - slay[i][c]*jm;
					}
				}
			}
			output(slay);
			for (int i = 0; i < rows; i++){
				print("x" + i + " = " + (slay[i][cols-1]/slay[i][i]));
				if (slay[i][cols-1]%slay[i][i]!=0){
					print(" + " + (slay[i][cols-1]%slay[i][i]) + "/" + slay[i][i]);
				}
				println("");
			}
		}
	}
	public void opred(int[][] a1){
		int n = a1.length;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = a1[i][j] * 1;
			}
		}
		int gm = 1;
		for (int i = 0; i < n; i++){
			if (a[i][i] == 0){
				boolean f = true;
				for (int j = i + 1; j < n; j++){
					if (a[j][i] != 0){
						int buf = 0;
						for (int i1 = 0; i1 < n; i1++){
							buf = a[i][i1];
							a[i][i1] = a[j][i1];
							a[j][i1] = buf;
						}
						gm *= (-1);
						f = false;
						break;
					}
				}
				if (f){
					System.out.println("0");
					break;
				}
			}
			for (int j = i+1; j<n; j+=1){
				if (a[j][i] == 0){
					continue;
				}
				int ac = a[i][i];
				int az = a[j][i];
				gm *= ac;
				for (int s1 = i; s1 < n; s1 ++){
					a[j][s1] = a[j][s1]*ac - a[i][s1]*az;
				}
			}
		}
		int p = 1;
		for (int i = 0; i < n; i++){
			p *= a[i][i];
		}
		print((p/gm) + " или ");
		println(p + "/" + gm);
	}
}