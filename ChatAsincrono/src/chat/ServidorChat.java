package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase principal del servidor del chat asíncrono.
 * Abre un puerto, espera la conexión de un cliente
 * y lanza un hilo de envío y otro de recepción.
 * 
 * @author Andres
 */
public class ServidorChat {

    public static void main(String[] args) {
        final int PUERTO = 5000;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado en el puerto " + PUERTO);
            System.out.println("Esperando cliente...");

            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

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
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}