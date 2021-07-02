package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import  ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void whenPosition22() {
        int x = 2;
        int y = 2;
        Figure bb = new BishopBlack(Cell.findBy(x, y));
        Cell cell = bb.position();
        Assert.assertEquals(cell, Cell.findBy(x, y));
    }

    @Test
    public void copy() {
        Figure bb = new BishopBlack(Cell.findBy(8, 8));
        Cell cell = Cell.A1;
        bb = bb.copy(cell);
        System.out.println(bb.position());
        Assert.assertEquals(cell, bb.position());
    }

    @Test
    public void whenPossibleMoveWay() {
        Figure bb = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] way = bb.way(Cell.G5);
        Assert.assertEquals(expected, way);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() {
        Figure bb = new BishopBlack(Cell.C2);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] way = bb.way(Cell.G5);
        Assert.assertEquals(expected, way);
    }

    @Test
    public void whenIsDiagonal() {
        Cell cell1  = Cell.C1;
        Cell cell2 = Cell.G5;
        BishopBlack bb = new BishopBlack(cell1);
        Assert.assertTrue(bb.isDiagonal(cell1, cell2));
    }

    @Test
    public void whenIsNotDiagonal() {
        Cell cell1  = Cell.A1;
        Cell cell2 = Cell.H1;
        BishopBlack bb = new BishopBlack(cell1);
        Assert.assertFalse(bb.isDiagonal(cell1, cell2));
    }
}