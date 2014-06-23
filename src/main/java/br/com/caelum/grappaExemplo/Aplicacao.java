package br.com.caelum.grappaExemplo;

import br.com.caelum.grappa.context.DefaultContext;
import br.com.caelum.grappa.context.GrappaContext;
import br.com.caelum.grappa.model.GrappaInstruction;
import br.com.caelum.grappa.model.GrappaInstruction.Action;
import br.com.caelum.grappa.model.GrappaPin.PinFormat;
import br.com.caelum.grappa.model.builder.LogicInstruction;
import br.com.caelum.grappa.pin.PhysicalDevice;

public class Aplicacao {
	
	public static void main(String[] args) {
		GrappaContext contexto = new DefaultContext();
		PhysicalDevice raspberryPi = contexto.getPhysicalDevice();
		GrappaInstruction requisicao = new GrappaInstruction(2, PinFormat.LOGIC, Action.WRITE, 1);
		raspberryPi.processInstruction(requisicao); // Abriu
		raspberryPi.processInstruction(new LogicInstruction().address(2).write(0)); // Fechou
	}

}
