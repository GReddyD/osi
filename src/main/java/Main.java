import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	private static int PORT = 54321;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT); // открыли сокет для подключения
		Socket clientSocket = serverSocket.accept(); // ждем подключения
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		System.out.println(">>> New connection accepted");
		final String name = in.readLine();
		out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
	}
}
