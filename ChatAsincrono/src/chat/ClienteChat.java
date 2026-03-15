package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase principal del cliente del chat asíncrono.
 * Se conecta al servidor y lanza un hilo de envío
 * y otro de recepción.
 * 
 * @author Lucía
 */
public class ClienteChat {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 5000;

        try {
            System.out.println("Conectando al servidor...");

            Socket socket = new Socket(HOST, PUERTO);
            System.out.println("Conectado al servidor");

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true
            );

            HiloRecibir hiloRecibir = new HiloRecibir(entrada);
            HiloEnviar hiloEnviar = new HiloEnviar(salida);

            hiloRecibir.start();
            hiloEnviar.start();

        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
}