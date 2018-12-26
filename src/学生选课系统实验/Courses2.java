package 学生选课系统实验;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Courses2 
{
	public static ArrayList<Course> courses2=new ArrayList<>();
	File file2=new File("coursesInformation.txt");
	public  Scanner input=new Scanner(file2);
	public Courses2() throws Exception
	{
		read();
	}
	public void read()
	{  
		while(input.hasNext())
		{
			/*String s1=input.next();
			String s2=input.next();
			String s3=input.next();
			new WarnAddRemove().warnAddRemove(s1+s2+s3);*/
			
			courses2.add(new Course(input.next(),Integer.parseInt(input.next()),input.next(),Float.parseFloat(input.next()),input.next()+input.next()+input.next(),input.next()+input.next()+input.next()));
		}
		//input.close();
		
		
	}
}
