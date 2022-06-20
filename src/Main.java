

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService  threadRun = Executors.newCachedThreadPool();
		Buffer sharedLocation = new UnsysnchronizedBuffer();
		
		System.out.printf(
			"Thread running\t\tValue\t "
			+ "Sum write\tSum read\n"
		);

		System.out.println("-------------------------------------------------------------------------------------");
		threadRun.execute(new WriteBuffer(sharedLocation));
		threadRun.execute(new ReadBuffer(sharedLocation));
		threadRun.execute(new WriteBufferIntArray(sharedLocation));
		threadRun.execute(new ReadBufferIntArray(sharedLocation));
		threadRun.execute(new WriteBufferDoubleArray(sharedLocation));
		threadRun.execute(new ReadBufferDoubleArray(sharedLocation));
		threadRun.execute(new WriteBufferStringArray(sharedLocation));
		threadRun.execute(new ReadBufferStringArray(sharedLocation));
		threadRun.shutdown();
		threadRun.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf(
			"Thread running\t\t\tIs\t\t\tClosing\n\n"
		);
	}

}
