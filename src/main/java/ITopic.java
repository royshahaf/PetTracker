
public interface ITopic {
	public void write(Object object);
	public Object read();
	public void register(ICallback callback);
}
