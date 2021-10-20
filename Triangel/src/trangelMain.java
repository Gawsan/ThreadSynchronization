import java.util.Scanner;

import com.thread.Thread1;
import com.thread.Thread2;

public class trangelMain {
	public static void main(String[] args) {

		String patern1 , pattern2;
		int count = 6;
		Object lock = new Object();

		try (Scanner myScan = new Scanner(System.in)) {
			System.out.print("Enter the pattern -1 : ");
			patern1 = myScan.next();
			
			System.out.print("Enter the pattern -2 : ");
			pattern2 = myScan.next();

			System.out.print("Enter count : ");
			count = myScan.nextInt();
		}
		
		Thread t1 = new Thread1(lock, count, patern1);
		Thread2 t2 = new Thread2(lock, count, pattern2);
		t1.start();
		t2.start();

	}

}
