import java.io.*;
import java.nio.file.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class Server {

	public static void main(String[] args) throws Exception {
		HttpServer oiseau_social = HttpServer.create(new InetSocketAddress(8000), 0);
		oiseau_social.createContext("/login", new LoginContext());
		oiseau_social.setExecutor(null); // creates a default executor
		oiseau_social.start();
	}

	static class LoginContext implements HttpHandler {
		@Override
		public void handle(HttpExchange request) throws IOException {
      String login = "<h1>Coucou Marion</h1>";

			request.sendResponseHeaders(200, login.length());
			OutputStream os = request.getResponseBody();
			os.write(login.getBytes());
			os.close();
		}
	}
}
