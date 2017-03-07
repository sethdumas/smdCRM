/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import objects.Clients;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author sethd
 */
public class ClientsDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Clients clients) {
        String sql = "INSERT INTO clients ('firstname', 'lastname', 'company', 'address1', address2', 'city', 'state', 'zip', 'phone', 'email', 'prospect')"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] values = {clients.getFirstname(), clients.getLastname(), clients.getCompany(), clients.getAddress1(), clients.getAddress2(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getEmail(), clients.isProspect()};

        return template.update(sql, values);
    }

    public int update(Clients clients) {
        String sql = "UPDATE clients SET 'firstname' = ?, 'lastname' = ?, 'company' = ?, 'address1' = ?, address2' = ?, 'city' = ?, 'state' = ?, 'zip' = ?, 'phone' = ?, 'email' = ?, 'prospect' = ?)"
                + "WHERE id = ?";

        Object[] values = {clients.getFirstname(), clients.getLastname(), clients.getCompany(), clients.getAddress1(), clients.getAddress2(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getEmail(), clients.isProspect()};

        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM clients WHERE id = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    public List<Clients> getClientList() {
        return template.query("SELECT * FROM clients", new RowMapper<Clients>() {
            @Override
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients a = new Clients();
                a.setId(rs.getInt("id"));
                a.setFirstname(rs.getString("firstname"));
                a.setLastname(rs.getString("lastname"));

                return a;
            }
        });
    }

    public Clients getClientById(int id) {
        logger.info("Get client by ID: " + id);
        String sql = "SELECT * FROM clients WHERE id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Clients>(Clients.class));
    }

    public List<Clients> getClientsByPage(int start, int total) {
        String sql = "SELECT * FROM clients LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Clients>() {
            @Override
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients a = new Clients();
                a.setId(rs.getInt(1));
                a.setFirstname(rs.getString(2));
                a.setLastname(rs.getString(3));
                a.setCompany(rs.getString(4));
                a.setAddress1(rs.getString(5));
                a.setAddress2(rs.getString(6));
                a.setCity(rs.getString(7));
                a.setState(rs.getString(8));
                a.setZip(rs.getString(9));
                a.setPhone(rs.getString(10));
                a.setEmail(rs.getString(11));
                a.setProspect(rs.getBoolean(12));

                return a;
            }
        });
    }

    public int getClientsCount() {
        String sql = "SELECT COUNT(id) AS rowcount FROM clients";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
