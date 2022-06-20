public interface Buffer {
	public void putBuffer(int value) throws InterruptedException;
	public int getBuffer() throws InterruptedException;
	public void putBufferIntArray(int value) throws InterruptedException;
	public int getBufferIntArray() throws InterruptedException;
	public void putBufferDoubleArray(double value) throws InterruptedException;
	public double getBufferDoubleArray() throws InterruptedException;
	public void putBufferStringArray(int value) throws InterruptedException;
	public int getBufferStringArray() throws InterruptedException;

}
