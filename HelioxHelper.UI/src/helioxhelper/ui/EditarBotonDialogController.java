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
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.proyectoHeliox.helper.entidades.Boton;
import org.proyectoHeliox.helper.entidades.Lenguaje;
import org.proyectoHeliox.helper.negocio.NegocioHeliox;

/**
 * Controla el diálogo para editar un botón.
 * @author Mariana
 */
public class EditarBotonDialogController extends VBox {
    
    private File fileAudio;
    private File fileEjecutable;
    private File fileIcono;
    private FileChooser fileChooser = new FileChooser();
    private Lenguaje l = new Lenguaje();
    private Boton b;
    private NegocioHeliox nh = new NegocioHeliox();
    private Properties config;
    
     @FXML
    private VBox vBox;

    @FXML
    private JFXTextField audio;

    @FXML
    private JFXButton btnAudio;

    @FXML
    private JFXTextField ejecutable;

    @FXML
    private JFXButton btbEjecutable;

    @FXML
    private JFXTextField icono;

    @FXML
    private JFXButton btnIcono;

    @FXML
    private JFXTextArea descripcion;

    public JFXTextArea getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JFXTextArea descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public Boton getB() {
        return b;
    }

    public void setB(Boton b) {
        this.b = b;
    }
    
    
     public EditarBotonDialogController(Properties config, Boton b ) {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditarBotonDialog.fxml"));
       fxmlLoader.setController(this);
       fxmlLoader.setRoot(this);
       
        try {
            
            fxmlLoader.load();

        } catch (IOException ex) {
            Logger.getLogger(FXMLAgregarBotonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.b = b;
        this.config = config;
        audio.setPromptText(config.getProperty("audio"));
        ejecutable.setPromptText(config.getProperty("aplicacion"));
        icono.setPromptText(config.getProperty("icono"));
        
        fileAudio = new File(b.getRutaAudio());
        fileIcono = new File(b.getRutaIcono());
        audio.setText(fileAudio.getName());
        icono.setText(fileIcono.getName());
        ejecutable.setText(b.getRutaEjecutable());  
        descripcion.setText(b.getDescripcion());
        System.out.println("Loaded!");
        
    }

    @FXML
    void handleSeleccionarEjecutableAction(ActionEvent event) {
        fileChooser.getExtensionFilters().clear();
        fileEjecutable = fileChooser.showOpenDialog(ejecutable.getScene().getWindow());
        if (fileEjecutable!= null){
              ejecutable.setText(fileEjecutable.toString());
        }      
        b.setRutaEjecutable(ejecutable.getText());
        System.out.println(b.getRutaEjecutable());
        
        
    }

    @FXML
    void handleSeleccionarIconoAction(ActionEvent event) {
         fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
        fileIcono = fileChooser.showOpenDialog(icono.getScene().getWindow());
        System.out.println(fileIcono);
        icono.setText(fileIcono.getName());
        b.setRutaIcono(fileIcono.toString());
        fileChooser.getExtensionFilters().clear();
    }

    @FXML
    void handleSelecionarAudioAction(ActionEvent event) {
       fileChooser.getExtensionFilters().clear();
              fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.*"),
                new FileChooser.ExtensionFilter("OGG", "*.ogg")
            );
        fileAudio = fileChooser.showOpenDialog(audio.getScene().getWindow());
        System.out.println(fileAudio);
        audio.setText(fileAudio.getName());
        b.setRutaAudio(fileAudio.toString());

    }
    
    
}
