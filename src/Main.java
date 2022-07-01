import java.sql.*;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultset;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select ID,Name,CountryCode,Population from city where CountryCode = 'TUR';");
            System.out.println("Bağlantı Kuruldu.");
            ArrayList<City> list = new ArrayList<City>();
            while(resultset.next())
            {
                list.add(new City(
                        resultset.getString("ID"),
                        resultset.getString("Name"),
                        resultset.getString("CountryCode"),
                        resultset.getString("Population")));
            }
            System.out.println("\nTotal City of Turkey : " + list.size());

            System.out.println("\nID\tName\tCountryCode\tPopulation");
            for (City c: list)
            {
                System.out.printf("%s\t%s\t\t%s\t\t%s\n",c.getId(),c.getName(),c.getCountryCode(),c.getPopulation());
            }
        } catch (SQLException exception) {
            helper.showerrorMessage(exception);
        } finally {
            connection.close();
        }

    }


}
