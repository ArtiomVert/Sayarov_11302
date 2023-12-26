public class RationalVector2D{
	private RationalFraction c1;
	private RationalFraction c2;
	public void set(RationalFraction c1, RationalFraction c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	public RationalFraction[] get(){
		return new RationalFraction[] {c1, c2};
	}
	public RationalVector2D(){
		set(new RationalFraction(), new RationalFraction());
	}
	public RationalVector2D(RationalFraction c1, RationalFraction c2){
		set(c1, c2);
	}
	public RationalVector2D add(RationalVector2D v){
		return new RationalVector2D(v.c1.add(c1), v.c2.add(c2));
	}

	public String toString(){
		return "(" + c1.toString() + ", " + c2.toString() + ")";
	}
	public double length(){
		return Math.sqrt(c1.mult(c1).add(c2.mult(c2)).value());
	}
	public RationalFraction scalarProduct(RationalVector2D v){
		return c1.mult(v.c1).add(c2.mult(v.c2));
	}
	public boolean equals(RationalVector2D v){
		return c1.equals(v.c1) && c2.equals(v.c2);
	}
}