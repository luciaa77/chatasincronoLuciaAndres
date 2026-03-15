package chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hilo encargado de leer mensajes del teclado
 * y enviarlos al servidor.
 */
public class HiloEnviar extends Thread {

    private Socket socket;

    public HiloEnviar(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            Scanner teclado = new Scanner(System.in);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            while (true) {

                String mensaje = teclado.nextLine();
                salida.println(mensaje);

            }

        } catch (Exception e) {

            System.out.println("Error enviando mensaje");
            e.printStackTrace();
        }
    }
}