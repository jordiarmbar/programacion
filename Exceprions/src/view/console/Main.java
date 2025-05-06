/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import exceptions.InvalidDateException;
import exceptions.InvalidIdException;
import java.util.Scanner;
import model.validations.UserDataValidations;

/**
 *
 * @author jordiarmbar
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        do {
            System.out.println("1.- Tester checkId");
            System.out.println("2.- Tester checkFormatDate");
            System.out.println("3.- Tester calculateAge");
            System.out.println("4.- Tester checkPostalCode");
            System.out.println("5.- Tester isNumeric");
            System.out.println("6.- Tester isAlphabetic");
            System.out.println("7.- Tester checkEmail");
            System.out.println("8.- Tester checkName");
            System.out.println("Z - Salir");

            System.out.println("Option:  ");
            option = sc.next();
            System.out.println(" ");

            switch (option) {
                case "1":
                    TestCheckId();
                    break;
                case "2":
                    TestcheckFormatDate();
                    break;

                case "3":
                    TestcalculateAge();
                    break;

                case "4":
                    TestcheckPostalCode();
                    break;

                case "5":
                    TestisNumeric();
                    break;

                case "6":
                    TestisAlphabetic();
                    break;

                case "7":
                    TestcheckEmail();
                    break;

                case "8":
                    TestcheckName();
                    break;

                default:
                    System.out.println("Incorrect error");
                    ;
            }
        } while (!option.equals("Z"));
    }

    static void TestCheckId() {
        System.out.println("NIF validator");
        System.out.print("Enter your id: ");
        String nif = sc.next();

        try {
            UserDataValidations.checkId(nif);
            System.out.println("Correct ID");
        } catch (InvalidIdException ex) {
            System.out.println("Incorrect ID: " + ex.getMessage());
        }
    }

    static void TestcheckFormatDate() {
        System.out.print("Enter a date (dd/mm/yyyy): ");
        String date = sc.next();

        try {
            UserDataValidations.checkFormatDate(date);
            System.out.println("Correct validation");
        } catch (InvalidDateException ex) {
            System.out.println("Incorrect validation: " + ex.getMessage());
        }
    }

    static void TestcalculateAge() {
        System.out.print("Enter a date (dd/mm/yy): "); //Pedimos al usuario que escriba una fecha
        String birthDate = sc.next();
        int final_age = UserDataValidations.calculateAge(birthDate); //Cogemos el boolean devuelto de la otra función

        System.out.println("You have " + final_age + " year/s"); //Imprimimos la edad del usuario.
        System.out.println(" ");
    }

    static void TestcheckPostalCode() {
        System.out.print("Enter a zip code (#####): "); //Pedimos al usuario que ingrese un código postal
        String zip = sc.next();
        boolean zipOk = UserDataValidations.checkPostalCode(zip); //Cogemos el boolean devuelto de la otra función

        if (zipOk) { //Comprobamos si el código postal es válido
            System.out.println("Your zip code is correct");
            System.out.println(" ");

        } else {
            System.out.println("Your zip code is incorrect");
            System.out.println(" ");

        }

    }

    static void TestisNumeric() {
        System.out.print("Enter a String: "); //Pedimos al usuario que ingrese un String
        String str = sc.next();
        boolean strOk = UserDataValidations.isNumeric(str); //Cogemos el boolean devuelto de la otra función

        if (strOk) { //Comprobamos si la cadena es numérica o no
            System.out.println("Your String is numeric");
            System.out.println(" ");
        } else {
            System.out.println("Your String is not numeric");
            System.out.println(" ");
        }

    }

    static void TestisAlphabetic() {
        System.out.print("Enter a String: "); //Pedimos al usuario que introduzca un String
        String str = sc.next();
        boolean strOk = UserDataValidations.isAlphabetic(str); //Cogemos el boolean devuelto de la otra función

        if (strOk) { //Comprobamos si el String tiene solo carácteres o no
            System.out.println("Your String has only characters");
            System.out.println(" ");
        } else {
            System.out.println("Your String hasn't characters");
            System.out.println(" ");
        }

    }

    static void TestcheckEmail() {
        System.out.print("Enter an email: "); //Pedimos al usuario que introduzca un email
        String email = sc.next();
        boolean emailOk = UserDataValidations.checkEmail(email); //Cogemos el boolean devuelto de la otra función

        if (emailOk) { //Comprobar si el email es correcto o no
            System.out.println("Your email is correct");
            System.out.println(" ");
        } else {
            System.out.println("Your email is incorrect");
            System.out.println(" ");
        }

    }

    static void TestcheckName() {
        System.out.println("Write your name: "); //Pedimos al usuario que introduzca un nombre
        String name = sc.next();
        boolean nameOk = UserDataValidations.checkName(name); //Cogemos el boolean devuelto de la otra función

        if (nameOk) { //Comprobamos si el nombre es correcto o no
            System.out.println("Your name is correct");
            System.out.println(" ");
        } else {
            System.out.println("Your name is incorrect");
            System.out.println(" ");
        }
    }
}


