package Modelo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficos {

    public static ChartPanel crearGrafico1(DefaultCategoryDataset datosBD) {

        JFreeChart chart = ChartFactory.createBarChart3D(
                "Gráfico de Aerolíneas Preferidas",
                "Aerolínea",
                "Cantidad de Veces Pedido",
                datosBD, // Datos
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
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

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static ChartPanel crearGrafico2(DefaultCategoryDataset datosBD) {

        JFreeChart chart = ChartFactory.createBarChart(
                "Vuelos más Vendidos",
                "Destino",
                "Cantidad de Reservas",
                datosBD, // Datos
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
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

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static ChartPanel crearGrafico3(DefaultCategoryDataset datosBD) {

        JFreeChart chart = ChartFactory.createAreaChart(
                "Ventas",
                "Destinos",
                "Cantidad de Ventas",
                datosBD,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static ChartPanel crearGraficoVuelosCanceladosActivos(DefaultPieDataset datosBD) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Vuelos Cancelados vs. Activos",
                datosBD,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
        plot.setOutlineVisible(false);

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static ChartPanel crearGraficoGananciasPerdidas(DefaultCategoryDataset datosBD) {
        JFreeChart chart = ChartFactory.createStackedAreaChart(
                "Ganancias y Pérdidas",
                "Fecha de Reserva",
                "Monto",
                datosBD,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(NumberFormat.getCurrencyInstance());

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static ChartPanel crearGraficoReservasCanceladas(DefaultCategoryDataset datosBD) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Reservas Canceladas vs. No Canceladas",
                "Fechas",
                "Cantidad de Reservas",
                datosBD,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(180, 212, 238));
        chart.getTitle().setPaint(new Color(12, 64, 160));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(237, 246, 253));
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

}
