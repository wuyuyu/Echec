package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;

public class Board {

    private Piece[][] boardGame;

    public Board(){
        this.boardGame=new Piece[8][8];
        Piece KING = new Piece( IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KING);
        this.boardGame [2][6]= KING;
    }
    public Piece takePiece (IChess.ChessPosition position){
        int position_X = position.x;
        int position_Y = position.y;
        Piece piece = this.boardGame [position_Y][position_X] ;
        return piece;
    }

}
