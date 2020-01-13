import java.io.*;
import java.nio.file.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class Server {

	public static void main(String[] args) throws Exception {
		HttpServer oiseau_social = HttpServer.create(new InetSocketAddress(8000), 0);
    HttpContext coucou = oiseau_social.createContext("/", new RootHandler());
    HttpContext coucou = oiseau_social.createContext("/login", new RootHandler());
    System.out.println(coucou.getPath());
		oiseau_social.setExecutor(null); // creates a default executor
		oiseau_social.start();
	}

	static class RootHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
      String coucou = "Hello world!";

      exchange.sendResponseHeaders(200, coucou.length());
      OutputStream os = exchange.getResponseBody();
      os.write(coucou.getBytes());
      os.close();
    }
  }

	static class LoginHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {

      Path file_path = FileSystems.getDefault().getPath("html", "login.html");
      BufferedReader file_reader = Files.newBufferedReader(file_path);

      String login = "", line;
      while ((line = file_reader.readLine()) != null)
      {
        login += line;
      }

			exchange.sendResponseHeaders(200, login.length());
			OutputStream os = exchange.getResponseBody();
			os.write(login.getBytes());
			os.close();
		}
	}
}
