package 学生选课系统实验;
import java.util.ArrayList;


import java.util.Scanner;
import java.io.File;
public class Students 
{
	public  ArrayList<Student> students=new ArrayList<>();
	public Students() throws Exception
	{
		File file=new File("studentsIdName.txt");
		Scanner input=new Scanner(file);
		//Scanner inputTxt=new Scanner("students'fileName.txt");
		while(input.hasNext())
		{
			
			students.add(new Student(input.next(),input.next(),input.next()+input.next()+input.next()));
			
		}
	    input.close();
		
	}
	public Students(ArrayList<Student> students)
	{
		this.students=students;
	}
	
}
