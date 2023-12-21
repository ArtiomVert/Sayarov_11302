public class RationalMatrix2x2{
	private RationalFraction[][] a = new RationalFraction[2][2];
	private void set(RationalFraction a1, RationalFraction a2, RationalFraction a3, RationalFraction a4){
		a[0][0] = a1;
		a[0][1] = a2;
		a[1][0] = a3;
		a[1][1] = a4;
	}
	private void set(RationalFraction[][] a1){
		set(a1[0][0], a1[0][1], a1[1][0], a1[1][1]);
	}
	public RationalMatrix2x2(){
		set(new RationalFraction(), new RationalFraction(), new RationalFraction(), new RationalFraction());
	}
	public RationalMatrix2x2(RationalFraction a1){
		set(a1, a1, a1, a1);
	}
	public RationalMatrix2x2(RationalFraction a1, RationalFraction a2, RationalFraction a3, RationalFraction a4){
		set(a1, a2, a3, a4);
	}
	public RationalMatrix2x2(RationalFraction[][] a1){
		set(a1);
	}
	public RationalMatrix2x2 add(RationalMatrix2x2 c){
		return new RationalMatrix2x2(c.a[0][0].add(a[0][0]), c.a[0][1].add(a[0][1]), c.a[1][0].add(a[1][0]), c.a[1][1].add(a[1][1]));
	}
	public RationalMatrix2x2 mult(RationalMatrix2x2 c){
		RationalFraction[][] nm = new RationalFraction[2][2];
		RationalFraction[][] ca = c.a;
		for (int i = 0; i<2; i++){
			for (int j = 0; j<2; j++){
				RationalFraction s = new RationalFraction();
				for (int k = 0; k < 2; k ++){
					s.add2(a[i][k].mult(ca[k][j]));
				}
				nm[i][j] = s;
			}
		}
		return new RationalMatrix2x2(nm);
	}
	public RationalFraction det(){
		return a[0][0].mult(a[1][1]).sub(a[1][0].mult(a[0][1]));
	}
	private RationalFraction q(RationalVector2D v, int q1, int q2, int q3){
		return a[q1][q2].mult(v.get()[q3]);
	}
	public RationalVector2D multVector(RationalVector2D v){
		return new RationalVector2D(q(v,0,0,0).add(q(v,0,1,1)), q(v,1,0,0).add(q(v,1,1,1)));
	}
}