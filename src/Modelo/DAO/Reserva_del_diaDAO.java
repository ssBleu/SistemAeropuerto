package Modelo.DAO;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.title.TextTitle;

public class Reserva_del_diaDAO extends JFrame {

    private JFreeChart chart;
    private DefaultCategoryDataset dataset;

    public Reserva_del_diaDAO() {
        super("Destinos Comprados");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {
        dataset = new DefaultCategoryDataset();

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Variables para almacenar el destino más popular
        String destinoPopular = "";
        int ventasMaximas = 0;

        // Obtener los datos de la base de datos
        String url = "jdbc:mysql://localhost:3306/bd_vuelos";
        String username = "root";
        String password = "";

        try {
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, username, password);

            // Crear una declaración SQL con un parámetro de fecha
            String query = "SELECT v.destino, COUNT(*) AS total "
                    + "FROM reserva_vuelo rv "
                    + "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo "
                    + "WHERE DATE(rv.fecha_reserva) = CURDATE() "
                    + "GROUP BY v.destino "
                    + "ORDER BY total DESC";

            // Preparar la consulta SQL
            PreparedStatement statement = connection.prepareStatement(query);

            // Ejecutar la consulta SQL
            ResultSet resultSet = statement.executeQuery();

            // Obtener los destinos y sus ventas y almacenarlos en el dataset
            while (resultSet.next()) {
                String destination = resultSet.getString("destino");
                int ventas = resultSet.getInt("total");
                dataset.addValue(ventas, "Destinos", destination);

                // Verificar si es el destino más popular
                if (ventas > ventasMaximas) {
                    ventasMaximas = ventas;
                    destinoPopular = destination;
                }
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear el gráfico de área
        chart = ChartFactory.createAreaChart(
                "Ventas", // Título del gráfico
                "Destinos", // Etiqueta del eje horizontal
                "Cantidad de Ventas", // Etiqueta del eje vertical
                dataset, // Datos
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

        // Mostrar el mensaje con el destino más popular
        System.out.println("El destino más popular de hoy día es: " + destinoPopular);

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
    }

    public static void main(String[] args) {
        Reserva_del_diaDAO reservaDelDiaDAO = new Reserva_del_diaDAO();
    }
}
