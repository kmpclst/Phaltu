package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcProductRepository implements ProductRepository {

    private final JdbcTemplate jdbc;

    public JdbcProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // RowMapper lambda — defined once, reused everywhere
    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
            rs.getLong("prod_id"),
            rs.getString("prod_name"),
            rs.getInt("price")
    );

    @Override
    public List<Product> findAll() {
        return jdbc.query("SELECT * FROM product ORDER BY prod_id", productRowMapper);
    }

    @Override
    public Optional<Product> findById(Long prodId) {
        var results = jdbc.query(
                "SELECT * FROM product WHERE prod_id = ?",
                productRowMapper,
                prodId // bound to first ?
        );
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Optional<Product> findByName(String prodName) {
        // TODO: implement findByName query
        var results = jdbc.query(
                "SELECT * FROM product WHERE prod_name = ?",
                productRowMapper,
                prodName // bound to first ?
        );
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Product save(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO product (prod_name, price) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, product.prodName());
            ps.setInt(2, product.price());
            return ps;
        }, keyHolder);
        Long id = keyHolder.getKey().longValue();
        return new Product(id, product.prodName(), product.price());
    }

    @Override
    public Product update(Product product) {
        // TODO: implement update
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void deleteById(Long prodId) {
        // TODO: implement deleteById
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
