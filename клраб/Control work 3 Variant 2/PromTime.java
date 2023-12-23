public class PromTime{
	private int hour;
	private int min;
	private int sec;
	private int time_in_sec;
	public void set(int hour, int min, int sec)throws UncorrectTimeExeption{
		if (hour < 0 || min < 0 || sec < 0){
			throw new UncorrectTimeExeption("Time can't be < 0");
		}
		if (min >= 60 || sec >= 60){
			throw new UncorrectTimeExeption("Minutes and secndes can't be >= 60");
		}
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		time_in_sec = hour * 3600 + min * 60 + sec;
	}
	private PromTime tisToPromTime(int secs)throws UncorrectTimeExeption{
		return new PromTime(secs/3600, secs/60%60, secs%60);
	}
	public PromTime(int hour, int min, int sec)throws UncorrectTimeExeption{
		set(hour, min, sec);
	}
	public PromTime()throws UncorrectTimeExeption{
		set(0, 0, 0);
	}

	public PromTime addTime(PromTime t)throws UncorrectTimeExeption{//сумма
		int secs = time_in_sec + t.time_in_sec;
		return tisToPromTime(secs);
	}
	public PromTime multTime(int m)throws UncorrectTimeExeption{//умножение
		if (m < 0){
			throw new UncorrectTimeExeption("You can't multiplicate on negative number");
		}
		int secs = time_in_sec * m;
		return tisToPromTime(secs);
	}
	public PromTime dif1(PromTime t)throws UncorrectTimeExeption{//расстояние
		int r = Math.abs(time_in_sec - t.time_in_sec);
		return tisToPromTime(r);
	}
	public int dif2(PromTime t)throws UncorrectTimeExeption{//расстояние
		return dif1(t).time_in_sec;
	}
	public boolean equals(PromTime t){//сравнение
		return time_in_sec == t.time_in_sec;
	}
	public int equals2(PromTime t){//сравнение
		if (time_in_sec > t.time_in_sec){
			return 1;
		}
		if (time_in_sec < t.time_in_sec){
			return 2;
		}
		return 3;
		
	}
	public String toString(){//toString
		return hour + " hour " + min + " min " + sec + " sec";
	}
}
class UncorrectTimeExeption extends Exception{
	public UncorrectTimeExeption(String err){
		super(err);
	}
}