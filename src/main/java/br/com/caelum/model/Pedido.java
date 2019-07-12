package br.com.caelum.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {
	private String num_pedido;
	private String data_compra;
	
	public String getNum_pedido() {
		return num_pedido;
	}
	public void setNum_pedido(String num_pedido) {
		this.num_pedido = num_pedido;
	}
	public String getData_compra() {
		return data_compra;
	}
	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
}
