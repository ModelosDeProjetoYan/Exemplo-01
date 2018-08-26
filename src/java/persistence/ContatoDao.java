/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import model.Contato;

/**
 *
 * @author YanNotebook
 */
public class ContatoDao {

    private static ContatoDao instance = new ContatoDao();

    private ContatoDao() {
    }

    public static ContatoDao getInstance() {
        return instance;
    }

    public void save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute("insert into contatos (nome, email)"
                    + " values ('" + contato.getNome() + "', '" + contato.getEmail() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResoucers(conn, st);
        }
    }

    private void closeResoucers(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }

    }

}
