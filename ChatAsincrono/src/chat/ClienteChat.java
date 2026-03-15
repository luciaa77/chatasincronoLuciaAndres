package chat;

/**
 * Clase ClienteChat
 * Se encarga de conectarse al servidor y arrancar el hilo de envío.
 * @author Lucía
 */
public class ClienteChat {

    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 5000;

        try {

            System.out.println("Conectando al servidor...");

            Socket socket = new Socket(host, puerto);

            System.out.println("Conectado al servidor");

            HiloEnviar hiloEnviar = new HiloEnviar(socket);
            hiloEnviar.start();

        } catch (IOException e) {

            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
    }
}