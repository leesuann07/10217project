package views;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.MainApp;

public class DayController extends MasterController{
	@FXML private Label lblDay;
	@FXML private Label lblCount;
	
	private LocalDate date;
	
	private boolean isFocused = false;
	
	public void setDayLabel(LocalDate date) {
		this.date = date;
		//해당 날짜의 일자를 가져온다.
		lblDay.setText(String.valueOf(date.getDayOfMonth()));
	}
	
	public void setCountLabel(Integer count) {
		lblCount.setText(count.toString());
	}
	
	@Override
	public void reset() {
		
	}
	public void setFocus() {
		//클릭되었을때 실행할 함수
		if(isFocused) {
			MainApp.app.loadTodoDate(date);
			MainApp.app.loadPane("todo");
			return;
		}
		MainController mc 
			= (MainController) MainApp.app.getController("main");
		mc.resetClickData();
		mc.setTodayInfo(date);
		isFocused = true;
		getRoot().getStyleClass().add("active");
	}
	
	public void outFocus() {
		isFocused = false;
		getRoot().getStyleClass().remove("active");
	}

	
}
