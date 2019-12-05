package fr.rphstudio.chess.game;


import fr.rphstudio.chess.interf.IChess.*;

import java.util.List;

public class Piece {
    private ChessColor color ;
    private ChessType type;
    private IMove move;

    public ChessColor getChessColor (){
        return this.color;
    }
    public ChessType getChessType (){
        return this.type;
    }

    public IMove getMove() {
        return this.move;
    }

    public Piece(ChessColor colorPiece, ChessType typePiece,IMove movePositionPossible){
     this.color = colorPiece;
     this.type = typePiece;
     this.move=movePositionPossible;
    }

    public List<ChessPosition> getMove(ChessPosition position , Board board) {
        return this.move.getPossibleMove(position,board);
    }

}
