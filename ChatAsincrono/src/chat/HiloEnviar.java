package chat;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Hilo encargado de leer mensajes desde teclado
 * y enviarlos al otro extremo del chat.
 * 
 * @author Lucía
 */
public class HiloEnviar extends Thread {

    private PrintWriter salida;

    /**
     * Constructor del hilo de envío.
     * 
     * @param salida flujo de salida del socket
     */
    public HiloEnviar(PrintWriter salida) {
        this.salida = salida;
    }

    /**
     * Lee continuamente del teclado y envía los mensajes.
     */
    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);

        try {
            while (true) {
                String mensaje = teclado.nextLine();
                salida.println(mensaje);
            }
        } catch (Exception e) {
            System.out.println("Error al enviar mensajes: " + e.getMessage());
        }
    }
}