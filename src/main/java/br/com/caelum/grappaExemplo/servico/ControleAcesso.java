package br.com.caelum.grappaExemplo.servico; // 1

import org.entrementes.grappa.ContextoGrappa;
import org.entrementes.grappa.ContextoGrappa.NivelLog;
import org.entrementes.grappa.gpio.ObservadorGpio;
import org.entrementes.grappa.gpio.ServicoGpio;
import org.entrementes.grappa.modelo.instrucao.InstrucaoRegistrador;

@ObservadorGpio(endereco = 2)// 2
public class ControleAcesso implements ServicoGpio { // 3

	private Integer contador = 0;

	@Override
	public void processarServico(Integer estadoPino) { // 4
		ContextoGrappa.getAplicacao().log("Evento pino - estado : " + estadoPino, NivelLog.INFO); // 5
		if (estadoPino.intValue() == 1) { // 6
			this.contador += 1;
			String entradas = this.contador + " entrada(s) autorizada(s).";
			ContextoGrappa.processarInstrucao(new InstrucaoRegistrador().endereco(1).escrever(entradas)); // 7
		}
	}
}
