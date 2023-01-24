package conversorTemperatura;

import javax.swing.*;
import java.util.Objects;

public class ConverteTemperatura {

    public double converterCelsiusParaFahrenheit(double valor) {
        double celsiusParaFahrenheit = valor * 1.8 + 32;
        celsiusParaFahrenheit = (double) Math.round(celsiusParaFahrenheit * 100d) / 100;
        
        JOptionPane.showMessageDialog(null, valor + " Graus Celsius são " + celsiusParaFahrenheit + " Graus Fahrenheit ");
        return celsiusParaFahrenheit;
    }

    public double converterCelsiusParaKelvin(double valor) {
        double celsiusParaKelvin = valor + 273.15;
        celsiusParaKelvin = (double) Math.round(celsiusParaKelvin * 100d) / 100;
        
        JOptionPane.showMessageDialog(null, valor + " Graus Celsius são " + celsiusParaKelvin + " Kelvin");
        return celsiusParaKelvin;
    }

    public double converterFahrenheitParaCelsius(double valor) {
        double fahrenheitParaCelsius = (valor - 32) / 1.8;
        fahrenheitParaCelsius = (double) Math.round(fahrenheitParaCelsius * 100d) / 100;
        
        JOptionPane.showMessageDialog(null, valor + " Graus Fahrenheit são " + fahrenheitParaCelsius + " Celsius");
        return fahrenheitParaCelsius;
    }

    public double converterKelvinParaCelsius(double valor) {
        double kelvinParaCelcius = valor - 273.15;
        kelvinParaCelcius = (double) Math.round(kelvinParaCelcius * 100d) / 100;
        
        JOptionPane.showMessageDialog(null, valor + " Kelvin são " + kelvinParaCelcius + " Celsius");
        return kelvinParaCelcius;
    }

    public double converterKelvinParaFahrenheit(double valor) {
        double kelvinParaFahrenheit = (valor - 273.15) * 9 / 5 + 32;
        kelvinParaFahrenheit = (double) Math.round(kelvinParaFahrenheit * 100d) / 100;
        
        JOptionPane.showMessageDialog(null, valor + " Kelvin são " + kelvinParaFahrenheit + " Fahrenheit");
        return kelvinParaFahrenheit;
    }

}