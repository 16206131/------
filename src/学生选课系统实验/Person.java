package 学生选课系统实验;

public class Person
{
	private String idCard;
	private String password;
	private String profession;
	private String name;
	public Person()
	{
		
	}
	public Person(String idCard,String name,String password,String profession)
	{
		this.idCard=idCard;
		this.name=name;
		this.password=password;
		this.profession=profession;
	}
	public String getIdCard()
	{
		return idCard;
	}
	public void setIdCard(String idCard)
	{
		this.idCard=idCard;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getProfession()
	{
		return profession;
	}
	public void setProfession(String profession)
	{
		this.profession=profession;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
