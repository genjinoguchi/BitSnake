import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener{
	private Square[][] board;
	private Square root;
	private int dx=0,dy=1;
	Thread movement, painting;

	public Board(){
		//init();
		//addKeyListener(this);
		//repaint();
		//movement.start();
		//painting.start();
		
		for(int x=0;x<10;x++){
			for(int y=0;y<10;y++){
				System.out.println("" + x + " " + y);
			}
		}
	}

	public void move(){
		board[root.getRow()+dy][root.getColumn()+dx].setColor(Color.blue);
		root = board[root.getRow()+dy][root.getColumn()+dx];
	}

	public void init(){
		board = new Square[50][50];
		for(int row=0;row<50;row++){
			for(int col=0;col<50;col++){
				board[row][col]=new Square();
				board[row][col].setCoordinates(col*10,row*10);
				board[row][col].setRowColumn(row,col);
				System.out.println(board[row][col]);
			}
		}

		board[25][25].setColor(Color.blue);
		root = board[25][25];
		System.out.println(root);
		movement = new Thread(new Mover());
		painting = new Thread(new Repainter());
	}

	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		for(int row=0;row<50;row++){
			for(int col=0;col<50;col++){
				board[row][col].paint(g2d);
			}
		}

	}

	public void run(char c){
		switch(c){
			case 'a':
			dy=0;
			dx=-1;
			break;
			case 's':
			dx=0;
			dy=-1;
			break;
			case 'd':
			dy=0;
			dx=1;
			break;
			case 'w':
			dy=1;
			dx=0;
			break;
			default:
		}
		System.out.println(""+dy+dx);

	}

	public void keyReleased(KeyEvent e){

	}
	public void keyPressed(KeyEvent e){
		run(e.getKeyChar());
		System.out.println("hurrdurr");
	}
	public void keyTyped(KeyEvent e){

	}

	public Board getParentClass(){
		return this;
	}

	private class Repainter implements Runnable{
		public void run() {
			getParentClass().repaint();
			System.out.println("Hurr");
			try{
				Thread.sleep(60);
			}catch(InterruptedException e){}
			run();
		}
	}

	private class Mover implements Runnable{
		public void run(){
			move();
			System.out.println("Durr");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
			run();
		}
	}

}