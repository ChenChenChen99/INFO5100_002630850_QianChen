package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class uploadController {
    @FXML
    private ImageView imageView;

    @FXML
    private Label imageInfoLabel;

    private File selectedFile;

    private Image image;

    private HelloController helloController;

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    @FXML
    protected void chooseImageButtonClick() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");

        // Set the extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.jpg, *.jpeg, *.png)", "*.jpg", "*.jpeg", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show the open file dialog
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Load the image from the selected file
            image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imageInfoLabel.setText("Image Information:\n" + selectedFile.getAbsolutePath() + "\n" + image.getWidth() + "x" + image.getHeight());
        }
    }

        @FXML
        protected void uploadImageButtonClick () throws IOException {
            if (selectedFile != null) {
                // Set default save path and file name
                String savePath = "Images/";
                String fileName = selectedFile.getName();

                // Create save directory if it doesn't exist
                File saveDir = new File(savePath);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }

                // Copy the selected file to the save directory
                File saveFile = new File(savePath + fileName);
                try {
                    Files.copy(selectedFile.toPath(), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle exception
                }

                // Add the ImageView to the VBox in the ScrollPane in HelloController
                if (helloController != null) {
                    helloController.addImageToScrollPane(image);
                }

                // Close the scene
                Stage stage = (Stage) imageInfoLabel.getScene().getWindow();
                stage.close();
            }
        }
    }