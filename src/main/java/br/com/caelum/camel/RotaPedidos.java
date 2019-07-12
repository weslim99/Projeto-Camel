package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			//Style File Sharing
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:pedidos?delay=5s&noop=true").
					setProperty("pedidoId", xpath("/pedido/id/text()")).
					setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()")).
					split().
					 	xpath("/pedido/itens/item").
					 	log("${id} - ${body}").
					filter().
						xpath("/item/formato[text()='EBOOK']").
					setProperty("ebookId", xpath("/item/livro/codigo/text()")).	
					log("${id} - ${body}").
					marshal()//transformar a mensagem em outro formato
						.xmljson().//de xml para json
					setHeader(Exchange.HTTP_METHOD, simple("clienteId=${property.clienteId}&pedidoId=${property.pedidoId}&ebookId=${property.ebookId}")).
				to("http4://localhost:8080/webservices/ebook/item");	
				//to("file:saida");
			}			
		});
		
		context.start();
		Thread.sleep(20000);
		context.stop();
	}	
}
