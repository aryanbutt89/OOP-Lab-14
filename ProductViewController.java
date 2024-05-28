package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductViewController {
    @FXML private TableView<Product> productTableView;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Double> priceColumn;
    @FXML private TableColumn<Product, String> descriptionColumn;

    private ProductApp productApp;

    public void setProductApp(ProductApp productApp) {
        this.productApp = productApp;
        productTableView.setItems(productApp.getProductList());
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @FXML
    private void handleDeleteProduct() {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            productApp.deleteProductFromDatabase(selectedProduct);
            productTableView.getItems().remove(selectedProduct);
        }
    }

    @FXML
    private void handleRefreshProducts() {
        productApp.loadProductsFromDatabase();
        productTableView.setItems(productApp.getProductList());
    }

}
