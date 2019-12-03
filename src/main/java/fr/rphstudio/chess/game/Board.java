package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;

public class Board {

    private Piece selectedPiece;
    private Piece[][] boardGame;

    public Board(){
        this.boardGame=new Piece[8][8];

        Piece KingBlack = new Piece( IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KING);
        this.boardGame [0][3] = KingBlack;
        Piece QueenBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_QUEEN);
        this.boardGame [0][4] = QueenBlack;
        Piece BishopBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP);
        this.boardGame [0][2] = BishopBlack;
        this.boardGame [0][5] = BishopBlack;
        Piece KnightBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT);
        this.boardGame [0][1] = KnightBlack;
        this.boardGame [0][6] = KnightBlack;
        Piece RookBlack= new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK);
        this.boardGame [0][0] = RookBlack;
        this.boardGame [0][7] = RookBlack;

        Piece PawnBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_PAWN);
        Piece PawnWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_PAWN);
        for(int i = 0;  i < boardGame [0].length; i = i+1){
            this.boardGame [1][i] = PawnBlack;
            this.boardGame [6][i] = PawnWhite;
        }

        Piece KingWhite = new Piece( IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KING);
        this.boardGame [7][3] = KingWhite;
        Piece QueenWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_QUEEN);
        this.boardGame [7][4] = QueenWhite;
        Piece BishopWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP);
        this.boardGame [7][2] = BishopWhite;
        this.boardGame [7][5] = BishopWhite;
        Piece KnightWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT);
        this.boardGame [7][1] = KnightWhite;
        this.boardGame [7][6] = KnightWhite;
        Piece RookWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK);
        this.boardGame [7][0] = RookWhite;
        this.boardGame [7][7] = RookWhite;
    }

    public Piece takePiece (IChess.ChessPosition position){
        int position_X = position.x;
        int position_Y = position.y;
        Piece piece = this.boardGame [position_Y][position_X] ;
        return piece;
    }

    public int piecesCounterWhite () {

        int nbPiecesWhite = 0;
        for (int i = 0; i < boardGame.length; i = i + 1) {
            for (int j = 0; j < boardGame[0].length; j = j + 1) {
                this.selectedPiece = this.boardGame[i][j];
                if (selectedPiece != null) {
                    if(selectedPiece.getChessColor() == IChess.ChessColor.CLR_WHITE){
                        nbPiecesWhite = nbPiecesWhite + 1;
                    }
                }
            }
        }
        return nbPiecesWhite;
    }

    public int piecesCounterBlack () {

        int nbPiecesBlack = 0;
        for (int i = 0; i < boardGame.length; i = i + 1) {
            for (int j = 0; j < boardGame[0].length; j = j + 1) {
                this.selectedPiece = this.boardGame[i][j];
                if (selectedPiece != null) {
                    if(selectedPiece.getChessColor() == IChess.ChessColor.CLR_WHITE){
                        nbPiecesBlack++;
                    }
                }
            }
        }
        return nbPiecesBlack;
    }

}
