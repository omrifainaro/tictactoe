import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class GameBoard extends Applet implements MouseListener, Symbols{
	
	private int turn = 1;
	int[] board = new int[9];
	
	public void init() {
		this.setSize(600, 600);
		this.setMinimumSize(new Dimension(600, 600));
		this.setMaximumSize(new Dimension(600, 600));
		this.setBackground(Color.cyan);
		this.addMouseListener(this);
		for (int i = 0; i < board.length; i++) {
			board[i] = EMPTY;
		}
	}
	
	public void start() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Graphics g = this.getGraphics();
		
		if (x > 0 && x < 200 && y > 0 && y < 200 && board[0] == EMPTY) {
			if (turn == 1) {
				board[0] = X;
				DrawX(0, 0);
				turn ++;
			}
			else{
				board[0] = O;
				DrawO(0, 0);
				turn --;
			}
		}
		
		if (x > 200 && x < 400 && y > 0 && y < 200 && board[1] == EMPTY) {
			if (turn == 1) {
				board[1] = X;
				DrawX(1, 0);
				turn ++;
			}
			else{
				board[1] = O;
				DrawO(1, 0);
				turn --;
			}
		}
		
		if (x > 400 && x < 600 && y > 0 && y < 200 && board[2] == EMPTY) {
			if (turn == 1) {
				board[2] = X;
				DrawX(2, 0);
				turn ++;
			}
			else{
				board[2] = O;
				DrawO(2, 0);
				turn --;
			}
		}
		
		if (x > 0 && x < 200 && y > 200 && y < 400 && board[3] == EMPTY) {
			if (turn == 1) {
				board[3] = X;
				DrawX(0, 1);
				turn ++;
			}
			else{
				board[3] = O;
				DrawO(0, 1);
				turn --;
			}
		}
		
		if (x > 200 && x < 400 && y > 200 && y < 400 && board[4] == EMPTY) {
			if (turn == 1) {
				board[4] = X;
				DrawX(1, 1);
				turn ++;
			}
			else{
				board[4] = O;
				DrawO(1, 1);
				turn --;
			}
		}
		
		if (x > 400 && x < 600 && y > 200 && y < 400 && board[5] == EMPTY) {
			if (turn == 1) {
				board[5] = X;
				DrawX(2, 1);
				turn ++;
			}
			else{
				board[5] = O;
				DrawO(2, 1);
				turn --;
			}
		}
		
		if (x > 0 && x < 200 && y > 400 && y < 600 && board[6] == EMPTY) {
			if (turn == 1) {
				board[6] = X;
				DrawX(0, 2);
				turn ++;
			}
			else{
				board[6] = O;
				DrawO(0, 2);
				turn --;
			}
		}
		
		if (x > 200 && x < 400 && y > 400 && y < 600 && board[7] == EMPTY) {
			if (turn == 1) {
				board[7] = X;
				DrawX(1, 2);
				turn ++;
			}
			else{
				board[7] = O;
				DrawO(1, 2);
				turn --;
			}
		}
		
		if (x > 400 && x < 600 && y > 400 && y < 600 && board[8] == EMPTY) {
			if (turn == 1) {
				board[8] = X;
				DrawX(2, 2);
				turn ++;
			}
			else{
				board[8] = O;
				DrawO(2, 2);
				turn --;
			}
		}
		
		check();
	}
	
	public void check(){
		if(isFull()){
			showMessage("It's a tie!");
			System.exit(0);
		}
		vertical();
		horizontal();
		diagonals();
	}
	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(null, msg, "Omri's Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void diagonals(){
		for (int i = 0; i < 3; i+=2) {
			if (board[i] != EMPTY) {
				if (i == 0) {
					if (board[i] == board[4] && board[i] == board[8]) {
						if (board[i] == X)
						{
							showMessage("X Wins");
							System.exit(0);
						}	
						else
						{
							showMessage("O Wins");
							System.exit(0);
						}
					}
				}
				else if(i == 2){
					if (board[i] == board[4] && board[i] == board[6]) {
						if (board[i] == X)
						{
							showMessage("X Wins");
							System.exit(0);
						}	
						else
						{
							showMessage("O Wins");
							System.exit(0);
						}
					}
				}
			}
		}
	}
	
	public void horizontal(){
		for (int i = 0; i < 7; i+=3) {
			if(board[i] != EMPTY){
				if(board[i] == board[i+1] && board[i] == board[i+2]){
					if (board[i] == X)
					{
						showMessage("X Wins");
						System.exit(0);
					}	
					else
					{
						showMessage("O Wins");
						System.exit(0);
					}
				}
			}
		}
	}
	
	public void vertical(){
		for(int i = 0; i < 3; i++)
		{
			if(board[i] != EMPTY){
				if(board[i+3] == board[i] && board[i+6] == board[i]){
					if (board[i] == X)
					{
						showMessage("X Wins");
						System.exit(0);
					}	
					else
					{
						showMessage("O Wins");
						System.exit(0);
					}
	            }
	        }
	    }
	}
	
	public boolean isFull(){
		for (int i = 0; i < board.length; i++) {
			if (board[i] == EMPTY) {
				return false;
			}
		}
		return true;
	}
	
	public void DrawO(int x, int y){
		Graphics g = this.getGraphics();
		g.setColor(Color.BLACK);
		g.drawOval(x*200, y*200 , 200, 200);
	}
	
	public void DrawX(int x, int y){
		Graphics g = this.getGraphics();
		g.setColor(Color.red);
		g.drawLine(x*200, y*200, x*200 + 200, y*200 + 200);
		g.drawLine(x*200, y*200 + 200, x*200 + 200, y*200);
	}
	
	public void stop() {
		super.stop();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	public void paint(Graphics g){
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
