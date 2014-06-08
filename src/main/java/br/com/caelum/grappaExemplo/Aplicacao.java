package br.com.caelum.grappaExemplo;

import org.entrementes.grappa.ContextoGrappa;
import org.entrementes.grappa.modelo.InstrucaoGrappa;
import org.entrementes.grappa.modelo.instrucao.InstrucaoGPIO;
import org.entrementes.grappa.modelo.instrucao.InstrucaoRegistrador;

public class Aplicacao {

	public static void main(String[] args) {
		ContextoGrappa.construir();
		lerAcessos();
		sinalizarAcesso();
		lerAcessos();
	}

	private static void lerAcessos() {
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(1, Conexao.REGISTRADOR,TipoAcao.LEITURA, null);
		InstrucaoGrappa resposta = ContextoGrappa.processarInstrucao(new InstrucaoRegistrador().endereco(1).ler());
		System.out.println(resposta.getValor().getCorpo()); // n entrada(s) autorizada(s).
	}

	private static void sinalizarAcesso() {
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(1, Conexao.GPIO,TipoAcao.ESCRITA, 1);
		ContextoGrappa.processarInstrucao(new InstrucaoGPIO().endereco(2).escrever(1)); // Abriu
		ContextoGrappa.processarInstrucao(new InstrucaoGPIO().endereco(2).escrever(0)); // Fechou
	}

}
