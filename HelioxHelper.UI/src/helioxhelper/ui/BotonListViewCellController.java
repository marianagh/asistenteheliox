/*
 * Copyright (C) 2016 Mariana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.proyectoHeliox.helper.entidades.Boton;
import org.proyectoHeliox.helper.entidades.Lenguaje;
import org.proyectoHeliox.helper.negocio.NegocioHeliox;

/**
 * FXML Controller class
 *
 * @author Mariana
 */
public class BotonListViewCellController extends ListCell<Boton> {
    
    Tooltip tooltip = new Tooltip("Puede probar el boton dando click aquí.");
    NegocioHeliox nh = new NegocioHeliox();
    ListView<Boton> listView;
    JFXDialogLayout layout;
    StackPane stackPane;
    JFXDialog dialog;
    File fileIcono;
    Properties config;
    private Lenguaje l;
    
    @FXML
    private HBox buttonCardBox;

    @FXML
    private ImageView iconoPrograma;

    @FXML
    private Label lblAudio;

    @FXML
    private Label lblPrograma;

    @FXML
    private Label lblDescripcion;

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnBorrar;

    private FXMLLoader loader;

    @FXML
    void audioOnMouseClicked(MouseEvent event) {

    }

    public BotonListViewCellController(ListView<Boton> listView, JFXDialogLayout layout,
            StackPane stackPane, JFXDialog dialog, Properties config, Lenguaje l) {
        super();
        this.listView = listView;
        this.layout = layout;
        this.stackPane = stackPane;
        this.dialog = dialog;
        this.config = config;
        this.l = l;
    }

    @Override
    protected void updateItem(Boton b, boolean empty) {
        super.updateItem(b, empty);
        if (empty || b == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (loader == null) {
                loader = new FXMLLoader(getClass().getResource("BotonListViewCell.fxml"));
                loader.setController(this);
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File fileEjecutable = new File(b.getRutaEjecutable());
            lblPrograma.setText(fileEjecutable.getName());
            lblDescripcion.setText(b.getDescripcion());
            
            tooltip.setStyle("-fx-font-size: 14px");
            Tooltip.install(iconoPrograma, tooltip);
            OGGPlayer audio = new OGGPlayer(b.getRutaAudio());
            
            iconoPrograma.setOnMouseEntered(e->{
               new Thread(new Runnable() {
                public void run(){
                    
                    audio.play();
                }
            }).start();
            
            
            });
            iconoPrograma.setOnMouseExited(e->{
                audio.stop();
            });
            iconoPrograma.setOnMouseClicked(e->{
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
            Image icon = new Image("file:///"+ b.getRutaIcono());
            
            iconoPrograma.setImage(icon);
            setGraphic(buttonCardBox);

        }
    }
    
    
}
