package 学生选课系统实验;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.Scanner;
import javafx.geometry.Insets;

public class WindowSearchStudentsInformation 
{
	
	public WindowSearchStudentsInformation(Course course1) throws Exception
	{
	
		windowSearchStudentsInformation(course1);
		 
	}
	public void windowSearchStudentsInformation(Course course2) throws Exception
	{
		Stage stage=new Stage();
		BorderPane borderPane=new BorderPane();
		borderPane.setPadding(new Insets(10,100,100,100));
		GridPane gridPane=new GridPane();
		gridPane.setPadding(new Insets(30,70,10,90));
		gridPane.setGridLinesVisible(true);
		ScrollPane scrollPane=new ScrollPane(borderPane);
		VBox vBox=new VBox();
		ArrayList<Student> stu=course2.getStudentsList();
		Label lbTitle=new Label("《"+course2.getName()+"》课程学生名单");
		
		Label lbId=new Label("		学号		");
		lbId.setMaxWidth(200);
		Label lbName=new Label("	姓名		");
		lbId.setMaxWidth(200);
		Scanner input=new Scanner(course2.getSaveStudentsInformation());
		int i=1;
		int k=0;
		gridPane.add(lbId,0,0);
		gridPane.add(lbName,1,0);
		while(input.hasNext())
		{
			Label lb1=new Label(input.next());
			
			Label lb2=new Label(input.next());
			
			gridPane.add(lb1, 0, i);
			gridPane.add(lb2,1,i);
			i++;
			k++;
		}
		Label lbNum=new Label("共"+k+"人");
		//input.close();
		vBox.getChildren().addAll(lbTitle,lbNum);
		vBox.setAlignment(Pos.CENTER);
		borderPane.setTop(vBox);
		borderPane.setCenter(gridPane);
		Scene scene=new Scene(scrollPane,600,600);
		stage.setTitle("《"+course2.getName()+"》学生名单");
		stage.setScene(scene);
		stage.show();
		
		
		
	}
}

