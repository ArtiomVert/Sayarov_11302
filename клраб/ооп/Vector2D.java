public class Vector2D{
	private double c1;
	private double c2;
	public void set(double c1, double c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	public double[] get(){
		return new double[] {c1, c2};
	}
	public Vector2D(){
		set(0, 0);
	}
	public Vector2D(double c1, double c2){
		set(c1, c2);
	}
	public Vector2D add(Vector2D v){
		return new Vector2D(v.c1+c1, v.c2+c2);
	}
	public void add2(Vector2D v){
		set(c1+v.c1, c2+v.c2);
	}
	public Vector2D sub(Vector2D v){
		return new Vector2D(c1-v.c1, c2-v.c2);
	}
	public void sub2(Vector2D v){
		set(c1-v.c1, c2-v.c2);
	}
	public Vector2D mult(double m){
		return new Vector2D(c1*m, c2*m);
	}
	public void mult2(double m){
		set(c1*m, c2*m);
	}
	public String toString(){
		return "(" + c1 + ", " + c2 + ")";
	}
	public double length(){
		return Math.sqrt(c1 * c1 + c2 * c2);
	}
	public double cos(Vector2D v){
		return scalarProduct(v)/(length()*v.length());
	}
	public double scalarProduct(Vector2D v){
		return c1*v.c1 + c2*v.c2;
	}
	public boolean equals(Vector2D v){
		return Math.abs(c1 - v.c1)<1e-9 && Math.abs(c2 - v.c2)<1e-9;
	}
}