package 学生选课系统实验;
import java.util.ArrayList;

import java.io.File;
public class Course 
{
	private String name;
	private String teacher;
	private int courseTime;
	private float mark;
	private int personGrade;
	private int personPaiMing;
	private ArrayList<Student> studentsList=new ArrayList<>();
	private ArrayList<Scores> scores;
	public File saveStudentsInformation;
	public File logGrade;
	public Course(String name)
	{
		this.name=name;
	}
	public Course()
	{
		
	}
	public Course(String name,int courseTime,String teacher,float mark,String s,String s2)
	{
		this.name=name;
		this.courseTime=courseTime;
		this.teacher=teacher;
		this.mark=mark;
		saveStudentsInformation=new File(s);
		logGrade=new File(s2);
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setTeacher(String teacher)
	{
		this.teacher=teacher;
	}
	public String getTeacher()
	{
		return teacher;
	}
	public void setCourseTime(int courseTime)
	{
		this.courseTime=courseTime;
	}
	public int getCourseTime()
	{
		return courseTime;
	}
	public void setMark(float mark)
	{
		this.mark=mark;
	}
	public float getMark()
	{
		return mark;
	}
	public void setScores(ArrayList<Scores> scores)
	{
		this.scores=scores;
	}
	public ArrayList<Scores> getScores()
	{
		return scores;
	}
	public class Scores
	{
		public String id;
		public String studentName;
		public float score;
		public Scores()
		{
			
		}
	}
	public void setSaveStudentsInformation(String s) //throws Exception
	{
		saveStudentsInformation=new File(s);
		
	}
	public void setSaveStudentsInformation(File file) //throws Exception
	{
		saveStudentsInformation=file;
		
	}
	public File getSaveStudentsInformation()
	{
		return saveStudentsInformation;
	}
	public void setStudentsList(ArrayList<Student> studentsList)
	{
		this.studentsList=studentsList;
	}
	public ArrayList<Student> getStudentsList()
	{
		return studentsList;
	}
	public File getLogGrade()
	{
		return logGrade;
	}
	public void setLogGrade(File logGrade)
	{
		this.logGrade=logGrade;
	}
	public void setPersonGrade(int personGrade)
	{
		this.personGrade=personGrade;
	}
	public int getPersonGrade()
	{
		return personGrade;
	}
	public void setPersonPaiMing(int personPaiMing)
	{
		this.personPaiMing=personPaiMing;
	}
	public int getPersonPaiMing()
	{
		return personPaiMing;
	}
	
}
