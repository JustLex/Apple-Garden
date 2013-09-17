import java.util.Random;

public class AppleTree {
	private Apple[] apples;
	private int applesCount = 0;
	private int blossoms = 0;
	
	public int getApplesCount() {
		return applesCount;
	}
	
	public int getBlossoms() {
		return blossoms;
	}



	public void bloom(){
		if (blossoms == 0){
			Random rand = new Random();
			blossoms = rand.nextInt(50);
		}
	}
	
	public void grow(){
		if (blossoms != 0){
			applesCount = blossoms;
			apples = new Apple[blossoms];
			for(int i = 0; i < applesCount; i++){
				apples[i] = new Apple();
			}
			blossoms = 0;
		}
	}
	
	public Apple[] punch(){
		Random rand = new Random();
		Apple dropped[] = new Apple[6];
		int applesFell = 0;
		for(int i = 0; i < 6; i++){
			int position = rand.nextInt(apples.length);
			if (apples[position] != null){
				dropped[i] = apples[position];
				apples[position] = null;
				applesFell++;
			}
		}
		applesCount -= applesFell;
		return dropped;
	}
}
