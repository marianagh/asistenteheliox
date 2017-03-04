/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import org.proyectoHeliox.helper.entidades.*;
import org.proyectoHeliox.helper.negocio.NegocioHeliox;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Controlador de la vista Settings.
 *
 * @author Mariana G<arcía
 */
public class FXMLSettingsController implements Initializable {
    
    
    IOUtil io= new IOUtil();    
    Properties configuracion = io.cargarPropiedades();
    NegocioHeliox nh = new NegocioHeliox();
    JFXDialogLayout layout = new JFXDialogLayout();
    JFXDialog dialog;
    private static FXMLSettingsController instance = null;
    @FXML
    private ImageView toolBarIcon;
    
    @FXML
    private JFXListView<Lenguaje> listaLenguajes;

    @FXML
    private JFXListView<Boton> listaBotones;
    
    private ObservableList<Boton> botonObservableList;
    private ObservableList<Lenguaje> lenguajeObservableList;
    
    @FXML
    private JFXButton btnAgregarBoton;

    @FXML
    private JFXButton agregarLenguaje;

    @FXML
    private JFXButton eliminarLenguaje;

    @FXML
    private StackPane stackPane;
    
    @FXML
    private JFXButton editarLenguaje;
    
    @FXML
    private JFXButton btnEditarBoton;

    @FXML
    private JFXButton btnEliminarBoton;
   
    void setStyle( JFXButton b) {
        b.setStyle("-fx-text-color: #212121");
        b.setStyle("-fx-background-color: white");
        b.setOnMouseEntered(e->{
            b.setStyle("-fx-background-color: #BDBDBD");
        });        
        b.setOnMouseExited(e->{
            b.setStyle("-fx-background-color: white");
        });        
    }
    
     @FXML
    void onActionEditarBoton(ActionEvent event) {
        layout.getActions().clear();
        layout.getBody().clear();
        
        layout.setHeading(new Label("EDITAR"));
        EditarBotonDialogController editarBotonDialog = new EditarBotonDialogController(configuracion, listaBotones.getSelectionModel().getSelectedItem());
        layout.getBody().setAll(editarBotonDialog);
        JFXButton btnOk = new JFXButton("GUARDAR");
        JFXButton btnCancel = new JFXButton("DESCARTAR");
        setStyle(btnCancel);
        setStyle(btnOk);
        layout.getActions().addAll(btnCancel, btnOk);
        
        dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
           btnOk.setOnAction(e->{
               editarBotonDialog.getB().setDescripcion(editarBotonDialog.getDescripcion().getText());
            try {
                nh.editarBoton(editarBotonDialog.getB());
                llenarListaBotones(listaLenguajes.getSelectionModel().getSelectedItem());
            } catch (SQLException | IOException ex) {
                Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            dialog.close();
            
        });
        btnCancel.setOnAction(e->{
        dialog.close();
        });
        dialog.show();
      
    }
    
      @FXML
    void onActionEliminarBoton(ActionEvent event) {
            
         layout.getActions().clear();
                layout.setHeading(new Label("¿ELIMINAR?"));
                JFXButton btnOk = new JFXButton("ELIMINAR");
                JFXButton btnCancel = new JFXButton("CONSERVAR");
                layout.getBody().clear();
                layout.getActions().addAll(btnCancel, btnOk);
                dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
                btnCancel.setOnMouseClicked(ev -> {
                    dialog.close();
                });
                btnOk.setOnMouseClicked(ev -> {
                    
                try {

                    nh.eliminarBoton(listaBotones.getSelectionModel().getSelectedItem());
                    llenarListaBotones(listaLenguajes.getSelectionModel().getSelectedItem());
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.close();
                });
                dialog.show();

    }
    
    @FXML
    void onActionEliminarLenguaje(ActionEvent event) throws SQLException, IOException {
        layout.getActions().clear();
        layout.getBody().clear();
        layout.getHeading().clear();
       
        if (!listaLenguajes.getSelectionModel().isEmpty()) {
            layout.getActions().clear();
            layout.setHeading(new Label("ELIMINAR "+ configuracion.getProperty("lenguaje").toUpperCase()+" " +  listaLenguajes.getSelectionModel().getSelectedItem().getNombre().toUpperCase()));
            JFXButton btnOk = new JFXButton("ELIMINAR");
            JFXButton btnCancel = new JFXButton("CONSERVAR");
            setStyle(btnCancel);
            setStyle(btnOk);
            layout.getActions().addAll(btnCancel, btnOk);
             JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
            btnCancel.setOnMouseClicked(e -> {
                dialog.close();
            });
            btnOk.setOnMouseClicked((MouseEvent e) -> {
                try {
                    nh.eliminarLenguaje(listaLenguajes.getSelectionModel().getSelectedItem());
                    listaLenguajes.getItems().clear();
                    llenarLista();
                    listaLenguajes.refresh();
                    
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.close();
            });
            dialog.show();

        } else {
            layout.setHeading(new Label("NO HAS SELECCIONADO NINGUN "+configuracion.getProperty("lenguaje").toUpperCase()));
            JFXButton btnOk = new JFXButton("ENTENDIDO");
            setStyle(btnOk);
            layout.getActions().clear();
            layout.setActions(btnOk);
            JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
            btnOk.setOnMouseClicked(e -> {
                dialog.close();
            });
            dialog.show();
        }

    }
    
    @FXML
    void onActionEditarLenguaje(ActionEvent event) {
        layout.getActions().clear();
        layout.getBody().clear();
        layout.getHeading().clear();
        if (listaLenguajes.getSelectionModel().isEmpty()){
            layout.setHeading(new Label("DEBE SELECCIONAR UN ELEMENTO PARA EDITAR"));
        }
        else {
            Lenguaje l = listaLenguajes.getSelectionModel().getSelectedItem();
            layout.setHeading(new Label("INFORMACIÓN DE "+configuracion.getProperty("lenguaje").toUpperCase()));
            AgregarLenguajeDialogController editarLenguajeBox = new AgregarLenguajeDialogController();
            editarLenguajeBox.getNombre().setText(listaLenguajes.getSelectionModel().getSelectedItem().getNombre());
            JFXButton btnOk = new JFXButton("GUARDAR");
            JFXButton btnCancel = new JFXButton("DESCARTAR");
            setStyle(btnOk);
            setStyle(btnCancel);
            layout.setActions(btnCancel, btnOk);
            layout.setBody(editarLenguajeBox);
            dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
            btnOk.setOnMouseClicked(e -> {

                l.setNombre(editarLenguajeBox.getNombre().getText());
              //  l.setIcono(null);
                try {
                    nh.editarLenguaje(l);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                listaLenguajes.getItems().clear();
                lenguajeObservableList.clear();
                try {
                    llenarLista();
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.close();
            });
            btnCancel.setOnMouseClicked(e -> {
                dialog.close();
            });
            dialog.show();
        }

    }

    @FXML
    void onActionAgregarLenguaje(ActionEvent event) throws SQLException {
        layout.getActions().clear();
        layout.getBody().clear();
        layout.getHeading().clear();
        layout.setHeading(new Label("AGREGAR NUEVO"));
        AgregarLenguajeDialogController agregarLenguajeDialog = new  AgregarLenguajeDialogController();
        layout.getBody().setAll(agregarLenguajeDialog);
        dialog = new JFXDialog(stackPane, layout,JFXDialog.DialogTransition.CENTER );
        JFXButton ok = new JFXButton("GUARDAR");
        JFXButton cancel = new JFXButton("DESCARTAR");
        layout.setActions(ok, cancel);
        Lenguaje l = new Lenguaje();
        ok.setOnAction(e->{
            l.setNombre(agregarLenguajeDialog.getNombre().getText());
            l.setIcono("");
            try {
                nh.agregarLenguaje(l);
                listaLenguajes.getItems().clear();
                llenarLista();
            } catch (SQLException | IOException ex) {
                Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                listaLenguajes.refresh();     
                dialog.close();
        });
        cancel.setOnAction(e->{
        dialog.close();
        });
        dialog.show();
        
    } 
    
    public void llenarLista() throws SQLException, IOException {
        listaLenguajes.getItems().clear();
        if (nh.listadoLenguajes().size()>= 1){
        for (Lenguaje l : nh.listadoLenguajes()) {
            lenguajeObservableList.add(l);
        }
        listaLenguajes.setItems(lenguajeObservableList);
        }
    }
    
    public void llenarListaBotones(Lenguaje l) throws SQLException, IOException {
        listaBotones.getItems().clear();
        if (nh.listadoBotonesLenguaje(l.getId()).size() >= 1) {
            for (Boton b : nh.listadoBotonesLenguaje(l.getId())) {
                botonObservableList.add(b);
            }
            listaBotones.setItems(botonObservableList);
        }
        
        System.out.println("Lista botones rellenada");

    }

    @FXML
    void agregarBoton(ActionEvent event) throws IOException {
        layout.getActions().clear();
        layout.getBody().clear();
        Lenguaje lenguaje = listaLenguajes.getSelectionModel().getSelectedItem();
        layout.setHeading(new Label("AGREGAR NUEVO"));
        FXMLAgregarBotonController agregarBoton = new FXMLAgregarBotonController(configuracion);
        layout.getBody().setAll(agregarBoton);
        JFXButton btnOk = new JFXButton("GUARDAR");
        JFXButton btnCancel = new JFXButton("DESCARTAR");
        setStyle(btnCancel);
        setStyle(btnOk);
        layout.getActions().addAll(btnCancel, btnOk);
        dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
           btnOk.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                if(agregarBoton.getFileIcono() == null ||  agregarBoton.getFileAudio() == null || agregarBoton.getFileEjecutable() == null || agregarBoton.getDescripcion().getText().equals("")){
                    dialog.close();
                    JFXDialogLayout layoutAlerts = new JFXDialogLayout();
                    layoutAlerts.setHeading(new Label("NO HA LLENADO TODOS LOS CAMPOS NECESARIOS"));
                    JFXButton btnOkAlert = new JFXButton("ENTENDIDO");
                    layout.setActions(btnOkAlert);
                    JFXDialog dialogAlerts = new JFXDialog(stackPane, layoutAlerts, JFXDialog.DialogTransition.CENTER);
                    btnOkAlert.setOnMouseClicked((MouseEvent event)->{
                        dialogAlerts.close();
                        dialog.show();
                    });
                    dialogAlerts.show();
                }
                if ( agregarBoton.getFileIcono().getName().endsWith(".ico") || agregarBoton.getFileAudio().getName().endsWith(".mp3") ){
                    
                    layout.getBody().clear();
                    layout.setHeading(new Label("HA SELECCIONADO ARCHIVOS NO ADMITIDOS."));
                    
                    
                } else {
                    Boton b = new Boton();
                    b.setRutaIcono(agregarBoton.getFileIcono().toString());
                    b.setRutaAudio(agregarBoton.getFileAudio().toString());
                    b.setDescripcion(agregarBoton.getDescripcion().getText());
                    b.setRutaEjecutable(agregarBoton.getEjecutable().getText());
                    try {
                        nh.agregarBoton(b, lenguaje.getId());
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                dialog.close();
                try {
                    
                    llenarListaBotones(lenguaje);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnCancel.setOnAction(e->{
        dialog.close();
        });
        dialog.show();
    }
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaLenguajes.setExpanded(Boolean.TRUE);
        listaLenguajes.setDepthProperty(1);
        setStyle(btnAgregarBoton);
        setStyle(agregarLenguaje);
        setStyle(editarLenguaje);
        setStyle(eliminarLenguaje);  
        btnEliminarBoton.setVisible(false);
        btnEditarBoton.setVisible(false);
        Tooltip tooltipAgregarBoton = new Tooltip("Agregar.");
        tooltipAgregarBoton.setStyle("-fx-font-size: 14");
        Tooltip.install(btnAgregarBoton, tooltipAgregarBoton);
        listaBotones.setCellFactory(botonListView -> new BotonListViewCellController(listaBotones, layout, stackPane, dialog, configuracion, listaLenguajes.getSelectionModel().getSelectedItem()));
        listaLenguajes.setCellFactory(lenguajeListView -> new LenguajeListViewCellController());
        instance = this;
        botonObservableList = FXCollections.observableArrayList();
        lenguajeObservableList = FXCollections.observableArrayList();
        Tooltip tooltipEliminar = new Tooltip("Eliminar.");
        tooltipEliminar.setStyle("-fx-font-size: 14");
        Image iconoEliminar = new Image(getClass().getResourceAsStream("/icons/delete.png"));
        ImageView iconView = new ImageView(iconoEliminar);
        iconView.setFitWidth(15);
        iconView.setFitHeight(15);
        eliminarLenguaje.setGraphic(iconView);
        eliminarLenguaje.setText(null);
        Tooltip.install(eliminarLenguaje, tooltipEliminar);
        Image iconoEditar = new Image(getClass().getResourceAsStream("/icons/edit.png"));
        ImageView iconViewEditar = new ImageView(iconoEditar);
        iconViewEditar.setFitWidth(15);
        iconViewEditar.setFitHeight(15);
        editarLenguaje.setGraphic(iconViewEditar);
        editarLenguaje.setText(null);
        Tooltip tooltipEditar = new Tooltip("Editar");
        tooltipEditar.setStyle("-fx-font-size: 14");
        Tooltip.install(editarLenguaje, tooltipEditar);
        Image iconoAgregar = new Image(getClass().getResourceAsStream("/icons/add_black.png"));
        ImageView iconViewAgregar = new ImageView(iconoAgregar);
        iconViewAgregar.setFitWidth(15);
        iconViewAgregar.setFitHeight(15);
        Tooltip tooltipAgregar = new Tooltip("Agregar");
        tooltipAgregar.setStyle("-fx-font-size: 14");
        Tooltip.install(agregarLenguaje, tooltipAgregar);
        agregarLenguaje.setGraphic(iconViewAgregar);
        agregarLenguaje.setText(null);

        try {
            try {
                // TODO
                llenarLista();
            } catch (IOException ex) {
                Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAgregarBoton.setVisible(false);
        listaLenguajes.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Lenguaje> observable, Lenguaje oldValue, Lenguaje newValue) -> {
            System.out.println("Selected item: " + newValue);
            btnAgregarBoton.setVisible(true);
            btnEditarBoton.setVisible(true);
            btnEliminarBoton.setVisible(true);
            listaBotones.getItems().clear();
            try {
                llenarListaBotones(newValue);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ContextMenu menuConfig = new ContextMenu();
        MenuItem config = new MenuItem("Personalizar");
        MenuItem about = new MenuItem("Acerca de");
        MenuItem salir = new MenuItem("Salir");
        about.setStyle("-fx-font-size: 14");
        config.setStyle("-fx-font-size: 14");
        salir.setStyle("-fx-font-size: 14");
        menuConfig.getItems().addAll(config, about, salir);
        about.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Acerca.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Acerca de");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                Image applicationIcon = new Image("file:/src/icon.png");
                stage.getIcons().add(applicationIcon);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        config.setOnAction(e -> {
            //abrirdialogo con panel de cofig.fxml
            layout.getActions().clear();
            layout.getBody().clear();
            layout.getHeading().clear();
            layout.setHeading(new Label("PERSONALIZAR ELEMENTOS"));
            ConfigController configCtrl = new ConfigController(configuracion);
            layout.setBody(configCtrl);
            JFXDialog dialogEditarPropiedades = new JFXDialog();
            dialogEditarPropiedades.setContent(layout);
            JFXButton btnOk = new JFXButton("GUARDAR");
            JFXButton btnCancel = new JFXButton("DESCARTAR");
            setStyle(btnOk);
            setStyle(btnCancel);
            layout.setActions(btnCancel, btnOk);
            btnOk.setOnMouseClicked(ev -> {
                Properties properties = new Properties();
                properties.setProperty("lenguaje", configCtrl.getLenguaje().getText());
                properties.setProperty("audio", configCtrl.getAudio().getText());
                properties.setProperty("aplicacion", configCtrl.getEjecutable().getText());
                properties.setProperty("icono", configCtrl.getIcono().getText());
                properties.setProperty("boton",configCtrl.getBoton().getText());
              
                try {
                    io.guardarPropiedades(properties);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                configuracion = io.cargarPropiedades();
                dialogEditarPropiedades.close();
            });
            btnCancel.setOnMouseClicked(ev->{
                dialogEditarPropiedades.close();
            });
            dialogEditarPropiedades.setTransitionType(JFXDialog.DialogTransition.CENTER);
            dialogEditarPropiedades.show(stackPane);
            
            
        });
        salir.setOnAction(e->{
        Platform.exit();
        });
        Tooltip tooltipConfig = new Tooltip("Configuracón.");
        Tooltip.install(toolBarIcon, tooltipConfig);
        toolBarIcon.setOnMousePressed(e->{
            menuConfig.show(toolBarIcon, e.getScreenX(), e.getScreenY());
        });
        
//        stackPane.getScene().getWindow().setOnCloseRequest(event->{
//             Stage settingsStage = (Stage) stackPane.getScene().getWindow();
//             HelioxAsistente heliox = new HelioxAsistente();
//             
//             Stage stage = new Stage();
//            try {
//                heliox.start(stage);
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    settingsStage.close();
//            
//        });
    }

    public static FXMLSettingsController getInstance() {
        return instance;
    }
    
}
