package br.com.caelum.grappaExemplo;

import org.gunisalvo.grappa.Grappa;
import org.gunisalvo.grappa.modelo.PacoteGrappa;
import org.gunisalvo.grappa.modelo.instrucao.InstrucaoGPIO;
import org.gunisalvo.grappa.modelo.instrucao.InstrucaoRegistrador;

public class Aplicacao {

	public static void main(String[] args) {
		Grappa.construir();
		lerAcessos();
		sinalizarAcesso();
		lerAcessos();
	}

	private static void lerAcessos() {
		// PacoteGrappa requisicao = new PacoteGrappa(1, Conexao.REGISTRADOR,TipoAcao.LEITURA, null);
		PacoteGrappa resposta = Grappa.processarPacote(new InstrucaoRegistrador().endereco(1).ler());
		System.out.println(resposta.getValor().getCorpo()); // n entrada(s) autorizada(s).
	}

	private static void sinalizarAcesso() {
		// PacoteGrappa requisicao = new PacoteGrappa(1, Conexao.GPIO,TipoAcao.ESCRITA, 1);
		Grappa.processarPacote(new InstrucaoGPIO().endereco(2).escrever(1)); // Abriu
		Grappa.processarPacote(new InstrucaoGPIO().endereco(2).escrever(0)); // Fechou
	}

}
