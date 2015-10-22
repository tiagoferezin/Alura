/**
 * 
 */
package br.com.alura.loja.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * @author Tiago Ferezin(Ciaware: cw002, Data: 22/10/2015) Funcionalidade da
 *         Classe:
 */
public class Projeto {

	private Long id;
	private String nome;
	private int dataInicio;

	public Projeto() {

	}

	public Projeto(Long id, String nome, int dataInicio) {
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(int dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String toXML() {
		XStream xstream = new XStream();
		return xstream.toXML(this);
	}
	
	public String toJson(){
		return new Gson().toJson(this);
	}

}
