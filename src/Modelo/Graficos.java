package Modelo;

import Modelo.DAO.AerolineaDAO;
import Modelo.DAO.ReservaDAO;
import Modelo.DAO.VueloDAO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficos {
    
    
    public static ChartPanel crearGrafico1(DefaultCategoryDataset datosBD) {

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createBarChart3D(
            "Gráfico de Aerolíneas Preferidas", // Título del gráfico
            "Aerolínea", // Etiqueta del eje horizontal
            "Cantidad de Veces Pedido", // Etiqueta del eje vertical
            datosBD, // Datos
            PlotOrientation.VERTICAL, // Orientación del gráfico (vertical)
            true, // Incluir leyenda
            true, // Mostrar información al pasar el ratón
            false // No se utilizan URLs
        );

        // Estilizar el gráfico
        chart.setBackgroundPaint(Color.GRAY);
        chart.getTitle().setPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);

        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.GREEN, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

        // Crear un ChartPanel y devolverlo
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
    
    
    
    public static ChartPanel crearGrafico2(DefaultCategoryDataset datosBD) {

        // Crear el gráfico de barras
         JFreeChart chart = ChartFactory.createBarChart(
                "Vuelos más Vendidos", // Título del gráfico
                "Destino", // Etiqueta del eje horizontal
                "Cantidad de Reservas", // Etiqueta del eje vertical
                datosBD, // Datos
                PlotOrientation.VERTICAL, // Orientación del gráfico (vertical)
                true, // Incluir leyenda
                true, // Mostrar información al pasar el ratón
                false // No se utilizan URLs
        );

        // Estilizar el gráfico
        chart.setBackgroundPaint(Color.GRAY);
        chart.getTitle().setPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);

        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.YELLOW, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        // Crear un ChartPanel y devolverlo
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
    
    public static ChartPanel crearGrafico3(DefaultCategoryDataset datosBD) {
        
        JFreeChart chart = ChartFactory.createAreaChart(
                "Ventas", // Título del gráfico
                "Destinos", // Etiqueta del eje horizontal
                "Cantidad de Ventas", // Etiqueta del eje vertical
                datosBD, // Datos
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true, // Mostrar información al pasar el ratón
                false
        );

        chart.setBackgroundPaint(Color.GRAY);
        chart.getTitle().setPaint(Color.WHITE);

        // Personalizar el gráfico
        TextTitle subtitle1 = new TextTitle("Subtitle Demo");
        chart.addSubtitle(subtitle1);
        chart.setBorderVisible(true);
        chart.setBorderPaint(Color.RED);

        // Configurar el eje vertical para que muestre números enteros
        NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());


        // Guardar el gráfico como una imagen
        try {
            ChartUtilities.saveChartAsPNG(
                    new File("NombreGrafica.png"), // Ruta y nombre de la imagen a crear
                    chart,
                    800, // Ancho
                    700 // Alto
            );
        } catch (IOException e) {
            System.err.println("Error creando gráfico.");
        }
        // Crear un ChartPanel y devolverlo
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
    
    
    
}
