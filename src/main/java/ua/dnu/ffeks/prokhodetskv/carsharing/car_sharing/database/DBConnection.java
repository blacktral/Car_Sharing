package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.database;



import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models.*;



import java.sql.*;

import java.time.LocalDate;

import java.time.LocalDateTime;



public class DBConnection {



// Налаштування бази даних

    private final String dbHost = "localhost";

    private final String dbPort = "5432";

    private final String dbUser = "postgres"; // Ваш логін (зазвичай postgres)

    private final String dbPass = "1234"; // Ваш пароль до БД

    private final String dbName = "Car_Sharing"; // Назва вашої бази даних



    Connection dbConnection;



    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

// Формуємо рядок підключення

// jdbc:postgresql://localhost:5432/car_sharing_db

        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;



        Class.forName("org.postgresql.Driver");



        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);



        return dbConnection;

    }

    public ObservableList<User> getAllUsers() {

        ObservableList<User> userList = FXCollections.observableArrayList();



// SQL запит

        String selectQuery = "SELECT * FROM users";



        try {

            PreparedStatement preparedStatement = getDbConnection().prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {

                User user = new User(

                        resultSet.getInt("id_user"),

                        resultSet.getString("first_name"),

                        resultSet.getString("middle_name"),

                        resultSet.getString("last_name"),

                        resultSet.getDate("date_birthday").toLocalDate(), // Конвертація SQL Date -> LocalDate

                        resultSet.getTimestamp("created_at").toLocalDateTime(), // Timestamp -> LocalDateTime

                        resultSet.getString("sex"),

                        resultSet.getString("address"),

                        resultSet.getString("phone_number"),

                        resultSet.getString("passport_data"),

                        resultSet.getInt("id_type")

                );





                userList.add(user);

            }

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }



        return userList;

    }



// --- USERS CRUD ---



// ДОДАВАННЯ

    public void addUser(String fn, String mn, String ln, LocalDate birth, String sex, String addr, String phone, String pass, int typeId) {

        String query = "INSERT INTO users (first_name, middle_name, last_name, date_birthday, sex, address, phone_number, passport_data, id_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, fn);

            ps.setString(2, mn);

            ps.setString(3, ln);

            ps.setDate(4, java.sql.Date.valueOf(birth)); // Виправлено

            ps.setString(5, sex);

            ps.setString(6, addr);

            ps.setString(7, phone);

            ps.setString(8, pass);

            ps.setInt(9, typeId);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



// РЕДАГУВАННЯ

    public void updateUser(int id, String fn, String mn, String ln, LocalDate birth, String sex, String addr, String phone, String pass, int typeId) {

        String query = "UPDATE users SET first_name=?, middle_name=?, last_name=?, date_birthday=?, sex=?, address=?, phone_number=?, passport_data=?, id_type=? WHERE id_user=?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, fn);

            ps.setString(2, mn);

            ps.setString(3, ln);

            ps.setDate(4, java.sql.Date.valueOf(birth)); // Виправлено

            ps.setString(5, sex);

            ps.setString(6, addr);

            ps.setString(7, phone);

            ps.setString(8, pass);

            ps.setInt(9, typeId);

            ps.setInt(10, id);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



// ВИДАЛЕННЯ

    public void deleteUser(int id) {

        String query = "DELETE FROM users WHERE id_user = ?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public ObservableList<Car> getAllCars() {

        ObservableList<Car> carList = FXCollections.observableArrayList();

        String selectQuery = "SELECT * FROM cars";



        try {

            PreparedStatement preparedStatement = getDbConnection().prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {

                Car car = new Car(

                        resultSet.getInt("id_car"),

                        resultSet.getInt("id_brand"),

                        resultSet.getString("number_car"),

                        resultSet.getString("number_body"),

                        resultSet.getString("number_engine"),

                        resultSet.getInt("production_year"),

                        resultSet.getInt("mileage"),

                        resultSet.getInt("service_interval"),

                        resultSet.getDouble("car_price"),

                        resultSet.getDouble("car_price_in_day"),

                        resultSet.getString("status"),

                        resultSet.getString("special_marks")

                );

                carList.add(car);

            }

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }

        return carList;

    }



// --- CARS CRUD ---



    public void addCar(int brandId, String num, String body, String eng, int year, int mileage, int interval, double price, double dayPrice, String status) {

        String query = "INSERT INTO cars (id_brand, number_car, number_body, number_engine, production_year, mileage, service_interval, car_price, car_price_in_day, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, brandId);

            ps.setString(2, num);

            ps.setString(3, body);

            ps.setString(4, eng);

            ps.setInt(5, year);

            ps.setInt(6, mileage);

            ps.setInt(7, interval);

            ps.setDouble(8, price);

            ps.setDouble(9, dayPrice);

            ps.setString(10, status);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public void updateCar(int id, int brandId, String num, String body, String eng, int year, int mileage, int interval, double price, double dayPrice, String status) {

        String query = "UPDATE cars SET id_brand=?, number_car=?, number_body=?, number_engine=?, production_year=?, mileage=?, service_interval=?, car_price=?, car_price_in_day=?, status=? WHERE id_car=?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, brandId);

            ps.setString(2, num);

            ps.setString(3, body);

            ps.setString(4, eng);

            ps.setInt(5, year);

            ps.setInt(6, mileage);

            ps.setInt(7, interval);

            ps.setDouble(8, price);

            ps.setDouble(9, dayPrice);

            ps.setString(10, status);

            ps.setInt(11, id);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public void deleteCar(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM cars WHERE id_car = ?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public ObservableList<Rent> getAllRents() {

        ObservableList<Rent> list = FXCollections.observableArrayList();

// Слово return є зарезервованим в SQL, тому беремо його в лапки "return"

        String query = "SELECT * FROM rent";



        try {

            PreparedStatement statement = getDbConnection().prepareStatement(query);

            ResultSet res = statement.executeQuery();



            while (res.next()) {

// Перевірка на NULL для дати повернення (якщо авто ще в оренді)

                Timestamp returnTs = res.getTimestamp("return");

                LocalDateTime returnDate = (returnTs != null) ? returnTs.toLocalDateTime() : null;



                Rent rent = new Rent(

                        res.getInt("id_rent"),

                        res.getTimestamp("giving").toLocalDateTime(),

                        res.getTimestamp("rental_period").toLocalDateTime(),

                        returnDate, // Передаємо оброблену дату або null

                        res.getInt("id_car"),

                        res.getInt("id_client"),

                        res.getInt("id_employee"),

                        res.getString("rent_status")

                );

                list.add(rent);

            }

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }

        return list;

    }



// --- MAINTENANCE CRUD ---



    public void addMaintenance(int carId, int mechId, LocalDate dateS, String desc, double price, String type) {

        String query = "INSERT INTO maintenance (id_car, id_mechanic, date_service, description, price, type) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, carId);

            ps.setInt(2, mechId);

            ps.setDate(3, java.sql.Date.valueOf(dateS));

            ps.setString(4, desc);

            ps.setDouble(5, price);

            ps.setString(6, type);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void updateMaintenance(int id, int carId, int mechId, LocalDate dateS, String desc, double price, String type) {

        String query = "UPDATE maintenance SET id_car=?, id_mechanic=?, date_service=?, description=?, price=?, type=? WHERE id_maintenance=?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, carId);

            ps.setInt(2, mechId);

            ps.setDate(3, java.sql.Date.valueOf(dateS));

            ps.setString(4, desc);

            ps.setDouble(5, price);

            ps.setString(6, type);

            ps.setInt(7, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deleteMaintenance(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM maintenance WHERE id_maintenance = ?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// --- ТЕХ. ОБСЛУГОВУВАННЯ (MAINTENANCE) ---

    public ObservableList<Maintenance> getAllMaintenance() {

        ObservableList<Maintenance> list = FXCollections.observableArrayList();



// Об'єднуємо таблиці, щоб взяти номер машини

        String query = "SELECT m.*, c.number_car FROM maintenance m JOIN cars c ON m.id_car = c.id_car";



        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                java.sql.Date finishDateSql = res.getDate("date_finish");

                LocalDate finishDate = (finishDateSql != null) ? finishDateSql.toLocalDate() : null;



                list.add(new Maintenance(

                        res.getInt("id_maintenance"),

                        res.getInt("id_car"),

                        res.getInt("id_mechanic"),

                        res.getDate("date_service").toLocalDate(),

                        res.getString("description"),

                        finishDate,

                        res.getDouble("price"),

                        res.getInt("mileage_at_moment"),

                        res.getString("type"),

                        res.getString("number_car") // Беремо це поле з таблиці cars

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// --- RENT CRUD ---



    public void addRent(LocalDateTime giving, LocalDateTime period, int carId, int clientId, int empId, String status) {

        String query = "INSERT INTO rent (giving, rental_period, id_car, id_client, id_employee, rent_status) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setTimestamp(1, java.sql.Timestamp.valueOf(giving));

            ps.setTimestamp(2, java.sql.Timestamp.valueOf(period));

            ps.setInt(3, carId);

            ps.setInt(4, clientId);

            ps.setInt(5, empId);

            ps.setString(6, status);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deleteRent(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM rent WHERE id_rent = ?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// --- BRANDS CRUD ---



    public void addBrand(String name, String tech, String desc) {

        String query = "INSERT INTO car_brands (name_brand, tech_requirements, description) VALUES (?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setString(2, tech);

            ps.setString(3, desc);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public void updateBrand(int id, String name, String tech, String desc) {

        String query = "UPDATE car_brands SET name_brand = ?, tech_requirements = ?, description = ? WHERE id_brand = ?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setString(2, tech);

            ps.setString(3, desc);

            ps.setInt(4, id);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public void deleteBrand(int id) {

        String query = "DELETE FROM car_brands WHERE id_brand = ?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

    }



    public ObservableList<Payment> getAllPayments() {

        ObservableList<Payment> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM payments";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new Payment(

                        res.getInt("id_payment"),

                        res.getInt("id_rent"),

                        res.getDouble("amount"),

                        res.getString("type"),

                        res.getString("method"),

                        res.getTimestamp("created_at").toLocalDateTime()

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// ---------------------------------------------------

// --- 6. ПОСЛУГИ (SERVICES) ---

// ---------------------------------------------------

    public void addService(String name, double price, String desc) {

        String query = "INSERT INTO services (service, price, description) VALUES (?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setDouble(2, price);

            ps.setString(3, desc);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void updateService(int id, String name, double price, String desc) {

        String query = "UPDATE services SET service=?, price=?, description=? WHERE id_service=?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setDouble(2, price);

            ps.setString(3, desc);

            ps.setInt(4, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deleteService(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM services WHERE id_service=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// ---------------------------------------------------

// --- 7. ПОСЛУГИ В ОРЕНДІ (RENTAL SERVICES) ---

// ---------------------------------------------------

    public void addRentalService(int rentId, int serviceId, int qty, double price) {

        String query = "INSERT INTO rental_services (rent_id, id_service, quantity, price_at_moment) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, rentId);

            ps.setInt(2, serviceId);

            ps.setInt(3, qty);

            ps.setDouble(4, price);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deleteRentalService(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM rental_services WHERE id_rental_services=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// ---------------------------------------------------

// --- 8. ПЛАТЕЖІ (PAYMENTS) ---

// ---------------------------------------------------

    public void addPayment(int rentId, double amount, String type, String method, LocalDateTime created) {

        String query = "INSERT INTO payments (id_rent, amount, type, method, created_at) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, rentId);

            ps.setDouble(2, amount);

            ps.setString(3, type);

            ps.setString(4, method);

            ps.setTimestamp(5, java.sql.Timestamp.valueOf(created));

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deletePayment(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM payments WHERE id_payment=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// ---------------------------------------------------

// --- 9. ПОСАДИ (POSITIONS) ---

// ---------------------------------------------------

    public void addPosition(String name, double salary, String resp, String req) {

        String query = "INSERT INTO positions (position_name, salary, responsibilities, requirements) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setDouble(2, salary);

            ps.setString(3, resp);

            ps.setString(4, req);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void updatePosition(int id, String name, double salary, String resp, String req) {

        String query = "UPDATE positions SET position_name=?, salary=?, responsibilities=?, requirements=? WHERE id_position=?";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setString(1, name);

            ps.setDouble(2, salary);

            ps.setString(3, resp);

            ps.setString(4, req);

            ps.setInt(5, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deletePosition(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM positions WHERE id_position=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// ---------------------------------------------------

// --- 10. ТИПИ КОРИСТУВАЧІВ (USER TYPES) ---

// ---------------------------------------------------

    public void addUserType(String name) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("INSERT INTO user_type (type_name) VALUES (?)");

            ps.setString(1, name);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



    public void deleteUserType(int id) {

        try {

            PreparedStatement ps = getDbConnection().prepareStatement("DELETE FROM user_type WHERE id_type=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// ---------------------------------------------------

// --- 11. ІСТОРІЯ ПОСАД (USER POSITIONS) ---

// ---------------------------------------------------

    public void addUserPosition(int userId, int posId, LocalDate start, LocalDate end, String reason, double salary) {

        String query = "INSERT INTO users_positions (id_user, id_position, start_date, end_date, leaving_reason, salary) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = getDbConnection().prepareStatement(query);

            ps.setInt(1, userId);

            ps.setInt(2, posId);

            ps.setDate(3, java.sql.Date.valueOf(start));



            if (end != null) ps.setDate(4, java.sql.Date.valueOf(end));

            else ps.setNull(4, java.sql.Types.DATE);



            ps.setString(5, reason);

            ps.setDouble(6, salary);

            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }

    }



// --- 6. БРЕНДИ (CAR BRANDS) ---

    public ObservableList<Car_Brands> getAllBrands() {

        ObservableList<Car_Brands> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM car_brands";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new Car_Brands(

                        res.getInt("id_brand"),

                        res.getString("name_brand"),

                        res.getString("tech_requirements"),

                        res.getString("description")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }







// --- 7. ПОСЛУГИ (SERVICES) ---

    public ObservableList<Services> getAllServices() {

        ObservableList<Services> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM services";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new Services(

                        res.getInt("id_service"),

                        res.getString("service"), // назва колонки в БД

                        res.getString("description"),

                        res.getDouble("price")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// --- 8. ПОСЛУГИ В ОРЕНДІ (RENTAL SERVICES) ---

    public ObservableList<Rental_Service> getAllRentalServices() {

        ObservableList<Rental_Service> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM rental_services";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new Rental_Service(

                        res.getInt("id_rental_services"),

                        res.getInt("rent_id"),

                        res.getInt("id_service"),

                        res.getInt("quantity"),

                        res.getDouble("price_at_moment")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// --- 9. ТИПИ КОРИСТУВАЧІВ (USER TYPES) ---

    public ObservableList<User_Type> getAllUserTypes() {

        ObservableList<User_Type> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM user_type";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new User_Type(

                        res.getInt("id_type"),

                        res.getString("type_name")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// --- 10. ПОСАДИ (POSITIONS) ---

    public ObservableList<Positions> getAllPositions() {

        ObservableList<Positions> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM positions";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

                list.add(new Positions(

                        res.getInt("id_position"),

                        res.getString("position_name"),

                        res.getDouble("salary"),

                        res.getString("responsibilities"),

                        res.getString("requirements")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;

    }



// --- 11. ІСТОРІЯ ПОСАД (USER POSITIONS) ---

    public ObservableList<User_Positions> getAllUserPositions() {

        ObservableList<User_Positions> list = FXCollections.observableArrayList();

        String query = "SELECT * FROM users_positions";

        try {

            ResultSet res = getDbConnection().prepareStatement(query).executeQuery();

            while (res.next()) {

// Обробка endDate, який може бути NULL (якщо ще працює)

                java.sql.Date endSql = res.getDate("end_date");

                java.time.LocalDate endDate = (endSql != null) ? endSql.toLocalDate() : null;



                list.add(new User_Positions(

                        res.getInt("id_user"),

                        res.getInt("id_position"),

                        res.getDate("start_date").toLocalDate(),

                        endDate,

                        res.getDouble("salary"), // <--- Спочатку зарплата (double)

                        res.getString("leaving_reason")

                ));

            }

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return list;





    }}