import java.security.SecureRandom;

public class WriteBufferIntArray implements Runnable{
	private int[] valorInt = {2,4,1,7,3,5,9,6,8,10};
	private static final SecureRandom
	generator = new SecureRandom();
	private final Buffer sharedLocation;
	public WriteBufferIntArray(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		int sum = 0;
		for (int count = 0;count < 10;count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBufferIntArray(valorInt[count]);
				sum+=valorInt[count];
				System.out.printf("\t\t\t%2d\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %d%n%s%n",
				"Escrita do total de valores: ",
				sum, "Escrita finalizada!");
	}
}
