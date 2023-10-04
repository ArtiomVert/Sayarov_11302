//4c gayss
/*
int[][] a = {
			{2,2,-1,1},
			{4,3,-1,2},
			{8,5,-3,4},
			{3,3,-2,-2}
		};
int[][] a = {
			{2,4,6},
			{2,5,8},
			{4,9,14}
		};
*/
public class Task9{
	public static void vivod(int[][] a){
		for (int i = 0; i<a.length; i++){
			for (int j = 0; j<a[0].length; j+=1){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
	public static void main(String[] args) {
		int[][] a = {
			{0,2,-1,1},
			{0,3,-1,2},
			{0,5,-3,4},
			{0,3,-2,-2}
		};
		int n = a.length;
		for (int i = 0; i < n; i++){
			vivod(a);
			//проверка на aii элемент для "лесенки"
			if (a[i][i] == 0){
				boolean f = true;
				int zamena = 0;
				for (int j = i + 1; j < n; j++){
					if (a[j][i] != 0){
						int buf = 0;
						zamena = j+1;
						for (int i1 = 0; i1 < n; i1++){
							buf = a[i][i1];
							a[i][i1] = a[j][i1];
							a[j][i1] = buf;
						}
						f = false;
						break;
					}
				}
				if (f){
					System.out.println("PIZDEC");
					break;
				}
				System.out.println("Строка " + (i+1) + " поменялась со строкой " + zamena);
				vivod(a);
			}
			//создание "лесенки", обнуление элементов под aii
			for (int j = i+1; j<n; j+=1){
				if (a[j][i] == 0){
					continue;
				}
				int ac = a[i][i];
				int az = a[j][i];
				System.out.println("Строка " + (j+1) + " умножена на " + ac +", вычитается строка " + (i+1) + ", умноженная на " + az);
				for (int s1 = i; s1 < n; s1 ++){
					a[j][s1] = a[j][s1]*ac - a[i][s1]*az;
				}
				vivod(a);
			}
			System.out.println("Переходим на слудующюю строку");
		}

		//вывод
		vivod(a);
	}
}