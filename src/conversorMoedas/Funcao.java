package conversorMoedas;

import java.io.IOException;

import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.text.DecimalFormat;

public class Funcao {
	private double taxaDolar;
	private double taxaEuro;
	private double taxaLibra;
	private double taxaDolarCanadense;
	

	public Funcao() {
		try {

			Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=BRL&amount=1").get();			
			Elements taxas = doc.select("td.rtRates");

			taxaDolar = Double.parseDouble(taxas.get(0).text());
			taxaEuro = Double.parseDouble(taxas.get(4).text());
			taxaLibra = Double.parseDouble(taxas.get(2).text());
			taxaDolarCanadense = Double.parseDouble(taxas.get(8).text());
			

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\n" + e.getMessage());

		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\nA estrutura da página da internet pode ter mudado.");
		}
	}

	public void converterMoeda(double valorRecebido) {
		String[] opcoes = { "De Reais a Dólares", "De Dólares a Reais", "De Reais a Euros", "De Euros a Reais",
				"De Reais a Libras", "De Libras a Reais", "De Reais a Dolares Canadenses", "De Dolares Canadenses a Reais"};

		String opcao = (String) JOptionPane.showInputDialog(null,
				"Escolha a moeda para a qual você deseja converter seu dinheiro", "Moedas", JOptionPane.PLAIN_MESSAGE,
				null, opcoes, "Escolha");

		DecimalFormat df = new DecimalFormat("#.##");

		ConverteMoedas conversor = new ConverteMoedas();
		ConverteMoedasParaReais conversorReais = new ConverteMoedasParaReais();

		switch (opcao) {
		case "De Reais a Dólares":
			double reaisDolares = conversor.converterReais(valorRecebido, taxaDolar);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(reaisDolares) + " dólares.");
			break;
			
		case "De Dólares a Reais":
			double dolaresReais = conversorReais.converterParaReais(valorRecebido, taxaDolar);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(dolaresReais) + " reais.");
			break;	

		case "De Reais a Euros":
			double reaisEuros = conversor.converterReais(valorRecebido, taxaEuro);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(reaisEuros) + " euros.");
			break;
			
		case "De Euros a Reais":
			double eurosReais = conversorReais.converterParaReais(valorRecebido, taxaEuro);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(eurosReais) + " reais.");
			break;	

		case "De Reais a Libras":
			double reaisLibras = conversor.converterReais(valorRecebido, taxaLibra);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(reaisLibras) + " libras esterlinas.");
			break;
			
		case "De Libras a Reais":
			double librasReais = conversorReais.converterParaReais(valorRecebido, taxaLibra);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(librasReais) + " reais.");
			break;
			
		case "De Reais a Dolares Canadenses":
			double reaisDolarCanadense = conversor.converterReais(valorRecebido, taxaDolarCanadense);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(reaisDolarCanadense) + " Dolares Canadenses.");
			break;
			
		case "De Dolares Canadenses a Reais":
			double DolarCanadenseReais = conversorReais.converterParaReais(valorRecebido, taxaDolarCanadense);
			JOptionPane.showMessageDialog(null, "Você tem " + df.format(DolarCanadenseReais) + " reais.");
			break;				
		
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			break;
		}
	}
}
