/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankito.aplicacion;

import com.bankito.Main;
import com.bankito.dominio.exceptions.DominioException;
import com.bankito.presentacion.CuentaDtoModel;
import com.bankito.presentacion.ResourcePath;
import com.bankito.servicio.ServicioBancario;
import com.bankito.servicio.dto.ClienteDto;
import com.bankito.servicio.dto.CuentaDto;
import com.bankito.servicio.dto.UsuarioDto;
import com.bankito.servicio.exceptions.ServicioException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.FloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kike
 */
public class ClienteViewController implements Initializable {

    private Main mainApp;
    private ServicioBancario sb;
    private ObservableList<CuentaDtoModel> listaCuentas;

    @FXML
    private ImageView abacoImg, cerdoImg, usuarioImg;
    @FXML
    private Label bienvenidoLbl, numCuentasLbl, saldoTotalLbl;
    @FXML
    private Button userBtn, cerrarSesionBtn;
    
    @FXML
    private TableView<CuentaDtoModel> cuentaTable;
    @FXML
    private TableColumn<CuentaDtoModel, String> numeroCuentaColumn;
    @FXML
    private TableColumn<CuentaDtoModel, Number> saldoColumn;
    @FXML
    private TableColumn<CuentaDtoModel, Number> numMovimientosColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaCuentas = FXCollections.observableArrayList();
        
        numeroCuentaColumn.setCellValueFactory(cellData -> cellData.getValue().getNumCuentaConFormatoProperty());
        numeroCuentaColumn.setStyle( "-fx-alignment: CENTER;");
        
        saldoColumn.setCellValueFactory(cellData -> cellData.getValue().getSaldoProperty());
        saldoColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");
        
        numMovimientosColumn.setCellValueFactory(cellData -> cellData.getValue().getNumMovimientosProperty());
        numMovimientosColumn.setStyle( "-fx-alignment: CENTER;");

        cuentaTable.setItems(listaCuentas);
    }

    public void initializeAfterSettingMain() {
        sb = mainApp.getServicioBancario();
        cargaSaludoBienvenida();
        cargaBotonesBarraSuperior();
        cargaSituacionGlobal();
        cargaTablaCuentas();
    }

    @FXML
    public void accionLogout(javafx.event.Event event) {
        try {
            boolean result = sb.logoutUsuario();

            if (result == true) {
                mainApp.goToLogin();
            } else {
                System.out.println("Error raro");
            }
        } catch (DominioException ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServicioException ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void accionIngresar(ActionEvent event) { 
        CuentaDtoModel cuenta = cuentaTable.getSelectionModel().getSelectedItem();
        if (cuenta != null) {
            System.out.println(cuenta.toString());
        }
        else 
            alertaCuentaSinSeleccionar();
    }
    
    @FXML
    public void alertaCuentaSinSeleccionar() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("No hay cuenta seleccionada");
        alert.setHeaderText(null);
        alert.setContentText("Para poder realizar la operación debes seleccionar una cuenta primero");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        // Add a custom icon.
        stage.getIcons().add(new Image(Main.class.getResourceAsStream(ResourcePath.BANKITO_ICON)));

        alert.showAndWait();
    }
    
    
    @FXML
    public void accionMuestraAcercaDe(javafx.event.Event event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de Bankito");
        alert.setHeaderText(null);
        alert.setContentText("Bankito es una aplicación con fines didácticos y "
                + "pedagógicos para ayudar en el proceso de enseñanza "
                + "y aprendizaje del lenguaje Java. \n"
                + "\nDesarrollada por Enrique Royo Sánchez en 2019.");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        // Add a custom icon.
        stage.getIcons().add(new Image(Main.class.getResourceAsStream(ResourcePath.BANKITO_ICON)));

        alert.showAndWait();
    }
    
       
    @FXML
    public void accionMuestraDatosCliente(javafx.event.Event event) {
        mainApp.goToDialogoDatosCliente();
    }
    
    public void setMainApp(Main aplicacion) {
        this.mainApp = aplicacion;
    }

    private void cargaSaludoBienvenida() {
        String nombre = "";
        try {
            UsuarioDto user = sb.getUsuarioLogado();
            ClienteDto cli = sb.buscaClientePorIdUsuario(user.getIdUsuario());
            if (cli != ClienteDto.NOT_FOUND) {
                nombre = " " + cli.getNombre();
            }
        } catch (ServicioException ex) {
            Logger.getLogger(ClienteViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bienvenidoLbl.setText("Hola" + nombre + ", bienvenid@ a Bankito");
    }

    private void cargaSituacionGlobal() {
        try {
            UsuarioDto usu = sb.getUsuarioLogado();
            List<CuentaDto> listaCue = sb.buscaCuentaPorUsuario(usu);
            int numCuentas = listaCue.size();
            float saldoTotal = 0.0f;
            for (CuentaDto c : listaCue) {
                saldoTotal = saldoTotal + c.getSaldo();
            }

            numCuentasLbl.setText("Tienes " + numCuentas + " cuentas abiertas en Bankito");
            saldoTotalLbl.setText("Con un saldo total de " + saldoTotal + " €");

        } catch (ServicioException ex) {
            Logger.getLogger(ClienteViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargaTablaCuentas() {
        try {
            UsuarioDto loggedUser = sb.getUsuarioLogado();
            List<CuentaDto> listaDto = sb.buscaCuentaPorUsuario(loggedUser);
            
            for(CuentaDto c : listaDto) {
                listaCuentas.add(new CuentaDtoModel(c));
            }
                        
        } catch (ServicioException ex) {
            Logger.getLogger(ClienteViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargaBotonesBarraSuperior() {
        Image imagen = new Image(Main.class.getResourceAsStream(ResourcePath.USER_BUTTON_ICON));
        userBtn.setGraphic(new ImageView(imagen));
        Tooltip tip = new Tooltip("Accede a tus datos personales");
        userBtn.setTooltip(tip);
        
        imagen = new Image(Main.class.getResourceAsStream(ResourcePath.POWEROFF_BUTTON_ICON));
        cerrarSesionBtn.setGraphic(new ImageView(imagen));
        tip = new Tooltip("Cerrar sesión");
        cerrarSesionBtn.setTooltip(tip);
    }

}