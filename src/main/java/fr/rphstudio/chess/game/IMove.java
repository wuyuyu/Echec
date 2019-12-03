package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface IMove {

    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition position, Board board);
}
