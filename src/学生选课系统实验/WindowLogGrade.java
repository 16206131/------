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

public class WindowLogGrade 
{
	//public ArrayList<TextField> tfList=new ArrayList<>();
	public WindowLogGrade(Course course1) throws Exception
	{
	
		windowLogGrade(course1);
		 
	}
	public void windowLogGrade(Course course2) throws Exception
	{	ArrayList<TextField> tfList=new ArrayList<>();
		Stage stage=new Stage();
		BorderPane borderPane1=new BorderPane();
		GridPane gridPane1=new GridPane();
		gridPane1.setPadding(new Insets(30,100,50,100));
		gridPane1.setGridLinesVisible(true);
		ScrollPane scrollPane=new ScrollPane(gridPane1);
		HBox hbox=new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10,10,10,50));
		VBox vbox=new VBox(10);
		vbox.setPadding(new Insets(30,100,50,100));
		//ArrayList<Student> stu=course2.getStudentsList();
		//Label lbTitle=new Label("《"+course2.getName()+"》课程学生名单");
		
		Label lbId=new Label("		学号		");
		lbId.setMaxWidth(200);
		Label lbName=new Label("	姓名		");
		lbId.setMaxWidth(200);
		Label lbGrade=new Label("		分数		");
		Scanner input=new Scanner(course2.getSaveStudentsInformation());
		gridPane1.add(lbId,0,0);
		gridPane1.add(lbName, 1, 0);
		gridPane1.add(lbGrade, 2, 0);
		ArrayList<Student> studentsList=new ArrayList<>();
		while(input.hasNext())
		{
			studentsList.add(new Student(input.next(),input.next()));
		}
		Student t=new Student();
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
		
		Scanner read=new Scanner(course2.getLogGrade());
		
		for(int i=0;i<studentsList.size();i++)
		{
			Label lb1=new Label(studentsList.get(i).getId());
			Label lb2=new Label(studentsList.get(i).getName());
			TextField tfGrade=new TextField();
			int k=i;
			if(read.hasNext())
			{
				tfGrade.setText(read.next());
				
			}
			tfGrade.setAlignment(Pos.CENTER_LEFT);
			tfList.add(tfGrade);
			
			gridPane1.add(lb1, 0, i+1);
			gridPane1.add(lb2,1,i+1);
			gridPane1.add(tfGrade,2,i+1);
		}
		read.close();
		Button btSave=new Button("保存");
		//Button btCorrect=new Button("修改");
		vbox.getChildren().add(btSave);
		hbox.getChildren().add(new Label("《"+course2.getName()+"》学生成绩登记表"));
		borderPane1.setTop(hbox);
		borderPane1.setCenter(scrollPane);
		borderPane1.setRight(vbox);
		Scene scene=new Scene(borderPane1,800,600);
		stage.setTitle("《"+course2.getName()+"》成绩登记表");
		stage.setScene(scene);
		stage.show();
		
		PrintWriter write=new PrintWriter(course2.getLogGrade());
		btSave.setOnAction(e->
		{
			for(TextField tf:tfList)
			{
				
				write.println(tf.getText());
				tf.setEditable(false);
				
			}
			write.close();
		});
		
		
	}
	
	
}
