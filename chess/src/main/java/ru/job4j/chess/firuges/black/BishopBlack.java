package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int posX = position.getX();
        int posY = position.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int size = Math.abs(posX - destX);
        Cell[] steps = new Cell[size];
        for (int i = 0; i < steps.length; i++) {
            posX = (posX < destX) ? posX + 1 : posX - 1;
            posY = (posY < destY) ? posY + 1 : posY - 1;
            steps[i] = Cell.findBy(posX, posY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
