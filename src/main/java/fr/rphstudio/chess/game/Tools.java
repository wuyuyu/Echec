package fr.rphstudio.chess.game;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;
import fr.rphstudio.chess.interf.IChess;

import java.util.List;

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

    public static boolean isEnemy(IChess.ChessPosition p, Board board, IChess.ChessColor color) {

        if (board.takePiece(p) != null)
            if (board.takePiece(p).getChessColor() != color) {
                return true;
            }
        return false;
    }


    public static List<IChess.ChessPosition> directionDiagonal(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> dirList = new List<IChess.ChessPosition>() {
        }

        int positionX = p.x;
        int positionY = p.y;

        for (int dir = 0; dir <= 3; dir++) {
            int dx = 1;
            int dy = 1;
            if (dir >= 2) {
                dx = -1;
            }
            if (dir % 2 == 0) {
                dy = -1;
            }
            positionY = positionY + dy;
            positionX = positionX + dx;
            // Create chess pos

            // check if position is in board (isValid ?)

                // check if there is another piece on my way (isEmpty, isEnemy ?)

                    // add pos to list
        }

        // return my supa list

    }
}



        /*
        for(int dir = 0; dir < 3; dir++){
            int dx = 1;
            int dy = 1;
            if(dir >= 2){
                dx = -1;
                p.x = p.x -dx;
            }
            if(dir %2 == 0){
                dy = -1;
            }*/