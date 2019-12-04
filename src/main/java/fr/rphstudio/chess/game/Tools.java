package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Tools {
    public static boolean isValid(IChess.ChessPosition p) {

        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(IChess.ChessPosition p, Board board) {
        Piece piece = board.takePiece(p);

        if (piece != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEnemy(IChess.ChessPosition p, Board board, IChess.ChessColor color ){

        if (board.takePiece(p) != null && board.takePiece(p).getChessColor()  != color ) {
            return true;
        } else {
            return false;
        }
    }
}