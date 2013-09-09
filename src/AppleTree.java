import java.util.Random;

public class AppleTree {
	private Apple[] apples;
	private int applesCount;
	
	public int getApplesCount() {
		return applesCount;
	}
	
	public void grow(){
		Random rand = new Random();
		apples = new Apple[rand.nextInt(50)];
		applesCount = apples.length;
		for(int i = 0; i < applesCount; i++){
			apples[i] = new Apple();
		}
	}
	
	public int punch(){
		Random rand = new Random();
		int applesFell = 0;
		for(int i = 0; i < 6; i++){
			int position = rand.nextInt(apples.length);
			if (apples[position] != null){
				apples[position] = null;
				applesFell++;
			}
		}
		applesCount -= applesFell;
		return applesFell;
	}
}
