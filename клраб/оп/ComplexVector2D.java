public class ComplexVector2D{
	private ComplexNumber c1;
	private ComplexNumber c2;
	public void set(ComplexNumber c1, ComplexNumber c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	public ComplexNumber[] get(){
		return new ComplexNumber[] {c1, c2};
	}
	public ComplexVector2D(){
		set(new ComplexNumber(), new ComplexNumber());
	}
	public ComplexVector2D(ComplexNumber c1, ComplexNumber c2){
		set(c1, c2);
	}
	public ComplexVector2D add(ComplexVector2D v){
		return new ComplexVector2D(v.c1.add(c1), v.c2.add(c2));
	}

	public String toString(){
		return "(" + c1.toString() + ", " + c2.toString() + ")";
	}
	public ComplexNumber scalarProduct(ComplexVector2D v){
		return c1.mult(v.c1).add(c2.mult(v.c2));
	}
	public boolean equals(ComplexVector2D v){
		return c1.equals(v.c1) && c2.equals(v.c2);
	}
}