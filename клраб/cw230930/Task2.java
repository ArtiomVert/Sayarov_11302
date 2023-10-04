//1ab
public class Task2{
	public static void main(String[] args) {
		int[] mas = {7,43,4,2,58,47,6,55,0,80,8,5,74,52,41,3};
		int find = -1;
		//неупор. поиск
		boolean flag = false;
		for (int i:mas){
			if (i == find){
				flag = true;
				break;
			}
		}
		System.out.println(flag?"YES":"NO");

		//сортировка
		flag = true;
		int mem = 0;
		while (flag){
			flag = false;
			for (int i = 0; i < mas.length - 1; i++){
				if (mas[i]>mas[i+1]){
					mem = mas[i];
					mas[i] = mas[i+1];
					mas[i+1] = mem;
					flag = true;
				}
			}
		}

		//упор. поиск
		flag = false;
		int l = 0;
		int r = mas.length;
		int pos = (l+r)/2;
		while (l<r){
			if (mas[pos]==find){
				flag = true;
				break;
			}
			if (mas[pos]>find){
				r = pos-1;
			}
			if (mas[pos]<find){
				l = pos+1;
			}
			pos = (l+r)/2;
		}
		System.out.println(flag?"YES":"NO");
	}
}