
public class NegativeQuantityException extends Exception {
    private int num;

    public int getNum() {
        return num;
    }
    public NegativeQuantityException(String message, int num){
        super(message);
        this.num = num;
    }
}
