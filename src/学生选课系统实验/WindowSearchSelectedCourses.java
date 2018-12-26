package 学生选课系统实验;
import javafx.stage.Stage;

import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class WindowSearchSelectedCourses //extends WindowStudent
{
		private TextField tfCourse;
		private TextField tfTime;
		private TextField tfTeacher;
		private TextField tfMark;
	public WindowSearchSelectedCourses() throws Exception
	{
		windowSearchSelectedCourses();
		/*int t;
		for(t=0;t<WindowStudent.loggingStudent.getSelectedCourse().size();t++)
		{
			if(tfCourse.getText().equals(WindowStudent.loggingStudent.getSelectedCourse().get(t).getName()))
			{
				tfTime.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getCourseTime()+"");
				tfTeacher.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getTeacher());
				tfMark.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getMark()+"");
			}
		}*/
	}
	public void windowSearchSelectedCourses() //throws Exception
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
		Label lbCourseTime=new Label("课时(小时)");
		lbCourseTime.setTextFill(Color.DARKRED);
		Label lbCourseTeacher=new Label("任课教师");
		lbCourseTeacher.setTextFill(Color.DARKRED);
		Label lbCourseMark=new Label("学分");
		lbCourseMark.setTextFill(Color.DARKRED);
		gridPaneLow.add(lbCourseName,0,0);
		gridPaneLow.add(lbCourseTime,1,0);
		gridPaneLow.add(lbCourseTeacher,2,0);
		gridPaneLow.add(lbCourseMark,3,0);   
		
		int i=1;
		
		for(Course myCourse:WindowStudent.loggingStudent.getSelectedCourse())
		{
			
			Label lb1=new Label(myCourse.getName());
			Label lb2=new Label(myCourse.getCourseTime()+"");
			Label lb3=new Label(myCourse.getTeacher());
			Label lb4=new Label(myCourse.getMark()+"");
			gridPaneLow.add(lb1,0,i);
			gridPaneLow.add(lb2,1,i);
			gridPaneLow.add(lb3,2,i);
			gridPaneLow.add(lb4,3,i);
			i++;
			
		}
	
		/*Label lb1=new Label(getLoggingStudent().getSelectedCourse().get(0).getName());
		gridPaneLow.add(lb1, 0, 1); */
		
		
			
		Label lbfast=new Label("快速查询通道");
		lbfast.setTextFill(Color.GREEN);
		Label lbEnd=new Label("查询结果如下");
		lbEnd.setTextFill(Color.BLUE);
		Label lbinput=new Label("请输入课程名称：");
		 tfCourse=new TextField();
		tfCourse.setEditable(true);
		Label lbTime=new Label("课时(小时)：");
		 tfTime=new TextField();
		tfTime.setEditable(false);
		Label lbTeacher=new Label("任课教师：");
		 tfTeacher=new TextField();
		tfTeacher.setEditable(false);
		Label lbMark=new Label("学分：");
		 tfMark=new TextField();
		tfMark.setEditable(false);
		Button btOk=new Button("确定");
		btOk.setOnAction(e->
		{
			int t=0;
			boolean warning=false;
			for(;t<WindowStudent.loggingStudent.getSelectedCourse().size();t++)
			{
				if(tfCourse.getText().equals(WindowStudent.loggingStudent.getSelectedCourse().get(t).getName()))
				{
					tfTime.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getCourseTime()+"");
					tfTeacher.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getTeacher());
					tfMark.setText(WindowStudent.loggingStudent.getSelectedCourse().get(t).getMark()+"");
					warning=true;
				}
				
			}
			if((!warning)&&!(tfCourse.getText().equals("")))
			{
				(new WarnAddRemove()).warnAddRemove("对不起！\n您没有选择该课程！");
			}
			if((!warning)&&(tfCourse.getText().equals("")))
			{
				(new WarnAddRemove()).warnAddRemove("请输入课程！");
			}
			
		
		});	
				
			
		
	
		
		gridPaneFast.add(lbfast, 0, 0);
		gridPaneFast.add(lbinput, 0, 2);
		gridPaneFast.add(btOk,3,2);
		gridPaneFast.add(lbEnd, 0, 3);
		gridPaneFast.add(lbTime, 0, 4);
		gridPaneFast.add(lbTeacher, 0, 5);
		gridPaneFast.add(lbMark, 0, 6);
		gridPaneFast.add(tfCourse, 1, 2);
		gridPaneFast.add(tfTime, 1, 4);
		gridPaneFast.add(tfTeacher, 1, 5);
		gridPaneFast.add(tfMark, 1, 6);
		borderPane1.setLeft(scrollPane);
		borderPane1.setRight(gridPaneFast);
		Scene scene=new Scene(borderPane1,000,500);
		stage.setTitle("查询课程");
		stage.setScene(scene);
		stage.show();
		
		
	
	}
}
