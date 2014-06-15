package br.com.caelum.grappaExemplo;

import org.entrementes.grappa.contexto.ContextoDesktop;
import org.entrementes.grappa.contexto.ContextoGrappa;
import org.entrementes.grappa.modelo.instrucao.InstrucaoGPIO;

import br.com.caelum.grappaExemplo.servico.ControleAcesso;

public class Aplicacao {

	public static void main(String[] args) {
		ContextoGrappa contexto = new ContextoDesktop();
		ControleAcesso dispositivo = (ControleAcesso) contexto.getDispositivos().get("controle-acesso");
		System.out.println(dispositivo.getContador() + " entrada(s) autorizada(s).");
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(2, Conexao.GPIO,TipoAcao.ESCRITA, 1);
		contexto.processarInstrucao(new InstrucaoGPIO().endereco(2).escrever(1)); // Abriu
		// InstrucaoGrappa requisicao = new InstrucaoGrappa(2, Conexao.GPIO,TipoAcao.ESCRITA, 0);
		contexto.processarInstrucao(new InstrucaoGPIO().endereco(2).escrever(0)); // Fechou
		System.out.println(dispositivo.getContador() + " entrada(s) autorizada(s).");
	}

}
