package com.encripdrador;

public class Encripdrador {
    private String oldPwd;
    private String newPwd;

    public Encripdrador() {
        this.oldPwd = "";
        this.newPwd = "";
    }

    public String encripdrar() {
        int iChar = 0;
        for (int i=0; i < oldPwd.length(); i++) {
            char actualChar = oldPwd.charAt(i);

            if (Character.isLetter(actualChar) || Character.isDigit(actualChar)) {
                if (iChar % 2 == 0) {   // decrease
                    if (isDecreasingSpecialCase(actualChar))
                        newPwd += treatDecreasingSpecialCase(actualChar);
                    else
                        newPwd += (char) ((int) actualChar - 1);
                } else {    // increase
                    if (isIncreasingSpecialCase(actualChar)) {
                        newPwd += treatIncreasingSpecialCase(actualChar);
                    }
                    else {
                        newPwd += (char) ((int) actualChar + 1);
                    }
                }
            }
            else {   // special characteres
                newPwd += actualChar;
                iChar--;
            }
            iChar++;
        }
        return newPwd;
    }

    public String decripdrar() {
        int iChar = 0;
        for (int i=0; i < oldPwd.length(); i++) {
            char actualChar = oldPwd.charAt(i);

            if (Character.isLetter(actualChar) || Character.isDigit(actualChar)) {
                if (iChar % 2 == 0) {   // increase
                    if (isIncreasingSpecialCase(actualChar))
                        newPwd += treatIncreasingSpecialCase(actualChar);
                    else
                        newPwd += (char) ((int) actualChar + 1);
                } else {    // decrease
                    if (isDecreasingSpecialCase(actualChar)) {
                        newPwd += treatDecreasingSpecialCase(actualChar);
                    }
                    else {
                        newPwd += (char) ((int) actualChar - 1);
                    }
                }
            }
            else {   // special characteres
                newPwd += actualChar;
                iChar--;
            }
            iChar++;
        }
        return newPwd;
    }

    private boolean isDecreasingSpecialCase(char actualChar) {
        if (Character.toLowerCase(actualChar) == 'a' || actualChar == '0')
            return true;
        else
            return false;
    }

    private char treatDecreasingSpecialCase(char actualChar) {
        char treatedChar = ' ';
        switch (actualChar) {
            case 'a':
                treatedChar = 'z';
                break;
            case 'A':
                treatedChar = 'Z';
                break;
            case '0':
                treatedChar = '9';
                break;
        }
        return treatedChar;
    }

    private boolean isIncreasingSpecialCase(char actualChar) {
        if (Character.toLowerCase(actualChar) == 'z' || actualChar == '9')
            return true;
        else
            return false;
    }

    private char treatIncreasingSpecialCase(char actualChar) {
        char treatedChar = ' ';
        switch (actualChar) {
            case 'z':
                treatedChar = 'a';
                break;
            case 'Z':
                treatedChar = 'A';
                break;
            case '9':
                treatedChar = '0';
                break;
        }
        return treatedChar;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
