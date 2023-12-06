public class RationalFraction{
	private int c;
	private int z;
	public boolean isPos(){return c>=0;}
	public RationalFraction()throws ZeroExeption{
		set(0, 1);
	}
	public RationalFraction(int c, int z)throws ZeroExeption{
		set(c, z);
	}
	private void set(int c, int z) throws ZeroExeption{
		if (z==0){
			throw new ZeroExeption();
		}
		this.c = c*z/abs(z);
		this.z = abs(z);
		reduce();
	}
	private int abs(int a){
		return Math.abs(a);
	}
	public String toString(){
		return c + "/" + z;
	}
	public void reduce(){
		int min = Math.min(abs(c), z);
		for (int i = min; i>1;i--){
			if (c%i==0 && z%i==0){
				c /= i;
				z /= i;
				break;
			}
		}
	}
	private int sum(RationalFraction r, int a){
		return c * r.z + a * r.c * z;
	}
	public RationalFraction add(RationalFraction r)throws ZeroExeption{
		return new RationalFraction(sum(r, 1), z * r.z);
	}
	public void add2(RationalFraction r)throws ZeroExeption{
		set(sum(r, 1), z * r.z);
	}
	public RationalFraction sub(RationalFraction r)throws ZeroExeption{
		return new RationalFraction(sum(r, -1), z * r.z);
	}
	public void sub2(RationalFraction r)throws ZeroExeption{
		set(sum(r, -1), z * r.z);
	}
	public RationalFraction mult(RationalFraction r)throws ZeroExeption{
		return new RationalFraction(c*r.c, z*r.z);
	}
	public void mult2(RationalFraction r)throws ZeroExeption{
		set(c*r.c, z*r.z);
	}
	public RationalFraction div(RationalFraction r)throws ZeroExeption{
		return new RationalFraction(c*r.z, z*r.c);
	}
	public void div2(RationalFraction r)throws ZeroExeption{
		set(c*r.z, z*r.c);
	}
	public double value(){
		return (double)c/z;
	}
	public boolean equals(RationalFraction r){
		return c==r.c && z==r.z;
	}
}
class ZeroExeption extends Exception{
	public ZeroExeption(){
		super("The denominator can't be 0");
	}
}