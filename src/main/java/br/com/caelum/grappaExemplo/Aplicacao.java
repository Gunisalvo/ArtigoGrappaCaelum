package br.com.caelum.grappaExemplo;

import org.entrementes.grappa.contexto.ContextoDesktop;
import org.entrementes.grappa.contexto.ContextoGrappa;
import org.entrementes.grappa.gpio.Raspberry;
import org.entrementes.grappa.modelo.instrucao.InstrucaoDigital;

public class Aplicacao {

	private static Raspberry PI;
	
	public static void main(String[] args) {
		iniciarHardware();
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(2, Conexao.GPIO,TipoAcao.ESCRITA, 1);
		PI.processarInstrucao(new InstrucaoDigital().endereco(2).escrever(1)); // Abriu
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(2, Conexao.GPIO,TipoAcao.ESCRITA, 0);
		PI.processarInstrucao(new InstrucaoDigital().endereco(2).escrever(0)); // Fechou
	}
	
	public static void iniciarHardware(){
		ContextoGrappa contexto = new ContextoDesktop();
		PI = contexto.getImplementacao();
	}

}
