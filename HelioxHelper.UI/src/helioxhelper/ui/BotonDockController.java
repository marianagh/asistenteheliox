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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.sound.sampled.LineUnavailableException;
import org.proyectoHeliox.helper.entidades.Boton;
import org.proyectoHeliox.helper.negocio.NegocioHeliox;

/**
 *
 * @author Mariana
 */
public class BotonDockController extends ListCell<Boton> {
     
    private NegocioHeliox nh = new NegocioHeliox();
    private ListView<Boton> listView;
    private Boton b;
    private FXMLLoader loader;
    //Audio player = new Audio();
    
     int contador;
     
    @FXML
    private JFXButton button;
   
   @Override
   protected void updateItem(Boton b, boolean empty){
       super.updateItem(b, empty);
       if (empty || b== null){
           setText(null);
           setGraphic(null);
       } else {
           if (loader == null){
           loader =  new FXMLLoader(getClass().getResource("BotonDockListView.fxml"));
           loader.setController(this);
               try {
                   loader.load();
               } catch (IOException ex) {
                   Logger.getLogger(BotonDockController.class.getName()).log(Level.SEVERE, null, ex);
               }
               System.out.println("loader button dock");
           }
           Image icon;
            icon = new Image("file:///"+ b.getRutaIcono());
            OGGPlayer audio = new OGGPlayer(b.getRutaAudio());
            ImageView iconView = new ImageView(icon);
            iconView.setFitHeight(40);
            iconView.setFitWidth(40);
            Tooltip tooltip = new Tooltip(b.getDescripcion());
            tooltip.setStyle("-fx-font-size: 14");
            Tooltip.install(button, tooltip);
            button.setOnMouseClicked(e->{
            System.out.print(b.getRutaEjecutable());
                try {
                    if (b.getRutaEjecutable().endsWith(".pdf")) {
                           //convertir ruta a archivo y de archivo a url
                            File f = new File(b.getRutaEjecutable());
                            URI u = f.toURI();
                        if (Desktop.isDesktopSupported()) {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.browse(u); //URL en lugar de la ruta

                        } else {

                            //process = Runtime.getRuntime().exec("xdg-open "+ b.getRutaEjecutable());
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setContentText("Desktop no soportado.");
                        } 

                    } else if (b.getRutaEjecutable().startsWith("http://")){
                        if (Desktop.isDesktopSupported()) {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.browse(new URI(b.getRutaEjecutable()));
                            } else {

                            //process = Runtime.getRuntime().exec("xdg-open "+ b.getRutaEjecutable());
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setContentText("Desktop no soportado.");
                        }
                    }
                    
                    else {
                        Process process = Runtime.getRuntime().exec(b.getRutaEjecutable());
                    }
                    } catch (IOException ex) {
                    Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                   Logger.getLogger(BotonDockController.class.getName()).log(Level.SEVERE, null, ex);
               }
            });
            
            button.setOnMouseEntered(e->{
            
            new Thread(new Runnable() {
                public void run(){
                    //player.play(b.getRutaAudio());
                    audio.play();
                }
            }).start();
            
            });
            
            button.setOnMouseExited(e->{
              
                   audio.stop();
               
                
            });
            
            button.setGraphic(iconView);
            setGraphic(button);
       }
   }
    
}
