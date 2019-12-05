package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class MoveRook implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {

        IChess.ChessPosition position_piece = new IChess.ChessPosition(position.x,position.y);

        return Tools.directionRook(position_piece,board);
    }
}
