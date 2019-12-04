package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class MoveKing implements IMove {

    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board) {
        int position_X = position.x;
        int position_Y = position.y;
        Piece piece = board.getBoardGame()[position_Y][position_X];
        List<IChess.ChessPosition> positions = new ArrayList<>();

        IChess.ChessPosition nextPos = null;

            if ( Tools.isEnemy(position, board, piece.getChessColor()) ) {

                /*
                nextPos =  new IChess.ChessPosition(position.x + 1, position.y);
                if (Tools.isValid(nextPos)){
                    positions.add(nextPos);
                }
                //*/
                if (position_X < 7) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y));
                }


                if (position_X > 0) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y));
                }
                if (position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x, position.y + 1));
                }
                if (position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x, position.y - 1));
                }
                if (position_X < 7 && position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y - 1));
                }
                if (position_X > 0 && position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y - 1));
                }
                if (position_X < 7 && position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y + 1));
                }
                if (position_X > 0 && position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y + 1));
                }
            } else if (piece.getChessColor() == IChess.ChessColor.CLR_WHITE && Tools.isEnemy(position, board, piece.getChessColor())) {
                if (position_X > 0) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y));
                }
                if (position_X < 7) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y));
                }
                if (position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x, position.y + 1));
                }
                if (position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x, position.y - 1));
                }
                if (position_X < 7 && position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y - 1));
                }
                if (position_X > 0 && position_Y > 0) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y - 1));
                }
                if (position_X < 7 && position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x + 1, position.y + 1));
                }
                if (position_X > 0 && position_Y < 7) {
                    positions.add(new IChess.ChessPosition(position.x - 1, position.y + 1));
                }
            }
            return positions;
        }
}