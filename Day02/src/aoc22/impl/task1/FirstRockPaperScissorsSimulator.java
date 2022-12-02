package aoc22.impl.task1;

import aoc22.impl.AbstractRockPaperScissorsSimulator;
import aoc22.impl.Choice;

/**
 * Advent of Code 2022
 * <p>
 * Day 02
 * <p>
 * Implementation for the solutions for first task.
 *
 * @author Szymon Rozmarynowski
 */
public class FirstRockPaperScissorsSimulator extends AbstractRockPaperScissorsSimulator {

    int getDuelPoints(Choice myChoice, Choice opponentChoice) {

        if (myChoice == opponentChoice) {
            return DRAW_POINTS;
        }
        if (opponentChoice == Choice.ROCK) {
            return myChoice == Choice.PAPER ? WIN_POINTS : LOSE_POINTS;
        } else if (opponentChoice == Choice.PAPER) {
            return myChoice == Choice.SCISSORS ? WIN_POINTS : LOSE_POINTS;
        } else {
            return myChoice == Choice.ROCK ? WIN_POINTS : LOSE_POINTS;
        }
    }

    @Override
    protected void readInput(String line) {
        Choice myChoice = Choice.getChoice(line.charAt(2));
        Choice opponentChoice = Choice.getChoice(line.charAt(0));
        points += getRoundResult(myChoice, opponentChoice);
    }

    @Override
    protected int getRoundResult(Choice myChoice, Choice opponentChoice) {
        return getDuelPoints(myChoice, opponentChoice) + getChoicePoints(myChoice);
    }
}
