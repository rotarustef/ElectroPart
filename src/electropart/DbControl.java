package electropart;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbControl {
    private final String dbPath;

    public DbControl(String dbPath) {
        this.dbPath = dbPath;
    }

    public ArrayList<String> getDatabese() {
        File folder = new File(dbPath);
        ArrayList<String> dbCategory = new ArrayList<String>();

        for (File file : folder.listFiles()) {
            if (file.getName().contains(".sqlite")) {
                dbCategory.add(file.getName().split(".sqlite")[0]);
            }
        }

        return dbCategory;
    }

    public void generateDataBase(String dbName) {
        String db = "jdbc:sqlite:" + dbName + ".sqlite";

        String sqlTable = "CREATE TABLE IF NOT EXISTS " + dbName + " ("
                + "	id INTEGER PRIMARY KEY,"
                + "	value text NOT NULL,"
                + "	quantity INTIGER NOT NULL,"
                + " footprint TEXT NOT NULL,"
                + "	manufacturer TEXT NOT NULL,"
                + "	location TEXT NOT NULL,"
                + "	pdf TEXT NOT NULL,"
                + "	timestamp DATE DEFAULT CURRENT_TIMESTAMP"
                + ");";

        try (Connection conn = DriverManager.getConnection(db)) {
            if (conn != null) {
                var table = conn.createStatement();
                table.execute(sqlTable);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void insertData(String dbName, TableData data) {
        String db = "jdbc:sqlite:" + dbName + ".sqlite";

        String sqlInsert = "INSERT INTO " + dbName
                + "(value,quantity,footprint,manufacturer,location,pdf) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(db)) {
            if (conn != null) {
                // var table = conn.createStatement();
                // table.execute(sqlTable);

                var dataIn = conn.prepareStatement(sqlInsert);
                dataIn.setString(1, data.getValue());
                dataIn.setInt(2, data.getQunatity());
                dataIn.setString(3, data.getFootprint());
                dataIn.setString(4, data.getManufacturer());
                dataIn.setString(5, data.getLocation());
                dataIn.setString(6, data.getPdf());

                dataIn.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<TableData> selectData(String dbName) {

        TableData data;
        ArrayList<TableData> rowData = new ArrayList<TableData>();

        String db = "jdbc:sqlite:" + dbName + ".sqlite";

        var sqlSelect = "SELECT id, value, quantity, footprint, manufacturer, location, pdf, timestamp FROM " + dbName;

        try (Connection conn = DriverManager.getConnection(db)) {
            if (conn != null) {
                var table = conn.createStatement();
                var result = table.executeQuery(sqlSelect);

                while (result.next()) {
                    data = new TableData(
                            result.getString("value"),
                            result.getInt("quantity"),
                            result.getString("footprint"),
                            result.getString("manufacturer"),
                            result.getString("location"),
                            result.getString("pdf"),
                            result.getString("timestamp"));

                    data.setId(result.getInt("id"));
                    rowData.add(data);
                }

            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return rowData;
    }
}