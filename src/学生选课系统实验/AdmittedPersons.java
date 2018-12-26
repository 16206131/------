package 学生选课系统实验;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class AdmittedPersons
{
	public static ArrayList<Person> personList;
	public AdmittedPersons() throws Exception
	{
		createPersonList();
	}
	public static ArrayList<Person> createPersonList() throws Exception
	{
		personList=new ArrayList<>();
		
		
		File file=new File("admittedPersons.txt");
		Scanner inputs=new Scanner(file);
		while(inputs.hasNext())
		{
			for(int i=0;i<4;i++)
			{
				personList.add(new Person(inputs.next(),inputs.next(),inputs.next(),inputs.next()));
			}
		}
		//inputs.close();
		return personList;
		
	}
}

