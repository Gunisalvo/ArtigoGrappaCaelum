package br.com.caelum.grappaExemplo.servico; // 1

import org.gunisalvo.grappa.Grappa;
import org.gunisalvo.grappa.Grappa.NivelLog;
import org.gunisalvo.grappa.gpio.GPIOListener;
import org.gunisalvo.grappa.gpio.ServicoGpio;
import org.gunisalvo.grappa.modelo.instrucao.InstrucaoRegistrador;

@GPIOListener(pino = 2)// 2
public class ControleAcesso implements ServicoGpio { // 3

	private Integer contador = 0;

	@Override
	public void processarServico(Integer estadoPino) { // 4
		Grappa.getAplicacao().log("Evento pino - estado : " + estadoPino, NivelLog.INFO); // 5
		if (estadoPino.intValue() == 1) { // 6
			this.contador += 1;
			String entradas = this.contador + " entrada(s) autorizada(s).";
			Grappa.processarPacote(new InstrucaoRegistrador().endereco(1).escrever(entradas)); // 7
		}
	}
}
