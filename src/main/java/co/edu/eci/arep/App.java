package co.edu.eci.arep;

import static spark.Spark.*;

import java.util.ArrayList;

public class App {
    public static void main( String[] args ) {
        // ArrayList passwords = {user_1: "dsdasdasdasdasdasdadasda", ""};

        port(getPort());
        secure(getKeyStorePath(), getKeyStorePassword(), null, null);
        get("/hello", (req, res) -> validatePassword(req.body().toString()));
    }

    static boolean validatePassword(String s) {

        return true;
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
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
