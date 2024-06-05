/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.project.config;

import java.io.File;

/**
 *
 * @author pctronique
 */
public class FileConfig {
    
    private final File file;
    private final File rootdir;

    public FileConfig() {
        String folderclass = FileConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        this.rootdir = new File(folderclass, "../..");
        this.file = new File(this.rootdir, "../config/config.properties");
    }
    
    public File getFile() {
        return this.file;
    }
    
    public File getRootdir() {
        return this.rootdir;
    }
    
}
