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

public class Aerolinea_preferidaDAO extends JFrame {

    private JFreeChart chart;

    public Aerolinea_preferidaDAO() {
        super("Gráfico de Aerolíneas Preferidas");
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

        // Construir la consulta SQL para obtener las aerolíneas y la cantidad de vuelos asociados
        String query = "SELECT a.nombre AS aerolinea, COUNT(*) AS total " +
                       "FROM aerolinea a " +
                       "JOIN avion av ON a.id_aerolinea = av.id_aerolinea " +
                       "JOIN vuelo v ON av.id_avion = v.id_avion " +
                       "GROUP BY a.nombre " +
                       "ORDER BY total DESC";

        // Ejecutar la consulta SQL
        ResultSet resultSet = statement.executeQuery(query);

        // Agregar los datos al dataset
        while (resultSet.next()) {
            String aerolinea = resultSet.getString("aerolinea");
            int total = resultSet.getInt("total");
            dataset.setValue(total, "Aerolínea", aerolinea);
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Crear el gráfico
    chart = ChartFactory.createBarChart3D(
            "Gráfico de Aerolíneas Preferidas", // Título del gráfico
            "Aerolínea", // Etiqueta del eje horizontal
            "Cantidad de Veces Pedido", // Etiqueta del eje vertical
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

    GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.GREEN, 0.0f, 0.0f, new Color(0, 64, 0));
    renderer.setSeriesPaint(0, gp);

    CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
}


    public static void main(String args[]) {
        Aerolinea_preferidaDAO demo = new Aerolinea_preferidaDAO();
    }
}
