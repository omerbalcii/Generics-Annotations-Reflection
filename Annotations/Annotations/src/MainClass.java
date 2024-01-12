import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class MainClass
{
	public static void main(String[] args)
	{
		 //ornek1();
		ornek2();
	}

	private static void ornek2()
	{
		Class<Deneme> dns = Deneme.class;
		Annotation[] ants = dns.getAnnotations();
		for (Annotation annotation : ants)
		{
			if (annotation.annotationType() == CustomLog.class)
			{
				System.err.println("evet var");
			}
		}
		Method[] mtds = dns.getDeclaredMethods();
		for (Method method : mtds)
		{
			if (method.getAnnotation(CustomLog.class) != null)
			{
				CustomLog ant = method.getAnnotation(CustomLog.class);
				if (ant.logLevel() > 2)
				{
					System.err.println("evet var -> ");
					System.err.println("@" + ant.annotationType().getName() + "(logLevel = " + ant.logLevel() + ")");
					Parameter param = method.getParameters()[0];
					System.err.println(method.getModifiers() + " " + method.getReturnType().getName() + " " + method.getName() + "(" + param.getType() + " " + param.getName() + ")");
				}
			}
			else
			{
				System.err.println("hayır yok");
			}
		}
	}

	/**
	 * Deprecate oldu bunun yerine ornek2 yi kullanın
	 */
	@Deprecated(since = "V3.4", forRemoval = true)
	@SuppressWarnings(value =
	{ "unused", "unchecked", "rawtypes" })
	private static void ornek1()
	{
		String TC;
		ArrayList liste = new ArrayList<String>();
		ArrayList<String> liste2 = (ArrayList<String>) liste;
		System.err.println("dsdf");
	}
}

@CustomLog(logLevel = 0)
class Deneme
{
	@CustomLog(logLevel = 4)
	public void islem(@CustomLog(logLevel = 1) int deger)
	{
	}
}