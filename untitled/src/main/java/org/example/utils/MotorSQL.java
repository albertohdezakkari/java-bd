package org.example.utils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class MotorSQL {
        protected Connection conn;
        protected Statement st;
        // protected PrepareStatement preSt;
        protected ResultSet rs;
    public abstract void connect();
    public abstract void disconnect();
    public abstract ResultSet ejecutarQuery(String SQL);
    public abstract int ejecutarSentencia(String SQL);
}
