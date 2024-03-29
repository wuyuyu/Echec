package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;

public class Board {

    private Piece selectedPiece;
    private Piece[][] boardGame;

    /**
     * Places the different pieces on the board when it is initialized
     */
    public Board() {
        this.boardGame = new Piece[8][8];

        Piece KingBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KING, new MoveKing(), true);
        this.boardGame[0][3] = KingBlack;
        Piece QueenBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_QUEEN, new MoveQueen(), true);
        this.boardGame[0][4] = QueenBlack;
        Piece BishopBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP, new MoveBishop(), true);
        this.boardGame[0][2] = BishopBlack;
        this.boardGame[0][5] = BishopBlack;
        Piece KnightBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT, new MoveKnight(), true);
        this.boardGame[0][1] = KnightBlack;
        this.boardGame[0][6] = KnightBlack;
        Piece RookBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK, new MoveRook(), true);
        this.boardGame[0][0] = RookBlack;
        this.boardGame[0][7] = RookBlack;

        Piece PawnBlack = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_PAWN, new MovePawn(), true);
        Piece PawnWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_PAWN, new MovePawn(), true);
        for (int i = 0; i < boardGame[0].length; i = i + 1) {
            this.boardGame[1][i] = PawnBlack;
            this.boardGame[6][i] = PawnWhite;
        }

        Piece KingWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KING, new MoveKing(), true);
        this.boardGame[7][3] = KingWhite;
        Piece QueenWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_QUEEN, new MoveQueen(), true);
        this.boardGame[7][4] = QueenWhite;
        Piece BishopWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP, new MoveBishop(), true);
        this.boardGame[7][2] = BishopWhite;
        this.boardGame[7][5] = BishopWhite;
        Piece KnightWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT, new MoveKnight(), true);
        this.boardGame[7][1] = KnightWhite;
        this.boardGame[7][6] = KnightWhite;
        Piece RookWhite = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK, new MoveRook(), true);
        this.boardGame[7][0] = RookWhite;
        this.boardGame[7][7] = RookWhite;
    }

    public Piece takePiece(IChess.ChessPosition position) {
        int position_X = position.x;
        int position_Y = position.y;
        if (Tools.isValid(position)) {
            return this.boardGame[position_Y][position_X];
        }
        return null;
    }

    /**
     * Counts the number of white pieces on the board
     * @return
     */
    public int piecesCounterWhite() {

        int nbPiecesWhite = 0;
        for (int i = 0; i < boardGame.length; i = i + 1) {
            for (int j = 0; j < boardGame[0].length; j = j + 1) {
                this.selectedPiece = this.boardGame[i][j];
                if (selectedPiece != null) {
                    if (selectedPiece.getChessColor() == IChess.ChessColor.CLR_WHITE) {
                        nbPiecesWhite++;
                    }
                }
            }
        }
        return nbPiecesWhite;
    }

    /**
     * Counts the number of black pieces on the board
     * @return
     */
    public int piecesCounterBlack() {

        int nbPiecesBlack = 0;
        for (int i = 0; i < boardGame.length; i = i + 1) {
            for (int j = 0; j < boardGame[0].length; j = j + 1) {
                this.selectedPiece = this.boardGame[i][j];
                if (selectedPiece != null) {
                    if (selectedPiece.getChessColor() == IChess.ChessColor.CLR_BLACK) {
                        nbPiecesBlack++;
                    }
                }
            }
        }
        return nbPiecesBlack;
    }

    public Piece[][] getBoardGame() {
        return boardGame;
    }

    /**
     * A piece can move with (we give it a new position)
     * @param pa
     * @param pb
     */
    public void movingPiece(IChess.ChessPosition pa, IChess.ChessPosition pb) {
        this.boardGame[pb.y][pb.x] = this.boardGame[pa.y][pa.x];
        this.boardGame[pa.y][pa.x] = null;
    }

    /**
     * Returns if a king is safe or threaten by an enemy piece
     * @param board
     * @param color
     * @return
     */
    public static boolean kingStatus(Board board, IChess.ChessColor color) {
        ArrayList<IChess.ChessPosition> piecesPossibleMovements = new ArrayList<>();
        IChess.ChessPosition positionKing = new IChess.ChessPosition();
        boolean resultTestKing = false;

            for (int i = 0; i < board.getBoardGame().length; i = i + 1) {
                for (int j = 0; j < board.getBoardGame()[0].length; j = j + 1) {
                    Piece selectedPiece = board.boardGame[i][j];
                    if (selectedPiece != null) {
                        if (selectedPiece.getChessColor() == color && selectedPiece.getChessType() == IChess.ChessType.TYP_KING) {
                            positionKing.x = j;
                            positionKing.y = i;
                        }
                    }
                }
            }
            for (int i = 0; i < board.getBoardGame().length; i = i + 1) {
                for (int j = 0; j < board.getBoardGame()[0].length; j = j + 1) {
                    Piece selectedPiece2 = board.boardGame[i][j];
                    if (selectedPiece2 != null) {
                        if (selectedPiece2.getChessColor() != color) {
                            IChess.ChessPosition positionSelectedPiece2 = new IChess.ChessPosition();
                            positionSelectedPiece2.x = j;
                            positionSelectedPiece2.y = i;
                            piecesPossibleMovements = (ArrayList<IChess.ChessPosition>) selectedPiece2.getMove().getPossibleMove(positionSelectedPiece2, board);
                            for (int k = 0; k < piecesPossibleMovements.size(); k = k + 1) {
                                if (positionKing.equals(piecesPossibleMovements.get(k))) {
                                    resultTestKing = true;
                                }
                            }
                        }
                    }
                }
            }
        if (resultTestKing == true) {
            return true;
        } else {
            return false;
        }
    }
}



