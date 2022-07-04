import java.security.SecureRandom;

public class WriteBufferDoubleArray implements Runnable{
	private double[] varDouble ={1.6,5.3,3.1,4.3,5.3,6.8,7.8,5.7,3.0,1.8};
	private static final SecureRandom
	generator = new SecureRandom();
	private final Buffer sharedLocation;
	public WriteBufferDoubleArray(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		double sum = 0.0;
		for (int count = 0;count < 10;count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBufferDoubleArray(varDouble[count]);
				sum+=varDouble[count];
				System.out.printf("\t\t\t%,.2f\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %,.2f%n%s%n",
				"Escrita do total de valores: ",
				sum, "Escrita finalizada!");
	}

}
