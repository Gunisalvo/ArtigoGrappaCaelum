package br.com.caelum.grappaExemplo.servico; // 1

import org.entrementes.grappa.gpio.ServicoGpio;
import org.entrementes.grappa.marcacao.ObservadorGpio;

@ObservadorGpio(endereco = 2)// 2
public class ControleAcesso implements ServicoGpio{

	private Integer contador = 0;
	
	@Override
	public void processarServico(Integer estadoPino) { // 3
		System.out.println("processando evento eletrico.");
		
		if (estadoPino.intValue() == 1) { // 4
			this.contador += 1;
			String mensagem = this.contador + " entrada(s) autorizada(s).";
			System.out.println(mensagem); //5
		}
	}
}
