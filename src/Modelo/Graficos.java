package Modelo;

import Modelo.DAO.AerolineaDAO;
import Modelo.DAO.ReservaDAO;
import Modelo.DAO.VueloDAO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;

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
        chart.setBackgroundPaint(new Color(180, 212, 238 ));
        chart.getTitle().setPaint(new Color(12,64,160 ));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253 ));
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
        chart.setBackgroundPaint(new Color(180, 212, 238 ));
        chart.getTitle().setPaint(new Color(12,64,160 ));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253 ));
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

        chart.setBackgroundPaint(new Color(180, 212, 238 ));
        chart.getTitle().setPaint(new Color(12,64,160 ));

        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253 ));
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

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
    
    
    public static ChartPanel crearGraficoVuelosCanceladosActivos(DefaultPieDataset datosBD) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Vuelos Cancelados vs. Activos", // Título del gráfico
                datosBD, // Datos
                true, // Incluir leyenda
                true, // Mostrar información al pasar el ratón
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
        plot.setOutlineVisible(false);

        // Etiquetas con valor real y porcentaje
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));

        // Crear un ChartPanel y devolverlo
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
    
    
public static ChartPanel crearGraficoGananciasPerdidas(DefaultCategoryDataset datosBD) {
    JFreeChart chart = ChartFactory.createStackedAreaChart(
            "Ganancias y Pérdidas", // Título del gráfico
            "Fecha de Reserva", // Etiqueta del eje X
            "Monto", // Etiqueta del eje Y
            datosBD, // Datos
            PlotOrientation.VERTICAL,
            true, // Incluir leyenda
            true, // Mostrar información al pasar el ratón
            false
    );

    chart.setBackgroundPaint(new Color(180, 212, 238));
    chart.getTitle().setPaint(new Color(12, 64, 160));

    CategoryPlot plot = chart.getCategoryPlot();
    plot.setBackgroundPaint(new Color(237, 246, 253));
    plot.setDomainGridlinesVisible(true);
    plot.setRangeGridlinePaint(Color.BLACK);

    // Configurar el eje Y para mostrar los valores como moneda
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setNumberFormatOverride(NumberFormat.getCurrencyInstance());

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


public static ChartPanel crearGraficoReservasCanceladas(DefaultCategoryDataset datosBD) {
    JFreeChart chart = ChartFactory.createBarChart(
            "Reservas Canceladas vs. No Canceladas", // Título del gráfico
            "Fechas", // Etiqueta del eje horizontal
            "Cantidad de Reservas", // Etiqueta del eje vertical
            datosBD, // Datos
            PlotOrientation.VERTICAL,
            true, // Incluir leyenda
            true, // Mostrar información al pasar el ratón
            false
    );

    chart.setBackgroundPaint(new Color(180, 212, 238));
    chart.getTitle().setPaint(new Color(12, 64, 160));

    CategoryPlot plot = chart.getCategoryPlot();
    plot.setBackgroundPaint(new Color(237, 246, 253));
    plot.setDomainGridlinesVisible(true);
    plot.setRangeGridlinePaint(Color.BLACK);

    // Configurar el eje vertical para que muestre números enteros
    NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

    // Crear un ChartPanel y devolverlo
    ChartPanel chartPanel = new ChartPanel(chart);
    return chartPanel;
}

}
