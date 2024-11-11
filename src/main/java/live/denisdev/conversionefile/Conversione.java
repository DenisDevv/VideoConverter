package live.denisdev.conversionefile;

import io.github.techgnious.IVCompressor;
import io.github.techgnious.dto.IVSize;
import io.github.techgnious.dto.ResizeResolution;
import io.github.techgnious.dto.VideoFormats;
import io.github.techgnious.exception.VideoException;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Conversione {
    IVCompressor compressor = new IVCompressor();
    private File file;

    @FXML
    protected void avviaConversione() {
        if (file == null) {
            System.err.println("No file selected.");
            return;
        }
        try {
            compressor.reduceVideoSizeAndSaveToAPath(file, VideoFormats.MP4, ResizeResolution.R240P, file.getPath().split(".mp4")[0] + "_resized.mp4");
            System.out.println("Video resized successfully.");
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (VideoException e) {
            System.err.println("VideoException occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void aggiungiFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona il video");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.flv", "*.avi"));
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            System.out.println("File selected: " + file.getAbsolutePath());
        } else {
            System.err.println("File selection cancelled.");
        }
    }
}