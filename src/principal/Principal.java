package principal;

import javax.swing.*;

import conversorMoedas.Funcao;
import conversorTemperatura.FuncaoTemperatura;

public class Principal {

	public static void main(String[] args) {
		Funcao moedas = new Funcao();
		FuncaoTemperatura temperatura = new FuncaoTemperatura();

		while (true) {

			String opcao = JOptionPane.showInputDialog(null, "Escolha uma opção: ", "Menu", JOptionPane.PLAIN_MESSAGE,
					null, new Object[] { "Conversor de Moeda", "Conversor de Temperatura" }, "Escolha").toString();

			switch (opcao) {
			case "Conversor de Moeda":
				String input = JOptionPane.showInputDialog("Insira um valor");
				if (checar(input)) {
					double valorRecebido = Double.parseDouble(input);
					moedas.converterMoeda(valorRecebido);

					int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
					if (JOptionPane.OK_OPTION == resposta) {
						System.out.println("Escolha opção Afirmativa");
					} else {
						JOptionPane.showMessageDialog(null, "Programa finalizado");
						System.exit(0);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				break;
			case "Conversor de Temperatura":
				input = JOptionPane.showInputDialog("Insira um valor de temperatura: ");

				if (checar(input)) {
					double valorRecebido = Double.parseDouble(input);
					temperatura.converterTemperatura(valorRecebido);
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
					if (JOptionPane.OK_OPTION == resposta) {
						System.out.println("Escolha opção Afirmativa");
					} else {
						JOptionPane.showMessageDialog(null, "Programa finalizado");
						System.exit(0);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				break;
			}
		}
	}

	public static boolean checar(String input) {
		try {
			double x = Double.parseDouble(input);
			if (x >= 0 || x < 0)
				;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
