package gobang;

public class IsWin {
	private int[][] location = Chessboard.getlocaton();
	public boolean isWin(int x, int y, int owner) {
		//判断水平
		int sum = 0;
		for(int i=x-1; i>=0; i-- ) {
			if ( location[i][y]==owner ) {
				sum ++;
			} else {
				break;
			}
		}
		for ( int i=x+1; i<Chessboard.getChessboardSize(); i++ ) {
			if ( location[i][y]==owner ) {
				sum ++;
			} else {
				break;
			}
		}
		if ( sum>=4 ) {
			return true;
		}
		
		//判断垂直
		sum = 0;
		for ( int i=y-1; i>=0; i-- ) {
			if ( location[x][i]==owner ) {
				sum ++;
			} else {
				break;
			}
		}
		for ( int i=y+1; i<Chessboard.getChessboardSize(); i++ ) {
			if ( location[x][i]==owner ) {
				sum ++;
			} else {
				break;
			}
		}
		if ( sum>=4 ) {
			return true;
		}
		//判断左上右下
		sum = 0;
		for ( int i=x-1,j=y-1; i>=0&&j>=0; i--,j-- ) {
			if ( location[i][j]==owner )
				sum ++;
			else break;
		}
		for ( int i=x+1,j=y+1; i<Chessboard.getChessboardSize()&&j<Chessboard.getChessboardSize(); i++,j++ ) {
			if ( location[i][j]==owner ) 
				sum ++;
			else break;
		}
		if ( sum>=4 ) 
			return true;
		
		//判断右上左下
		sum = 0;
		for ( int i=x+1,j=y-1; i<Chessboard.getChessboardSize()&&j>=0; i++,j-- ) {
			if ( location[i][j]==owner ) 
				sum ++;
			else break;
		}
		for ( int i=x-1,j=y+1; i>=0&&j<Chessboard.getChessboardSize(); i--,j++ ) {
			if ( location[i][j]==owner )
				sum ++;
			else break;
		}
		if ( sum>=4 ) 
			return true;
		
		return false;
	}
	
}
