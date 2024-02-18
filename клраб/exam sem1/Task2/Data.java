public class Data{
	private int date_in_day;
	private int y;
	private int m;
	private int d;
	private int[] posv = {31,29,31,30,31,30,31,30,30,31,30,31};
	int[] pos = {31,28,31,30,31,30,31,30,30,31,30,31};
	public Data(int y, int m, int d)throws DateException{
		set(y,m,d);
	}
	private void set(int y, int m, int d)throws DateException{
		if (y>=0 && m>=1 && m<=12 && d>=1){
			if (m==2){
				if (y%4==0 && d<=29 || y%4!=0 && d<=28){
					set2(y,m,d); 
				} else{
					throw new DateException();
				}
			} else if (d<=pos[m-1]){
				set2(y,m,d);
			} else{
				throw new DateException();
			}
		} else{
			throw new DateException();
		}
	}
	private void set2(int y, int m, int d){
		date_in_day = y/4*365 + (y-y/4)*364 + d;
		for (int i = 0; i<m-1; i++){
			date_in_day += y/4==0?posv[i]:pos[i];
		}
		this.y = y;
		this.m = m;
		this.d = d;
	}
	public int difInDay(Data data){
		return Math.abs(data.date_in_day - date_in_day);
	}
	public int difInMon(Data data){
		return difInDay(data)/30;
	}
	public boolean equals(Data data){
		return data.date_in_day == date_in_day;
	}
	public String toString(){
		return d+"."+m+"."+y;
	}
	public Data isFirstDate(Data data){
		if (data.date_in_day>=date_in_day){
			return data;
		}
		return this;
	}
	public int difInDayNeg(Data data){
		return data.date_in_day - date_in_day;
	}
}
class DateException extends Exception{
	public DateException(){
		super("Impossible date");
	}
}
/*
1-31
2-28/29
3-31
4-30
5-31
6-30
7-31
8-30
9-30
10-31
11-30
12-31
*/