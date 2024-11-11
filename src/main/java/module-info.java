module live.denisdev.conversionefile {
    requires javafx.controls;
    requires javafx.fxml;
    requires IVCompressor;
    requires java.desktop;


    opens live.denisdev.conversionefile to javafx.fxml;
    exports live.denisdev.conversionefile;
}