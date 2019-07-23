import java.net.URL;

public class Main {

    public static void main(String[] args) {

        URL resource = Main.class.getResource("/");
        System.out.println(resource.toString());


    }
}
