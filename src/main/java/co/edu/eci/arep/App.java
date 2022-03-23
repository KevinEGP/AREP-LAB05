package co.edu.eci.arep;

import static spark.Spark.*;

public class App {
    public static void main( String[] args ) {
        port(getPort());
        secure(getKeyStorePath(), getKeyStorePassword(), null, null);
        get("/hello", (req, res) -> "Hello Heroku");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    static String getKeyStorePath() {
        if (System.getenv("KEYSTOREPATH") != null) {
            return System.getenv("KEYSTOREPATH");
        }
        return "keystores/ecikeystore.p12";
    }

    static String getKeyStorePassword() {
        if (System.getenv("KEYSTOREPASSWORD") != null) {
            return System.getenv("KEYSTOREPASSWORD");
        }
        return "123456";
    }
    
}
