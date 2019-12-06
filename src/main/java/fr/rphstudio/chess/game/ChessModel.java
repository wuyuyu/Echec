package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.OutOfBoardException;
import fr.rphstudio.chess.launcher.ChessFontManager;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements fr.rphstudio.chess.interf.IChess {


    private Board board;
    private ChessColor white;



    private ChessModel (){
        this.board= new Board();
    }


    private static ChessModel INSTANCE = new ChessModel();



    public static ChessModel getInstance(){
        return INSTANCE;
    }


    /**
     * Reinitializes the board like the very fist turn
     */
    @Override
    public void reinit() {
        this.board = new Board();
    }

    /**
     * Returns the type of a piece
     * @param p x/y position on the board where we want to get the piece type.
     * @return
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = this.board.takePiece(p);
        if(piece != null){
            return piece.getChessType();
        }else{
           throw new EmptyCellException();
        }
    }

    /**
     * Returns the color of a piece
     * @param p x/y position on the board where we want to get the piece color.
     * @return
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = this.board.takePiece(p);
        if(piece != null){
            return piece.getChessColor();
        }else{
            throw new EmptyCellException();
        }
    }

    /**
     * Returns the number of taking pieces
     * @param color the requested color of the pieces to count.
     * @return
     */
    @Override
    public int getNbRemainingPieces(ChessColor color) {
        if (color == ChessColor.CLR_WHITE){
            return board.piecesCounterWhite();
        }
        if (color == ChessColor.CLR_BLACK){
            return board.piecesCounterBlack();
        }
        return 0;
    }

    /**
     * Returns a list of the piece's moves
     * @param p requested piece position.
     * @return
     */
    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        List list = new ArrayList();
        Piece piece = this.board.takePiece(p);
        if(piece != null){
            return piece.getMove(p,this.board);

        }
        return list;
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        this.board.movingPiece(p0, p1);
    }

    /**
     * Returns and display if a king is safe or threaten by an enemy piece
     * @param color the requested king color.
     * @return
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        if (Board.kingStatus(this.board, color)) {
            return ChessKingState.KING_THREATEN;
        } else {
            return ChessKingState.KING_SAFE;
        }
    }

    /**
     * Returns the list of taking pieces
     * @param color color of the removed pieces
     * @return
     */
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
