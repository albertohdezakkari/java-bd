package org.example.utils;

public abstract class MotorSQL {
        protected Connection connect;
        protected Statement st;
        protected PrepareStatement preSt;
        protected ResultSet rs;
    public abstract void connect();
    public abstract void disconnect();
    public abstract void ejecutarQuery(String SQL);
    public abstract void ejecutarSentencia();
}
