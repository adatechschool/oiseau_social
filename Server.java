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

      Path file_path = FileSystems.getDefault().getPath("html", "login.html");
      BufferedReader file_reader = Files.newBufferedReader(file_path);

      String login = "", line;
      while ((line = file_reader.readLine()) != null)
      {
        login += line;
      }

			request.sendResponseHeaders(200, login.length());
			OutputStream os = request.getResponseBody();
			os.write(login.getBytes());
			os.close();
		}
	}
}
