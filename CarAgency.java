package car.agency;

//import NewClass;
import db.go;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CarAgency extends Application {

    final ObservableList options = FXCollections.observableArrayList();
   // final ObservableList optionss = FXCollections.observableArrayList();

    private static String url = "";
    private static String dbname = "caragency";
    private static Connection con;

    private static void seturl() {
        url = "jdbc:mysql://localhost:3306/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
    }

    private static void setconnection() {
        try {
            seturl();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(ex.getMessage());
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void fillcombo() {
        // setconnection();
        try {
            setconnection();
            String query = "select carName from cars";
            Statement stmt = con.prepareStatement(query);
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                options.add(result.getString("carName"));
            }

        } catch (SQLException ex) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setconnection();
        fillcombo();
        //create pane
        Pane mainpanee = new Pane();
        Pane showcars = new Pane();
        Pane updatecar = new Pane();
        Pane deletecar = new Pane();
        Pane paymentcar = new Pane();
        Pane newcustomerrr = new Pane();
        Pane regularcutomer = new Pane();

        //create scences
        Scene showcarscene = new Scene(showcars, 500, 400);

        Scene updatecarscence = new Scene(updatecar, 500, 300);
        Scene deletecarsscene = new Scene(deletecar, 500, 300);
        Scene paymentscene = new Scene(paymentcar, 500, 300);
        Scene newscene = new Scene(mainpanee, 500, 300);
        Scene newscustomerr = new Scene(newcustomerrr, 500, 300);
        Scene regularcutomerr = new Scene(regularcutomer, 500, 300);

        //add background image to scence
        BackgroundImage myBI1 = new BackgroundImage(new Image("1920x1440_A189584_large.jpg", 500, 300, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        BackgroundImage myBI11 = new BackgroundImage(new Image("1920x1440_A189584_large.jpg", 500, 400, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //set background to scence
        showcars.setBackground(new Background(myBI11));
        updatecar.setBackground(new Background(myBI1));
        deletecar.setBackground(new Background(myBI1));
        paymentcar.setBackground(new Background(myBI1));
        mainpanee.setBackground(new Background(myBI1));
        newcustomerrr.setBackground(new Background(myBI1));
        regularcutomer.setBackground(new Background(myBI1));

        //create and set label with style
        Label main = new Label("main menu");
        main.setLayoutX(170);
        main.setLayoutY(5);
        main.setFont(Font.font("Verdana", 25));
        main.setStyle("-fx-background-color: yellow");
        //create button to show stored cars
        Button show = new Button("show stored cars");
        show.setLayoutX(50);
        show.setLayoutY(50);
        show.setFont(Font.font("Verdana", 15));
        show.setStyle("-fx-background-color: DARKORANGE");
        show.setTextFill(Color.BLACK);
        //create button to logout of application
        Button b1 = new Button("log out");
        b1.setFont(Font.font("Verdana", 15));
        b1.setLayoutX(420);
        b1.setLayoutY(10);
        b1.setStyle("-fx-background-color: red");
        //create button to add cars
        Button add = new Button("Add cars");
        add.setLayoutX(300);
        add.setLayoutY(50);
        add.setFont(Font.font("Verdana", 15));
        add.setStyle("-fx-background-color: DARKORANGE");
        //create button to delete cars
        Button delete = new Button("delete cars");
        delete.setLayoutX(80);
        delete.setLayoutY(120);
        delete.setFont(Font.font("Verdana", 15));
        delete.setStyle("-fx-background-color: DARKORANGE");
        //create button to buy cars
        Button payment = new Button("payment");
        payment.setLayoutX(310);
        payment.setLayoutY(120);
        payment.setFont(Font.font("Verdana", 15));
        payment.setStyle("-fx-background-color: DARKORANGE");
        //create button back to return to the previous scence
        Button back = new Button("back");
        back.setLayoutX(5);
        back.setLayoutY(5);
        back.setStyle("-fx-background-color: DARKORANGE");
        back.setFont(Font.font("Verdana", 15));
        Button back2 = new Button("back");
        back2.setLayoutX(5);
        back2.setLayoutY(5);
        back2.setStyle("-fx-background-color: DARKORANGE");
        back2.setFont(Font.font("Verdana", 15));
        Button back3 = new Button("back");
        back3.setLayoutX(5);
        back3.setLayoutY(5);
        back3.setStyle("-fx-background-color: DARKORANGE");
        back3.setFont(Font.font("Verdana", 15));
        Button back4 = new Button("back");
        back4.setLayoutX(5);
        back4.setLayoutY(5);
        back4.setStyle("-fx-background-color: DARKORANGE");
        back4.setFont(Font.font("Verdana", 15));
        //create combox to add cars from database
        ComboBox comboBox = new ComboBox(options);
        // comboBox.setMaxHeight(50);
        comboBox.setEditable(false);

        comboBox.setValue("please choose model");
        comboBox.setLayoutX(300);
        comboBox.setLayoutY(50);

        //add cars method in HBox
        HBox cars = new HBox();
        Label one = new Label("Enter car name:");
        one.setFont(Font.font("Verdana", 20));
        one.setTextFill(Color.WHITE);
        one.setStyle("-fx-background-color: DARKORANGE");

        TextField addcars = new TextField();
        cars.getChildren().add(one);
        cars.getChildren().add(addcars);
        cars.setLayoutX(20);
        cars.setLayoutY(40);
        cars.setSpacing(25);
        // cars model year
        HBox cars2 = new HBox();
        Label two = new Label("Enter model year:");
        two.setFont(Font.font("Verdana", 20));
        two.setStyle("-fx-background-color: DARKORANGE");
        two.setTextFill(Color.WHITE);
        TextField addcarss = new TextField();
        cars2.getChildren().add(two);
        cars2.getChildren().add(addcarss);
        cars2.setLayoutX(20);
        cars2.setLayoutY(70);
        cars2.setSpacing(5);
        //cars colors
        HBox cars3 = new HBox();
        Label three = new Label("Enter car Colors:");
        three.setFont(Font.font("Verdana", 20));
        three.setStyle("-fx-background-color: DARKORANGE");
        three.setTextFill(Color.WHITE);
        TextField caro = new TextField();
        cars3.getChildren().add(three);
        cars3.getChildren().add(caro);
        cars3.setLayoutX(20);
        cars3.setLayoutY(100);
        cars3.setSpacing(20);
        //cars quantity
        HBox cars4 = new HBox();
        Label four = new Label("Enter car quantity:");
        four.setFont(Font.font("Verdana", 20));
        four.setStyle("-fx-background-color: DARKORANGE");
        four.setTextFill(Color.WHITE);
        TextField caroo = new TextField();
        cars4.getChildren().add(four);
        cars4.getChildren().add(caroo);
        cars4.setLayoutX(20);
        cars4.setLayoutY(130);
        cars4.setSpacing(3);
        //cars price
        HBox cars5 = new HBox();
        Label five = new Label("Enter car Price:");
        five.setFont(Font.font("Verdana", 20));
        five.setStyle("-fx-background-color: DARKORANGE");
        five.setTextFill(Color.WHITE);
        TextField carooo = new TextField();
        cars5.getChildren().add(five);
        cars5.getChildren().add(carooo);
        cars5.setLayoutX(20);
        cars5.setLayoutY(160);
        cars5.setSpacing(35);
        //create button add to save new cars to database
        Button bmwbutton = new Button("Save");
        bmwbutton.setLayoutX(200);
        bmwbutton.setLayoutY(200);
        bmwbutton.setFont(Font.font("Verdana", 15));
        bmwbutton.setStyle("-fx-background-color: DARKORANGE");
        bmwbutton.setTextFill(Color.WHITE);

        //set action on button add and connect with db
        bmwbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    String carname = addcars.getText();
                    int carmodel = Integer.parseInt(addcarss.getText());
                    String carco = caro.getText();
                    int carqu = Integer.parseInt(caroo.getText());
                    int carprice = Integer.parseInt(carooo.getText());
                    boolean isadd = go.runNonquery(carname, carmodel, carco, carqu, carprice);
                    if (isadd) {
                        JOptionPane.showMessageDialog(null, "Car added");

                    } else {
                        JOptionPane.showMessageDialog(null, "not added");
                    }
                } catch (Exception e) {

                }
                //set fields empty
                addcars.clear();
                addcarss.clear();
                caro.clear();
                caroo.clear();
                carooo.clear();

            }

        });

        //add hbox to scence
        updatecar.getChildren().add(cars);
        updatecar.getChildren().add(cars2);
        updatecar.getChildren().add(cars3);
        updatecar.getChildren().add(cars4);
        updatecar.getChildren().add(cars5);
        updatecar.getChildren().add(bmwbutton);

        //create Hbox to with label and textfiled to show cars
        HBox sho = new HBox();
        Label namee = new Label("Car Name:");
        namee.setTextFill(Color.DARKORANGE);
        namee.setFont(Font.font("Verdana", 20));
        TextField name = new TextField();
        sho.setLayoutX(10);
        sho.setLayoutY(140);
        sho.setSpacing(5);
        name.setEditable(false);
        HBox sho1 = new HBox();
        Label nameee = new Label("Car Model:");
        nameee.setTextFill(Color.DARKORANGE);
        nameee.setFont(Font.font("Verdana", 20));
        TextField model = new TextField();
        model.setEditable(false);
        sho1.setLayoutX(10);
        sho1.setLayoutY(170);
        sho1.setSpacing(5);
        HBox sho2 = new HBox();
        Label nn = new Label("COLORS  :");
        nn.setTextFill(Color.DARKORANGE);
        nn.setFont(Font.font("Verdana", 20));
        TextField mm = new TextField();
        mm.setEditable(false);
        sho2.setLayoutX(10);
        sho2.setLayoutY(200);
        sho2.setSpacing(7);
        HBox sho3 = new HBox();
        Label aa = new Label("Quantity  :");
        aa.setTextFill(Color.DARKORANGE);
        aa.setFont(Font.font("Verdana", 20));
        TextField ss = new TextField();
        ss.setEditable(false);
        sho3.setLayoutX(10);
        sho3.setLayoutY(230);
        sho3.setSpacing(5);
        HBox sho4 = new HBox();
        Label gg = new Label("Price    :");
        gg.setTextFill(Color.DARKORANGE);
        gg.setFont(Font.font("Verdana", 20));
        TextField ff = new TextField();
        ff.setEditable(false);
        sho4.setLayoutX(10);
        sho4.setLayoutY(260);
        sho4.setSpacing(30);
        //set action on combobox to recieve data from database and filter it
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String q = "select * from cars where carName=? ";
                    PreparedStatement st = con.prepareStatement(q);
                    st.setString(1, (String) comboBox.getValue());
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        name.setText(rs.getString("carName"));
                        model.setText(rs.getString("modelnumber"));
                        mm.setText(rs.getString("CARCOLOR"));
                        ss.setText(rs.getString("CARQUANTITY"));
                        ff.setText(rs.getString("CARPRICE") + "LE");

                    }
                } catch (SQLException e) {

                }
            }

        });
        //create buttons to add new custumer in payment scence
        Button newcustomer = new Button("new cutomer");
        newcustomer.setLayoutX(90);
        newcustomer.setLayoutY(120);
        newcustomer.setStyle("-fx-background-color: DARKORANGE");
        newcustomer.setFont(Font.font("Verdana", 15));
        //create buuton to go to payment bill window
        Button regular = new Button("payment bill");
        regular.setLayoutX(230);
        regular.setLayoutY(120);
        regular.setStyle("-fx-background-color: DARKORANGE");
        regular.setFont(Font.font("Verdana", 15));
        //create button back to return to previous window
        Button back5 = new Button("back");
        back5.setLayoutX(5);
        back5.setLayoutY(5);
        back5.setStyle("-fx-background-color: DARKORANGE");
        back5.setFont(Font.font("Verdana", 15));
        //create button back to return to previous window
        Button back6 = new Button("back");
        back6.setLayoutX(5);
        back6.setLayoutY(5);
        back6.setStyle("-fx-background-color: DARKORANGE");
        back6.setFont(Font.font("Verdana", 15));
        //create button save to save information and set style
        Button savenewcustomer = new Button("save");
        savenewcustomer.setLayoutX(220);
        savenewcustomer.setLayoutY(200);
        savenewcustomer.setStyle("-fx-background-color: DARKORANGE");
        savenewcustomer.setTextFill(Color.WHITE);
        savenewcustomer.setFont(Font.font("Verdana", 15));

        //set component in hbox to save customer info
        HBox savefname = new HBox();
        Label cname = new Label("Enter first name:");
        cname.setFont(Font.font("Verdana", 20));
        cname.setTextFill(Color.WHITE);
        cname.setStyle("-fx-background-color: DARKORANGE");

        TextField savenamefield = new TextField();
        savefname.getChildren().add(cname);
        savefname.getChildren().add(savenamefield);
        savefname.setLayoutX(20);
        savefname.setLayoutY(40);
        savefname.setSpacing(46);
        // cars model year
        HBox savelastname = new HBox();
        Label fnmane = new Label("Enter last name:");
        fnmane.setFont(Font.font("Verdana", 20));
        fnmane.setStyle("-fx-background-color: DARKORANGE");
        fnmane.setTextFill(Color.WHITE);
        TextField lnametext = new TextField();
        savelastname.getChildren().add(fnmane);
        savelastname.getChildren().add(lnametext);
        savelastname.setLayoutX(20);
        savelastname.setLayoutY(70);
        savelastname.setSpacing(50);
        //cars colors
        HBox address = new HBox();
        Label addresslabel = new Label("Enter address:");
        addresslabel.setFont(Font.font("Verdana", 20));
        addresslabel.setStyle("-fx-background-color: DARKORANGE");
        addresslabel.setTextFill(Color.WHITE);
        TextField addresstext = new TextField();
        address.getChildren().add(addresslabel);
        address.getChildren().add(addresstext);
        address.setLayoutX(20);
        address.setLayoutY(100);
        address.setSpacing(70);
        //cars quantity
        HBox phonenumber = new HBox();
        Label phonelabel = new Label("Enter phone number:");
        phonelabel.setFont(Font.font("Verdana", 20));
        phonelabel.setStyle("-fx-background-color: DARKORANGE");
        phonelabel.setTextFill(Color.WHITE);
        TextField phonetext = new TextField();
        phonenumber.getChildren().add(phonelabel);
        phonenumber.getChildren().add(phonetext);
        phonenumber.setLayoutX(20);
        phonenumber.setLayoutY(130);
        phonenumber.setSpacing(3);
        //disscount code
        HBox code = new HBox();
        Label codelabel = new Label("Enter code:");
        codelabel.setFont(Font.font("Verdana", 20));
        codelabel.setStyle("-fx-background-color: DARKORANGE");
        codelabel.setTextFill(Color.WHITE);
        TextField codetext = new TextField();
        code.getChildren().add(codelabel);
        code.getChildren().add(codetext);
        code.setLayoutX(20);
        code.setLayoutY(160);
        code.setSpacing(100);
        //set action on button to save information to database

        savenewcustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String firstname = savenamefield.getText();
                    String lastname = lnametext.getText();
                    String addre = addresstext.getText();
                    int phone = Integer.parseInt(phonetext.getText());
                    String co = codetext.getText();
                    boolean isadd = go.customersave(firstname, lastname, addre, phone, co);
                    if (isadd) {
                        JOptionPane.showMessageDialog(null, "cutomer saved");

                    } else {
                        JOptionPane.showMessageDialog(null, "not added");
                    }
                } catch (Exception e) {

                }
                //set fields empty
                savenamefield.clear();
                lnametext.clear();
                addresstext.clear();
                phonetext.clear();
                codetext.clear();

            }

        });
        //create payment component and add in hbox
        HBox savebill = new HBox();
        TextField cartextfield = new TextField();
        cartextfield.setPromptText("Enter car name");
        TextField colortextfield = new TextField();
        colortextfield.setPromptText("Enter car color");
        TextField pricetextfield = new TextField();
        pricetextfield.setPromptText("Enter car price");
        savebill.setLayoutX(20);
        savebill.setLayoutY(50);
        savebill.setSpacing(10);
        savebill.getChildren().add(cartextfield);
        savebill.getChildren().add(colortextfield);
        savebill.getChildren().add(pricetextfield);
        Label subtotallabel = new Label("subtotal       :");
        subtotallabel.setFont(Font.font("Verdana", 20));
        subtotallabel.setStyle("-fx-background-color: DARKORANGE");
        subtotallabel.setTextFill(Color.WHITE);
        subtotallabel.setLayoutX(10);
        subtotallabel.setLayoutY(90);
        Label vatlabel = new Label("vat              :");
        vatlabel.setFont(Font.font("Verdana", 20));
        vatlabel.setStyle("-fx-background-color: DARKORANGE");
        vatlabel.setTextFill(Color.WHITE);
        vatlabel.setLayoutX(10);
        vatlabel.setLayoutY(120);
        Label totallabel = new Label("Total amount:");
        totallabel.setFont(Font.font("Verdana", 20));
        totallabel.setStyle("-fx-background-color: DARKORANGE");
        totallabel.setTextFill(Color.WHITE);
        totallabel.setLayoutX(10);
        totallabel.setLayoutY(150);
        Button savee = new Button("submit and save bill");
        savee.setLayoutX(200);
        savee.setLayoutY(200);
        savee.setStyle("-fx-background-color: DARKORANGE");
        savee.setTextFill(Color.WHITE);
        savee.setFont(Font.font("Verdana", 15));
//set action on save bill
        savee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                long pricecar = Integer.parseInt(pricetextfield.getText());
                subtotallabel.setText("subtotal       :" + pricecar + "LE");

                long vat;
                vat = pricecar * 14 / 100;
                //vat=vat*100;
                //vat = vat / 100;
                vatlabel.setText("vat              :" + vat + "LE");
                totallabel.setText("Total amount:" + (pricecar + vat) + "LE");
                PrintWriter output;
                String carnamebill = cartextfield.getText();
                String colorbill = colortextfield.getText();
                //save and print the bill
                try {
                    output = new PrintWriter("billNo.txt");
                    output.println("**************************************Welcome in our Store*******************************");
                    output.println("==============");

                    output.println("----");
                    output.println("car name:" + carnamebill);
                    output.println("car Color:" + colorbill);
                    output.println("subtotal:" + pricecar + "LE");
                    output.println("vat:" + vat + "LE");
                    output.println("Total amount:" + (pricecar + vat) + "LE");
                    output.println();
                    output.println("***Thank you for Visiting our Store ***");
                    output.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "not add");

                }

            }

        });
        HBox delett = new HBox();
        TextField deletetext = new TextField();

        Label delettlabel = new Label("Enter Car name:");
        delettlabel.setFont(Font.font("Verdana", 20));
        delettlabel.setStyle("-fx-background-color: DARKORANGE");
        delettlabel.setTextFill(Color.WHITE);
        delettlabel.setLayoutX(10);
        delettlabel.setLayoutY(150);
        delett.getChildren().add(delettlabel);
        delett.getChildren().add(deletetext);
        delett.setLayoutX(80);
        delett.setLayoutY(25);
        delett.setSpacing(10);
        Button dletebutton = new Button("Delete");
        dletebutton.setLayoutX(70);
        dletebutton.setLayoutY(200);
        dletebutton.setStyle("-fx-background-color: DARKORANGE");
        dletebutton.setTextFill(Color.WHITE);
        dletebutton.setFont(Font.font("Verdana", 15));

        dletebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String deleteee=deletetext.getText();
                boolean isdelete=go.deleted(deleteee);
                if(isdelete){
                         JOptionPane.showMessageDialog(null, "deleted");

                    
                }
                else{
                                             JOptionPane.showMessageDialog(null, " not ^deleted");

                    
                }
//                try {
//                    String query = "delete from cars where carName=?" + deletetext.getText();
//                    Statement stmt = con.prepareStatement(query);
//                    stmt.execute(query);
//                    JOptionPane.showMessageDialog(null, "deleted");
//
//                    stmt.close();
//                    con.close();
//
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, " not deleted");
//
//                }

            }

        });

        //add component to scene
        sho.getChildren().add(namee);
        sho.getChildren().add(name);
        sho1.getChildren().add(nameee);
        sho1.getChildren().add(model);
        sho2.getChildren().add(nn);
        sho2.getChildren().add(mm);
        sho3.getChildren().add(aa);
        sho3.getChildren().add(ss);
        sho4.getChildren().add(gg);
        sho4.getChildren().add(ff);

        showcars.getChildren().add(comboBox);
        showcars.getChildren().add(sho);
        showcars.getChildren().add(sho1);
        showcars.getChildren().add(sho2);
        showcars.getChildren().add(sho3);
        showcars.getChildren().add(sho4);

        paymentcar.getChildren().add(newcustomer);
        paymentcar.getChildren().add(regular);
        regularcutomer.getChildren().add(back6);
        regularcutomer.getChildren().add(savebill);
        regularcutomer.getChildren().add(subtotallabel);
        regularcutomer.getChildren().add(vatlabel);
        regularcutomer.getChildren().add(totallabel);
        regularcutomer.getChildren().add(savee);

        showcars.getChildren().add(back);
        updatecar.getChildren().add(back2);
        deletecar.getChildren().add(back3);
        deletecar.getChildren().add(delett);
        deletecar.getChildren().add(dletebutton);

        paymentcar.getChildren().add(back4);
        newcustomerrr.getChildren().add(back5);
        newcustomerrr.getChildren().add(savefname);
        newcustomerrr.getChildren().add(savelastname);
        newcustomerrr.getChildren().add(address);
        newcustomerrr.getChildren().add(phonenumber);
        newcustomerrr.getChildren().add(code);

        newcustomerrr.getChildren().add(savenewcustomer);

        mainpanee.getChildren().add(show);
        mainpanee.getChildren().add(add);
        mainpanee.getChildren().add(delete);
        mainpanee.getChildren().add(payment);
        mainpanee.getChildren().add(main);
        mainpanee.getChildren().add(b1);
        //craete username and password
        HBox h = new HBox();
        Label l = new Label("User name");
        l.setTextFill(Color.DARKORANGE);
        l.setFont(Font.font("Verdana", 20));
        TextField f = new TextField();
        f.setPromptText("username");
        h.setLayoutX(100);
        h.setLayoutY(250);
        h.setSpacing(25);
        h.getChildren().add(l);
        h.getChildren().add(f);
        Label l2 = new Label("Car");
        l2.setFont(Font.font("Verdana", 100));
        l2.setTextFill(Color.DARKORANGE);
        l2.setLayoutX(250);
        l2.setLayoutY(10);
        Label l3 = new Label("Mangement System");
        l3.setFont(Font.font("Verdana", 30));
        l3.setLayoutX(195);
        l3.setLayoutY(120);
        l3.setTextFill(Color.DARKORANGE);
        HBox h1 = new HBox();
        Label l1 = new Label("Password");
        l1.setTextFill(Color.DARKORANGE);
        l1.setFont(Font.font("Verdana", 20));
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        h1.setLayoutX(100);
        h1.setLayoutY(280);
        h1.setSpacing(38);
        h1.getChildren().add(l1);
        h1.getChildren().add(passwordField);
        final Label lblMessage = new Label();
        lblMessage.setLayoutX(150);
        lblMessage.setLayoutY(350);
        lblMessage.setFont(Font.font("Verdana", 15));
        Button signin = new Button("sign in");
        signin.setStyle("-fx-background-color: DARKORANGE");
        signin.setLayoutX(250);
        signin.setLayoutY(320);
        signin.setTextFill(Color.WHITE);
        signin.setFont(Font.font("Verdana", 15));
        //login connection with database
        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String user = f.getText();
                    String pass = passwordField.getText();
                    boolean isloged = go.checkuserandpass(user, pass);
                    if (isloged) {
                        primaryStage.setScene(newscene);
                        primaryStage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username or password");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error");

                    f.requestFocus();

                }
                //set fields empty
                f.clear();
                passwordField.clear();
                f.setText("");
                passwordField.setText("");
            }
        });
        //set background to scene
        Pane mainpane = new Pane();
        BackgroundImage myBI = new BackgroundImage(new Image("1920x1440_A189584_large.jpg", 500, 500, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //add image to scene
        Image image = new Image("585e4bcdcb11b227491c3396.png");
        ImageView k = new ImageView(image);
        k.setFitHeight(20);
        k.setFitWidth(20);
        k.setLayoutX(210);
        k.setLayoutY(250);
        Image imagek = new Image("unnamed.png");
        ImageView m = new ImageView(imagek);
        m.setFitHeight(30);
        m.setFitWidth(30);
        m.setLayoutX(195);
        m.setLayoutY(275);
        Image imagekk = new Image("unnamed (1).png");
        ImageView t = new ImageView(imagekk);
        t.setFitHeight(200);
        t.setFitWidth(200);
        t.setLayoutX(5);
        t.setLayoutY(20);
        Image bmwimage = new Image("bmw-png--2415.png");
        ImageView bm = new ImageView(bmwimage);
        bm.setFitHeight(100);
        bm.setFitWidth(250);
        bm.setLayoutX(10);
        bm.setLayoutY(30);

        //add component to scene
        showcars.getChildren().add(bm);
        mainpane.getChildren().add(t);
        mainpane.getChildren().add(k);
        mainpane.getChildren().add(m);
        mainpane.setBackground(new Background(myBI));
        mainpane.getChildren().add(h);
        mainpane.getChildren().add(l2);
        mainpane.getChildren().add(l3);
        mainpane.getChildren().add(h1);
        mainpane.getChildren().add(signin);
        mainpane.getChildren().add(lblMessage);
        Scene scene = new Scene(mainpane, 500, 500);
        //add buttons back to scene
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });
        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(showcarscene);
                primaryStage.show();
            }
        });
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(updatecarscence);
                primaryStage.show();
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(deletecarsscene);
                primaryStage.show();
            }
        });
        payment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(paymentscene);
                primaryStage.show();
            }
        });
        //add back button
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(newscene);
                primaryStage.show();
            }
        });
        back2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(newscene);
                primaryStage.show();
            }
        });
        back3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(newscene);
                primaryStage.show();
            }
        });
        back4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(newscene);
                primaryStage.show();
            }
        });
        newcustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(newscustomerr);
                primaryStage.show();
            }
        });
        regular.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(regularcutomerr);
                primaryStage.show();
            }
        });
        back5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(paymentscene);
                primaryStage.show();
            }
        });
        back6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(paymentscene);
                primaryStage.show();
            }
        });

        //name,set icon and show scene
        primaryStage.setTitle("car agency");
        primaryStage.getIcons().add(new Image("unnamed (1).png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
