import java.awt.Graphics2D;
import java.awt.Color;

public class Square{
	private Color color;
	private Square next;
	private int px,py; //Location of the top right.
	private int row,col; //Location in array;

	public Square(){
		color=Color.black;
	}

	public Square(Color c){
		setColor(c);
	}

	public void paint(Graphics2D g2d){
		g2d.setColor(color);
		g2d.fillRect(px,py,10,10);
	}

	public void setNext(Square s){
		next = s;
	}
	public Square getNext(Square s){
		return next;
	}
	public void setColor(Color c){
		color = c;
	}
	public Color getColor(){
		return color;
	}
	public boolean isSnake(){
		return color==Color.blue;
	}
	public int getPX(){
		return px;
	}
	public int getPY(){
		return py;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return col;
	}
	public void setCoordinates(int x,int y){
		px=x;
		py=y;
	}
	public void setRowColumn(int row,int column){
		this.row = row;
		this.col = col;
	}
	public String toString(){
		return "" + col + " " + row;
	}
}