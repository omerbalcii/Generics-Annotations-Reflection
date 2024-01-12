import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainClass
{
	public static void main(String[] args)
	{
//		Person p = new Person();
//		p.setIsim("numan");
//		System.err.println(p.getIsim());
		try
		{
			// ornek1();
			ornek2(Person.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void ornek2(Class<?> cls) throws Exception
	{
		Constructor<?> cstr = cls.getDeclaredConstructors()[0];
		Object p = cstr.newInstance();
		Method[] metods = cls.getDeclaredMethods();
		for (Method method : metods)
		{
			if (method.getName().equals("ozelMetod"))
			{
				if (Modifier.isPrivate(method.getModifiers()))
				{
					method.setAccessible(true);
					method.invoke(p);
				}
			}
		}
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields)
		{
			if (field.getName().equals("TC"))
			{
				if (Modifier.isPrivate(field.getModifiers()))
				{
					field.setAccessible(true);
					field.set(p, "2222");
					System.err.println(field.get(p));
				}
			 }
		}
	}

	private static void ornek1() throws Exception
	{
		Class<Person> cls = Person.class;
		Constructor<?> cstr = cls.getDeclaredConstructors()[0];
		Object p = cstr.newInstance();
		// cls.getMethods() yazılabilirdi
		Method[] metods = p.getClass().getDeclaredMethods();
		for (Method method : metods)
		{
			if (method.getName().equals("setIsim"))
			{
				// method.getParameterTypes()
				method.invoke(p, "numan");
			}
		}
		for (Method method : metods)
		{
			if (method.getName().equals("getIsim"))
			{
				Object result = method.invoke(p);
				System.err.println(result);
			}
		}
	}
}

class Person
{
	private String isim;
	private final String TC = "111";

	public Person()
	{
	}

	private void ozelMetod()
	{
		System.err.println("Özel metod");
	}

	public void setIsim(String isim)
	{
		this.isim = isim;
	}

	public String getIsim()
	{
		return isim;
	}
}