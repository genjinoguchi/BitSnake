import javax.swing.*;
import java.awt.*;

public class Game{
	public JFrame frame;
	private Board board;
	public static int BOARD_WIDTH=500,BOARD_HEIGHT=500;

	public Game(){
		frame = new JFrame("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(30,0);
		frame.setSize(500,500);
		frame.setVisible(true);

		board = new Board();
		frame.getContentPane().add(board);
	}

	public static void main(String[] args) {
		Game g = new Game();

	}

}