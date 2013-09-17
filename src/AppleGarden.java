import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AppleGarden {
	private static AppleTree tree;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		int option = 1;
		while (option > 0 && option < 4){
			printMenu();
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(reader.readLine());
			switch (option) {
			case 1:
				growTree();
				break;
			case 2:
				bloom();
				break;
			case 3:
				startPunching();
				break;
			default:
				break;
			}
		}
		if (option == 4){
			System.out.print("exiting");
		} else {
			System.out.print("invalid input... exiting");
		}
	}
	
	private static void printMenu(){
		System.out.println("1. Grow tree");
		System.out.println("2. Tree blossoms");
		System.out.println("3. Grow apples & start punching");
		System.out.println("4. Exit");
	}
	
	private static void growTree(){
		tree = new AppleTree();
		System.out.println("New tree grown!");
	}
	
	private static void bloom(){
		if (tree.getBlossoms() == 0){
			tree.bloom();
			System.out.println("Tree blooms! Number of blossoms: " + tree.getBlossoms());
		} else {
			System.out.println("Tree already blooms! Number of blossoms: " + tree.getBlossoms());
		}
		
	}
	
	private static void startPunching() throws InterruptedException{
		if (tree.getBlossoms() == 0){
			System.out.println("Nothing to gather!");
		} else {
			tree.grow();
			printStats(tree);
			while(tree.getApplesCount() > 0){
				System.out.print("punch!\n");
				int applesFell = 0;
				int seedsFell = 0;
				Apple[] dropped = tree.punch();
				for (int i = 0; i < 6; i++){
					if (dropped[i] != null){
						applesFell++;
						seedsFell += dropped[i].getSeeds();
					}
				}
				System.out.println("Apples fell: " + applesFell);
				System.out.println("Seeds fell: " + seedsFell);
				printStats(tree);
				Thread.sleep(150);
			}
		}
	}
	
	private static void printStats(AppleTree tree){
		System.out.println("Apples still on the tree: " + tree.getApplesCount());
	}
}
