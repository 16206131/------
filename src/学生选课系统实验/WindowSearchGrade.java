package 学生选课系统实验;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import javafx.geometry.*;
public class WindowSearchGrade 
{
	public WindowSearchGrade(Course course1) throws Exception
	{
	
		windowSearchGrade(course1);
		 
	}
	public void windowSearchGrade(Course course2) throws Exception
	{	
		Scanner read=new Scanner(course2.getLogGrade());
		if(!read.hasNext())
			new WarnAddRemove().warnAddRemove("对不起！还没有登记成绩");
		else
		{
			Stage stage=new Stage();
			BorderPane borderPane1=new BorderPane();
			GridPane gridPane1=new GridPane();
			gridPane1.setPadding(new Insets(30,100,50,100));
			gridPane1.setGridLinesVisible(true);
			ScrollPane scrollPane=new ScrollPane(gridPane1);
			HBox hbox=new HBox();
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(10,10,10,50));
			Label lbTitle=new Label("《"+course2.getName()+"》课程学生成绩单");
			
			Label lbId=new Label("学号");
			lbId.setPrefWidth(80);
			lbId.setAlignment(Pos.CENTER);
			Label lbName=new Label("姓名");
			lbName.setPrefWidth(80);
			lbName.setAlignment(Pos.CENTER);
			Label lbGrade=new Label("分数  ");
			lbGrade.setPrefWidth(80);
			lbGrade.setAlignment(Pos.CENTER);
			Label lbMark=new Label("学分");
			lbMark.setPrefWidth(80);
			lbMark.setAlignment(Pos.CENTER);
			Label lbNum=new Label("排名");
			lbNum.setPrefWidth(80);
			lbNum.setAlignment(Pos.CENTER);
			Label lbAve=new Label("平均分");
			lbAve.setPrefWidth(80);
			lbAve.setAlignment(Pos.CENTER);
			Scanner input=new Scanner(course2.getSaveStudentsInformation());
			gridPane1.add(lbId,0,0);
			gridPane1.add(lbName, 1, 0);
			gridPane1.add(lbGrade, 2, 0);
			gridPane1.add(lbMark, 3, 0);
			gridPane1.add(lbNum, 4, 0);
			ArrayList<Student> studentsList=new ArrayList<>();
			while(input.hasNext())
			{
				studentsList.add(new Student(input.next(),input.next()));
				
			}
			//input.close();
			Student t;
			for(int i=0;i<studentsList.size()-1;i++)
			{
				for(int j=i+1;j<studentsList.size();j++)
				{
					if(Long.parseLong(studentsList.get(i).getId())>Long.parseLong(studentsList.get(j).getId()))
					{
						t=studentsList.get(i);
						studentsList.set(i,studentsList.get(j));
						studentsList.set(j,t);
					}
				}
			}
			//Scanner read=new Scanner(course2.getLogGrade());
			if(read.hasNext())
			{
				for(int i=0;i<studentsList.size();i++)
				{	
					studentsList.get(i).setGrade(Integer.parseInt(read.next()));
				}
			}
			Student t2;
			for(int i=0;i<studentsList.size()-1;i++)
			{
				for(int j=i+1;j<studentsList.size();j++)
				{
					if(studentsList.get(i).getGrade()<studentsList.get(j).getGrade())
					{
						t2=studentsList.get(i);
						studentsList.set(i,studentsList.get(j));
						studentsList.set(j,t2);
					}
				}
			}
			float totalGrade=0;
			for(int i=0,k=1;i<studentsList.size();i++)
			{	
				totalGrade+=studentsList.get(i).getGrade();
				Label lb1=new Label("   "+studentsList.get(i).getId()+"   ");
				lb1.setAlignment(Pos.CENTER);
				lb1.setPrefWidth(80);
				Label lb2=new Label(" "+studentsList.get(i).getName());
				lb2.setAlignment(Pos.CENTER);
				lb2.setPrefWidth(80);
				Label lb3=new Label(""+studentsList.get(i).getGrade());
				lb3.setAlignment(Pos.CENTER);
				lb3.setPrefWidth(80);
				float j=studentsList.get(i).getGrade()>=60?course2.getMark():0;
				Label lb4=new Label("  "+j);
				lb4.setAlignment(Pos.CENTER);
				lb4.setPrefWidth(80);
				Label lb5=new Label(""+k);
				lb5.setAlignment(Pos.CENTER);
				lb5.setPrefWidth(80);
				k++;
				gridPane1.add(lb1,0,i+1);
				gridPane1.add(lb2,1,i+1);
				gridPane1.add(lb3,2,i+1);
				gridPane1.add(lb4,3,i+1);
				gridPane1.add(lb5,4,i+1);
				
			}
			gridPane1.add(lbAve,0,studentsList.size()+2);
			Label lbAveGrade=new Label(Math.round((totalGrade/studentsList.size())*100)/100.0+"");
			lbAveGrade.setPrefWidth(80);
			lbAveGrade.setAlignment(Pos.CENTER);
			gridPane1.add(lbAveGrade,1,studentsList.size()+2);
			hbox.getChildren().add(lbTitle);
			borderPane1.setTop(hbox);
			borderPane1.setCenter(scrollPane);
			
			Scene scene=new Scene(borderPane1,800,600);
			stage.setTitle("《"+course2.getName()+"》成绩单");
			stage.setScene(scene);
			stage.show();
		}
	}
}
