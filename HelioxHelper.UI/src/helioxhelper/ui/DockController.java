/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.awt.AWTException;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyectoHeliox.helper.entidades.*;
import org.proyectoHeliox.helper.negocio.NegocioHeliox;

/**
 * Controlador de la vista del dock.
 *
 * @author Mariana García
 */
public class DockController implements Initializable {
     private ObservableList<Boton> botonObservableList;
     private ObservableList<Lenguaje> lenguajeObservableList;
     Audio player = new Audio();

    ScrollPane sp = new ScrollPane();

     @FXML
    private JFXButton settingsButton;
     
      @FXML
    void showContextMenu(ContextMenuEvent event) {

    }
    
    @FXML
    private ImageView settingsIcon;

    IOUtil ioUtil;

    private final NegocioHeliox nh = new NegocioHeliox();

    @FXML
    private JFXComboBox<Lenguaje> combobox;

    @FXML
    private JFXListView<Boton> listViewBotones;

    public ObservableList<Boton> getBotonObservableList() {
        return botonObservableList;
    }

    public void setBotonObservableList(ObservableList<Boton> botonObservableList) {
        this.botonObservableList = botonObservableList;
    }

    public ObservableList<Lenguaje> getLenguajeObservableList() {
        return lenguajeObservableList;
    }

    public void setLenguajeObservableList(ObservableList<Lenguaje> lenguajeObservableList) {
        this.lenguajeObservableList = lenguajeObservableList;
    }

    public JFXListView<Boton> getListViewBotones() {
        return listViewBotones;
    }

    public void setListViewBotones(JFXListView<Boton> listViewBotones) {
        this.listViewBotones = listViewBotones;
    }
    
    public DockController getController(){
        return this;
    }

    public void obtenerLenguajes() throws SQLException, IOException {
        for (Lenguaje l : nh.listadoLenguajes()) {
            
            lenguajeObservableList.add(l);
            
        }
        combobox.setItems(lenguajeObservableList);
        
    }

    public void addIconToTray() throws AWTException {
        if (SystemTray.isSupported()) {
            SystemTray sysTray = SystemTray.getSystemTray();
            PopupMenu trayPopupMenu = new PopupMenu();
            java.awt.MenuItem action = new java.awt.MenuItem("Acerca de");
            java.awt.MenuItem config = new java.awt.MenuItem("Configuración");
            java.awt.MenuItem salir = new java.awt.MenuItem("Salir");
            config.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Configuración - Heliox Asistente");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.setScene(new Scene(root));
                    Image applicationIcon = new Image("file:icon.png");
                    stage.getIcons().add(applicationIcon);
                    stage.show();
                } catch (Exception ex) {
                   ex.printStackTrace();
                }
            });
            action.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Acerca.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Acerca de - Heliox Asistente");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.setScene(new Scene(root));
                    Image applicationIcon = new Image("file:/src/icon.png");
                    stage.getIcons().add(applicationIcon);
                    stage.show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
             
            trayPopupMenu.add(action);
            trayPopupMenu.add(config);
            java.awt.Image image = Toolkit.getDefaultToolkit().getImage("file:/src/icon.png");
            trayPopupMenu.addSeparator();
            trayPopupMenu.add(salir);
            salir.addActionListener((java.awt.event.ActionEvent e) -> {
                Platform.exit();
            });
            TrayIcon trayIcon = new TrayIcon(image, "Heliox Asistente", trayPopupMenu);
            trayIcon.setImageAutoSize(true);
            sysTray.add(trayIcon);
        }
    }

    public void llenarPanelBotones(Lenguaje l) throws SQLException, IOException {
         listViewBotones.getItems().clear();
        if (nh.listadoBotonesLenguaje(l.getId()).size()>=1 ){
        
         for (Boton b : nh.listadoBotonesLenguaje(l.getId())) {
            botonObservableList.add(b);
        }
        listViewBotones.setItems(botonObservableList);
        }
        
    }

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewBotones.setCellFactory(botonListView -> new BotonDockController());
        botonObservableList =FXCollections.observableArrayList();
        lenguajeObservableList = FXCollections.observableArrayList();
        try {
            nh.crearTablas();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        try {
//            addIconToTray();
//        } catch (AWTException ex) {
//            Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
            settingsIcon.setImage(icon);
            Tooltip tipCombobox = new Tooltip("Cambiar lista actual.");
            Tooltip.install(combobox, tipCombobox);
            tipCombobox.setStyle("-fx-font-size: 14");
            Tooltip tipConfig = new Tooltip("Administrar listas y configuración.");
            Tooltip.install(settingsIcon, tipConfig);
            tipConfig.setStyle("-fx-font-size: 14");
            try {
                
                try {
                    obtenerLenguajes();
                } catch (IOException ex) {
                    Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
            }
            combobox.setCellFactory(lenguajeListView -> new LenguajeListViewCellController());
            combobox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Lenguaje> observable, Lenguaje oldValue, Lenguaje newValue) -> {
                System.out.println("Nuevo " + newValue);
                System.out.println("Viejo " + oldValue);
                listViewBotones.getItems().clear();
                try {
                    llenarPanelBotones(newValue);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            try {
                if (nh.listadoLenguajes().size()>0){
                    combobox.getSelectionModel().selectFirst();
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(DockController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ContextMenu menu = new ContextMenu();
            MenuItem config = new MenuItem("Configuración");
            MenuItem about  = new MenuItem("Acerca de");
            MenuItem exit = new MenuItem("Salir");
            about.setStyle("-fx-font-size: 14");
            menu.setStyle("-fx-font-size: 14");
            config.setStyle("-fx-font-size:14");
            menu.getItems().addAll(config, about, exit);
            about.setOnAction(e->{
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
                } catch (Exception ex){
                    System.out.print(ex.getMessage());
                }
            });
            
            exit.setOnAction(e->{
                Platform.exit();
            });
            config.setOnAction((ActionEvent e)->{
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Configuración");
                    stage.initModality(Modality.WINDOW_MODAL);
                    FXMLSettingsController settings = fxmlLoader.getController();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    Image applicationIcon = new Image("file:/src/icon.png");
                    stage.getIcons().add(applicationIcon);
                    stage.show();
                } catch (Exception ex){
                    System.out.print(ex.getMessage());
                    System.out.println(ex.getStackTrace());
                }
//                    Stage stage = (Stage) settingsButton.getScene().getWindow();
//                    stage.close();
            });
            
            settingsIcon.setOnMouseClicked(ev->{
                menu.show(settingsIcon, ev.getScreenX(), ev.getScreenY());
            });
           
            
            
    }
        
    }
    
      
     
    

