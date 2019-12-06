package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class MoveKnight implements IMove {

    /**
     * Returns the possible moves of a knight piece
     * @param position
     * @param board
     * @return
     */
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {

        IChess.ChessPosition position_piece = new IChess.ChessPosition(position.x,position.y);

        return Tools.directionKnight(position_piece,board);
    }
}
