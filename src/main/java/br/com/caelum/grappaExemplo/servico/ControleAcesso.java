package br.com.caelum.grappaExemplo.servico; // 1

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.entrementes.grappa.dispositivo.Dispositivo;
import org.entrementes.grappa.gpio.ObservadorGpio;

@Dispositivo(nome = "controle-acesso")// 2
public class ControleAcesso {

	private Integer contador = 0;
	
	private final String USUARIO_GMAIL = "seu usuario Gmail";
	private final String SENHA_GMAIL = "sua senha Gmail";
	private final String EMAIL_GMAIL = "seu email Gmail";
	private final String EMAIL_DESTINO = "email notificado";

	public Integer getContador() {
		return contador;
	}
	
	@ObservadorGpio(endereco = 2)
	public void processarServico(Integer estadoPino) { // 3
		System.out.println("processando evento eletrico.");
		
		if (estadoPino.intValue() == 1) { // 4
			this.contador += 1;
			String mensagem = this.contador + " entrada(s) autorizada(s).";
			enviarEmailPeloGmail(mensagem); //5
		}
	}
	
	private void enviarEmailPeloGmail(String corpoMensagem) {
		System.out.println("enviando mensagem.");
		
		Properties configuracaoGmail = new Properties();
		configuracaoGmail.put("mail.smtp.host", "smtp.gmail.com");
		configuracaoGmail.put("mail.smtp.socketFactory.port", "465");
		configuracaoGmail.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		configuracaoGmail.put("mail.smtp.auth", "true");
		configuracaoGmail.put("mail.smtp.port", "465");

		Session sessaoGmail = Session.getDefaultInstance(configuracaoGmail,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USUARIO_GMAIL,SENHA_GMAIL);
					}
				});
		try {
			Message emailNotificacao = new MimeMessage(sessaoGmail);
			emailNotificacao.setFrom(new InternetAddress(EMAIL_GMAIL));
			emailNotificacao.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(EMAIL_DESTINO));
			emailNotificacao.setSubject("[Grappa] Evento Registrado!");
			emailNotificacao.setText(corpoMensagem);
			Transport.send(emailNotificacao);

		} catch (MessagingException ex) {
			throw new RuntimeException(ex);
		}
	}	
}
