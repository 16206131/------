package ѧ��ѡ��ϵͳʵ��;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class WindowErrorLog 
{
	public WindowErrorLog()
	{
		windowErrorLog();
	}
	public void windowErrorLog()
	{
		Stage stageError=new Stage();
		Label lbError=new Label("��Ǹ��������Ϣ����ȷ\n���������룡");
		StackPane stackPaneError=new StackPane();
		stackPaneError.getChildren().add(lbError);
		Scene scene=new Scene(stackPaneError,300,100);
		stageError.setTitle("Warning");
		stageError.setScene(scene);
		stageError.show();
		stageError.setResizable(false);
	}
}
