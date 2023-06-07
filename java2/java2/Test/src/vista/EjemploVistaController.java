package vista;
import Clases.Arraylist;
import Clases.Contacto;
import Clases.Gestion;
import Clases.Nodo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EjemploVistaController implements Initializable {
    @FXML
    private TableColumn<Contacto, String> email1;
    @FXML
    private TableColumn<Contacto, String> direccion1;
    @FXML
    private TableColumn<Contacto, String> favorito1;
    @FXML
    private TableColumn<Contacto, String> nombre1;
    @FXML
    private TableColumn<Contacto, String> tipo1;
    @FXML
    private TableView<Contacto> table;
    @FXML
    private TableColumn<Contacto, String> telefono1;
    @FXML
    private TextField nombret;
    @FXML
    private TextField telefonot;
    @FXML
    private TextField correot;
    @FXML
    private TextField direcciont;
    @FXML
    private CheckBox cFavorito;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    private String[] tipo2 ={"Familiar","Conocido","Amigo"};

    @FXML
    private TextField txtBusqueda;
    @FXML
    private void btnBuscar(ActionEvent event){
        Arraylist busqueda = agenda.Buscar(txtBusqueda.getText());
        table.getItems().clear();
        for(int i=0; i<busqueda.getSize(); i++){
            table.getItems().add(busqueda.getArreglo()[i]);
        }

    }
    Gestion agenda = new Gestion();

    @FXML
    private void btnInsert(ActionEvent event){

        if (!nombret.getText().isEmpty() || !telefonot.getText().isEmpty() || !correot.getText().isEmpty() || !direcciont.getText().isEmpty()){
            String favorito = "No";
            if(cFavorito.isSelected()){favorito= " Si";}
            Contacto nuevaPersona = new Contacto(nombret.getText(), telefonot.getText(), correot.getText(),direcciont.getText(),myChoiceBox.getValue(),favorito);

            agenda.agregarContacto(nuevaPersona);
            nombret.clear();
            telefonot.clear();
            correot.clear();
            direcciont.clear();

        }else{
            System.out.println("Los campos no deberian estar vacios");
        }
    }
    @FXML
    private void btnActualizar(ActionEvent event){
        Nodo tmp = agenda.getInterna().getPrimerNodo();
        table.getItems().clear();
        while (tmp.getSiguienteNodo() != null){
            tmp = tmp.getSiguienteNodo();
            for(int i=0; i<tmp.getDato().getSize(); i++){
                table.getItems().add(tmp.getDato().get(i));
            }
        }
    }
    @FXML
    private void btnEliminar(ActionEvent event){
        agenda.removerContacto(table.getSelectionModel().getSelectedItem());
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());


    }
    ObservableList<Contacto> initialData(){
        Contacto Samuel = new Contacto("Samuel Reyes","98971232","sreyesz@unah.hn","TGU","Conocido","Si");
        Contacto Erick = new Contacto("Erick Escoto","88971232","edescoto@unah.hn","TGU","Familiar","No");
        Contacto Julio = new Contacto("Julio Diaz","78971232","cesararteaga@unah.hn","TGU","Amigo","Si");
        agenda.agregarContacto(Samuel);
        agenda.agregarContacto(Erick);
        agenda.agregarContacto(Julio);
        return FXCollections.observableArrayList(Samuel,Erick,Julio);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombre1.setCellValueFactory(new PropertyValueFactory<Contacto, String>("nombre1"));
        telefono1.setCellValueFactory(new PropertyValueFactory<Contacto,String>("telefono1"));
        email1.setCellValueFactory(new PropertyValueFactory<Contacto,String>("email1"));
        direccion1.setCellValueFactory(new PropertyValueFactory<Contacto,String>("direccion1"));
        tipo1.setCellValueFactory(new PropertyValueFactory<Contacto,String>("tipo1"));
        favorito1.setCellValueFactory(new PropertyValueFactory<Contacto, String>("favorito1"));
        table.setItems(initialData());

        myChoiceBox.getItems().addAll(tipo2);
    }
}