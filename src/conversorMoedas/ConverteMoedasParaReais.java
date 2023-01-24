package conversorMoedas;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ConverteMoedasParaReais {
	public double converterParaReais(double valorRecebido, double taxaConversao) {
		double moedaConvertida = valorRecebido / taxaConversao;
		moedaConvertida = (double) Math.round(moedaConvertida * 100d) / 100;
		return moedaConvertida;
	}

	public static void main(String[] args) {
		double reais = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Reais: "));
		String url = "https://www.x-rates.com/table/?from=BRL&amount=1";
		String mensagem = "";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements taxas = doc.select("td.rtRates");

			double taxaDolar = Double.parseDouble(taxas.get(0).text());
			double taxaEuro = Double.parseDouble(taxas.get(4).text());
			double taxaLibra = Double.parseDouble(taxas.get(2).text());
			double taxaDolarCanadense = Double.parseDouble(taxas.get(8).text());

			ConverteMoedasParaReais conversor = new ConverteMoedasParaReais();

			double reaisDolares = conversor.converterParaReais(reais, taxaDolar);
			mensagem += "Você tem " + reaisDolares + " dólares.\n";

			double reaisEuros = conversor.converterParaReais(reais, taxaEuro);
			mensagem += "Você tem " + reaisEuros + " euros.\n";

			double reaislibras = conversor.converterParaReais(reais, taxaLibra);
			mensagem += "Você tem " + reaislibras + " libras esterlinas.\n";

			double reaisDolarCanadense = conversor.converterParaReais(reais, taxaDolarCanadense);
			mensagem += "Você tem " + reaisDolarCanadense + " dólares canadenses.\n";

			JOptionPane.showMessageDialog(null, mensagem);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\n" + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao tentar obter as taxas de conversão.\nA estrutura da página da internet pode ter mudado.");
	}
}
}
