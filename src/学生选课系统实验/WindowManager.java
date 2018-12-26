package 学生选课系统实验;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.Scanner;
public class WindowManager
{
	
	public Button btOk;
	RadioButton rbStuInfo;
	RadioButton rbLogGrade;
	RadioButton rbSearchGrade;
	RadioButton rbAverage;
	ListView<Object> lvCourse;
	private ArrayList<String> systemCourses=new ArrayList<>();
	 
	
	public WindowManager() 
	{
		windowManager();
		
	
	}
	public void windowManager()
	{
		
		try {
			loadSystemCourses();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorderPane borderPaneManager=new BorderPane();
		StackPane stackPaneManager=new StackPane();
		stackPaneManager.setPadding(new Insets(5,200,5,200));
		ImageView ivManager=new ImageView("image3.jpg");
		ivManager.setFitHeight(200);
		ivManager.setFitWidth(300);
		Label lb1=new Label("Manager",ivManager);
		//lb1.setStyle("-fx-border-color: green;-fx-background-color:white");
		lb1.setContentDisplay(ContentDisplay.BOTTOM);
		lb1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,70));
		lb1.setTextFill(Color.GREEN);
		lb1.setMaxWidth(1200);
		lb1.setMaxHeight(200);
		stackPaneManager.getChildren().add(lb1);
		borderPaneManager.setTop(stackPaneManager);
		BorderPane borderPaneCourse=new BorderPane();
		borderPaneCourse.setPadding(new Insets(30,30,60,80));
		Label lbCourse=new Label("选择课程：");
		lbCourse.setStyle("-fx-border-color:blue");
		lbCourse.setTextFill(Color.SEAGREEN);
		
		lvCourse=new ListView<Object>(FXCollections.observableArrayList(systemCourses.toArray()));
		lvCourse.setPrefSize(100,200);
		lvCourse.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		borderPaneCourse.setTop(lbCourse);
		//ScrollPane scrollPaneCourse=new ScrollPane(lvCourse);
		borderPaneCourse.setCenter(lvCourse);
		BorderPane borderPaneFunction=new BorderPane();
		borderPaneFunction.setPadding(new Insets(30,250,30,700));
		Label lbFunction=new Label("选择功能：");
		lbFunction.setStyle("-fx-border-color:red");
		lbFunction.setTextFill(Color.RED);
		rbStuInfo=new RadioButton("查询学生信息");
		rbLogGrade=new RadioButton("登记成绩");
		rbSearchGrade=new RadioButton("查询学生成绩");
		rbAverage=new RadioButton("课程平均成绩");
		ToggleGroup group=new ToggleGroup();
		rbStuInfo.setToggleGroup(group);
		rbLogGrade.setToggleGroup(group);
		rbSearchGrade.setToggleGroup(group);
		rbAverage.setToggleGroup(group);
		VBox vBoxFunction=new VBox(5);
		vBoxFunction.setPadding(new Insets(20,0,0,0));
		vBoxFunction.getChildren().addAll(rbStuInfo,rbLogGrade,rbSearchGrade,rbAverage);
		borderPaneFunction.setTop(lbFunction);
		borderPaneFunction.setCenter(vBoxFunction);
		btOk=new Button("   OK   ");
		handleBtOk();
		
		
		HBox hBoxBt=new HBox();
		hBoxBt.setPadding(new Insets(30,30,30,30));
		hBoxBt.setStyle("-fx-background-color:gray");
		hBoxBt.setAlignment(Pos.CENTER);
		hBoxBt.getChildren().add(btOk);
		borderPaneManager.setLeft(borderPaneCourse);
		borderPaneManager.setRight(borderPaneFunction);
		borderPaneManager.setBottom(hBoxBt);
		Stage windowManager=new Stage();
		Scene sceneManager=new Scene(borderPaneManager,2600,650);
		windowManager.setTitle("管理者窗口");
		windowManager.setScene(sceneManager);
		windowManager.show();	
		
	}
	public void loadSystemCourses() throws Exception
	{
		File fileSystemCourses=new File("systemCourses.txt");
		Scanner input=new Scanner(fileSystemCourses);
		while(input.hasNext())
		{
			systemCourses.add(input.next());
		}
		//input.close();
	}
	
	public void handleBtOk() //throws Exception
	{
		
		btOk.setOnAction(e->
		{
			if(rbStuInfo.isSelected())
			{
				//lvCourse.getSelectionModel().selectedItemProperty().addListener(ov->
				//{
					try {
							for( int i=0;i<Courses2.courses2.size();i++)
							{
								
								if(Courses2.courses2.get(i).getName().equals(lvCourse.getSelectionModel().getSelectedItem()))
								{
									
									
									try {
											new WindowSearchStudentsInformation(Courses2.courses2.get(i));
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										break;
									
												
								}
							}
						} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
										}
								
				
			}
			else if(rbLogGrade.isSelected())
			{
				try {
					for( int i=0;i<Courses2.courses2.size();i++)
					{
						
						if(Courses2.courses2.get(i).getName().equals(lvCourse.getSelectionModel().getSelectedItem()))
						{
							
							
							try {
									new WindowLogGrade(Courses2.courses2.get(i));
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							
										
						}
					}
				} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}
						
		
			}
			else if(rbAverage.isSelected())
			{
				try {
					for( int i=0;i<Courses2.courses2.size();i++)
					{
						
						if(Courses2.courses2.get(i).getName().equals(lvCourse.getSelectionModel().getSelectedItem()))
						{
							
							
							try {	
									int total=0;
											
									double ave=0,count=0;
									Scanner inputGrade=new Scanner(Courses2.courses2.get(i).getLogGrade());
									while(inputGrade.hasNext())
									{
										total+=inputGrade.nextInt();
										count++;
									}
									ave=Math.round((total/count)*100)/100.0;
									new WarnAddRemove().warnAddRemove("《"+Courses2.courses2.get(i).getName()+"》的平均成绩为\n\t\t"+ave);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							
										
						}
					}
				} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}
						
		
			}
			else if(rbSearchGrade.isSelected())
			{
				try {
					for( int i=0;i<Courses2.courses2.size();i++)
					{
						
						if(Courses2.courses2.get(i).getName().equals(lvCourse.getSelectionModel().getSelectedItem()))
						{
							
							
							try {
									new WindowSearchGrade(Courses2.courses2.get(i));
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							
										
						}
					}
				} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}
						
		
			}
		});		
		
	}
}

