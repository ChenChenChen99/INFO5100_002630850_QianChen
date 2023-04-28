package com.example.project;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class HelloController {
    @FXML
    private VBox imageBox;

    @FXML
    private ScrollPane imageScrollPane;

    @FXML
    private Label statusLabel;

    public ArrayList<Pair<Image,String>> images;

    public HashSet<Integer> selectedImagesIdx;

    public void initialize() {
        System.out.println("HelloController initialized!");
        imageBox = new VBox(); // Initialize the VBox object
        images = new ArrayList<>();
        selectedImagesIdx = new HashSet<Integer>();
    }

    @FXML
    protected void uploadImageButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("upload.fxml"));
        Parent root = loader.load();

        // pass the helloController object to the uploadController
        uploadController uploadController = loader.getController();
        uploadController.setHelloController(this);

        Stage upload = new Stage();
        upload.setTitle("Image Upload");
        Scene scene = new Scene(root, 520, 380);
        upload.setScene(scene);

        upload.show();
    }

    public void addImageToScrollPane(Image image) {
        String format = image.getUrl().substring(image.getUrl().lastIndexOf(".") + 1).toLowerCase();
        images.add(new Pair<>(image, format));

        HBox hbox = new HBox();
        hbox.setSpacing(20);

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setUserData(images.indexOf(new Pair<>(image, format)));

        RadioButton radioButton = new RadioButton();
        radioButton.setOnAction(event -> selectImageButtonClick(event));

        Label imageSize = new Label(image.getWidth() + "x" + image.getHeight());
        String url = image.getUrl();
        Label imageFormat = new Label(url.substring(url.lastIndexOf(".") + 1).toLowerCase());

        hbox.getChildren().addAll(radioButton, imageView, imageSize, imageFormat);
        hbox.setAlignment(Pos.CENTER);

        imageBox.getChildren().add(hbox);
        imageScrollPane.setContent(imageBox);
    }

    @FXML
    public void selectImageButtonClick(ActionEvent event) {
        RadioButton radioButton = (RadioButton) event.getSource();
        HBox hbox = (HBox) radioButton.getParent();
        ImageView imageView = (ImageView) hbox.getChildren().get(1);
        int index = (int) imageView.getUserData();
        System.out.println("Image index: " + index);

        if (selectedImagesIdx.contains(index)) {
            selectedImagesIdx.remove(index);
            System.out.println("Image removed from selectedImages");
        } else {
            selectedImagesIdx.add(index);
            System.out.println("Image added to selectedImages");
        }
        setStatus("Selected images: " + selectedImagesIdx.size());
    }

    @FXML
    protected void convertImageButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("covert.fxml"));
        Parent root = loader.load();

        covertController covertController = loader.getController();
        covertController.setHelloController(this);

        Stage upload = new Stage();
        upload.setTitle("Covert Image");
        Scene scene = new Scene(root, 360, 240);
        upload.setScene(scene);

        upload.show();
    }

    public void updateImageToScrollPane(Image image, int index, String format) {
        images.set(index, new Pair<>(image, format));

        HBox hbox = (HBox) imageBox.getChildren().get(index);

        ImageView imageView = (ImageView) hbox.getChildren().get(1);
        imageView.setImage(image);
        imageView.setUserData(index);

        Label imageSize = (Label) hbox.getChildren().get(2);
        imageSize.setText(image.getWidth() + "x" + image.getHeight());

        Label imageFormat = (Label) hbox.getChildren().get(3);
        imageFormat.setText(format);
    }

    @FXML
    protected void downloadImageButtonClick() throws IOException {
        if (selectedImagesIdx.size() == 0) {
            setStatus("No image selected!");
            return;
        }

        if (selectedImagesIdx.size() > 1) {
            setStatus("Only one image can be downloaded at a time!");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            for (int index : selectedImagesIdx) {
                Image image = images.get(index).getKey();
                String format = images.get(index).getValue();
                File fileWithFormat = new File(file.getAbsolutePath() + "." + format);
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
                ImageIO.write(bufferedImage, format, fileWithFormat);
            }
        }
    }


    private void setStatus(String status) {
        statusLabel.setText(status);
    }
}

