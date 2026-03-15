package chat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Hilo encargado de recibir mensajes desde el otro extremo del chat
 * y mostrarlos por pantalla.
 * 
 * @author Andres
 */
public class HiloRecibir extends Thread {

    private BufferedReader entrada;

    /**
     * Constructor del hilo receptor.
     * 
     * @param entrada flujo de entrada del socket
     */
    public HiloRecibir(BufferedReader entrada) {
        this.entrada = entrada;
    }

    /**
     * Método que mantiene la recepción continua de mensajes.
     */
    @Override
    public void run() {
        String mensaje;

        try {
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Cliente: " + mensaje);
            }
        } catch (IOException e) {
            System.out.println("Error al recibir mensajes: " + e.getMessage());
        }
    }
}