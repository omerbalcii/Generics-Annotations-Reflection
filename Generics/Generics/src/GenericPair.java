public class GenericPair<TIP1, TIP2>
{
	// generic tipler de extends mantığı ile yazılabilir
	private TIP1 key;
	private TIP2 value;

	public GenericPair()
	{
	}

	public GenericPair(TIP1 key, TIP2 value)
	{
		this.key = key;
		this.value = value;
	}

	public void setKey(TIP1 key)
	{
		this.key = key;
	}

	public void setValue(TIP2 value)
	{
		this.value = value;
	}

	public TIP1 getKey()
	{
		return key;
	}

	public TIP2 getValue()
	{
		return value;
	}
}
