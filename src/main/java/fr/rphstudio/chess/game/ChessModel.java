package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.OutOfBoardException;
import fr.rphstudio.chess.launcher.ChessFontManager;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements fr.rphstudio.chess.interf.IChess {


    private Board board;


    private ChessModel (){
        this.board= new Board();
    }


    private static ChessModel INSTANCE = new ChessModel();



    public static ChessModel getInstance(){
        return INSTANCE;
    }



    @Override
    public void reinit() {

    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = this.board.takePiece(p);
        if(piece != null){
            return piece.getChessType();
        }else{
           throw new EmptyCellException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = this.board.takePiece(p);
        if(piece != null){
            return piece.getChessColor();
        }else{
            throw new EmptyCellException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return 0;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        ArrayList list = new ArrayList();
        return list;
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_THREATEN;

    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        ArrayList list = new ArrayList();
        return list;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }
}
