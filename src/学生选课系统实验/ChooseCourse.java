package ѧ��ѡ��ϵͳʵ��;
import javafx.stage.Stage;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
public class ChooseCourse extends Application
{
	public static TextField tfId;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		BorderPane borderPane1=new BorderPane();
		StackPane stackPane1=new StackPane();
		stackPane1.setStyle("-fx-background-color:orange");
		stackPane1.setPadding(new Insets(30,30,30,30));
		Image image1=new Image("image1.jpg");
		ImageView IV1=new ImageView(image1);
		IV1.setFitHeight(250);
		IV1.setFitWidth(500);
		Label lb1=new Label("��ӭ����ѡ��ϵͳ",IV1);
		lb1.setContentDisplay(ContentDisplay.BOTTOM);
		lb1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,50));
		lb1.setTextFill(Color.GREEN);
		stackPane1.getChildren().add(lb1);
		GridPane gridPane1=new GridPane();
		gridPane1.setAlignment(Pos.CENTER);
		gridPane1.setHgap(5);
		gridPane1.setVgap(5);
		gridPane1.setStyle("-fx-background-color:white");
		Label lbId=new Label("�˺ţ�");
		Label lbPassword=new Label("���룺");
		Label lbPerson=new Label("��ݣ�");
		tfId=new TextField();
		tfId.setPrefColumnCount(8);                 
		PasswordField passwordField=new PasswordField();
		passwordField.setPrefColumnCount(8);                 
		ComboBox<String> cboPerson=new ComboBox<>();
		cboPerson.getItems().addAll("ѧ��","����Ա");
		cboPerson.setValue("ѧ��");
		Button btLog=new Button("��¼");
		gridPane1.add(lbId,0,0);
		gridPane1.add(tfId,1,0);		
		gridPane1.add(lbPassword,0,1);
		gridPane1.add(passwordField,1,1);
		gridPane1.add(lbPerson,0,2);
		gridPane1.add(cboPerson,1,2);
		gridPane1.add(btLog,1,3);
		gridPane1.setHalignment(btLog,HPos.RIGHT);
		borderPane1.setTop(stackPane1);
		borderPane1.setCenter(gridPane1);
		Scene scene=new Scene(borderPane1,2000,650);
		primaryStage.setTitle("��ӭ����ѡ��ϵͳ");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(true);
		ArrayList<Person> personList=AdmittedPersons.createPersonList();
		/*try {
			new Courses2();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		btLog.setOnAction(e->
		{	
			try {
				new Courses2();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			boolean flag=false;
			int flag1=0;
			for(Person person:personList) 
			{
				if(tfId.getText().equals(person.getIdCard())&&passwordField.getText().equals(person.getPassword())&&cboPerson.getValue().equals(person.getProfession()))
				{
					
					flag=true;
				}
				if(flag&&(cboPerson.getValue()).equals("ѧ��"))
				{
					flag1=1;
					try {
						new WindowStudent();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
					break;
				}
				if(flag&&cboPerson.getValue().equals("����Ա"))
				{
					flag1=1;
					new WindowManager();
				
					
						
					
					break;
				}
			}
			if(flag1==0)
			{
				new WindowErrorLog();
			}
			
		});
		//new WindowStudent();
		//new WindowManager();
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
} 