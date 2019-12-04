package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.List;

public class MoveBishop implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {

        /**
         * code non valide juste pour ne pas sortir du programme.
         */
        int position_X = position.x;
        int position_Y = position.y;
        Piece piece = board.getBoardGame()[position_Y][position_X];

        IChess.ChessPosition position_piece = new IChess.ChessPosition(position_X,position_Y);

        return Tools.directionDiagonal(position_piece,board);

    }
}
