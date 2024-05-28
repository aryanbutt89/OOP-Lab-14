package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainViewController {
    @FXML private TextField nameInput;
    @FXML private TextField priceInput;
    @FXML private TextField descriptionInput;

    private ProductApp productApp;

    public void setProductApp(ProductApp productApp) {
        this.productApp = productApp;
    }

    @FXML
    private void handleAddProduct() {
        String name = nameInput.getText();
        double price = Double.parseDouble(priceInput.getText());
        String description = descriptionInput.getText();

        Product product = new Product(0, name, price, description);
        productApp.saveProductToDatabase(product);

        nameInput.clear();
        priceInput.clear();
        descriptionInput.clear();
    }

    @FXML
    private void handleDisplayProducts() {
        productApp.displayProducts();
    }

    @FXML
    private void handleDeleteAllProducts() {
        productApp.deleteAllProductsFromDatabase();
    }
}
