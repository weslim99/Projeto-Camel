package br.com.caelum.camel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXB;

import br.com.caelum.model.Pedido;

public class TesteCamel {
	public static void main(String[] args) throws FileNotFoundException{
		Pedido pedido = new Pedido();
		
		
		pedido.setNum_pedido("102938");
		pedido.setData_compra("20/06/2019");
		
		//para gravar o XML no arquivo
		JAXB.marshal(pedido, new FileOutputStream("pedido.xml"));
		
		//Criar um objeto a partir de um xml
		Pedido pedidoRetorno  = JAXB.unmarshal(new FileInputStream("pedido.xml"), Pedido.class);
		
		System.out.println("Numero do Pedido: " + pedidoRetorno.getNum_pedido());
		System.out.println("Data do Pedido: " + pedidoRetorno.getData_compra());
		
	}
}
