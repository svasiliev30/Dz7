package testPerson;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

import sbp.WelcomeHandler.WelcomeHandler;
import sbp.dao.ProductRepository;
import sbp.myThread.MyPutServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TestThread {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8080;

    /**
     * Start server
     * @param args
     * @throws IOException
     */
        public static void main(String[] args) throws IOException{

            HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), 0);

            server.createContext("/welcome", new WelcomeHandler());
            server.createContext("/person", new MyPutServer(new ProductRepository()));

            server.setExecutor(Executors.newSingleThreadExecutor());

            server.start();
            System.out.println("Simple server started...");
    }
}



