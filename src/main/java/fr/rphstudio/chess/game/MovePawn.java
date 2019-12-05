package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess;

import java.util.*;

public class MovePawn implements IMove {

    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {

       /* Piece piVBoolean=board.takePiece(position);
        
        boolean checkValue = piVBoolean.getvalid_first();

        IChess.ChessPosition position_piece;

        if (checkValue) {

            checkValue=false;

            return Tools.directionPawn(position_piece,board);
        }
        else{
            return Tools.directionPawn2(position_piece,board);*/

       int position_X = position.x;
        int position_Y = position.y;
        Piece piece = board.getBoardGame()[position_Y][position_X];
        IChess.ChessColor test = piece.getChessColor();
        List<IChess.ChessPosition> positions = new ArrayList<>();
        if (position_Y == 6 || position_Y == 1) {
            if (test == IChess.ChessColor.CLR_BLACK) {
                positions.add(new IChess.ChessPosition(position.x, position.y + 1));
                positions.add(new IChess.ChessPosition(position.x, position.y + 2));
                return positions;
            }
            positions.add(new IChess.ChessPosition(position.x, position.y - 1));
            positions.add(new IChess.ChessPosition(position.x, position.y - 2));
            return positions;
        } else if (test == IChess.ChessColor.CLR_BLACK) {
            positions.add(new IChess.ChessPosition(position.x, position.y + 1));
            return positions;
        }
        positions.add(new IChess.ChessPosition(position.x, position.y - 1));
        return positions;
    }
}

