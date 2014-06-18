package br.com.caelum.grappaExemplo;

import org.entrementes.grappa.contexto.ContextoGrappa;
import org.entrementes.grappa.contexto.ContextoPadrao;
import org.entrementes.grappa.gpio.Raspberry;
import org.entrementes.grappa.modelo.InstrucaoGrappa;
import org.entrementes.grappa.modelo.InstrucaoGrappa.Acao;
import org.entrementes.grappa.modelo.InstrucaoGrappa.Formato;
import org.entrementes.grappa.modelo.instrucao.InstrucaoLogica;

public class Aplicacao {
	
	public static void main(String[] args) {
		ContextoGrappa contexto = new ContextoPadrao();
		Raspberry pi = contexto.getImplementacao();
		InstrucaoGrappa requisicao = new InstrucaoGrappa(2, Formato.LOGICO, Acao.ESCRITA, 1);
		pi.processarInstrucao(requisicao); // Abriu
		pi.processarInstrucao(new InstrucaoLogica().endereco(2).escrever(0)); // Fechou
	}

}
