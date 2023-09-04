module com.example.pickaplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.velshh.pickaplate to javafx.fxml;
    exports me.velshh.pickaplate;
}