package wooteco.chess.domain.piece;

import wooteco.chess.domain.board.Coordinate;
import wooteco.chess.domain.board.Path;
import wooteco.chess.domain.board.Position;

public class Rook extends Piece {

    private static final double SCORE = 5;
    private static final String NAME = "rook";

    public Rook(final Team team) {
        super(NAME, team, SCORE);
    }

    @Override
    public boolean isMovable(final Path path) {
        return path.isStraight()
                && (path.isEmptyOnEnd() || path.isEnemyOnEnd())
                && path.isNotBlocked();
    }

    @Override
    public boolean isInitialPosition(final Position position) {
        if (team == Team.WHITE) {
            return position.equals(Position.of(Coordinate.ONE, Coordinate.ONE))
                    || position.equals(Position.of(Coordinate.ONE, Coordinate.EIGHT));
        }
        return position.equals(Position.of(Coordinate.EIGHT, Coordinate.ONE))
                || position.equals(Position.of(Coordinate.EIGHT, Coordinate.EIGHT));
    }
}
