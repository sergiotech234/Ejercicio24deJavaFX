package org.example;

// Importación de clases JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

// Importación para listas y resultados opcionales
import java.util.ArrayList;
import java.util.Optional;

// Clase principal que hereda de Application
public class Main extends Application {

    // Lista donde se almacenarán los nombres
    ArrayList<String> personas = new ArrayList<>();

    // Método que inicia la interfaz gráfica
    @Override
    public void start(Stage primaryStage) {

        // Crear botones CRUD
        Button btnCrear = new Button("Crear");
        Button btnLeer = new Button("Leer");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");

        // Asociar cada botón con su método
        btnCrear.setOnAction(e -> crear());
        btnLeer.setOnAction(e -> leer());
        btnActualizar.setOnAction(e -> actualizar());
        btnEliminar.setOnAction(e -> eliminar());

        // VBox organiza componentes verticalmente
        VBox root = new VBox(
                10,
                btnCrear,
                btnLeer,
                btnActualizar,
                btnEliminar
        );

        // Centrar elementos
        root.setAlignment(Pos.CENTER);

        // Crear escena
        Scene scene =
                new Scene(root, 300, 250);

        // Configurar ventana
        primaryStage.setTitle("CRUD JavaFX");
        primaryStage.setScene(scene);

        // Mostrar ventana
        primaryStage.show();
    }

    // CREATE
    // Añade un nuevo nombre a la lista
    private void crear() {

        // Crear ventana de entrada
        TextInputDialog dialogo =
                new TextInputDialog();

        dialogo.setTitle("Crear");
        dialogo.setHeaderText("Añadir nombre");

        // Obtener resultado
        Optional<String> resultado =
                dialogo.showAndWait();

        // Si el usuario pulsa aceptar
        resultado.ifPresent(nombre -> {

            // Guardar nombre
            personas.add(nombre);

            // Mostrar mensaje en consola
            System.out.println(
                    "Añadido: " + nombre
            );
        });
    }

    // READ
    // Muestra todos los datos
    private void leer() {

        System.out.println("Lista:");

        // Recorrer lista
        for(String persona : personas){

            // Mostrar cada nombre
            System.out.println(persona);
        }
    }

    // UPDATE
    // Modifica un elemento
    private void actualizar() {

        // Comprobar si la lista está vacía
        if(personas.isEmpty()){

            System.out.println("No hay datos");
            return;
        }

        // Solicitar posición
        TextInputDialog dialogo =
                new TextInputDialog();

        dialogo.setHeaderText(
                "Posición a modificar (0,1,2...)"
        );

        Optional<String> pos =
                dialogo.showAndWait();

        if(pos.isPresent()){

            // Convertir String a entero
            int indice =
                    Integer.parseInt(pos.get());

            // Pedir nuevo nombre
            TextInputDialog nuevo =
                    new TextInputDialog();

            nuevo.setHeaderText(
                    "Nuevo nombre"
            );

            Optional<String> nombreNuevo =
                    nuevo.showAndWait();

            nombreNuevo.ifPresent(nombre -> {

                // Reemplazar dato
                personas.set(
                        indice,
                        nombre
                );

                System.out.println(
                        "Actualizado"
                );
            });
        }
    }

    // DELETE
    // Elimina un elemento
    private void eliminar() {

        // Comprobar lista vacía
        if(personas.isEmpty()){

            System.out.println("No hay datos");

            return;
        }

        // Solicitar posición
        TextInputDialog dialogo =
                new TextInputDialog();

        dialogo.setHeaderText(
                "Posición a eliminar"
        );

        Optional<String> pos =
                dialogo.showAndWait();

        if(pos.isPresent()){

            // Convertir texto a número
            int indice =
                    Integer.parseInt(
                            pos.get()
                    );

            // Eliminar elemento
            personas.remove(indice);

            System.out.println(
                    "Eliminado"
            );
        }
    }

    // Método principal
    public static void main(String[] args) {
        launch(args);
    }
}
