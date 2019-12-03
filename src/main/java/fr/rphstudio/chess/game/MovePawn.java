package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess;

import java.util.*;

public class MovePawn implements IMove {

    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {
        int position_X = position.x;
        int position_Y = position.y;
        Piece piece = board.getBoardGame()[position_Y][position_X];
        List<IChess.ChessPosition> positions = new ArrayList<>();



        positions.add( new IChess.ChessPosition(position.x,position.y-1) );
        positions.add( new IChess.ChessPosition(position.x,position.y+1) );

        /*for (int i = 0; i < board.getBoardGame().length; i++) {
            for(int j = 0 ;j<board.getBoardGame()[0].length;j++){
                if(board.getBoardGame()[position_Y +1][position_X] == null ){
                }
                    positions.add();
                    positions.add();

                }
                if(board.getBoardGame()[position_Y][position_X+1] == null){

                }
            }

        }

         */
        return positions;
    }
}
