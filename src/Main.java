import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println("provide the file name: ");
        File file = new File(input);
    }
}