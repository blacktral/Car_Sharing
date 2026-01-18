module ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.sql;
    requires org.postgresql.jdbc;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing to javafx.fxml;
    exports ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing;

    opens ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.controllers to javafx.fxml;
    exports ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.controllers;

    exports ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

    exports ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.database;
}