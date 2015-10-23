/**
 * 
 */
package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Tiago Ferezin(Ciaware: cw002, Data: 22/10/2015) Funcionalidade da
 *         Classe:
 */
public class Servidor {

	/**
	 * Criado por Tiago Ferezin (Ciaware: cw002, Data: 22/10/2015)
	 * Funcionalidade do método:
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		HttpServer server = inicializaServidor();
		System.out.println("Servidor Rodando!!!");
		System.in.read();

		server.stop();
		
	}

	static HttpServer inicializaServidor() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig()
				.packages("br.com.alura.loja");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,
				config);

		return server;
	}

}
