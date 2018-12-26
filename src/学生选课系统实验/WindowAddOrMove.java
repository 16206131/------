package 学生选课系统实验;
import javafx.scene.Node;


import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;
public class WindowAddOrMove 
{	
	private PrintWriter write=new PrintWriter(WindowStudent.loggingStudent.getSaveCourses());
	
	
	public WindowAddOrMove() throws Exception
	{
		windowAddOrMove();
		
		
	}
	public void windowAddOrMove() throws Exception 
	{
		Stage stage=new Stage();
		GridPane gridPaneAddOrMove=new GridPane();
		gridPaneAddOrMove.setGridLinesVisible(true);
		ScrollPane scrollPaneAddOrMove=new ScrollPane(gridPaneAddOrMove);
		scrollPaneAddOrMove.setPadding(new Insets(50,20,20,100));
	
		gridPaneAddOrMove.setAlignment(Pos.TOP_CENTER);
		gridPaneAddOrMove.setHgap(0);
		gridPaneAddOrMove.setVgap(0);
		Label lbCourse=new Label("         课程名称    ");
		lbCourse.setTextFill(Color.NAVY);
		lbCourse.setAlignment(Pos.BOTTOM_CENTER);
		Label lbTime=new Label("课时(小时)");
		lbTime.setTextFill(Color.NAVY);
		Label lbTeacher=new Label("任课教师");
		lbTeacher.setTextFill(Color.NAVY);
		Label lbMark=new Label("学分");
		lbMark.setTextFill(Color.NAVY);
		Label lbBeyond=new Label("   满否  ");
		lbBeyond.setTextFill(Color.NAVY);
		Label lbSelection=new Label("选择课程");
		lbSelection.setTextFill(Color.NAVY);
		Label lbRemove=new Label("删除课程");
		lbRemove.setTextFill(Color.NAVY);
		gridPaneAddOrMove.add(lbCourse,0,0);
		gridPaneAddOrMove.add(lbTime,1,0);
		gridPaneAddOrMove.add(lbTeacher,2,0);
		gridPaneAddOrMove.add(lbMark,3,0);
		gridPaneAddOrMove.add(lbBeyond,4,0);
		gridPaneAddOrMove.add(lbSelection,5,0);
		gridPaneAddOrMove.add(lbRemove,6,0);
		File file=new File("courseTimeTeacher.txt");
	
		Scanner input=new Scanner(file);
		int j=1,k=1;
		
		
		while(input.hasNext())
		{	Course course=new Course();
			Courses.courses.add(course);
			for(int i=0;i<4;i++)
			{
				Label lb=new Label();
				String s=input.next();
				if(i==3)
				{
					course.setMark(Float.parseFloat(s));
				}
				if(i==1)
				{
					course.setCourseTime(Integer.parseInt(s));
				}
				if(i==2)
				{
					course.setTeacher(s);
				}
				lb.setText("  "+s+"  ");
				lb.setTextAlignment(TextAlignment.CENTER);
				gridPaneAddOrMove.add(lb,i,j);
				gridPaneAddOrMove.setValignment(lb, VPos.CENTER);
				if(i==0)
				{
					course.setName(s);
				
					Button btDelete=new Button(" 删课 ");
					Button btSelect=new Button(" 选课");
					btSelect.setTextFill(Color.GREEN);
				
					btSelect.setOnAction(e->
					{
						try {
								boolean flag3=false;
								for(Course loggingSelectedCourse:WindowStudent.loggingStudent.getSelectedCourse())
								{
									if(loggingSelectedCourse.getName().equals(s))
									{
										flag3=true;
										(new WarnAddRemove()).warnAddRemove("已经选课成功！！！");
										break;
									}
								}
								
										
								if(flag3==false)
								{
									
									WindowStudent.loggingStudent.getSelectedCourse().add(course);
									PrintWriter repeatWriter=new PrintWriter(WindowStudent.loggingStudent.getSaveCourses());
									for(Course repeatCourse:WindowStudent.loggingStudent.getSelectedCourse())
									{
										repeatWriter.print(repeatCourse.getName()+"\t");
										repeatWriter.print(repeatCourse.getCourseTime()+"\t");
										repeatWriter.print(repeatCourse.getTeacher()+"\t");
										repeatWriter.println(repeatCourse.getMark());
									
									}
									repeatWriter.close();
									btSelect.setText(" 已选");
									btSelect.setTextFill(Color.DARKGRAY);
									int m=0;
									for(m=0;m<Courses.courses.size();m++)
									{
										Course manageCourse=Courses2.courses2.get(m);
										
										if(manageCourse.getName().equals(s))
										{
											manageCourse.getStudentsList().clear();
											Scanner inputCourseStudents=new Scanner(manageCourse.getSaveStudentsInformation());
											//new WarnAddRemove().warnAddRemove();
											while(inputCourseStudents.hasNext())
											{
												manageCourse.getStudentsList().add(new Student(inputCourseStudents.next(),inputCourseStudents.next()));
											}
											inputCourseStudents.close();
											PrintWriter pw=new PrintWriter(manageCourse.getSaveStudentsInformation());
											
											int flag4=0;
											for(Student student:manageCourse.getStudentsList())
											{
												if(student.getId().equals(WindowStudent.loggingStudent.getId()))
												{
													flag4=1;
													break;
												}
											}
											if(flag4==0)
												manageCourse.getStudentsList().add(new Student(WindowStudent.loggingStudent.getId(),WindowStudent.loggingStudent.getName()));
											for(Student student:manageCourse.getStudentsList())
											{
												pw.println(student.getId()+"\t"+student.getName());
												
											}
											pw.close();
											break;
										}
									}
								}
									
								
									
						
							}
						 catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
						
					});
					
					btDelete.setOnAction(e->
					{
						int t=0;
						try {
								int flag=1;
								
								for(t=0;t<WindowStudent.loggingStudent.getSelectedCourse().size();t++)
								  {
								 		if(WindowStudent.loggingStudent.getSelectedCourse().get(t).getName().equals(s))
										{
									
											WindowStudent.loggingStudent.getSelectedCourse().remove(WindowStudent.loggingStudent.getSelectedCourse().get(t));
											PrintWriter repeatWriters=new PrintWriter(WindowStudent.loggingStudent.getSaveCourses());
											for(Course repeatCourse:WindowStudent.loggingStudent.getSelectedCourse())
											{
												repeatWriters.print(repeatCourse.getName()+"\t");
												repeatWriters.print(repeatCourse.getCourseTime()+"\t");
												repeatWriters.print(repeatCourse.getTeacher()+"\t");
												repeatWriters.println(repeatCourse.getMark());
									
											}
											flag=0;
											repeatWriters.close();
											btSelect.setText(" 选课");
											btSelect.setTextFill(Color.GREEN);
											(new WarnAddRemove()).warnAddRemove("删除成功！");
											break;
										}
								  }
								if(flag==1)
								{
								
									Stage stageError=new Stage();
									Label lbError=new Label("对不起！\n您还没有选择《"+course.getName()+"》 ！！！");
									StackPane stackPaneError=new StackPane();
									stackPaneError.getChildren().add(lbError);
									Scene scene=new Scene(stackPaneError,300,60);
									stageError.setTitle("Warning");
									stageError.setScene(scene);
									stageError.show();
									stageError.setResizable(false);
								}
								for(t=0;t<WindowStudent.loggingStudent.getSelectedCourse().size();t++)	
								{
											int m=0;
											for(m=0;m<Courses2.courses2.size();m++)
											{
												Course manageCourse=Courses2.courses2.get(m);
												
												if(manageCourse.getName().equals(s))
												{
													manageCourse.getStudentsList().clear();
													Scanner inputCourseStudents=new Scanner(manageCourse.getSaveStudentsInformation());
													while(inputCourseStudents.hasNext())
													{
														manageCourse.getStudentsList().add(new Student(inputCourseStudents.next(),inputCourseStudents.next()));
													}
													inputCourseStudents.close();
													for(Student student:manageCourse.getStudentsList())
													{
														if(student.getId().equals(WindowStudent.loggingStudent.getId()))
														{
															manageCourse.getStudentsList().remove(student);
														}
														break;
													}
													PrintWriter pw=new PrintWriter(manageCourse.getSaveStudentsInformation());
													for(Student student:manageCourse.getStudentsList())
													{
														pw.println(student.getId()+"\t"+student.getName());
														
													}
													pw.close();
													break;
												}
													
											}	
											break;		
												
									}
								 
								
						} 
					
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
					btDelete.setTextFill(Color.RED);
					gridPaneAddOrMove.add(btSelect,5,k);
					gridPaneAddOrMove.add(btDelete,6,k);
					k++;
					
				}
				
			}
			j++;
			
		}
		//input.close();
		
		
		Scene scene=new Scene(scrollPaneAddOrMove,700,550);
		stage.setTitle("选课/删课");
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	
	
	
}
