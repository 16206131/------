package 学生选课系统实验;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class WarnAddRemove 
{
	public WarnAddRemove()
	{
		
	}
	public void warnAddRemove(String s)
	{
		Stage stageError=new Stage();
		Label lbError=new Label(s);
		StackPane stackPaneError=new StackPane();
		stackPaneError.getChildren().add(lbError);
		Scene scene=new Scene(stackPaneError,300,100);
		stageError.setTitle("Warning");
		stageError.setScene(scene);
		stageError.show();
		stageError.setResizable(false);
	}
}
