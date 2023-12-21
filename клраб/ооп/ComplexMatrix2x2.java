public class ComplexMatrix2x2{
	private ComplexNumber[][] a = new ComplexNumber[2][2];
	private void set(ComplexNumber a1, ComplexNumber a2, ComplexNumber a3, ComplexNumber a4){
		a[0][0] = a1;
		a[0][1] = a2;
		a[1][0] = a3;
		a[1][1] = a4;
	}
	private void set(ComplexNumber[][] a1){
		set(a1[0][0], a1[0][1], a1[1][0], a1[1][1]);
	}
	public ComplexMatrix2x2(){
		set(new ComplexNumber(), new ComplexNumber(), new ComplexNumber(), new ComplexNumber());
	}
	public ComplexMatrix2x2(ComplexNumber a1){
		set(a1, a1, a1, a1);
	}
	public ComplexMatrix2x2(ComplexNumber a1, ComplexNumber a2, ComplexNumber a3, ComplexNumber a4){
		set(a1, a2, a3, a4);
	}
	public ComplexMatrix2x2(ComplexNumber[][] a1){
		set(a1);
	}
	public ComplexMatrix2x2 add(ComplexMatrix2x2 c){
		return new ComplexMatrix2x2(c.a[0][0].add(a[0][0]), c.a[0][1].add(a[0][1]), c.a[1][0].add(a[1][0]), c.a[1][1].add(a[1][1]));
	}
	public ComplexMatrix2x2 mult(ComplexMatrix2x2 c){
		ComplexNumber[][] nm = new ComplexNumber[2][2];
		ComplexNumber[][] ca = c.a;
		for (int i = 0; i<2; i++){
			for (int j = 0; j<2; j++){
				ComplexNumber s = new ComplexNumber();
				for (int k = 0; k < 2; k ++){
					s.add2(a[i][k].mult(ca[k][j]));
				}
				nm[i][j] = s;
			}
		}
		return new ComplexMatrix2x2(nm);
	}
	public ComplexNumber det(){
		return a[0][0].mult(a[1][1]).sub(a[1][0].mult(a[0][1]));
	}
	private ComplexNumber q(ComplexVector2D v, int q1, int q2, int q3){
		return a[q1][q2].mult(v.get()[q3]);
	}
	public ComplexVector2D multVector(ComplexVector2D v){
		return new ComplexVector2D(q(v,0,0,0).add(q(v,0,1,1)), q(v,1,0,0).add(q(v,1,1,1)));
	}
}