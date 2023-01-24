package conversorMoedas;

import java.io.IOException;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ConverteMoedas {
	public double converterReais(double valorRecebido, double taxaConversao) {
		double moedaConvertida = valorRecebido * taxaConversao;
		moedaConvertida = (double) Math.round(moedaConvertida * 100d) / 100;
		return moedaConvertida;
	}

	public static void main(String[] args) {
		// Obtém o valor em reais do usuário para fazer a conversão
		double reais = 0.0;
		try {
			reais = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Reais: "));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Digite apenas números.");
			return;
		}

		// usa a abaixo para URL obter taxas de câmbio, (Exemplo) para demonstração de como pegar cotações via URL
		String url = "https://www.x-rates.com/table/?from=BRL&amount=1";
		String mensagem = "";

		try {
			// nesse trecho do código Jsoup faz a conexão no site e verifica as taxas de câmbio
			Document doc = Jsoup.connect(url).get();
			Elements taxas = doc.select("td.rtRates");

			double taxaDolar = Double.parseDouble(taxas.get(0).text());
			double taxaEuro = Double.parseDouble(taxas.get(4).text());
			double taxaLibra = Double.parseDouble(taxas.get(2).text());			
			double taxaDolarCanadense = Double.parseDouble(taxas.get(8).text());

			ConverteMoedas conversor = new ConverteMoedas();

			// Aqui faz a Conversão do valor de reais para outras moedas			
			double dolares = conversor.converterReais(reais, taxaDolar);
			double euros = conversor.converterReais(reais, taxaEuro);
			double libras = conversor.converterReais(reais, taxaLibra);
			double dolaresCanadenses = conversor.converterReais(reais, taxaDolarCanadense);
			

			// Aqui Cria a mensagem para mostrar o resultado
			mensagem += "Você tem " + dolares + " dólares.\n";
			mensagem += "Você tem " + euros + " euros.\n";
			mensagem += "Você tem " + libras + " libras esterlinas.\n";
			mensagem += "Você tem " + dolaresCanadenses + " dólares canadenses.\n";
			
			

			JOptionPane.showMessageDialog(null, mensagem);

			// Exemplo simples de tratamentos de erros 
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\n" + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\nA estrutura da página da internet pode ter mudado.");
		}
	}
}
