package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.database.DBConnection;
import ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AdminController {

    private DBConnection dbHandler = new DBConnection();

    @FXML
    private ComboBox<String> tablesComboBox;

    @FXML
    private TableView<Object> mainTableView;

    @FXML
    void initialize() {
        ObservableList<String> tables = FXCollections.observableArrayList(
                "Користувачі (Users)",
                "Автомобілі (Cars)",
                "Замовлення (Rents)",
                "Тех. обслуговування (Maintenance)",
                "Платежі (Payments)",
                "Бренди (Car Brands)",
                "Послуги (Services)",
                "Послуги в оренді (Rental Services)",
                "Типи користувачів (User Types)",
                "Посади (Positions)",
                "Історія посад (User Positions)"
        );
        tablesComboBox.setItems(tables);
    }

    @FXML
    void handleViewTable() {
        String selectedTable = tablesComboBox.getValue();
        if (selectedTable == null) return;

        mainTableView.getColumns().clear();
        mainTableView.getItems().clear();

        switch (selectedTable) {
            case "Користувачі (Users)" -> loadUsersTable();
            case "Автомобілі (Cars)" -> loadCarsTable();
            case "Замовлення (Rents)" -> loadRentsTable();
            case "Тех. обслуговування (Maintenance)" -> loadMaintenanceTable();
            case "Платежі (Payments)" -> loadPaymentsTable();
            case "Бренди (Car Brands)" -> loadBrandsTable();
            case "Послуги (Services)" -> loadServicesTable();
            case "Послуги в оренді (Rental Services)" -> loadRentalServicesTable();
            case "Типи користувачів (User Types)" -> loadUserTypesTable();
            case "Посади (Positions)" -> loadPositionsTable();
            case "Історія посад (User Positions)" -> loadUserPositionsTable();
            default -> System.out.println("Таблиця ще не реалізована");
        }
    }

// --- ЗАВАНТАЖЕННЯ ТАБЛИЦЬ ---

    private void loadUsersTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        TableColumn<Object, String> fnCol = new TableColumn<>("Ім'я");
        fnCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Object, String> lnCol = new TableColumn<>("Прізвище");
        lnCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Object, String> phoneCol = new TableColumn<>("Телефон");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        mainTableView.getColumns().addAll(idCol, fnCol, lnCol, phoneCol);
        mainTableView.getItems().addAll(dbHandler.getAllUsers());
    }

    private void loadCarsTable() {
        TableColumn<Object, String> numCol = new TableColumn<>("Номер");
        numCol.setCellValueFactory(new PropertyValueFactory<>("numberCar"));
        TableColumn<Object, Double> priceCol = new TableColumn<>("Ціна/День");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("carPriceInDay"));
        TableColumn<Object, String> statusCol = new TableColumn<>("Статус");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        mainTableView.getColumns().addAll(numCol, priceCol, statusCol);
        mainTableView.getItems().addAll(dbHandler.getAllCars());
    }

    private void loadRentsTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idRent"));
        TableColumn<Object, String> giveCol = new TableColumn<>("Видача");
        giveCol.setCellValueFactory(new PropertyValueFactory<>("giving"));
        TableColumn<Object, String> retCol = new TableColumn<>("Повернення");
        retCol.setCellValueFactory(new PropertyValueFactory<>("rentalPeriod"));
        TableColumn<Object, String> stCol = new TableColumn<>("Статус");
        stCol.setCellValueFactory(new PropertyValueFactory<>("rentStatus"));
        mainTableView.getColumns().addAll(idCol, giveCol, retCol, stCol);
        mainTableView.getItems().addAll(dbHandler.getAllRents());
    }

    private void loadMaintenanceTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idMaintenance"));
        TableColumn<Object, String> carCol = new TableColumn<>("Автомобіль");
        carCol.setCellValueFactory(new PropertyValueFactory<>("carNumber"));
        TableColumn<Object, String> descCol = new TableColumn<>("Опис");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn<Object, Double> priceCol = new TableColumn<>("Ціна");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        mainTableView.getColumns().addAll(idCol, carCol, descCol, priceCol);
        mainTableView.getItems().addAll(dbHandler.getAllMaintenance());
    }

    private void loadPaymentsTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idPayment"));
        TableColumn<Object, Double> amCol = new TableColumn<>("Сума");
        amCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<Object, String> metCol = new TableColumn<>("Метод");
        metCol.setCellValueFactory(new PropertyValueFactory<>("method"));
        TableColumn<Object, String> timeCol = new TableColumn<>("Дата");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        mainTableView.getColumns().addAll(idCol, amCol, metCol, timeCol);
        mainTableView.getItems().addAll(dbHandler.getAllPayments());
    }

    private void loadBrandsTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idBrand"));
        TableColumn<Object, String> nameCol = new TableColumn<>("Бренд");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameBrand"));
        TableColumn<Object, String> techCol = new TableColumn<>("Вимоги");
        techCol.setCellValueFactory(new PropertyValueFactory<>("techRequirements"));
        mainTableView.getColumns().addAll(idCol, nameCol, techCol);
        mainTableView.getItems().addAll(dbHandler.getAllBrands());
    }

    private void loadServicesTable() {
        TableColumn<Object, String> nameCol = new TableColumn<>("Послуга");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        TableColumn<Object, Double> prCol = new TableColumn<>("Ціна");
        prCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Object, String> descCol = new TableColumn<>("Опис");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        mainTableView.getColumns().addAll(nameCol, prCol, descCol);
        mainTableView.getItems().addAll(dbHandler.getAllServices());
    }

    private void loadRentalServicesTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idRentalServices"));
        TableColumn<Object, Integer> rentIdCol = new TableColumn<>("ID Оренди");
        rentIdCol.setCellValueFactory(new PropertyValueFactory<>("rentId"));
        TableColumn<Object, Integer> srvIdCol = new TableColumn<>("ID Послуги");
        srvIdCol.setCellValueFactory(new PropertyValueFactory<>("idService"));
        TableColumn<Object, Integer> qtyCol = new TableColumn<>("К-сть");
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Object, Double> priceCol = new TableColumn<>("Ціна");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("priceAtMoment"));
        mainTableView.getColumns().addAll(idCol, rentIdCol, srvIdCol, qtyCol, priceCol);
        mainTableView.getItems().addAll(dbHandler.getAllRentalServices());
    }

    private void loadUserTypesTable() {
        TableColumn<Object, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idType"));
        TableColumn<Object, String> nameCol = new TableColumn<>("Тип");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        mainTableView.getColumns().addAll(idCol, nameCol);
        mainTableView.getItems().addAll(dbHandler.getAllUserTypes());
    }

    private void loadPositionsTable() {
        TableColumn<Object, String> nameCol = new TableColumn<>("Посада");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("positionName"));
        TableColumn<Object, Double> salCol = new TableColumn<>("Зарплата");
        salCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        mainTableView.getColumns().addAll(nameCol, salCol);
        mainTableView.getItems().addAll(dbHandler.getAllPositions());
    }

    private void loadUserPositionsTable() {
        TableColumn<Object, Integer> uIdCol = new TableColumn<>("ID User");
        uIdCol.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        TableColumn<Object, Integer> pIdCol = new TableColumn<>("ID Pos");
        pIdCol.setCellValueFactory(new PropertyValueFactory<>("idPosition"));
        TableColumn<Object, String> stCol = new TableColumn<>("Start");
        stCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        TableColumn<Object, String> endCol = new TableColumn<>("End");
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        TableColumn<Object, Double> salCol = new TableColumn<>("Salary");
        salCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        mainTableView.getColumns().addAll(uIdCol, pIdCol, stCol, endCol, salCol);
        mainTableView.getItems().addAll(dbHandler.getAllUserPositions());
    }

// --- ОБРОБКА КНОПОК ---

    @FXML
    void handleAddRecord() {
        String table = tablesComboBox.getValue();
        if (table == null) return;

        switch (table) {
            case "Користувачі (Users)" -> showUserDialog(null);
            case "Автомобілі (Cars)" -> showCarDialog(null);
            case "Замовлення (Rents)" -> showRentDialog(null);
            case "Тех. обслуговування (Maintenance)" -> showMaintenanceDialog(null);
            case "Бренди (Car Brands)" -> showBrandDialog(null);
            case "Послуги (Services)" -> showServiceDialog(null);
            case "Платежі (Payments)" -> showPaymentDialog(null);
            case "Посади (Positions)" -> showPositionDialog(null);
            case "Типи користувачів (User Types)" -> showUserTypeDialog(null);
            default -> System.out.println("Для цієї таблиці діалог ще не створено");
        }
    }

    @FXML
    void handleEditRecord() {
        String table = tablesComboBox.getValue();
        Object item = mainTableView.getSelectionModel().getSelectedItem();
        if (item == null) return;

        switch (table) {
            case "Користувачі (Users)" -> showUserDialog((User) item);
            case "Автомобілі (Cars)" -> showCarDialog((Car) item);
            case "Замовлення (Rents)" -> showRentDialog((Rent) item);
            case "Тех. обслуговування (Maintenance)" -> showMaintenanceDialog((Maintenance) item);
            case "Бренди (Car Brands)" -> showBrandDialog((Car_Brands) item);
            case "Послуги (Services)" -> showServiceDialog((Services) item);
            case "Платежі (Payments)" -> showPaymentDialog((Payment) item);
            case "Посади (Positions)" -> showPositionDialog((Positions) item);
            case "Типи користувачів (User Types)" -> showUserTypeDialog((User_Type) item);
        }
    }

    @FXML
    void handleDeleteRecord() {
        String table = tablesComboBox.getValue();
        Object item = mainTableView.getSelectionModel().getSelectedItem();

        if (item == null || table == null) {
            System.out.println("Не обрано запис або таблицю!");
            return;
        }

        try {
            switch (table) {
                case "Користувачі (Users)" -> { dbHandler.deleteUser(((User) item).getIdUser()); loadUsersTable(); }
                case "Автомобілі (Cars)" -> { dbHandler.deleteCar(((Car) item).getIdCar()); loadCarsTable(); }
                case "Замовлення (Rents)" -> { dbHandler.deleteRent(((Rent) item).getIdRent()); loadRentsTable(); }
                case "Тех. обслуговування (Maintenance)" -> { dbHandler.deleteMaintenance(((Maintenance) item).getIdMaintenance()); loadMaintenanceTable(); }
                case "Платежі (Payments)" -> { dbHandler.deletePayment(((Payment) item).getIdPayment()); loadPaymentsTable(); }
                case "Бренди (Car Brands)" -> { dbHandler.deleteBrand(((Car_Brands) item).getIdBrand()); loadBrandsTable(); }
                case "Послуги (Services)" -> { dbHandler.deleteService(((Services) item).getIdService()); loadServicesTable(); }
                case "Послуги в оренді (Rental Services)" -> { dbHandler.deleteRentalService(((Rental_Service) item).getIdRentalServices()); loadRentalServicesTable(); }
                case "Посади (Positions)" -> { dbHandler.deletePosition(((Positions) item).getIdPosition()); loadPositionsTable(); }
                case "Типи користувачів (User Types)" -> { dbHandler.deleteUserType(((User_Type) item).getIdType()); loadUserTypesTable(); }
            }
        } catch (Exception e) {
            String errorMsg = e.getMessage();
            if (errorMsg != null && (errorMsg.contains("foreign key") || errorMsg.contains("constraint"))) {
                showError("Неможливо видалити цей запис!\n\nВін використовується в інших таблицях. Спочатку видаліть пов'язані дані.");
            } else {
                showError("Помилка при видаленні: " + e.getMessage());
            }
        }
    }

// --- ДОПОМІЖНІ МЕТОДИ ---

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Помилка");
        alert.setHeaderText("Операцію не виконано");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean isCarAvailable(int carId, LocalDateTime start, LocalDateTime end, int currentRentId) {
        List<Rent> allRents = dbHandler.getAllRents();
        for (Rent rent : allRents) {
            if (rent.getIdRent() == currentRentId) continue;
            if ("Closed".equalsIgnoreCase(rent.getRentStatus()) || "Cancelled".equalsIgnoreCase(rent.getRentStatus())) continue;

            if (rent.getIdCar() == carId) {
                LocalDateTime rStart = rent.getGiving();
                LocalDateTime rEnd = rent.getRentalPeriod();
                if (start.isBefore(rEnd) && end.isAfter(rStart)) {
                    return false;
                }
            }
        }
        return true;
    }

// --- МЕТОДИ ДІАЛОГОВИХ ВІКОН ---

    private void showUserDialog(User user) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Користувач");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField fn = new TextField(); fn.setPromptText("Ім'я");
        TextField ln = new TextField(); ln.setPromptText("Прізвище");
        TextField mn = new TextField(); mn.setPromptText("По батькові");
        DatePicker birth = new DatePicker(); birth.setPromptText("Дата народження");
        TextField phone = new TextField(); phone.setPromptText("Телефон");
        TextField address = new TextField(); address.setPromptText("Адреса");
        TextField pass = new TextField(); pass.setPromptText("Паспорт");
        TextField typeId = new TextField(); typeId.setPromptText("ID Типу (1-Admin, 2-Client)");

        if (user != null) {
            fn.setText(user.getFirstName()); ln.setText(user.getLastName()); mn.setText(user.getMiddleName());
            birth.setValue(user.getDateBirthday());
            phone.setText(user.getPhoneNumber()); address.setText(user.getAddress());
            pass.setText(user.getPassportData()); typeId.setText(String.valueOf(user.getIdType()));
        }

        grid.addRow(0, new Label("Ім'я:"), fn);
        grid.addRow(1, new Label("Прізвище:"), ln);
        grid.addRow(2, new Label("По батькові:"), mn);
        grid.addRow(3, new Label("Дата нар.:"), birth);
        grid.addRow(4, new Label("Телефон:"), phone);
        grid.addRow(5, new Label("Адреса:"), address);
        grid.addRow(6, new Label("Паспорт:"), pass);
        grid.addRow(7, new Label("ID Типу:"), typeId);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    int tId = Integer.parseInt(typeId.getText());
                    boolean typeExists = dbHandler.getAllUserTypes().stream().anyMatch(t -> t.getIdType() == tId);
                    if (!typeExists) { showError("Тип користувача з ID " + tId + " не знайдено!"); return null; }

                    if (user == null) dbHandler.addUser(fn.getText(), mn.getText(), ln.getText(), birth.getValue(), "M", address.getText(), phone.getText(), pass.getText(), tId);
                    else dbHandler.updateUser(user.getIdUser(), fn.getText(), mn.getText(), ln.getText(), birth.getValue(), "M", address.getText(), phone.getText(), pass.getText(), tId);
                    loadUsersTable();
                    return true;
                } catch (NumberFormatException e) { showError("ID типу має бути числом!"); } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showCarDialog(Car car) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Автомобіль");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField brandId = new TextField(); brandId.setPromptText("ID Бренду");
        TextField num = new TextField(); num.setPromptText("Номер авто");
        TextField price = new TextField(); price.setPromptText("Ціна авто");
        TextField dayPrice = new TextField(); dayPrice.setPromptText("Ціна в день");
        TextField status = new TextField("free");

        if (car != null) {
            brandId.setText(String.valueOf(car.getIdBrand()));
            num.setText(car.getNumberCar());
            price.setText(String.valueOf(car.getCarPrice()));
            dayPrice.setText(String.valueOf(car.getCarPriceInDay()));
            status.setText(car.getStatus());
        }

        grid.addRow(0, new Label("ID Бренду:"), brandId);
        grid.addRow(1, new Label("Номер:"), num);
        grid.addRow(2, new Label("Ціна:"), price);
        grid.addRow(3, new Label("Ціна/День:"), dayPrice);
        grid.addRow(4, new Label("Статус:"), status);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    int bId = Integer.parseInt(brandId.getText());
                    boolean brandExists = dbHandler.getAllBrands().stream().anyMatch(b -> b.getIdBrand() == bId);
                    if (!brandExists) { showError("Бренд з ID " + bId + " не знайдено!"); return null; }

                    String stub = "N/A";
                    if (car == null) dbHandler.addCar(bId, num.getText(), stub, stub, 2020, 0, 10000, Double.parseDouble(price.getText()), Double.parseDouble(dayPrice.getText()), status.getText());
                    else dbHandler.updateCar(car.getIdCar(), bId, num.getText(), stub, stub, 2020, 0, 10000, Double.parseDouble(price.getText()), Double.parseDouble(dayPrice.getText()), status.getText());
                    loadCarsTable();
                    return true;
                } catch (NumberFormatException e) { showError("Перевірте числові поля!"); } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    // --- ОНОВЛЕНИЙ МЕТОД З ФІЛЬТРАЦІЄЮ СПИСКІВ ---
    private void showRentDialog(Rent r) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Оренда");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        DatePicker giveDate = new DatePicker();
        DatePicker planDate = new DatePicker();

        // Завантажуємо всіх користувачів
        List<User> allUsers = dbHandler.getAllUsers();

        // ФІЛЬТРАЦІЯ: Клієнти (type = 2)
        List<User> clients = allUsers.stream()
                .filter(u -> u.getIdType() == 2)
                .collect(Collectors.toList());

        // ФІЛЬТРАЦІЯ: Працівники (type = 1, або будь-хто крім клієнтів)
        List<User> employees = allUsers.stream()
                .filter(u -> u.getIdType() == 1) // Вважаємо що 1 - це Admin/Employee
                .collect(Collectors.toList());

        // ComboBox для автомобілів
        ComboBox<Car> carComboBox = new ComboBox<>();
        carComboBox.setItems(FXCollections.observableArrayList(dbHandler.getAllCars()));
        carComboBox.setConverter(new StringConverter<Car>() {
            @Override
            public String toString(Car car) {
                return car == null ? "" : car.getNumberCar() + " (" + car.getIdCar() + ")";
            }
            @Override
            public Car fromString(String string) { return null; }
        });

        // ComboBox для Клієнтів
        ComboBox<User> clientComboBox = new ComboBox<>();
        clientComboBox.setItems(FXCollections.observableArrayList(clients));
        clientComboBox.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return user == null ? "" : user.getFirstName() + " " + user.getLastName();
            }
            @Override
            public User fromString(String string) { return null; }
        });

        // ComboBox для Працівників
        ComboBox<User> empComboBox = new ComboBox<>();
        empComboBox.setItems(FXCollections.observableArrayList(employees));
        empComboBox.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return user == null ? "" : user.getFirstName() + " " + user.getLastName();
            }
            @Override
            public User fromString(String string) { return null; }
        });

        TextField status = new TextField("Active");

        if (r != null) {
            giveDate.setValue(r.getGiving().toLocalDate());
            planDate.setValue(r.getRentalPeriod().toLocalDate());
            status.setText(r.getRentStatus());

            carComboBox.getItems().stream().filter(c -> c.getIdCar() == r.getIdCar()).findFirst().ifPresent(carComboBox::setValue);
            clientComboBox.getItems().stream().filter(u -> u.getIdUser() == r.getIdClient()).findFirst().ifPresent(clientComboBox::setValue);
            empComboBox.getItems().stream().filter(u -> u.getIdUser() == r.getIdEmployee()).findFirst().ifPresent(empComboBox::setValue);
        }

        grid.addRow(0, new Label("Дата видачі:"), giveDate);
        grid.addRow(1, new Label("Дата повернення:"), planDate);
        grid.addRow(2, new Label("Автомобіль:"), carComboBox);
        grid.addRow(3, new Label("Клієнт:"), clientComboBox);
        grid.addRow(4, new Label("Працівник:"), empComboBox);
        grid.addRow(5, new Label("Статус:"), status);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    Car selectedCar = carComboBox.getValue();
                    User selectedClient = clientComboBox.getValue();
                    User selectedEmp = empComboBox.getValue();

                    if (selectedCar == null || selectedClient == null || selectedEmp == null || giveDate.getValue() == null || planDate.getValue() == null) {
                        showError("Будь ласка, заповніть всі поля!");
                        return null;
                    }

                    LocalDateTime giving = giveDate.getValue().atStartOfDay();
                    LocalDateTime period = planDate.getValue().atStartOfDay();

                    if (giving.isAfter(period)) {
                        showError("Дата видачі не може бути пізніше дати повернення!");
                        return null;
                    }

                    int currentRentId = (r == null) ? -1 : r.getIdRent();
                    if (!isCarAvailable(selectedCar.getIdCar(), giving, period, currentRentId)) {
                        showError("Цей автомобіль вже зайнятий на обрані дати!");
                        return null;
                    }

                    if (r == null) dbHandler.addRent(giving, period, selectedCar.getIdCar(), selectedClient.getIdUser(), selectedEmp.getIdUser(), status.getText());
                    // else dbHandler.updateRent(...)

                    loadRentsTable();
                    return true;

                } catch (Exception e) {
                    showError("Помилка бази даних: " + e.getMessage());
                }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showMaintenanceDialog(Maintenance m) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Тех. обслуговування");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField carId = new TextField(); carId.setPromptText("ID Авто");
        TextField mechId = new TextField(); mechId.setPromptText("ID Механіка");
        DatePicker dateS = new DatePicker();
        TextField desc = new TextField(); desc.setPromptText("Що робили?");
        TextField price = new TextField(); price.setPromptText("Ціна");

        if (m != null) {
            carId.setText(String.valueOf(m.getIdCar()));
            mechId.setText(String.valueOf(m.getIdMechanic()));
            dateS.setValue(m.getDateService());
            desc.setText(m.getDescription());
            price.setText(String.valueOf(m.getPrice()));
        }

        grid.addRow(0, new Label("ID Авто:"), carId);
        grid.addRow(1, new Label("ID Механіка:"), mechId);
        grid.addRow(2, new Label("Дата:"), dateS);
        grid.addRow(3, new Label("Опис:"), desc);
        grid.addRow(4, new Label("Ціна:"), price);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    int cId = Integer.parseInt(carId.getText());
                    int mechIdVal = Integer.parseInt(mechId.getText());

                    boolean carExists = dbHandler.getAllCars().stream().anyMatch(c -> c.getIdCar() == cId);
                    if (!carExists) { showError("Авто з ID " + cId + " не знайдено!"); return null; }

                    boolean mechExists = dbHandler.getAllUsers().stream().anyMatch(u -> u.getIdUser() == mechIdVal);
                    if (!mechExists) { showError("Механіка (User) з ID " + mechIdVal + " не знайдено!"); return null; }

                    if (m == null) dbHandler.addMaintenance(cId, mechIdVal, dateS.getValue(), desc.getText(), Double.parseDouble(price.getText()), "Repair");
                    else dbHandler.updateMaintenance(m.getIdMaintenance(), cId, mechIdVal, dateS.getValue(), desc.getText(), Double.parseDouble(price.getText()), "Repair");
                    loadMaintenanceTable();
                    return true;
                } catch (NumberFormatException e) { showError("Перевірте числові поля (ID, Ціна)!"); } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showServiceDialog(Services s) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle(s == null ? "Додати послугу" : "Редагувати послугу");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField name = new TextField(); name.setPromptText("Назва");
        TextField price = new TextField(); price.setPromptText("Ціна");
        TextField desc = new TextField(); desc.setPromptText("Опис");

        if (s != null) {
            name.setText(s.getServiceName());
            price.setText(String.valueOf(s.getPrice()));
            desc.setText(s.getDescription());
        }

        grid.addRow(0, new Label("Назва:"), name);
        grid.addRow(1, new Label("Ціна:"), price);
        grid.addRow(2, new Label("Опис:"), desc);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    if (s == null) dbHandler.addService(name.getText(), Double.parseDouble(price.getText()), desc.getText());
                    else dbHandler.updateService(s.getIdService(), name.getText(), Double.parseDouble(price.getText()), desc.getText());
                    loadServicesTable();
                    return true;
                } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showBrandDialog(Car_Brands b) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle(b == null ? "Додати бренд" : "Редагувати бренд");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField name = new TextField(); name.setPromptText("Назва");
        TextField tech = new TextField(); tech.setPromptText("Вимоги");
        TextField desc = new TextField(); desc.setPromptText("Опис");

        if (b != null) {
            name.setText(b.getNameBrand());
            tech.setText(b.getTechRequirements());
            desc.setText(b.getDescription());
        }

        grid.addRow(0, new Label("Назва:"), name);
        grid.addRow(1, new Label("Вимоги:"), tech);
        grid.addRow(2, new Label("Опис:"), desc);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    if (b == null) dbHandler.addBrand(name.getText(), tech.getText(), desc.getText());
                    else dbHandler.updateBrand(b.getIdBrand(), name.getText(), tech.getText(), desc.getText());
                    loadBrandsTable();
                    return true;
                } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showPaymentDialog(Payment p) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Платіж");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField rentId = new TextField(); rentId.setPromptText("ID Оренди");
        TextField amount = new TextField(); amount.setPromptText("Сума");
        TextField type = new TextField(); type.setPromptText("Тип (Card/Cash)");
        TextField method = new TextField(); method.setPromptText("Метод (Online/Term)");

        if (p != null) {
            rentId.setText(String.valueOf(p.getIdRent()));
            amount.setText(String.valueOf(p.getAmount()));
            type.setText(p.getType());
            method.setText(p.getMethod());
        }

        grid.addRow(0, new Label("ID Оренди:"), rentId);
        grid.addRow(1, new Label("Сума:"), amount);
        grid.addRow(2, new Label("Тип:"), type);
        grid.addRow(3, new Label("Метод:"), method);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    int rId = Integer.parseInt(rentId.getText());
                    boolean rentExists = dbHandler.getAllRents().stream().anyMatch(r -> r.getIdRent() == rId);
                    if (!rentExists) { showError("Оренди з ID " + rId + " не знайдено!"); return null; }

                    if (p == null) dbHandler.addPayment(rId, Double.parseDouble(amount.getText()), type.getText(), method.getText(), LocalDateTime.now());
                    loadPaymentsTable();
                    return true;
                } catch (NumberFormatException e) { showError("ID та сума мають бути числами!"); } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showPositionDialog(Positions p) {
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.setTitle("Посада");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new javafx.geometry.Insets(20));

        TextField name = new TextField();
        TextField salary = new TextField();
        TextField resp = new TextField();
        TextField req = new TextField();

        if (p != null) {
            name.setText(p.getPositionName());
            salary.setText(String.valueOf(p.getSalary()));
            resp.setText(p.getResponsibilities());
            req.setText(p.getRequirements());
        }

        grid.addRow(0, new Label("Назва:"), name);
        grid.addRow(1, new Label("Зарплата:"), salary);
        grid.addRow(2, new Label("Обов'язки:"), resp);
        grid.addRow(3, new Label("Вимоги:"), req);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    if (p == null) dbHandler.addPosition(name.getText(), Double.parseDouble(salary.getText()), resp.getText(), req.getText());
                    else dbHandler.updatePosition(p.getIdPosition(), name.getText(), Double.parseDouble(salary.getText()), resp.getText(), req.getText());
                    loadPositionsTable();
                    return true;
                } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
            }
            return null;
        });
        dialog.showAndWait();
    }

    private void showUserTypeDialog(User_Type t) {
        TextInputDialog dialog = new TextInputDialog(t != null ? t.getTypeName() : "");
        dialog.setTitle("Тип користувача");
        dialog.setHeaderText("Введіть назву типу:");
        dialog.setContentText("Назва:");

        dialog.showAndWait().ifPresent(name -> {
            try {
                if (t == null) dbHandler.addUserType(name);
                loadUserTypesTable();
            } catch (Exception e) { showError("Помилка: " + e.getMessage()); }
        });
    }
}