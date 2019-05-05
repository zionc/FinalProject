//package worldcup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

@SuppressWarnings("Duplicates")

public class WorldCupSimulation extends Application {
    
    Scene scene1;
    Scene scene2;
    Scene scene3;

    @Override
    public void start(Stage primaryStage) {
        FileInitializer fz = new FileInitializer();


        Regions region = new Regions();

        region.setAmericas(new League("CONCACAF",fz.getRegionTeams("CONCACAF")));
        region.setAfrica(new League("CAF",fz.getRegionTeams("CAF")));
        region.setAsia(new League("AFC",fz.getRegionTeams("AFC")));
        region.setEurope(new League("UEFA",fz.getRegionTeams("UEFA")));
        region.setOceania(new League("OFC",fz.getRegionTeams("OFC")));
        region.setSouthAmerica(new League("CONMEBOL",fz.getRegionTeams("CONMEBOL")));

        System.out.println(region.getAsia().toString());

        HBox main = new HBox();
        TabPane tabs = new TabPane();
        Paint mainPaint = Color.DARKGREEN;
        main.setBackground(new Background(new BackgroundFill(mainPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        Paint mainBorderPaint = Color.BLACK;
        double mainBorderWidth = 1;
        main.setBorder(new Border(new BorderStroke(mainBorderPaint,
                                                   BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(mainBorderWidth))));

        /*
         * WELCOME PAGE TABS AND TABLES
         */
        Tab concacafTab = createTab(region.getAmericas().getName(),region.getAmericas());
        Tab conmebolTab = createTab(region.getAmericas().getName(),region.getSouthAmerica());
        Tab uefaTab = createTab(region.getEurope().getName(),region.getEurope());
        Tab cafTab = createTab(region.getAmericas().getName(),region.getAfrica());
        Tab afcTab = createTab(region.getAsia().getName(),region.getAsia());
        Tab ofcTab = createTab(region.getAfrica().getName(),region.getOceania());

        tabs.getTabs().addAll(concacafTab,conmebolTab,uefaTab,cafTab,afcTab,ofcTab );
        tabs.setPrefWidth(800);

        /*
         * BRACKET
         */
        BracketPane bp = new BracketPane();
        
        bp.addTeam("test1");
        bp.addTeam("test2");
        bp.addTeam("test3");
        bp.addTeam("test4");
        bp.addTeam("test5");
        bp.addTeam("test6");
        bp.addTeam("test7");
        bp.addTeam("test8");
        bp.addTeam("test9");
        bp.addTeam("test10");
        bp.addTeam("test11");
        bp.addTeam("test12");
        bp.addTeam("test13");
        bp.addTeam("test14");
        bp.addTeam("test15");
        bp.addTeam("test16");
        bp.addTeam("test17");
        bp.addTeam("test18");
        bp.addTeam("test19");
        bp.addTeam("test20");
        bp.addTeam("test21");
        bp.addTeam("test22");
        bp.addTeam("test23");
        bp.addTeam("test24");
        bp.addTeam("test25");
        bp.addTeam("test26");
        bp.addTeam("test27");
        bp.addTeam("test28");
        bp.addTeam("test29");
        bp.addTeam("test30");
        bp.addTeam("test31");
        bp.addTeam("test32");
        bp.addTeam("test33");
        bp.addTeam("test34");
//        bp.display();
        Button start = new Button();
        Paint startPaint = Color.HOTPINK;
        start.setBackground(new Background(new BackgroundFill(startPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        start.setFont(new Font(15));
        start.setText("Start Simulation");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(new Scene(bp, 700, 1100));
                primaryStage.setMaximized(true);
            }
        });
                InfoBox iq = new InfoBox();
        //iq.instructions();
        
        Button info = new Button();
        info.setText("Information");
        Paint infoPaint = Color.AQUA;
        info.setBackground(new Background(new BackgroundFill(infoPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        info.setFont(new Font(15));
        info.setOnAction(e -> iq.instructions());
        Button instructions = new Button();
        Paint instrPaint = Color.GOLD;
        instructions.setText("Instructions");
        instructions.setBackground(new Background(new BackgroundFill
                                                  (instrPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        instructions.setFont(new Font(15));
        Button close = new Button();
        Paint closePaint = Color.BISQUE;
        close.setText("End Program");
        close.setBackground(new Background(new BackgroundFill
                                           (closePaint, CornerRadii.EMPTY, Insets.EMPTY)));
        close.setFont(new Font(15));
        ToolBar startBar = new ToolBar(start, info, instructions, close);
        startBar.setOrientation(Orientation.VERTICAL);
        startBar.setOrientation(Orientation.VERTICAL);
        Paint backgroundPaint = Color.DARKGREEN;
        startBar.setBackground(new Background(new BackgroundFill
                                              (backgroundPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        Paint borderPaint = Color.BLACK;
        double borderWidth = .5;
        startBar.setBorder(new Border(new BorderStroke
                                      (borderPaint, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                                       new BorderWidths(borderWidth))));
        BorderPane startPage = new BorderPane();
//        startPage.setCenter(startBar);
        
        Label label2 = new Label("This is where the instructions go");
        Label label3 = new Label("This is where more info goes");
        


        BorderPane instructionPane = new BorderPane();
        instructionPane.setTop(instructions);
        
        BorderPane root = new BorderPane();
        Tab i = new Tab();
        i.setText("Navigation");
        
        i.setContent(instructionPane);
        
        Tab in = new Tab();
        in.setText("Information");
        in.setContent(label3);
        TabPane instructions2 = new TabPane(i, in);
        
        root.setCenter(instructions2);

        main.getChildren().addAll(startBar, tabs);

        Scene scene = new Scene(main, 800, 600);

       // scene1 = new Scene(root);
        //instructions.setOnAction(e -> primaryStage.setScene(scene1));
        primaryStage.setTitle("The World Cup");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        
        primaryStage.show();
    }

    public Tab createTab (String region,League l) {
        Tab tab = new Tab(region);
        tab.setClosable(false);



        TableColumn<Team, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Team, ArrayList> rankColumn = new TableColumn<>("Rank");
        rankColumn.setMinWidth(50);

        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));



        TableColumn<Team, String> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setMinWidth(50);
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableView<Team> table = new TableView<>();
        table.setItems(getTeams(region,l));
        table.getColumns().addAll(nameColumn, rankColumn, pointsColumn);
        table.getSortOrder().add(rankColumn);
        tab.setContent(table);

        return tab;
    }

    public ObservableList<Team> getTeams(String reg, League l) {


        if (reg.equals("CONCACAF")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else if (reg.equals("CONMEBOL")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else if (reg.equals("UEFA")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else if (reg.equals("CAF")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else if (reg.equals("AFC")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else if (reg.equals("OFC")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(l.getTeams());
            return teams;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}


