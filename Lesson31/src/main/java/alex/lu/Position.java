package alex.lu;

public enum Position {

    DIRECTOR(2),
    WORKER(1);

    public final int coef;

    Position(int coef) {
        this.coef = coef;
    }
}