import com.johanastrom.StringUtilities;

public class Main {

    public static void main(String[] args) {
        StringUtilities su = new StringUtilities();
        boolean anagram = su.isAnagram("hej", "heJ");
        System.out.println(anagram);
    }
}
