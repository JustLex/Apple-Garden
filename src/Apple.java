import java.util.Random;

public class Apple {
	private int seeds;
	
	public Apple(){
		Random rand = new Random();
		this.seeds = rand.nextInt(10);
	}

	public int getSeeds() {
		return seeds;
	}
}
