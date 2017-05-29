
public class ItemAlreadyExistsException extends Exception {
    private int num;

    public int getNum() {
        return num;
    }
    public ItemAlreadyExistsException(String message, int num){
        super(message);
        this.num = num;
    }
}
