package 学生选课系统实验;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class WindowStudentSearchGrade 
{
	private TextField tfCourse;
	private TextField tfFastGrade;
	private TextField tfFastMark;
	private TextField tfFastPaiMing;
	public WindowStudentSearchGrade()
	{
		try {
			windowStudentSearchGrade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void windowStudentSearchGrade() throws Exception
	{
		Stage stage=new Stage();
		BorderPane borderPane1=new BorderPane();
		GridPane gridPaneLow=new GridPane();
		gridPaneLow.setPadding(new Insets(20,100,20,50));
		GridPane gridPaneFast=new GridPane();
		gridPaneFast.setPadding(new Insets(20,100,20,50));
		ScrollPane scrollPane=new ScrollPane(gridPaneLow);
		gridPaneLow.setGridLinesVisible(true);
		Label lbCourseName=new Label("课程名称");
		lbCourseName.setTextFill(Color.DARKRED);
		lbCourseName.setPrefWidth(120);
		lbCourseName.setAlignment(Pos.CENTER);
		Label lbGrade=new Label("分数");
		lbGrade.setTextFill(Color.DARKRED);
		lbGrade.setPrefWidth(80);
		lbGrade.setAlignment(Pos.CENTER);
		Label lbMark=new Label("学分");
		lbMark.setTextFill(Color.DARKRED);
		lbMark.setPrefWidth(80);
		lbMark.setAlignment(Pos.CENTER);
		Label lbNum=new Label("排名");
		lbNum.setTextFill(Color.DARKRED);
		lbNum.setPrefWidth(80);
		lbNum.setAlignment(Pos.CENTER);
		gridPaneLow.add(lbCourseName,0,0);
		gridPaneLow.add(lbGrade,1,0);
		gridPaneLow.add(lbMark,2,0);
		gridPaneLow.add(lbNum,3,0);
		
		Scanner input=new Scanner(WindowStudent.loggingStudent.getSaveCourses());
		while(input.hasNext())
		{	
			String s=input.next();
			String s2=input.next();
			String s3=input.next();
			String s4=input.next();
			for(Course course:Courses2.courses2)
			{
				
				if(course.getName().equals(s))
				{
					
					int count=0;
					Scanner read2=new Scanner(course.getLogGrade());
					while(read2.hasNext())
					{	
						read2.next();
					
						count++;
					}
							
					Scanner read3=new Scanner(course.getSaveStudentsInformation());
					while(read3.hasNext())
					{
						course.getStudentsList().add(new Student(read3.next(),read3.next()));
					}
					if(count==course.getStudentsList().size())
					{
						Course myCourse=new Course(course.getName());
						myCourse.setCourseTime(course.getCourseTime());
								
						myCourse.setSaveStudentsInformation(course.getSaveStudentsInformation());
						myCourse.setTeacher(course.getTeacher());
						myCourse.setMark(course.getMark());
						
						myCourse.setLogGrade(course.getLogGrade());
								
						myCourse.setStudentsList(course.getStudentsList());
								
						Student t;
						for(int i=0;i<myCourse.getStudentsList().size()-1;i++)
						{
							for(int j=i+1;j<myCourse.getStudentsList().size();j++)
							{
								if(Long.parseLong(myCourse.getStudentsList().get(i).getId())>Long.parseLong(myCourse.getStudentsList().get(j).getId()))
								{
									t=myCourse.getStudentsList().get(i);
									myCourse.getStudentsList().set(i,myCourse.getStudentsList().get(j));
									myCourse.getStudentsList().set(j,t);
								}
							}
						}
						Scanner read=new Scanner(course.getLogGrade());
						for(int i=0;i<myCourse.getStudentsList().size();i++)
						{	
							myCourse.getStudentsList().get(i).setGrade(Integer.parseInt(read.next()));
						}
						Student t2;
						for(int i=0;i<myCourse.getStudentsList().size()-1;i++)
						{
							for(int j=i+1;j<myCourse.getStudentsList().size();j++)
							{
								if(myCourse.getStudentsList().get(i).getGrade()<myCourse.getStudentsList().get(j).getGrade())
								{
									t2=myCourse.getStudentsList().get(i);
									myCourse.getStudentsList().set(i,myCourse.getStudentsList().get(j));
									myCourse.getStudentsList().set(j,t2);
								}
							}
						}
						for(Student student:myCourse.getStudentsList())
						{
							if(student.getId().equals(WindowStudent.loggingStudent.getId()))
							{
								myCourse.setPersonGrade(student.getGrade());
								myCourse.setPersonPaiMing(myCourse.getStudentsList().indexOf(student)+1);
								break;
							}
						}
						WindowStudent.loggingStudent.getCoursesOfKnowingGrade().add(myCourse);
						break;
					}
				}
			}
		}						
					
		int i=1;
		
		for(Course myCourse:WindowStudent.loggingStudent.getCoursesOfKnowingGrade())
		{
			
			Label lb1=new Label(myCourse.getName());
			lb1.setAlignment(Pos.CENTER);
			lb1.setPrefWidth(120);
			Label lb2=new Label(myCourse.getPersonGrade()+"");
			lb2.setAlignment(Pos.CENTER);
			lb2.setPrefWidth(80);
			Label lb3=new Label(myCourse.getMark()+"");
			lb3.setAlignment(Pos.CENTER);
			lb3.setPrefWidth(80);
			Label lb4=new Label(myCourse.getPersonPaiMing()+"");
			lb4.setAlignment(Pos.CENTER);
			lb4.setPrefWidth(80);
			gridPaneLow.add(lb1,0,i);
			gridPaneLow.add(lb2,1,i);
			gridPaneLow.add(lb3,2,i);
			gridPaneLow.add(lb4,3,i);
			i++;
			
		}
		Label lbfast=new Label("快速查询通道");
		lbfast.setTextFill(Color.GREEN);
		Label lbEnd=new Label("查询结果如下");
		lbEnd.setTextFill(Color.BLUE);
		Label lbinput=new Label("请输入课程名称：");
		 tfCourse=new TextField();
		tfCourse.setEditable(true);
		Label lbFastGrade=new Label("分数");
		 tfFastGrade=new TextField();
		tfFastGrade.setEditable(false);
		Label lbFastMark=new Label("学分");
		 tfFastMark=new TextField();
		tfFastMark.setEditable(false);
		Label lbFastPaiMing=new Label("排名");
		 tfFastPaiMing=new TextField();
		tfFastPaiMing.setEditable(false);
		Button btOk=new Button("确定");
		btOk.setOnAction(e->
		{
			for(Course course:WindowStudent.loggingStudent.getCoursesOfKnowingGrade())
			{
				if(tfCourse.getText().equals(course.getName()))
				{
				     tfFastGrade.setText(course.getPersonGrade()+"");
				     if(course.getPersonGrade()>=60)
				     {
				    	 tfFastMark.setText(course.getMark()+"");
				     }
				     else
				     {
				    	 tfFastMark.setText(0+"");
				     }
				     tfFastPaiMing.setText(course.getPersonPaiMing()+"");
				     break;
				}
			}
		});
		gridPaneFast.add(lbfast, 0, 0);
		gridPaneFast.add(lbinput, 0, 2);
		gridPaneFast.add(btOk,3,2);
		gridPaneFast.add(lbEnd, 0, 3);
		gridPaneFast.add(lbFastGrade, 0, 4);
		gridPaneFast.add(lbFastMark, 0, 5);
		gridPaneFast.add(lbFastPaiMing, 0, 6);
		gridPaneFast.add(tfCourse, 1, 2);
		gridPaneFast.add(tfFastGrade, 1, 4);
		gridPaneFast.add(tfFastMark, 1, 5);
		gridPaneFast.add(tfFastPaiMing, 1, 6);
		borderPane1.setCenter(scrollPane);
		borderPane1.setRight(gridPaneFast);
		Scene scene=new Scene(borderPane1,000,500);
		stage.setTitle("查询成绩");
		stage.setScene(scene);
		stage.show();
		
	}
}

