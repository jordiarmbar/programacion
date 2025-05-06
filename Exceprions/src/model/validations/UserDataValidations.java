/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import exceptions.InvalidIdException;
import exceptions.InvalidDateException;

/**
 *
 * @author jordiarmbar
 */
public class UserDataValidations {

       public static void checkId(String id) throws InvalidIdException {
        if (id.length() != 9) {
            throw new InvalidIdException("The ID must have 9 digits");
        }

        char letra = id.charAt(8);
        String numerosStr = id.substring(0, 8);

        int numeros;
        try {
            numeros = Integer.parseInt(numerosStr);
        } catch (NumberFormatException e) {
            throw new InvalidIdException("The first 8 digits must be numbers.");
        }

        char[] letrasValidas = {'T','R','W','A','G','M','Y','F','P','D','X','B',
                                'N','J','Z','S','Q','V','H','L','C','K','E'};

        if (letrasValidas[numeros % 23] != letra) {
            throw new InvalidIdException("The letter ID isn't valid.");
        }
    }
   

    public static void checkFormatDate(String date) throws InvalidDateException {
        String[] partes = date.split("/");

        if (partes.length != 3) {
            throw new InvalidDateException("Incorrect format. Use dd/mm/yyyy.");
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);

            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 0) {
                throw new InvalidDateException("Date out of range.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidDateException("The date must have only numbers.");
        }
    }


    public static int calculateAge(String birthDate) {

        String[] dateList = birthDate.split("/"); //Creamos una array para poner la fecha escrita por el usuario y usamos el comando .split() para separar los elementos de la lsta con "/"

        if (dateList.length == 3){
        String year = dateList[2]; //Con esta variable cogemos el año que está en la posición 2 del array y lo pasamos a int

        int int_year = Integer.parseInt(year);

        int final_age = 2025 - int_year; //Aquí hacemos el cálculo entre este año y el año escrito por el usuario

        return final_age; //Devolvemos el boolean al main
        } else {
            return -1;
        }
        
        

    }

    public static boolean checkPostalCode(String zip) {
        boolean zipOk = false;

        if (zip.length() == 5) { //Hacemos condiciones if para comprobar si el valor escrito por el susario tiene la cantidad de carácteres que 5 o no usando .length()
            zipOk = true;
        }
        if (zip.length() != 5) {
            zipOk = false;

        }
        return zipOk; //Devolvemos el boolean al main
    }

    public static boolean isNumeric(String str) {
        boolean strOk = false;

        try { //Usamos los comandos try y catch para probar la conversión del String a int y comprobar si se ha podido hacer o no, hacemos la conversion para comprobar si el String es numérico o no
            Integer.parseInt(str);
            strOk = true;
        } catch (NumberFormatException excepcion) {
            strOk = false;
        }
        return strOk; //Devolvemos el boolean al main
    }

    public static boolean isAlphabetic(String str) {
        boolean strOk = true;
        for (char letter : str.toCharArray()) { //Recorremos cada carácter de la cadena con un "for each"
            if (!Character.isLetter(letter)) { //Verificamos si el carácter no es una letra
                strOk = false;
                break;
            }
        }
        return strOk; //Devolvemos el boolean al main
    }

    public static boolean checkEmail(String email) {
        boolean emailOk = true;

        if (email.contains("@") && (email.contains(".com") || (email.contains(".org")) || (email.contains(".net")) || (email.contains(".es")))) { //Hacemos condiciones if para comprobar si el String ingresado por el usuario con tiene los siguientes carácteres
            emailOk = true;
        } else {
            emailOk = false;
        }
        return emailOk; //Devolvemos el boolean al main
    }

    public static boolean checkName(String name) {
        boolean nameOk = false;

        if ((name.length() > 20) || ((name.contains("1")) || (name.contains("2")) || (name.contains("3")) || (name.contains("4")) || (name.contains("5")) || (name.contains("6")) || (name.contains("7")) || (name.contains("8")) || (name.contains("9")) || (name.contains("0")))) {
            nameOk = false; //Hacemos condiciones para ver si contiene o no numeero, o si se pasa de los 20 carácteres
        } else {
            nameOk = true;
        }
        return nameOk; //Devolvemos el boolean al main
    }
}
