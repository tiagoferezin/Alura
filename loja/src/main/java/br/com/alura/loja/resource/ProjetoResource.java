/**
 * 
 */
package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

/**
 * @author Tiago Ferezin(Ciaware: cw002, Data: 22/10/2015)
 * Funcionalidade da Classe: 
 */
@Path("projetos")
public class ProjetoResource {

	@Path("{id}")
	@GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") Long id) {
        Projeto projeto = new ProjetoDAO().busca(id);
        return projeto.toXML();
    }
	
}