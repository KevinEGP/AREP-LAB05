package co.edu.eci.arep;

import static spark.Spark.*;

public class App {
    public static void main( String[] args ) {
        port(5000);
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello Heroku");
    }
}
