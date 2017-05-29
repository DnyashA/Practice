import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Владимир on 28.05.2017.
 */
public class Exceptions {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static HashSet hash;
    public static int curQuantity = 5;

    public static void add(int item) throws ItemAlreadyExistsException{
        arr.add(1);
        arr.add(2);
        hash = new HashSet(arr);
        if(hash.contains(item)) throw new ItemAlreadyExistsException("Item alredy exists", item);
        else {
            arr.add(item);
            hash = new HashSet(arr);
        }
    }

    public static void get(int q) throws NegativeQuantityException{
        if (curQuantity - q < 0) throw new NegativeQuantityException("Trying get more than have", curQuantity);
        else {
            curQuantity -= q;
        }
    }

    public static void main(String[] args) throws ItemAlreadyExistsException, NegativeQuantityException {
        //add(1);
        //get(8);
    }
}
