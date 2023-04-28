package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class covertController {

    @FXML
    private ChoiceBox<String> formatChoiceBox;

    private HelloController helloController;

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    @FXML
    protected void covertImageButtonClick() {
        if (helloController.selectedImagesIdx.isEmpty()) {
            // no image selected, handle the error
            System.out.println("No image selected");
            return;
        }

        // get the selected format from the choice box
        String selectedFormat = formatChoiceBox.getSelectionModel().getSelectedItem().toLowerCase();

        // convert the selected image to the selected format
        for (int index : helloController.selectedImagesIdx) {
            Image selectedImage = helloController.images.get(index).getKey();
            try {
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(selectedImage, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, selectedFormat, byteArrayOutputStream);
                Image convertedImage = new Image(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                helloController.updateImageToScrollPane(convertedImage, index, selectedFormat);
            } catch (IOException e) {
                // handle the error
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) formatChoiceBox.getScene().getWindow();
        stage.close();
    }
}
