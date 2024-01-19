public class Main{

	public static Data lastData(Data[] ds){
			Data ld = ds[0];
			for (Data td:ds){
				if(td.difInDayNeg(ld)<0){
					ld = td;
				}
			}
			return ld;
		}
		public static boolean haveEquals(Data[] ds){
			for (int i = 0; i < ds.length - 1; i++){
				for (int j = i+1; j < ds.length; j++){
					if (ds[i].equals(ds[j])){
						return true;
					}
				}
			}
			return false;
		}
	public static void main(String[] args) {
		
		try{
			Data[] ds = new Data[]{new Data(1966,7,4), new Data(322,3,6), new Data(1966,7,4)};
			System.out.println(lastData(ds).toString());
			System.out.println(haveEquals(ds));
		} catch (Exception e) {
			System.out.println("error");
		}
		
	}
}