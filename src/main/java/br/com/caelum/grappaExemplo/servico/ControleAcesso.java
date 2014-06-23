package br.com.caelum.grappaExemplo.servico; // 1

import br.com.caelum.grappa.annotation.PinListener;
import br.com.caelum.grappa.pin.PinService;

@PinListener(addresses = 2)// 2
public class ControleAcesso implements PinService{

	private Integer contador = 0;
	
	@Override
	public void processEvent(Integer estadoPino) { // 3
		System.out.println("processando evento eletrico.");
		
		if (estadoPino.intValue() == 1) { // 4
			this.contador += 1;
			String mensagem = this.contador + " entrada(s) autorizada(s).";
			System.out.println(mensagem); //5
		}
	}
}
