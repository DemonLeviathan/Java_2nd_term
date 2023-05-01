import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Planets", "postgres", "oralcumshot");
            connection.setAutoCommit(false);
            String deleteTables = "DELETE FROM planet;" +
                    "DELETE FROM satellites";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteTables);
            deleteStatement.executeUpdate();
            String querySatellites = "INSERT into satellites(satellite_name, satellite_radius, distance) " +
                    "values('Moon', 1737.4, 384399)," +
                    "('Phobos', 11.3, 9376),"+
                    "('Deimos', 6.2, 23463.2)";
            String query = "INSERT into planet(planet_name, radius, temperature, atmosphere, live, satellites) " +
                    "values('Mercury', 2439.7, 164, false, false, null), " +
                    "('Venera', 6051.8, 464, 'true', 'false', null)," +
                    "('Earth', 6371, 13.9, 'true', 'true', 'Moon')," +
                    "('Mars', 3389.5 , 20, 'false', 'false', 'Phobos')";
            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement statement1 = connection.prepareStatement(querySatellites);
            statement1.executeUpdate();
            statement.executeUpdate();
            connection.commit();
            final Logger LOGGER = null;

            String query1 = "SELECT * FROM planet WHERE live = ?";
            PreparedStatement statement2 = connection.prepareStatement(query1);
            statement2.setString(1, "true");
            ResultSet set1 = statement2.executeQuery();

            ResultSetMetaData metadata = set1.getMetaData();
            int columnCount = metadata.getColumnCount();
            while (set1.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(metadata.getColumnName(i) + ": " + set1.getString(i));
                }
            }

            System.out.println("---------------------------------------");

            String sql = "SELECT planet_name, radius, satellites \n" +
                    "FROM planet \n" +
                    "WHERE satellites IS NOT NULL \n" +
                    "AND radius = (SELECT MIN(radius) FROM planet) \n" +
                    "ORDER BY planet_name;";
            PreparedStatement statement3 = connection.prepareStatement(sql);
            ResultSet set2 = statement3.executeQuery();

            while (set2.next()) {
                String planetName = set2.getString("planet_name");
                double radius = set2.getDouble("radius");
                String satellites = set2.getString("satellites");

                System.out.println("Planet name: " + planetName);
                System.out.println("Radius: " + radius);
                System.out.println("Satellites: " + satellites);
                System.out.println();
            }

            System.out.println("---------------------------------------");

            String sql1 = "SELECT planet.planet_name, SUM(satellites.satellite_radius) AS total_satellites_radius\n" +
                    "FROM planet\n" +
                    "JOIN satellites ON planet.satellites = satellites.satellite_name\n" +
                    "GROUP BY planet.planet_name\n" +
                    "ORDER BY total_satellites_radius DESC\n" +
                    "LIMIT 1;";
            PreparedStatement statement4 = connection.prepareStatement(sql1);
            ResultSet set3 = statement4.executeQuery();

            while (set3.next()) {
                String planetName = set3.getString("planet_name");
                double totalSatellitesRadius = set3.getDouble("total_satellites_radius");

                System.out.println("Planet name: " + planetName);
                System.out.println("Total radius of satellites: " + totalSatellitesRadius);
                System.out.println();
            }

        } catch (SQLDataException ex) {

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }
}