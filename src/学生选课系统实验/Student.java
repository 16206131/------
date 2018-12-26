package 学生选课系统实验;
import java.util.ArrayList;

import java.io.File;
public class Student
{
	private String id;
	private String name;
	private int grade;
	private ArrayList<Course> selectedCourse=new ArrayList<Course>();
	public File saveCourses;
	private ArrayList<Course> coursesOfKnowingGrade=new ArrayList<>();
	public Student()
	{
		
	}
	public Student(String id,String name,ArrayList<Course> selectedCourse)
	{
		this.id=id;
		this.name=name;
		this.selectedCourse=selectedCourse;
	}
	public Student(String id,String name,String saveingCourses)
	{
		this.id=id;
		this.name=name;
		saveCourses=new File(saveingCourses);
	}
	public Student(String id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public Student(String id,String name,int grade)
	{
		this.id=id;
		this.name=name;
		this.grade=grade;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setSelectedCourse(ArrayList<Course> selectedCourse)
	{
		this.selectedCourse=selectedCourse;
	}
	public ArrayList<Course> getSelectedCourse()
	{
		return selectedCourse;
	}
	public void setSaveCourses(File saveCourses)
	{
		this.saveCourses=saveCourses;
	}
	public File getSaveCourses()
	{
		return saveCourses;
	}
	public void setGrade(int grade)
	{
		this.grade=grade;
	}
	public int getGrade()
	{
		return grade;
	}
	public ArrayList<Course> getCoursesOfKnowingGrade()
	{
		return coursesOfKnowingGrade;
	}
	
	
}
