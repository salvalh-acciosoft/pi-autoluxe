package com.example;

import ClasesObjetos.Productos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ProductoCeldaController extends ListCell<Productos> {
    @FXML
    private HBox root;
    @FXML
    private Label lblReferencia;
    @FXML
    private Label lblCantidad;
    @FXML
    private Label lblDescripcion;
    @FXML
    private ComboBox<String> comboAlmacen;
    @FXML
    private Label lblPrecio;
    @FXML
    private Button btnAumentar;
    @FXML
    private Button btnDisminuir;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Productos producto, boolean empty) {
        super.updateItem(producto, empty);

        if (empty || producto == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("producto_celda.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lblReferencia.setText("Ref: " + producto.getReferencia());
            lblCantidad.setText(String.valueOf(producto.getCantidad()));
            lblDescripcion.setText(producto.getDescripcion());
            comboAlmacen.setValue(producto.getAlmacen());
            lblPrecio.setText("Precio: " + producto.getPrecio());

            btnAumentar.setOnAction(event -> {
                producto.setCantidad(producto.getCantidad() + 1);
                lblCantidad.setText(String.valueOf(producto.getCantidad()));
            });

            btnDisminuir.setOnAction(event -> {
                if (producto.getCantidad() > 0) {
                    producto.setCantidad(producto.getCantidad() - 1);
                    lblCantidad.setText(String.valueOf(producto.getCantidad()));
                }
            });

            comboAlmacen.setOnAction(event -> {
                producto.setAlmacen(comboAlmacen.getValue());
            });

            setText(null);
            setGraphic(root);
        }
    }
}
