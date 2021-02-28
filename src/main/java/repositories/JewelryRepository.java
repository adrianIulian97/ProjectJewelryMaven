package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JewelryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addJewelry(String name) {
        String sql = "INSERT INTO jewelry VALUES (NULL, ?)";
        jdbcTemplate.update(sql, name);
    }
}
