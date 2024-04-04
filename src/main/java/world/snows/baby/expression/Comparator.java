package world.snows.baby.expression;

public enum Comparator {
    EQUAL {
        @Override
        public Comparator capped() {
            return NOT_EQUAL;
        }
    },
    NOT_EQUAL {
        @Override
        public Comparator capped() {
            return EQUAL;
        }
    },
    LESS {
        @Override
        public Comparator capped() {
            return GREATER_EQUAL;
        }
    },
    LESS_EQUAL {
        @Override
        public Comparator capped() {
            return GREATER;
        }
    },
    GREATER {
        @Override
        public Comparator capped() {
            return LESS_EQUAL;
        }
    },
    GREATER_EQUAL {
        @Override
        public Comparator capped() {
            return LESS;
        }
    };

    public abstract Comparator capped();
}
