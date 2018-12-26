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
import java.util.Scanner;
public class WindowStudent 
{
	private String[] choiceType= {"选课/删课","查询选课","查询成绩"};
	public  static Student loggingStudent;
	
	public WindowStudent() throws Exception
	{
		windowStudent();
	}
	public void windowStudent() throws Exception
	{
		for(Student student:new Students().students)
		{
			/*if(ChooseCourse.tfId.getText().equals(student.getId()))
			{
				loggingStudent=student;
				break;
			}*/
			if(Long.parseLong(ChooseCourse.tfId.getText())==Long.parseLong(student.getId()))
			{
				loggingStudent=student;
				ArrayList<Course> loggingStudentCourses=new ArrayList<>();
				Scanner inputLoggingStudentCourses=new Scanner(loggingStudent.getSaveCourses());
				while(inputLoggingStudentCourses.hasNext())
				{
					Course loggingStudentCourse=new Course();
					loggingStudentCourse.setName(inputLoggingStudentCourses.next());
					loggingStudentCourse.setCourseTime(Integer.parseInt(inputLoggingStudentCourses.next()));
					loggingStudentCourse.setTeacher(inputLoggingStudentCourses.next());
					loggingStudentCourse.setMark(Float.parseFloat(inputLoggingStudentCourses.next()));
					loggingStudentCourses.add(loggingStudentCourse);
					
				}
			   // inputLoggingStudentCourses.close();
				loggingStudent.setSelectedCourse(loggingStudentCourses);  
				
				break;
			}
		}
		Stage stageStudent=new Stage();
		BorderPane borderPaneStudent=new BorderPane();
		BorderPane borderPaneTop=new BorderPane();
		borderPaneTop.setStyle("-fx-background-color:white");
		borderPaneTop.setPadding(new Insets(0,0,0,0));
		Image image2=new Image("image2.jpg");
		ImageView imageViewStudent=new ImageView(image2);
		imageViewStudent.setFitHeight(100);
		imageViewStudent.setFitWidth(1300);
		Label lb1=new Label("Student",imageViewStudent);
		lb1.setStyle("-fx-border-color: green;-fx-background-color:white");
		lb1.setContentDisplay(ContentDisplay.BOTTOM);
		lb1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,50));
		lb1.setTextFill(Color.GREEN);
		lb1.setMaxWidth(1200);
		lb1.setMaxHeight(200);
		borderPaneTop.setCenter(lb1);
		VBox vBoxStudent=new VBox(10);
		vBoxStudent.setPadding(new Insets(30,20,20,20));
		vBoxStudent.setStyle("-fx-background-color:blue;-fx-border-color:black");
		Label lbWarning=new Label("请选择操作类型");
		lbWarning.setTextFill(Color.RED);
		
		ListView<String> lvStudent=new ListView<>(FXCollections.observableArrayList(choiceType));
		lvStudent.setPrefSize(100,100);
		lvStudent.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lvStudent.getSelectionModel().selectedItemProperty().addListener(ov->
		{
			if(lvStudent.getSelectionModel().getSelectedItem().equals("选课/删课"))
			{
				try {
					new WindowAddOrMove();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(lvStudent.getSelectionModel().getSelectedItem().equals("查询选课"))
			{
				try {
					new WindowSearchSelectedCourses();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(lvStudent.getSelectionModel().getSelectedItem().equals("查询成绩"))
			{
				try {
					new WindowStudentSearchGrade();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		vBoxStudent.getChildren().addAll(lbWarning,lvStudent);
		Label lbStudent=new Label("学生：");
		TextField tfStudent=new TextField();
		tfStudent.setAlignment(Pos.CENTER);
		tfStudent.setText(getTextName());
		tfStudent.setEditable(false);
		HBox hBoxStudent=new HBox(5);
		hBoxStudent.setPadding(new Insets(30,150,500,20));
		hBoxStudent.getChildren().addAll(lbStudent,tfStudent);
		borderPaneStudent.setTop(lb1);
		borderPaneStudent.setLeft(vBoxStudent);
		borderPaneStudent.setRight(hBoxStudent);
		Scene sceneStudent=new Scene(borderPaneStudent,2600,650);
		stageStudent.setTitle("学生窗口");
		stageStudent.setScene(sceneStudent);
		stageStudent.show();
		
	}
	
	public String getTextName()
	{
		for(Person person:AdmittedPersons.personList)
		{
			if(person.getIdCard().equals(ChooseCourse.tfId.getText()))
			{
				return person.getName();
				
			}
		}
		return null;
	}
	public void setLoggingStudent(Student loggingStudent)
	{
		this.loggingStudent=loggingStudent;
	}
	public Student getLoggingStudent()
	{
		return loggingStudent;
	}
}
