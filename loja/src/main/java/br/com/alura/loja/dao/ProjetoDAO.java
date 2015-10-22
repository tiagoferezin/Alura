/**
 * 
 */
package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.alura.loja.modelo.Projeto;

/**
 * @author Tiago Ferezin(Ciaware: cw002, Data: 22/10/2015) Funcionalidade da
 *         Classe:
 */
public class ProjetoDAO {

	private static Map<Long, Projeto> banco = new HashMap<Long, Projeto>();
	private static AtomicLong contador = new AtomicLong(1);

	static {
		banco.put(1L, new Projeto(1L, "Minha loja", 2014));
		banco.put(2L, new Projeto(2L, "Alura", 2014));
	}

	public void adiciona(Projeto projeto) {
		Long id = contador.incrementAndGet();
		projeto.setId(id);
		banco.put(id, projeto);
	}

	public Projeto busca(Long id) {
		return banco.get(id);
	}
	
	public Projeto remove(Long id){
		return banco.remove(id);
	}

}
