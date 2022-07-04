import java.security.SecureRandom;

public class WriteBufferStringArray implements Runnable{
	private String[] valorString = {"1","2","3","4","5","6","7","8","9","10"};
	private static final SecureRandom
	generator = new SecureRandom();
	private final Buffer sharedLocation;
	public WriteBufferStringArray(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		int sum = 0;
		for (int count = 0;count < 10;count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBufferStringArray(count);
				int actualValue = Integer.parseInt(valorString[count]);

				sum+=actualValue;
				System.out.printf("\t\t\t%d\n",sum);
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
