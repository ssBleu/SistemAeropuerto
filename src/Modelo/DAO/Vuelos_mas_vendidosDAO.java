package Modelo.DAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Vuelos_mas_vendidosDAO extends JFrame {
    private JFreeChart chart;

    public Vuelos_mas_vendidosDAO() {
        super("Gráfico de Vuelos más Vendidos");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Obtener los datos de la base de datos
        String url = "jdbc:mysql://localhost:3306/bd_vuelos";
        String username = "root";
        String password = "";

        try {
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, username, password);

            // Crear una declaración SQL
            Statement statement = connection.createStatement();

            // Construir la consulta SQL para obtener los vuelos más vendidos y su destino
            String query = "SELECT v.destino, COUNT(*) AS total " +
                           "FROM reserva_vuelo rv " +
                           "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo " +
                           "GROUP BY v.destino " +
                           "ORDER BY total DESC";

            // Ejecutar la consulta SQL
            ResultSet resultSet = statement.executeQuery(query);

            // Agregar los datos al dataset
            while (resultSet.next()) {
                String destino = resultSet.getString("destino");
                int total = resultSet.getInt("total");
                dataset.setValue(total, "Vuelos más Vendidos", destino);
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear el gráfico de barras
        chart = ChartFactory.createBarChart(
                "Vuelos más Vendidos", // Título del gráfico
                "Destino", // Etiqueta del eje horizontal
                "Cantidad de Reservas", // Etiqueta del eje vertical
                dataset, // Datos
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
    }

    public static void main(String args[]) {
        Vuelos_mas_vendidosDAO demo = new Vuelos_mas_vendidosDAO();
    }
}

