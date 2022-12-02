package aoc22.impl.task2;

import aoc22.impl.AbstractRockPaperScissorsSimulator;
import aoc22.impl.Choice;

/**
 * Advent of Code 2022
 * <p>
 * Day 02
 * <p>
 * Implementation for the solutions for second task.
 *
 * @author Szymon Rozmarynowski
 */
public class SecondRockPaperScissorsSimulator extends AbstractRockPaperScissorsSimulator {
    int getDuelPoints(WantedResult wantedResult) {
        if (wantedResult == WantedResult.LOSE) {
            return LOSE_POINTS;
        } else if (wantedResult == WantedResult.DRAW) {
            return DRAW_POINTS;
        } else {
            return WIN_POINTS;
        }
    }

    @Override
    protected void readInput(String line) {
        Choice opponentChoice = Choice.getChoice(line.charAt(0));
        WantedResult wantedResult = WantedResult.getWantedResult(line.charAt(2));
        Choice myChoice = getMyChoice(opponentChoice, wantedResult);
        points = points + getDuelPoints(wantedResult) + getRoundResult(myChoice, opponentChoice);
    }

    private Choice getMyChoice(Choice opponentChoice, WantedResult wantedResult) {
        if (wantedResult == WantedResult.DRAW) {
            return opponentChoice;
        } else if (wantedResult == WantedResult.LOSE) {
            if (opponentChoice == Choice.PAPER) {
                return Choice.ROCK;
            } else if (opponentChoice == Choice.ROCK) {
                return Choice.SCISSORS;
            } else {
                return Choice.PAPER;
            }
        } else {
            if (opponentChoice == Choice.PAPER) {
                return Choice.SCISSORS;
            } else if (opponentChoice == Choice.ROCK) {
                return Choice.PAPER;
            } else {
                return Choice.ROCK;
            }
        }
    }

    @Override
    protected int getRoundResult(Choice myChoice, Choice opponentChoice) {
        return getChoicePoints(myChoice);
    }
}
