package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Optional;
public class Main extends Application {
    // Lista para guardar datos
    ArrayList<String> personas = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {

        Button btnCrear = new Button("Crear");
        Button btnLeer = new Button("Leer");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");

        btnCrear.setOnAction(e -> crear());
        btnLeer.setOnAction(e -> leer());
        btnActualizar.setOnAction(e -> actualizar());
        btnEliminar.setOnAction(e -> eliminar());

        VBox root = new VBox(10,
                btnCrear,
                btnLeer,
                btnActualizar,
                btnEliminar);

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("CRUD JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // CREATE
    private void crear() {
        TextInputDialog dialogo = new TextInputDialog();

        dialogo.setTitle("Crear");
        dialogo.setHeaderText("Añadir nombre");

        Optional<String> resultado = dialogo.showAndWait();

        resultado.ifPresent(nombre -> {
            personas.add(nombre);
            System.out.println("Añadido: " + nombre);
        });
    }
    // READ
    private void leer() {
        System.out.println("Lista:");

        for(String persona : personas){
            System.out.println(persona);
        }
    }
    // UPDATE
    private void actualizar() {
        if(personas.isEmpty()){
            System.out.println("No hay datos");
            return;
        }
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setHeaderText("Posición a modificar (0,1,2...)");
        Optional<String> pos = dialogo.showAndWait();
        if(pos.isPresent()){
            int indice = Integer.parseInt(pos.get());
            TextInputDialog nuevo = new TextInputDialog();
            nuevo.setHeaderText("Nuevo nombre");
            Optional<String> nombreNuevo = nuevo.showAndWait();
            nombreNuevo.ifPresent(nombre -> {
                personas.set(indice,nombre);
                System.out.println("Actualizado");
            });
        }
    }

    // DELETE
    private void eliminar() {
        if(personas.isEmpty()){
            System.out.println("No hay datos");
            return;
        }
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setHeaderText("Posición a eliminar");
        Optional<String> pos = dialogo.showAndWait();
        if(pos.isPresent()){
            int indice = Integer.parseInt(pos.get());
            personas.remove(indice);
            System.out.println("Eliminado");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}