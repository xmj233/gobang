package man_machine;

import gobang.Chessboard;
import gobang.Location;

public class SearchLocation {
	private int[][] location = Chessboard.getlocaton();
	private int[][] score = Chessboard.getscore();
	public Location searchLocation() {
		for ( int i=0; i<Chessboard.getChessboardSize(); i++ ) {
			for ( int j=0; j<Chessboard.getChessboardSize(); j++ ) {
				score[i][j] = 0;
			}
		}
		int humanChessmanNum = 0;
		int machineChessmanNum = 0;
		int tupleScoreTmp = 0;
		
		int goalX = -1;
		int goalY = -1;
		int maxScore = -1;
		
		//扫描纵向的15行
		for ( int i=0; i<15; i++ ) {
			for ( int j=0; j<11; j++ ) {
				int k = j;
				while ( k<j+5 ) {
					if ( location[i][k]==-1 ) machineChessmanNum++;
					else if ( location[i][k]==1 ) humanChessmanNum++;
					k ++;
				}
				tupleScoreTmp  = tupleScore(humanChessmanNum, machineChessmanNum);
				for ( k=j; k<j+5; k++ ) {
					score[i][k] += tupleScoreTmp;
				}
				humanChessmanNum = 0;
				machineChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		//扫描横向15行
		for ( int i=0; i<15; i++ ) {
			for ( int j=0; j<11; j++ ) {
				int k = j;
				while ( k<j+5 ) {
					if ( location[k][i]==-1 ) machineChessmanNum++;
					else if ( location[k][i]==1 ) humanChessmanNum++;
					k++;
				}
				tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
				for ( k=j; k<j+5; k++ ) {
					score[k][i] += tupleScoreTmp;
				}
				humanChessmanNum = 0;
				machineChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		//扫描右上角到左下角上侧部分
		for ( int i=14; i>=4; i-- ) {
			for (int k=i,j=0; j<15&&k>=0; j++,k-- ) {
				int m=k;
				int n=j;
				while ( m>k-5&&k-5>=-1 ) {
					if ( location[m][n]==-1 ) machineChessmanNum ++;
					else if ( location[m][n]==1 ) humanChessmanNum ++;
					m -- ;
					n ++ ;
				}
				if ( m==k-5 ) {
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					for ( m=k,n=j; m>k-5; m--,n++ ) {
						score[m][n] += tupleScoreTmp;
					}
				}
				humanChessmanNum = 0;
				machineChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		//扫描右上角到左下角的下侧部分
		for ( int i=1; i<15; i++ ) {
			for ( int k=i,j=14; j>=0&&k<15; j--,k++ ) {
				int m = k;
				int n = j;
				while ( m<k+5&&k+5<=15 ) {
					if ( location[n][m]==-1 ) machineChessmanNum ++;
					else if ( location[n][m]==1 ) humanChessmanNum ++;
					m++;
					n--;
				}
				if ( m==k+5 ) {
					tupleScore(humanChessmanNum, machineChessmanNum);
					for ( m=k,n=j; m<k+5; m++,n-- ) {
						score[n][m] += tupleScoreTmp;
					}
				}
				humanChessmanNum = 0;
				machineChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		//扫描左上角到右下角的上侧部分
		for ( int i=0; i<11; i++ ) {
			for ( int k=i,j=0; j<15&&k<15; j++, k++ ) {
				int m=k;
				int n=j;
				while ( m<k+5&&k+5<=15 ) {
					if ( location[m][n]==-1 ) machineChessmanNum++;
					else if ( location[m][n]==1 ) humanChessmanNum++;
					m++;
					n++;
				}
				if ( m==k+5 ) {
					tupleScoreTmp  = tupleScore(humanChessmanNum, machineChessmanNum);
					for ( m=k,n=j;m<k+5;m++,n++ ) {
						score[m][n] += tupleScoreTmp;
					}
				}
				humanChessmanNum = 0;
				machineChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		

		
		//扫描左上角到右下角的下侧部分
		for ( int i=1; i<11; i++ ) {
			for ( int k=i,j=0; j<15&&k<15; j++, k++ ) {
				int m = k;
				int n = j;
				while ( m<k+5&&k+5<=15 ) {
					if ( location[n][m]==-1 ) machineChessmanNum++;
					else if ( location[n][m]==1 ) humanChessmanNum++;
					m++;
					n++;
				}
				if ( m==k+5 ) {
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					for ( m=k,n=j;m<k+5;m++,n++ ) {
						score[n][m] += tupleScoreTmp;
					}
				}
				machineChessmanNum = 0;
				humanChessmanNum = 0;
				tupleScoreTmp = 0;
			}
		}
		
		for ( int i=0; i<15; i++ ) {
			for ( int j=0; j<15; j++ ) {
				if ( location[i][j]==0&&score[i][j]>maxScore ) {
					goalX = i;
					goalY = j;
					maxScore = score[i][j];
				}
			}
		}
		if ( goalX!=-1 &&goalY!=-1 ) {
			return new Location(goalX, goalY, -1);
		}
		return new Location(-1, -1, -1);

	}
	
	public int tupleScore( int humanChessmanNum, int machineChessmanNum) {
		if ( humanChessmanNum>0 && machineChessmanNum>0 ) 
			return 0;
		if ( humanChessmanNum==0 && machineChessmanNum==0 )
			return 7;
		if ( machineChessmanNum==1 ) 
			return 35;
		if ( machineChessmanNum==2 )
			return 800;
		if ( machineChessmanNum==3 ) 
			return 15000;
		if ( machineChessmanNum==4 )
			return 800000;
		if ( humanChessmanNum==1 ) 
			return 15;
		if ( humanChessmanNum==2 ) 
			return 400;
		if ( humanChessmanNum==3 ) 
			return 1800;
		if ( humanChessmanNum==4 ) 
			return 100000;
		return -1;
	}
}

