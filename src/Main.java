import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.FindFailed;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        try {
            Pattern image = new Pattern("path/to/your/image.png");
            screen.wait(image, 10);
            screen.click(image);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}