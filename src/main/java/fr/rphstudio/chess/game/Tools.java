 package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tools {

    /**
     * Returns if a future position is valid (on the board or not)
     * @param p
     * @return
     */
    public static boolean isValid(IChess.ChessPosition p) {

        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if a future position is empty or not
     * @param pDestination
     * @param board
     * @return
     */
    public static boolean isEmpty(IChess.ChessPosition pDestination, Board board) {
        Piece piece = board.takePiece(pDestination);

        if (piece == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if on a future position there is an anemy or not
     * @param pDestination
     * @param board
     * @param colorInit
     * @return
     */
    public static boolean isEnemy(IChess.ChessPosition pDestination, Board board, IChess.ChessColor colorInit) {

        if (board.takePiece(pDestination) != null)
            if (board.takePiece(pDestination).getChessColor() != colorInit) {
                return true;
            }
        return false;
    }

    /**
     * @param piece_statut_bool
     * @return
     */
    public static boolean isValue_bool(Piece piece_statut_bool) {

            if (piece_statut_bool.getvalid_first()) {

                return piece_statut_bool.getvalid_first()==false;
            }else {
                return piece_statut_bool.getvalid_first() == false;
            }
    }

    /**
     * Returns the possible moves of a piece in diagonal
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionDiagonal(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();

        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 3; dir++) {
            int dx = 1;
            int dy = 1;
            if (dir >= 2) {
                dx = -1;
            }
            if (dir % 2 == 0) {
                dy = -1;
            }

            for(int distance= 1;distance<=7;distance++){

                int destX = positionX + (dy*distance);
                int destY = positionY + (dx*distance);

                // Create chess pos
                IChess.ChessPosition destPosition = new IChess.ChessPosition(destX,destY);

                // check if position is in board (isValid ?)
                if(isValid(destPosition)){
                    // check if there is another piece on my way (isEmpty, isEnemy ?)
                    if(isEmpty(destPosition,brd)){
                        positionsList.add(destPosition);
                    }
                    else {
                        if (isEnemy(destPosition,brd,piece.getChessColor())){
                            // add pos to list
                            positionsList.add(destPosition);
                        }
                        // stop
                        break;
                    }
                }
            }
        }
        // return my supa list
        return positionsList;
    }

    /**
     * Returns the possible moves of a rook piece
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionRook(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();

        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 3; dir++) {
            int dx = 0;
            int dy = 0;
            if (dir == 0) {
                dy = +1;
            }
            if (dir == 1){
                dy = -1;
            }
            if (dir == 2){
                dx = +1;
            }
            if (dir == 3) {
                dx = -1;
            }

            for(int distance= 1;distance<=7;distance++){

                int destX = positionX + (dy*distance);
                int destY = positionY + (dx*distance);

                // Create chess pos
                IChess.ChessPosition destPosition = new IChess.ChessPosition(destX,destY);

                // check if position is in board (isValid ?)
                if(isValid(destPosition)){
                    // check if there is another piece on my way (isEmpty, isEnemy ?)
                    if(isEmpty(destPosition,brd)){
                        positionsList.add(destPosition);
                    }
                    else {
                        if (isEnemy(destPosition,brd,piece.getChessColor())){
                            // add pos to list
                            positionsList.add(destPosition);
                        }
                        // stop
                        break;
                    }
                }
            }
        }
        // return my supa list
        return positionsList;
    }

    /**
     * Returns the possible moves of a queen piece
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionQueen(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();

        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 7; dir++) {
            int dx = 1;
            int dy = 1;
            if (dir == 0) {
                dy = 1;
                dx = 1;
            }
            if (dir == 1) {
                dx = 1;
                dy = -1;
            }
            if(dir == 2){
                dx = -1;
                dy = -1;
            }
            if (dir == 3){
                dx = -1;
                dy = 1;
            }
            if (dir == 4) {
                dx = 0;
                dy = 1;
            }
            if (dir == 5){
                dx = 0;
                dy = -1;
            }
            if (dir == 6){
                dy = 0;
                dx = 1;
            }
            if (dir == 7) {
                dx = -1;
                dy = 0;
            }

            for(int distance= 1;distance<=7;distance++){

                int destX = positionX + (dy*distance);
                int destY = positionY + (dx*distance);

                // Create chess pos
                IChess.ChessPosition destPosition = new IChess.ChessPosition(destX,destY);

                // check if position is in board (isValid ?)
                if(isValid(destPosition)){
                    // check if there is another piece on my way (isEmpty, isEnemy ?)
                    if(isEmpty(destPosition,brd)){
                        positionsList.add(destPosition);
                    }
                    else {
                        if (isEnemy(destPosition,brd,piece.getChessColor())){
                            // add pos to list
                            positionsList.add(destPosition);
                        }
                        // stop
                        break;
                    }
                }
            }
        }
        // return my supa list
        return positionsList;
    }

    /**
     * Returns the possible moves of a king piece
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionKing(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();

        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 7; dir++) {
            int dx = 1;
            int dy = 1;
            if (dir == 0) {
                dy = 1;
                dx = 1;
            }
            if (dir == 1) {
                dx = 1;
                dy = -1;
            }
            if(dir == 2){
                dx = -1;
                dy = -1;
            }
            if (dir == 3){
                dx = -1;
                dy = 1;
            }
            if (dir == 4) {
                dx = 0;
                dy = 1;
            }
            if (dir == 5){
                dx = 0;
                dy = -1;
            }
            if (dir == 6){
                dy = 0;
                dx = 1;
            }
            if (dir == 7) {
                dx = -1;
                dy = 0;
            }

            for(int distance= 1;distance<=1;distance++){

                int destX = positionX + (dy*distance);
                int destY = positionY + (dx*distance);

                // Create chess pos
                IChess.ChessPosition destPosition = new IChess.ChessPosition(destX,destY);

                // check if position is in board (isValid ?)
                if(isValid(destPosition)){
                    // check if there is another piece on my way (isEmpty, isEnemy ?)
                    if(isEmpty(destPosition,brd)){
                        positionsList.add(destPosition);
                    }
                    else {
                        if (isEnemy(destPosition,brd,piece.getChessColor())){
                            // add pos to list
                            positionsList.add(destPosition);
                        }
                        // stop
                        break;
                    }
                }
            }
        }
        // return my supa list
        return positionsList;
    }

    /**
     * Returns the possible moves of a knight piece
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionKnight(IChess.ChessPosition p, Board brd) {


        List<IChess.ChessPosition> positionsList = new ArrayList<>();


        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 7; dir++) {
            int dx = 0;
            int dy = 0;
            if (dir == 0) {
                // positions.add(new IChess.ChessPosition(position.x - 2, position.y + 1));//1
                dx = -2;
                dy = +1;
            }
            if (dir == 1) {
                //positions.add(new IChess.ChessPosition(position.x - 2, position.y - 1));//2
                dx = -2;
                dy = -1;
            }
            if (dir == 2) {
                //positions.add(new IChess.ChessPosition(position.x - 1, position.y - 2));//3
                dx = -1;
                dy = -2;
            }
            if (dir == 3) {
                //positions.add(new IChess.ChessPosition(position.x - 1, position.y + 2));// 4
                dx = -1;
                dy = +2;
            }
            if (dir == 4) {
                //positions.add(new IChess.ChessPosition(position.x + 1, position.y + 2)); // 5
                dx = +1;
                dy = +2;
            }
            if (dir == 5) {
                //positions.add(new IChess.ChessPosition(position.x + 1, position.y - 2));//6
                dx = +1;
                dy = -2;
            }
            if (dir == 6) {
                //positions.add(new IChess.ChessPosition(position.x + 2, position.y + 1)); // 7
                dx = +2;
                dy = +1;
            }
            if (dir == 7) {
                //positions.add(new IChess.ChessPosition(position.x + 2, position.y - 1)); //8
                dx = +2;
                dy = -1;
            }

            for (int distance = 1; distance <= 1; distance++) {

                int destX = positionX + (dx * distance);
                int destY = positionY + (dy * distance);

                // Create chess pos
                IChess.ChessPosition destPosition = new IChess.ChessPosition(destX, destY);

                // check if position is in board (isValid ?)
                if (isValid(destPosition)) {
                    // check if there is another piece on my way (isEmpty, isEnemy ?)
                    if (isEmpty(destPosition, brd)) {
                        positionsList.add(destPosition);
                    } else {
                        if (isEnemy(destPosition, brd, piece.getChessColor())) {
                            // add pos to list
                            positionsList.add(destPosition);
                        }
                        // stop
                        break;
                    }
                }
            }

        }
        // return my supa list
        return positionsList;
    }

    /**
     * Returns the possible moves of a pawn piece (move of 1 cell)
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionPawn (IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();


        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);



            for (int dir = 0; dir <= 2; dir++) {
                int dx = 0;
                int dy = 0;
                if (piece.getChessColor() == IChess.ChessColor.CLR_WHITE) {


                    if (dir > 1) {
                        dx = 0;
                    }
                    if (dir % 2 == 0) {
                        dy = -1;
                    }


                    for (int distance = 1; distance <= 2; distance++) {

                        int destX = positionX + (dx * distance);
                        int destY = positionY + (dy * distance);

                        // Create chess pos
                        IChess.ChessPosition destPosition = new IChess.ChessPosition(destX, destY);

                        // check if position is in board (isValid ?)
                        if (isValid(destPosition)) {
                            // check if there is another piece on my way (isEmpty, isEnemy ?)
                            if (isEmpty(destPosition, brd)) {
                                positionsList.add(destPosition);
                            } else {
                                if (isEnemy(destPosition, brd, piece.getChessColor())) {
                                    // add pos to list
                                    positionsList.add(destPosition);
                                }
                                // stop
                                break;
                            }
                        }
                    }
                    // return my supa list
                    return positionsList;
                } else {
                    if (dir > 1) {
                        dx = 0;
                    }
                    if (dir % 2 == 0) {
                        dy = +1;
                    }

                    for (int distance = 1; distance <= 2; distance++) {

                        int destX = positionX + (dx * distance);
                        int destY = positionY + (dy * distance);

                        // Create chess pos
                        IChess.ChessPosition destPosition = new IChess.ChessPosition(destX, destY);

                        // check if position is in board (isValid ?)
                        if (isValid(destPosition)) {
                            // check if there is another piece on my way (isEmpty, isEnemy ?)
                            if (isEmpty(destPosition, brd)) {
                                positionsList.add(destPosition);
                            } else {
                                if (isEnemy(destPosition, brd, piece.getChessColor())) {
                                    // add pos to list
                                    positionsList.add(destPosition);
                                }
                                // stop
                                break;
                            }
                        }
                    }
                }

            }
            // return my supa list
            return positionsList;
    }


    /**
     * Returns the possible moves of a pawn piece (move of 2 cells)
     * @param p
     * @param brd
     * @return
     */
    public static List<IChess.ChessPosition> directionPawn2(IChess.ChessPosition p, Board brd) {

        // crerate empty list of positions
        List<IChess.ChessPosition> positionsList = new ArrayList<>();


        int positionX = p.x;
        int positionY = p.y;
        Piece piece = brd.takePiece(p);

        for (int dir = 0; dir <= 2; dir++) {
            int dx = 0;
            int dy = 0;
            if(piece.getChessColor() == IChess.ChessColor.CLR_WHITE){


                if (dir > 1) {
                    dx = 0;
                }
                if (dir % 2 == 0) {
                    dy = -1;
                }

                for (int distance = 1; distance <= 1; distance++) {

                    int destX = positionX + (dx * distance);
                    int destY = positionY + (dy * distance);

                    // Create chess pos
                    IChess.ChessPosition destPosition = new IChess.ChessPosition(destX, destY);

                    // check if position is in board (isValid ?)
                    if (isValid(destPosition)) {
                        // check if there is another piece on my way (isEmpty, isEnemy ?)
                        if (isEmpty(destPosition, brd)) {
                            positionsList.add(destPosition);
                        } else {
                            if (isEnemy(destPosition, brd, piece.getChessColor())) {
                                // add pos to list
                                positionsList.add(destPosition);
                            }
                            // stop
                            break;
                        }
                    }
                }
            }else{
                if (dir > 1) {
                    dx = 0;
                }
                if (dir % 2 == 0) {
                    dy = +1;
                }

                for (int distance = 1; distance <= 2; distance++) {

                    int destX = positionX + (dx * distance);
                    int destY = positionY + (dy * distance);

                    // Create chess pos
                    IChess.ChessPosition destPosition = new IChess.ChessPosition(destX, destY);

                    // check if position is in board (isValid ?)
                    if (isValid(destPosition)) {
                        // check if there is another piece on my way (isEmpty, isEnemy ?)
                        if (isEmpty(destPosition, brd)) {
                            positionsList.add(destPosition);
                        } else {
                            if (isEnemy(destPosition, brd, piece.getChessColor())) {
                                // add pos to list
                                positionsList.add(destPosition);
                            }
                            // stop
                            break;
                        }
                    }
                }
            }

        }
        // return my supa list
        return positionsList;
    }

}