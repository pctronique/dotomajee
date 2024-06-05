/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.project.config;

import fr.pctronique.conf.ConnectSgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pctronique
 */
public class Sgbd {
    
    private final Connection cn;
    private final Statement st;

    public Sgbd() throws ClassNotFoundException, SQLException {
        FileConfig fileConfig = new FileConfig();
        Class.forName("com.mysql.jdbc.Driver");  
        ConnectSgbd connectSgbd = new ConnectSgbd(fileConfig.getFile());
        this.cn = DriverManager.getConnection(connectSgbd.getUrl(), connectSgbd.getUser(), connectSgbd.getPass());
        this.st = this.cn.createStatement();
    }
    
    public Connection getCn() {
        return this.cn;
    }
    
    public Statement getSt() {
        return this.st;
    }
    
}
