package helioxhelper.ui;

/*
 * Copyright (C) 2016 Mariana
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author Mariana
 */
import com.jfoenix.controls.JFXTextField;
import helioxhelper.ui.FXMLAgregarBotonController;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ConfigController extends VBox {
    
    private Properties config;
    
    @FXML
    private VBox vBox;

    @FXML
    private JFXTextField audio;

    @FXML
    private JFXTextField ejecutable;

    @FXML
    private JFXTextField icono;

    @FXML
    private JFXTextField lenguaje;

    @FXML
    private JFXTextField boton;

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public JFXTextField getAudio() {
        return audio;
    }

    public void setAudio(JFXTextField audio) {
        this.audio = audio;
    }

    public JFXTextField getEjecutable() {
        return ejecutable;
    }

    public void setEjecutable(JFXTextField ejecutable) {
        this.ejecutable = ejecutable;
    }

    public JFXTextField getIcono() {
        return icono;
    }

    public void setIcono(JFXTextField icono) {
        this.icono = icono;
    }
    

    public JFXTextField getBoton() {
        return boton;
    }

    public void setBoton(JFXTextField boton) {
        this.boton = boton;
    }    
    
    public ConfigController(Properties config){
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Config.fxml"));
       fxmlLoader.setController(this);
       fxmlLoader.setRoot(this);
        try {
            
            fxmlLoader.load();

        } catch (IOException ex) {
            Logger.getLogger(FXMLAgregarBotonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.config = config;
        audio.setPromptText(config.getProperty("audio"));
        audio.setText(config.getProperty("audio"));
        ejecutable.setPromptText(config.getProperty("aplicacion"));
        ejecutable.setText(config.getProperty("aplicacion"));
        icono.setPromptText(config.getProperty("icono"));
        icono.setText(config.getProperty("icono"));
        boton.setPromptText(config.getProperty("boton"));
        boton.setText(config.getProperty("boton"));
        lenguaje.setPromptText(config.getProperty("lenguaje"));
        lenguaje.setText(config.getProperty("lenguaje"));
        System.out.println("Loaded!");
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public JFXTextField getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(JFXTextField lenguaje) {
        this.lenguaje = lenguaje;
    }

}