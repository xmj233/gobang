package gobang;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Chessboard extends JPanel {
	private static final int CHESSBOARD_SIZE = 15;
	private int margin = 20;
	private static List<Location> locationList = new ArrayList<Location>();
	private static int[][] location = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
	private static int[][] score = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
	
	public Chessboard() {
		this.setBackground(new Color(137,190,178));
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		drawChessboard(g);
		drawChess(g);
	}
	
	public static int[][] getscore() {
		return score;
	}
	
	public static List<Location> getList() {
		return locationList;
	}

	public static int getChessboardSize() {
		return CHESSBOARD_SIZE;
	}
	
	public static int[][] getlocaton() {
		return location;
	}

	
	public int[][] getScore() {
		return score;
	}


	private void drawChessboard(Graphics g) {
		// TODO Auto-generated method stub
		int cellsize = (this.getWidth()-margin*2)/(CHESSBOARD_SIZE-1);
		for ( int i=0; i<CHESSBOARD_SIZE; i++ ) {
			g.drawLine(margin, margin+cellsize*i, this.getWidth()-margin, margin+cellsize*i);
			g.drawLine(margin+cellsize*i, margin, margin+cellsize*i, this.getHeight()-margin);
		}
	}
	
	private void drawChess(Graphics g) {
		int cellsize = (this.getWidth()-margin*2)/(CHESSBOARD_SIZE-1);
		for ( int i=0; i<locationList.size(); i++ ) {
			Location loc = locationList.get(i);
			if ( loc.getOwner()==1 ) {
				g.setColor(Color.black);
				g.fillOval(loc.getX()*cellsize+margin-cellsize/2, loc.getY()*cellsize+margin-cellsize/2, cellsize, cellsize);
			} else if ( loc.getOwner()==-1){
				g.setColor(Color.white);
				g.fillOval(loc.getX()*cellsize+margin-cellsize/2, loc.getY()*cellsize+margin-cellsize/2, cellsize, cellsize);
			}
			
		}
	}
	
	public void addChess(Location location) {
		locationList.add(location);
		repaint();
	}
	
	public void addLocation(int x, int y, int owner) {
		location[x][y] = owner;
	}
	
	public int getCellsize() {
		return (this.getWidth()-margin*2)/(CHESSBOARD_SIZE-1);
	}
	
	public boolean isLegal(int x, int y) {
		if ( x>=0&&x<CHESSBOARD_SIZE&&y>=0&&y<CHESSBOARD_SIZE&&location[x][y]==0 ) {
			return true;
		}
		return false;
	}
	
	public void init() {
		for ( int i=0; i<locationList.size(); i++ ) {
			locationList.get(i).setOwner(0);
		}
		for ( int i=0; i<CHESSBOARD_SIZE; i++ ) {
			for ( int j=0; j<CHESSBOARD_SIZE; j++ ) {
				location[i][j] = 0;
				score[i][j] = 0;
			}
		}
		
	}

}
















