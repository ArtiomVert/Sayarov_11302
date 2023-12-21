public class RationalComplexNumber {
	private RationalFraction d;
	private RationalFraction i;
	private void set(RationalFraction d, RationalFraction i){
		this.d = d;
		this.i = i;
	}
	public RationalComplexNumber(){
		set(new RationalFraction(), new RationalFraction());
	}
	public RationalComplexNumber(RationalFraction d, RationalFraction i){
		set(d, i);
	}
	public RationalComplexNumber add(RationalComplexNumber  c){
		return new RationalComplexNumber (c.d.add(d), c.i.add(i));
	}
	public RationalComplexNumber sub(RationalComplexNumber  c){
		return new RationalComplexNumber (d.sub(c.d), i.sub(c.i));
	}
	public RationalComplexNumber mult(RationalComplexNumber  c){
		return new RationalComplexNumber (c.d.mult(d).sub(c.i.mult(i)), c.i.mult(d).add(c.d.mult(i)));
	}
	public String toString(){
		String s = i.toString()+"*i";
		if (d.isPos()){
			s += "+" + d.toString();
		} else {
			s += d.toString();
		}
		return s;
	}
}