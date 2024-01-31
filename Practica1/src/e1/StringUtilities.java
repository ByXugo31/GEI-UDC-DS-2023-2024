package e1;

public class StringUtilities {
    public static boolean isValidString(String str, String str2, int longitud) {
        boolean valid = false;

        if (str == null){
            valid = false;
            return valid;
        } else valid = !str.isBlank() && !str.isEmpty() && str.length() >= longitud;
        if (valid == true) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str.charAt(i) == str2.charAt(j) || Character.isDigit(str.charAt(i))) {
                        valid = true;
                        break;
                    } else valid = false;
                }
            }
        }
        return valid;
    }

    public static String lowercaseFirst(String str){

        StringBuilder lowercase = new StringBuilder();
        StringBuilder uppercase = new StringBuilder();

        if (str != null){
            for (int i = 0;i<str.length();i++){
                if (Character.isLowerCase(str.charAt(i))) lowercase.append(str.charAt(i));
                else uppercase.append(str.charAt(i));
            }
        }

        return lowercase + uppercase.toString();
    }

    public static boolean checkTextStats(String str,int min, int max){

        if(str == null || str.isEmpty() || min<=0 || max <= 0) throw new IllegalArgumentException("Texto nulo o vacío, o valores negativos o cero para min/max no permitidos.");

        int letterCount;
        int wordCount;
        int maxLenght = 0;
        int totalLetterCount = 0;
        float media;

        String[] frase = str.split(" ");
        wordCount = frase.length;

        for (String palabra : frase){
            letterCount = palabra.length();
            totalLetterCount += letterCount;
            maxLenght = Math.max(palabra.length(),maxLenght);
        }

        media = (float) totalLetterCount /wordCount;

        return media<=max && media>=min && maxLenght<=2*media;
    }

}