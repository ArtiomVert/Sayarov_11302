public abstract class ASport{
	private String name;
	public ASport(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public abstract void start();
	public abstract void end();
}