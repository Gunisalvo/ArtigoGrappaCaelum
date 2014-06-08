package br.com.caelum.grappaExemplo.servico;//1

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.entrementes.grappa.registradores.ObservadorRegistrador;
import org.entrementes.grappa.registradores.ServicoRegistrador;

@ObservadorRegistrador(endereco = 1)// 2
public class Mensageiro implements ServicoRegistrador { // 3

	private final String USUARIO_GMAIL = "seuUsuario";
	private final String SENHA_GMAIL = "suaSenha";
	private final String EMAIL_GMAIL = "seuEmail";
	private final String EMAIL_DESTINO = "emailDestino";

	@Override
	public void processarServico(Object valorEndereco) { // 4
		enviarEmailPeloGmail((String) valorEndereco); // 5
	}

	private void enviarEmailPeloGmail(String mensagem) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USUARIO_GMAIL,SENHA_GMAIL);
					}
				});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_GMAIL));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(EMAIL_DESTINO));
			message.setSubject("[Grappa] Evento Registrado!");
			message.setText(mensagem);
			Transport.send(message);

		} catch (MessagingException e) {
			e.getMessage();
		}
	}
}
