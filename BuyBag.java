package projectoop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Person{  
    protected String name; 
    
    Person(){  //Default constructor for Person class    
    }
    
    Person(String name){ //Constructor with name as argument
        this.name = name;
    }
    
    public String getName(){ //get Person's name
        return name;
    }
}

class Bag extends Person{
    double price;
    String brand,color;

    Bag(){   //Default constructor Bag   
    }
    
    Bag(String brand, String color, double price) { //Constructor Bag with brand, colour and price as arguments
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() { //get brand of the bag
        return brand;
    }
    
    public double getPrice() { // get price of the bag
        return price;
    }   

    public String getColor() { //get colour of the bag
        return color;
    }
}

class DiscountedBag extends Bag{

    private double discount;

    public DiscountedBag() { //Default constructor for DiscountedBag
}
    public DiscountedBag(double discount) { //Constructor with discount as argument   
        this.discount = discount;
    }   
    public DiscountedBag(int discount) { //Overloading method   
        this.discount = discount;
    } 
    
    public double getDiscount() { //get discount
        return discount;
    }
}

public class BuyBag extends Application { //Make GUI to BuyBag using JavaFX
    double price, newprice;
    
    @Override
    public void start(Stage primaryStage) {
        
        Bag[] bags = new Bag[12]; //Store all the bag data in 12 Arrays
        
        bags[0] = new Bag("Adidas","Black",120);
        bags[1] = new Bag("Nike", "Black", 135);
        bags[2] = new Bag("Puma", "Black", 140);
        bags[3] = new Bag("New Balance", "Black", 125);
        bags[4] = new Bag("Adidas","White",140);
        bags[5] = new Bag("Nike", "White", 155);
        bags[6] = new Bag("Puma", "White", 165);
        bags[7] = new Bag("New Balance", "White", 145);
        bags[8] = new Bag("Adidas", "Red", 110);
        bags[9] = new Bag("Nike", "Red", 125);
        bags[10] = new Bag("Puma", "Red", 130);
        bags[11] = new Bag("New Balance", "Red", 115);
        
        GridPane gridPane = new GridPane(); //Use gridPane to place all the nodes
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: BISQUE;");

        Label titleLabel = new Label("STYLOZ BAG");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        GridPane.setConstraints(titleLabel, 0, 0, 1, 1);

        Label nameLabel = new Label("Name :");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameTextField = new TextField();
        GridPane.setConstraints(nameTextField, 1, 1);

        Label BuyLabel = new Label("--- Buy Now ---");
        BuyLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        GridPane.setConstraints(BuyLabel, 0, 2, 2, 1);

        Label BagBrandLabel = new Label("Brand :");
        GridPane.setConstraints(BagBrandLabel, 0, 3);

        //Use combo box to select the brand
        ComboBox<String> cboBrand = new ComboBox<>();        
        cboBrand.getItems().addAll("Adidas", "Nike", "Puma", "New Balance");
        GridPane.setConstraints(cboBrand, 1, 3);

        Label colourtBagLabel = new Label("Colour :");
        GridPane.setConstraints(colourtBagLabel, 0, 4);

        //Use radio button to select the colour
        RadioButton rdBlack = new RadioButton("Black");
        RadioButton rdWhite = new RadioButton("White");
        RadioButton rdRed = new RadioButton("Red");
        ToggleGroup colourtBagToggleGroup = new ToggleGroup();
        rdBlack.setToggleGroup(colourtBagToggleGroup);
        rdWhite.setToggleGroup(colourtBagToggleGroup);
        rdRed.setToggleGroup(colourtBagToggleGroup);
        GridPane.setConstraints(rdBlack, 1, 4);
        GridPane.setConstraints(rdWhite, 2, 4);
        GridPane.setConstraints(rdRed, 3, 4);              
        
        Label priceLabel = new Label("Price :");
        GridPane.setConstraints(priceLabel, 0, 5);

        Label priceBagLabel = new Label(" ");
        GridPane.setConstraints(priceBagLabel, 1, 5);
        
        //Event handler when click the black radiobutton
        rdBlack.setOnAction(e -> {
                if (cboBrand.getValue().equals("Adidas")) {
                    priceBagLabel.setText("RM 120");
                    this.price = 120;
                    bags[0].getPrice();    
                    
                } else if(cboBrand.getValue().equals("Nike")) {
                    priceBagLabel.setText("RM 135");
                    this.price = 135;
                    bags[1].getPrice();                        
                }
                else if(cboBrand.getValue().equals("Puma")) {
                    priceBagLabel.setText("RM 140");
                    this.price = 140;
                    bags[2].getPrice();                        
                }
                else if(cboBrand.getValue().equals("New Balance")) {
                    priceBagLabel.setText("RM 125");
                    this.price = 125;
                    bags[3].getPrice();                        
                }
            });
        
        //Event handler when click the white radiobutton        
        rdWhite.setOnAction(e -> {
                if (cboBrand.getValue().equals("Adidas")) {
                    priceBagLabel.setText("RM 140");
                    this.price = 140;
                    bags[4].getPrice();    
                   
                } else if(cboBrand.getValue().equals("Nike")) {
                    priceBagLabel.setText("RM 155");
                    this.price = 155;
                    bags[5].getPrice();                        
                }
                else if(cboBrand.getValue().equals("Puma")) {
                    priceBagLabel.setText("RM 165");
                    this.price = 165;
                    bags[6].getPrice();                        
                }
                else if(cboBrand.getValue().equals("New Balance")) {
                    priceBagLabel.setText("RM 145");
                    this.price = 145;
                    bags[7].getPrice();    
                    
                }
            });
        
        //Event handler when click the red radiobutton       
        rdRed.setOnAction(e -> {
                if (cboBrand.getValue().equals("Adidas")) {
                    priceBagLabel.setText("RM 110");
                    this.price = 110;
                    bags[8].getPrice();                        
                }
                else if(cboBrand.getValue().equals("Nike")) {
                    priceBagLabel.setText("RM 125");
                    this.price = 125;
                    bags[9].getPrice();                        
                }
                else if(cboBrand.getValue().equals("Puma")) {
                    priceBagLabel.setText("RM 130");
                    this.price = 130;
                    bags[10].getPrice();                        
                }
                else if(cboBrand.getValue().equals("New Balance")) {
                    priceBagLabel.setText("RM 115");
                    this.price = 115;
                    bags[11].getPrice();                        
                }
            });
        
        Label paymentLabel = new Label("Payment method :");       
        GridPane.setConstraints(paymentLabel, 0, 6);
        
        //Use combo box to select type of payment
        ComboBox<String> cboPayment = new ComboBox<>();
        cboPayment.getItems().addAll("Cash", "Credit Card");
        GridPane.setConstraints(cboPayment, 1, 6);
 
        Label discountLabel = new Label("Discount :");
        GridPane.setConstraints(discountLabel, 0, 7);
        
        Label discountBagLabel = new Label(" ");
        GridPane.setConstraints(discountBagLabel, 1, 7);

        Label NpriceLabel = new Label("New Price :");
        GridPane.setConstraints(NpriceLabel, 0, 8);
        
        Label NpriceBagLabel = new Label(" ");
        GridPane.setConstraints(NpriceBagLabel, 1, 8);
               
                
        cboPayment.setOnAction(e -> {
                String selectedPayment = cboPayment.getSelectionModel().getSelectedItem();
                if (selectedPayment != null) {
                    if (selectedPayment.equals("Cash")) {
                        discountBagLabel.setText("15%");
                        newprice = price * (1 - 0.15); //Calculate the price after discount 15%
                        NpriceBagLabel.setText("RM " +newprice);
                        
                    } else if (selectedPayment.equals("Credit Card")) {
                        discountBagLabel.setText("5%");
                        newprice = price * (1 - 0.05); //Calculate the price after discount 5%
                        NpriceBagLabel.setText("RM " +newprice);
                    }
                }
            });        
        
        //Make each column width 20 pixels
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(20);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(20);

        Button DoneButton = new Button("Done"); //This button will open a new Stage 
        DoneButton.setOnAction(e -> {
            
            if (nameTextField.getText().isEmpty() || cboBrand.getValue() == null ||
            (!rdBlack.isSelected() && !rdWhite.isSelected() && !rdRed.isSelected()) ||
            cboPayment.getValue() == null) {            
            //Error Stage will pop out
            Stage tqStage = new Stage();
            Text tqText = new Text("Please Fill in All the Required Information!");
            VBox tqLayout = new VBox(tqText);
            tqLayout.setAlignment(Pos.CENTER);
            tqText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            tqLayout.setStyle("-fx-background-color: POWDERBLUE;");
            Scene thankYouScene = new Scene(tqLayout, 500, 100);
            tqStage.setScene(thankYouScene);
            tqStage.setTitle("Error");
            tqStage.show();
            } 
            
            else {    
            //Close the primaryStage
            primaryStage.hide(); 
            //Thank You Stage will pop out
            Stage tqStage = new Stage();
            Text tqText = new Text("Thank You " +nameTextField.getText()+ " :) \nPlease come again !");
            VBox tqLayout = new VBox(tqText);
            tqLayout.setAlignment(Pos.CENTER);
            tqText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            tqLayout.setStyle("-fx-background-color: POWDERBLUE;");
            Scene thankYouScene = new Scene(tqLayout, 500, 200);
            tqStage.setScene(thankYouScene);
            tqStage.setTitle("Thank You");
            tqStage.show();
            }
            
            
            
        });
        GridPane.setConstraints(DoneButton, 2, 10);
       

        Button resetButton = new Button("Reset"); //This button will reset all the data
        resetButton.setOnAction(e -> {
            nameTextField.clear();
            cboBrand.getSelectionModel().clearSelection();
            cboPayment.getSelectionModel().clearSelection();
            rdBlack.setSelected(false);
            rdWhite.setSelected(false);
            rdRed.setSelected(false);
            priceBagLabel.setText("");
            discountBagLabel.setText("");
            NpriceBagLabel.setText("");
        });
        
        GridPane.setConstraints(resetButton, 1, 10);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);
        gridPane.getChildren().addAll(
                titleLabel, nameLabel, nameTextField, BuyLabel, BagBrandLabel, cboBrand, 
                colourtBagLabel,rdBlack, rdWhite, rdRed, cboPayment, priceLabel, priceBagLabel,
                paymentLabel ,NpriceLabel, discountLabel,discountBagLabel, NpriceBagLabel, resetButton, DoneButton
        );

        
        Scene scene = new Scene(gridPane,700,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BAG");
        primaryStage.show();
    }

    public static void main(String[] args) { //Use to run the program
        launch(args);
    }
    
    
}

