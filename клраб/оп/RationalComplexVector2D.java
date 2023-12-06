public class RationalComplexVector2D{
	private RationalComplexNumber c1;
	private RationalComplexNumber c2;
	public void set(RationalComplexNumber c1, RationalComplexNumber c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	public RationalComplexNumber[] get(){
		return new RationalComplexNumber[] {c1, c2};
	}
	public RationalComplexVector2D(){
		set(new RationalComplexNumber(), new RationalComplexNumber());
	}
	public RationalComplexVector2D(RationalComplexNumber c1, RationalComplexNumber c2){
		set(c1, c2);
	}
	public RationalComplexVector2D add(RationalComplexVector2D v){
		return new RationalComplexVector2D (v.c1.add(c1), v.c2.add(c2));
	}

	public String toString(){
		return "(" + c1.toString() + ", " + c2.toString() + ")";
	}
	public RationalComplexNumber scalarProduct(RationalComplexVector2D v){
		return c1.mult(v.c1).add(c2.mult(v.c2));
	}
}