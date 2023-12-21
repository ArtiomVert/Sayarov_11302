public class RationalComplexMatrix2x2{
	private RationalComplexNumber [][] a = new RationalComplexNumber [2][2];
	private void set(RationalComplexNumber  a1, RationalComplexNumber  a2, RationalComplexNumber  a3, RationalComplexNumber  a4){
		a[0][0] = a1;
		a[0][1] = a2;
		a[1][0] = a3;
		a[1][1] = a4;
	}
	private void set(RationalComplexNumber [][] a1){
		set(a1[0][0], a1[0][1], a1[1][0], a1[1][1]);
	}
	public RationalComplexMatrix2x2 (){
		set(new RationalComplexNumber (), new RationalComplexNumber (), new RationalComplexNumber (), new RationalComplexNumber ());
	}
	public RationalComplexMatrix2x2 (RationalComplexNumber  a1){
		set(a1, a1, a1, a1);
	}
	public RationalComplexMatrix2x2 (RationalComplexNumber  a1, RationalComplexNumber  a2, RationalComplexNumber  a3, RationalComplexNumber  a4){
		set(a1, a2, a3, a4);
	}
	public RationalComplexMatrix2x2 (RationalComplexNumber [][] a1){
		set(a1);
	}
	public RationalComplexMatrix2x2  add(RationalComplexMatrix2x2  c){
		return new RationalComplexMatrix2x2 (c.a[0][0].add(a[0][0]), c.a[0][1].add(a[0][1]), c.a[1][0].add(a[1][0]), c.a[1][1].add(a[1][1]));
	}
	public RationalComplexMatrix2x2  mult(RationalComplexMatrix2x2  c){
		RationalComplexNumber [][] nm = new RationalComplexNumber [2][2];
		RationalComplexNumber [][] ca = c.a;
		for (int i = 0; i<2; i++){
			for (int j = 0; j<2; j++){
				RationalComplexNumber  s = new RationalComplexNumber ();
				for (int k = 0; k < 2; k ++){
					s = s.add(a[i][k].mult(ca[k][j]));
				}
				nm[i][j] = s;
			}
		}
		return new RationalComplexMatrix2x2 (nm);
	}
	public RationalComplexNumber  det(){
		return a[0][0].mult(a[1][1]).sub(a[1][0].mult(a[0][1]));
	}
	private RationalComplexNumber  q(RationalComplexVector2D  v, int q1, int q2, int q3){
		return a[q1][q2].mult(v.get()[q3]);
	}
	public RationalComplexVector2D  multVector(RationalComplexVector2D  v){
		return new RationalComplexVector2D (q(v,0,0,0).add(q(v,0,1,1)), q(v,1,0,0).add(q(v,1,1,1)));
	}
}