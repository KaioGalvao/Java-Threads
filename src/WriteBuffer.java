import java.security.SecureRandom;

public class WriteBuffer implements Runnable{
	private static final SecureRandom 
	generator = new SecureRandom();
	private final Buffer sharedLocation;	
	public WriteBuffer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		int sum = 0;
		for (int count =1;count <=10;count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBuffer(count);
				sum+=count;
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
