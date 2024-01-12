import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass
{
	public static void main(String[] args)
	{
//		ArrayList<String> liste = new ArrayList<>();
//		liste.add("sadas");
		// liste.add(34);
//		Pair<PersonTuremis, BufferedReader> ikili = new Pair<>();
		//Yeni oluşturulan personda ikiliyi kullanabiliyor.
//		ikili.setValue(new Person());
//		Person p = ikili.getValue();
//		genericMetod("sdasd");
//		MyList liste = new MyList();
		// ornek2();
	}

	private static void ornek2()
	{
		// generic felaketi, sağ tarafı yazmayınca
		// iki tarafa da generic tipler yazılmalı
		GenericPair<Vehicle, Person> pair = new GenericPair(new Person(), new Vehicle());//Genericpair parametre istedi
		Vehicle v = pair.getKey();
		System.err.println(v);
	}

	static <TIP1, TIP2> TIP2 genericMetod(TIP1 param)
	{
		TIP2 localVariable = null;
		ArrayList<TIP1> myList = new ArrayList<>();
		return localVariable;
	}
}

class PairExtensionWithTypeExtension<SUKRU1 extends Person, SUKRU2 extends String> extends PairExtensionWithType<SUKRU1, SUKRU2>
{
}
//bu kod, PairExtensionWithType adlı bir generic sınıfın Person türünden türetilmiş sınıf veya Person türü için 
//ve String türü için kullanılabilen yeni bir generic sınıf olan PairExtensionWithTypeWithType'ı tanımlar. 
//Bu, tür güvenliği ve sınırlamaların sağlandığı kodları oluşturmanıza olanak tanır.Bu ifade,
//+/SUKRU1 ve SUKRU2 tür parametrelerini kullanarak yeni bir generic sınıf oluşturuyor.

class PairExtensionWithType<ABUZIDDIN1 extends Person, ABUZDDIN2 extends String> extends Pair<ABUZIDDIN1, ABUZDDIN2>
{
	// yukarıdaki tiplere saygı duymak zorundayız
}

class PairExtension extends Pair<Person, Vehicle>
{
	// yukarıdaki tiplere saygı duymak zorundayız
}

// zorlama örnek
class MyList extends ArrayList<Person>
{
}

class Vehicle
{
}

class Person
{
}

class PersonTuremis extends Person
{
}

class NKReader extends BufferedReader
{
	public NKReader(String path) throws FileNotFoundException
	{
		super(new FileReader(path));
	}

	public String readLineAt(int lineNumber) throws IOException
	{
		String temp = "";
		for (int i = 0; i < lineNumber; i++)
		{
			temp = super.readLine();
		}
		return temp;
	}

	public ArrayList<String> readWords() throws IOException
	{
		ArrayList<String> keliemeler = new ArrayList<String>();
		StringBuilder kelime = new StringBuilder();
		while (super.ready())
		{
			int temp = super.read();
			if (temp != 32 && temp != 10)
			{
				kelime.append((char) temp);
			}
			else
			{
				keliemeler.add(kelime.toString());
				kelime = new StringBuilder();
			}
		}
		return keliemeler;
	}
}
