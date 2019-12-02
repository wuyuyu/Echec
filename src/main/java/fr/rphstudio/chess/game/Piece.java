package fr.rphstudio.chess.game;


import fr.rphstudio.chess.interf.IChess.*;

public class Piece {
    private ChessColor color ;
    private ChessType type;

    public ChessColor getChessColor (){
        return this.color;
    }
    public ChessType getChessType (){
        return this.type;
    }


    public Piece(ChessColor colorPiece,ChessType typePiece){
     this.color = colorPiece;
     this.type = typePiece;
    }


}
