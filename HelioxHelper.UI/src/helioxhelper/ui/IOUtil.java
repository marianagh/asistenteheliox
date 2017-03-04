
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase de utlidad para el manejo de archivos.
 *
 * @author Mariana García
 */
public class IOUtil {

    private Properties prop = new Properties();
    private String icono;
    private String audio;
    private String lenguaje;
    private String aplicacion;
    String filename = "config.properties";

    public Properties cargarPropiedades() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            
            input = new FileInputStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);

            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("lenguaje"));
            System.out.println(prop.getProperty("audio"));
            System.out.println(prop.getProperty("icono"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.prop = prop;
    }
    
    public void guardarPropiedades(Properties config) throws FileNotFoundException, IOException{
        try {
          
             FileOutputStream fOut = new FileOutputStream(filename);
            config.store(fOut, "Modificado");
            System.out.println("Modificado");
            fOut.close();
             } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }
    
    
}
