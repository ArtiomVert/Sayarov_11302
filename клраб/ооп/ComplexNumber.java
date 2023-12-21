public class ComplexNumber{
	private double d;
	private double i;
	private void set(double d, double i){
		this.d = d;
		this.i = i;
	}
	public ComplexNumber(){
		set(0, 0);
	}
	public ComplexNumber(double d, double i){
		set(d, i);
	}
	public ComplexNumber add(ComplexNumber c){
		return new ComplexNumber(c.d + d, c.i + i);
	}
	public void add2(ComplexNumber c){
		set(c.d + d, c.i + i);
	}
	public ComplexNumber sub(ComplexNumber c){
		return new ComplexNumber(c.d - d, c.i - i);
	}
	public void sub2(ComplexNumber c){
		set(c.d - d, c.i - i);
	}
	public ComplexNumber multNumber(double m){
		return new ComplexNumber(m * d, m * i);
	}
	public void multNumber2(double m){
		set(m * d, m * i);
	}
	public ComplexNumber mult(ComplexNumber c){
		return new ComplexNumber(c.d * d - c.i * i, c.i * d + c.d * i);
	}
	public void mult2(ComplexNumber c){
		set(c.d * d - c.i * i, c.i * d + c.d * i);
	}
	public ComplexNumber div(ComplexNumber c){
		double zn = c.i*c.i + c.d*c.d;
		double d1 = (d*c.d + i*c.i)/zn;
		double i1 = (i*c.d - d*c.i)/zn;
		return new ComplexNumber(d1, i1);
	}
	public void div2(ComplexNumber c){
		ComplexNumber c1 = div(c);
		set(c1.d, c.i);
	}
	public double length(){
		return Math.sqrt(i * i + d * d);
	}
	public String toString(){
		String s = i+"*i";
		if (d<0){
			s += d;
		} else {
			s += "+" + d;
		}
		return s;
	}
	public Double arg(){
		if (i!=0){
			return 2*Math.atan((length()-d)/i);
		} else if(d>0){
			return 0.0;
		} else if(d<0){
			return Math.PI;
		}
		return null;
	}
	public ComplexNumber pow(double n){
		double pr = Math.pow(length(), n);
		ComplexNumber c = new ComplexNumber(pr*Math.cos(n*arg()), pr*Math.sin(n*arg()));
		return c;
	}
	private boolean eq(double a, double b){
		return Math.abs(a - b)<1e-8;
	}
	public boolean equals(ComplexNumber c){
		return eq(c.i, i) && eq(c.d, d);
	}
}