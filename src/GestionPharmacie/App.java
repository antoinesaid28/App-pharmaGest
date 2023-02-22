package GestionPharmacie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

import java.util.Scanner;

public class App extends Application {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        // insertUsersDataByConsol();

        launch(args);

    }

    public static void insertUsersDataByConsol() throws SQLException {
        boolean willContinue = true;

        // start of the program
        System.out.println("Voici un exemple :");
        while (willContinue) {
            System.out.println(
                    "Que voulais vous faire? (Appuyer A => Ajouter, U => update, D=>delete, L => Users-List, Q=>quit");
            char choice = scanner.nextLine().charAt(0);

            // choose mode
            CRUDMode mode = choice == 'A' ? CRUDMode.ADD
                    : choice == 'U' ? CRUDMode.UPDATE
                            : choice == 'D' ? CRUDMode.DELETE
                                    : choice == 'Q' ? CRUDMode.QUIT
                                            : choice == 'L' ? CRUDMode.LISTALLSTUDENTS : CRUDMode.INVALID;

            switch (mode) {
                case ADD:
                    System.out.println("Add!");
                    System.out.println("Mon choix est " + CRUDMode.ADD.CRUDModeNme);
                    System.out.println("Le numero d'énumération est  " + CRUDMode.ADD.ordinal());

                    System.out.println("Le Type choisie = est : " + CRUDMode.ADD.valueOf("ADD"));

                    DBUtil.addPharmacien(retrieveInput(mode));

                    break;
                case UPDATE:
                    System.out.println("Update!");
                    DBUtil.updatePharmacien(retrieveInput(mode));
                    break;
                case DELETE:
                    System.out.println("Delete!");
                    DBUtil.deletePharmacien(retrieveInput(mode));
                    break;
                case QUIT:
                    System.out.println("GoodBye!");
                    willContinue = false;
                    break;
                case LISTALLSTUDENTS:
                    System.out.println("List of Students:");
                    System.out.println(DBUtil.getAllPharmacien());
                    break;
                case INVALID:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    private static Pharmacien retrieveInput(CRUDMode mode) {
        Pharmacien pharmacien = new Pharmacien();

        System.out.println("Fill up details:");

        /*
         * This is redundant. Is there a better way of doing this?
         * Please refactor the way input is being done
         * Leave the return statement as is
         */
        if (mode.equals(CRUDMode.ADD) || mode.equals(CRUDMode.UPDATE)) {

            if (mode.equals(CRUDMode.UPDATE)) {
                System.out.println("Id:");
                pharmacien.setIdPharmacien(scanner.nextInt());
            }
            // System.out.println("Id:");
            // pharmacien.setIdPharmacien(scanner.nextInt());

            System.out.println("Nom:");
            pharmacien.setNom(scanner.nextLine());

            System.out.println("Prénom:");
            pharmacien.setPrenom(scanner.nextLine());

            System.out.println("Fonction:");
            pharmacien.setFonction(scanner.nextLine());

            System.out.println("Adresse:");
            pharmacien.setAdresse(scanner.nextLine());

            System.out.println("Telephone:");
            pharmacien.setTelephone(scanner.nextLine());

            System.out.println("Mail:");
            pharmacien.setMail(scanner.nextLine());

            System.out.println("Password:");
            pharmacien.setPassword(scanner.nextLine());

        } else if (mode.equals(CRUDMode.DELETE)) {
            System.out.println("Id:");
            pharmacien.setIdPharmacien(scanner.nextInt());
        }
        return pharmacien;
    }

    double X, Y = 8;

    @Override
    public void start(Stage dashboardStage) throws Exception {

        Parent DashboardFrame = FXMLLoader.load(
                // getClassLoader().
                getClass().getResource(
                        "JFx/Controlleurs/Inscription.fxml"));
                        //"DashboardFrame.fxml"));

       /* dashboardStage.initStyle(StageStyle.UNDECORATED);
        DashboardFrame.setOnMousePressed(Event -> {
            X = Event.getSceneX();
            Y = Event.getSceneY();
        });
        DashboardFrame.setOnMouseDragged(Event -> {
            dashboardStage.setX(Event.getScreenX() - X);
            dashboardStage.setX(Event.getScreenY() - Y);
        });*/
        Scene scene = new Scene(DashboardFrame);
        dashboardStage.setTitle("Dashboard Pharmacy");
        dashboardStage.setScene(scene);
        dashboardStage.setResizable(false);
        dashboardStage.centerOnScreen();
        dashboardStage.show();

        // Parent RegisterFrame = FXMLLoader.load(
        // // getClassLoader().
        // getClass().getResource(
        // "DashboardFrame.fxml"));
        // Scene scene = new Scene(RegisterFrame);
        // RegisterPage.setTitle("Dashboard Pharmacy "); /* Connexion / Inscription */
        // RegisterPage.setScene(scene);
        // RegisterPage.setResizable(false);
        // RegisterPage.centerOnScreen();
        // RegisterPage.show();

        // Parent authentification = FXMLLoader.load(
        // // getClassLoader().
        // getClass().getResource(
        // "ConnectFrame.fxml"));
        // Scene scene = new Scene(authentification);
        // connexionPage.setTitle("page de Connexion");
        // connexionPage.setScene(scene);
        // connexionPage.setResizable(false);
        // connexionPage.centerOnScreen();
        // connexionPage.show();

    }
}
