public class Matrix2x2{
	private double[][] a = new double[2][2];
	private void set(double a1, double a2, double a3, double a4){
		a[0][0] = a1;
		a[0][1] = a2;
		a[1][0] = a3;
		a[1][1] = a4;
	}
	private void set(double[][] a1){
		set(a1[0][0], a1[0][1], a1[1][0], a1[1][1]);
	}
	public Matrix2x2(){
		set(0, 0, 0, 0);
	}
	public Matrix2x2(double a1){
		set(a1, a1, a1, a1);
	}
	public Matrix2x2(double a1, double a2, double a3, double a4){
		set(a1, a2, a3, a4);
	}
	public Matrix2x2(double[][] a1){
		set(a1);
	}
	public Matrix2x2 add(Matrix2x2 c){
		return new Matrix2x2(c.a[0][0]+a[0][0], c.a[0][1]+a[0][1], c.a[1][0]+a[1][0], c.a[1][1]+a[1][1]);
	}
	public void add2(Matrix2x2 c){
		set(add(c).a);
	}
	public Matrix2x2 sub(Matrix2x2 c){
		return new Matrix2x2(a[0][0]-c.a[0][0], a[0][1]-c.a[0][1], a[1][0]-c.a[1][0], a[1][1]-c.a[1][1]);
	}
	public void sub2(Matrix2x2 c){
		set(sub(c).a);
	}
	public void out(){
		System.out.println(a[0][0] + " " + a[0][1]);
		System.out.println(a[1][0] + " " + a[1][1]);
	}
	public Matrix2x2 multNumber(double m){
		return new Matrix2x2(m * a[0][0], m * a[0][1], m * a[1][0], m * a[1][1]);
	}
	public void multNumber2(double m){
		set(multNumber(m).a);
	}

	public Matrix2x2 mult(Matrix2x2 c){
		double[][] nm = new double[2][2];
		double[][] ca = c.a;
		for (int i = 0; i<2; i++){
			for (int j = 0; j<2; j++){
				double s = 0;
				for (int k = 0; k < 2; k ++){
					s += a[i][k]*ca[k][j];
				}
				nm[i][j] = s;
			}
		}
		return new Matrix2x2(nm);
	}
	public void mult2(Matrix2x2 c){
		set(mult(c).a);
	}
	public double det(){
		return (a[0][0]*a[1][1] - a[1][0]*a[0][1]);
	}
	public void transpon(){
		double buf = a[0][1];
		a[0][1] = a[1][0];
		a[1][0] = buf;
	}
	public Matrix2x2 inverseMatrix(){
		double[][] q = {
			{a[1][1], -1*a[0][1]},
			{-1*a[1][0], a[0][0]}
		};
		Matrix2x2 nm = new Matrix2x2(q);
		try{
			nm.multNumber2(1/det());
		}catch(Exception e){
			return new Matrix2x2();
		}
		return nm;
	}
	public Matrix2x2 equivalentDiagonal(){
		Matrix2x2 nm = new Matrix2x2(a);
		double[][] m = nm.a;
		if (m[0][0]==0){
			if (m[1][0]!=0){
				m[0][0] = m[1][0];
				m[1][0] = 0;
				double buf = m[0][1];
				m[0][1] = m[1][1];
				m[1][1] = buf;
			}
		}else {
			double div = m[1][0]/m[0][0];
			m[1][0] = 0;
			m[1][1] -= m[0][1]*div;
		}
		if (m[1][1]!=0){
			m[0][1] = 0;
		}
		nm.set(m);
		return nm;
	}
	private double q(Vector2D v, int q1, int q2, int q3){
		return a[q1][q2]*v.get()[q3];
	}
	public Vector2D multVector(Vector2D v){
		return new Vector2D(q(v,0,0,0)+q(v,0,1,1), q(v,1,0,0)+q(v,1,1,1));
	}
}