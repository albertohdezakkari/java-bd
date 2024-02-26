package org.example.utils;

import java.sql.*;
import java.util.Properties;

public class MotorSQLPostgre extends MotorSQL {
    private Properties props;
    private static final String URL = "jdbc:postgresql://postgres.cf0m8qieoh0e.us-east-1.rds.amazonaws.com/postgres";
    private static final String CONTROLADOR
            = "com.mysql.jdbc.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "LUCASLUCAS";
    private static final String SSL = "false";

    public MotorSQLPostgre(){
        this.props = new Properties();
            this.props.setProperty("user", USER);
            this.props.setProperty("password", PASS);
            this.props.setProperty("ssl", SSL);
    }
    @Override
    public void connect() {
        try {
            super.conn = DriverManager.getConnection(URL, props);
            if (super.conn != null) {
                System.out.println("Conectado a la base de datos!");
            } else {
                System.out.println("Fallo al conectar con la base de datos.");
            }
            super.st = this.conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();

            }
            if (st != null) {
                st.close();

            }
            if (conn != null) {
                conn.close();

            }
        } catch (SQLException ex) {

        }
    }
    @Override
    public ResultSet ejecutarQuery(String SQL) {
        try {
            super.rs = this.st.executeQuery(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return super.rs;
    }
    @Override
    public int ejecutarSentencia(String SQL) {
        int filasModificadas = 0;
        try {
            filasModificadas = this.st.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filasModificadas;
    }
}
