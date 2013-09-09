import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AppleGarden {
	public static void main(String[] args) throws IOException, InterruptedException {
		int option = 1;
		while (option == 1){
			printMenu();
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(reader.readLine());
			switch (option) {
			case 1:
				startPunching();
				break;
			case 2:
				break;
			default:
				option = 3;
				break;
			}
		}
		if (option == 2){
			System.out.print("exiting");
		} else {
			System.out.print("invalid input... exiting");
		}
	}
	
	private static void printMenu(){
		System.out.print("1. Grow tree\n2. Exit\n");
	}
	
	private static void startPunching() throws InterruptedException{
		AppleTree tree = new AppleTree();
		tree.grow();
		printStats(tree);
		while(tree.getApplesCount() > 0){
			System.out.print("punch!\n");
			int applesFell = tree.punch();
			System.out.print("Apples fell: " + applesFell + "\n");
			printStats(tree);
			Thread.sleep(150);
		}
	}
	
	private static void printStats(AppleTree tree){
		System.out.print("Apples still on the tree: " + tree.getApplesCount() + "\n");
	}
}
