package ctrl;

import java.util.ArrayList;

import model.MovieDAO;
import model.MovieVO;
import view.View;

public class Ctrl {
	//[멤버변수]
	private MovieDAO mDAO;
	private View view;
	
	//[생성자]
	public Ctrl() {
		this.mDAO=new MovieDAO();
		this.view=new View();
	}
	
	public void startApp() {
		ArrayList<MovieVO> mdatas=mDAO.selectAll(null);
		view.printList(mdatas);
	}
}
