/**
 * 
 */
package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import junit.framework.Assert;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

import com.thoughtworks.xstream.XStream;

/**
 * @author Tiago Ferezin(Ciaware: cw002, Data: 22/10/2015) Funcionalidade da
 *         Classe:
 */
public class ClienteTest {

	private HttpServer server;

	@Before
	public void before() {
		server = Servidor.inicializaServidor();
	}

	@After
	public void after() {
		Servidor.pararSerivdor(server);
	}

	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080");

		String conteudo = target.path("/carrinhos/1").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
		System.out.println(conteudo);

	}

	@Test
    public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        String conteudo = target.path("/projetos/1").request().get(String.class);
        Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
        Assert.assertEquals("Minha loja", projeto.getNome());
        System.out.println(conteudo);
    }

}
