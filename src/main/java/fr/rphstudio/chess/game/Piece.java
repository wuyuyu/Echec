package fr.rphstudio.chess.game;


import fr.rphstudio.chess.interf.IChess.*;

import java.util.List;

public class Piece {
    private ChessColor color ;
    private ChessType type;
    private IMove move;
    private boolean valid_first;

    public ChessColor getChessColor (){
        return this.color;
    }
    public ChessType getChessType (){
        return this.type;
    }

    public IMove getMove() {
        return this.move;
    }

    public Piece(ChessColor colorPiece, ChessType typePiece,IMove movePositionPossible,boolean true_value){
     this.color = colorPiece;
     this.type = typePiece;
     this.move=movePositionPossible;
     this.valid_first=true_value;
    }

    /**
     * Returns the possible moves of a piece

     * @param position
     * @param board
     * @return
     */
    public List<ChessPosition> getMove(ChessPosition position , Board board) {
        return this.move.getPossibleMove(position,board);
    }
    public boolean getvalid_first(){
        return this.valid_first;
    }

}
