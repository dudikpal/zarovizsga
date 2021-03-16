package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DogTypes {
    
    
    private MariaDbDataSource dataSource;
    
    
    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    public List<String> getDogsByCountry(String country) {
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT name FROM dog_types WHERE country = ?")
        ){
            stmt.setString(1, country.toUpperCase());
            return selectDogsByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot read file, ", se);
        }
    }
    
    
    private List<String> selectDogsByPreparedStatement(PreparedStatement stmt) {
        
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("ResultSet cannot read, ", se);
        }
    }
}
