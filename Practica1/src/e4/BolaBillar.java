package e4;

public enum BolaBillar {
    blanca(0, "blanco", "blanca"),
    b1(1, "amarillo", "lisa"),
    b2(2, "azul", "lisa"),
    b3(3, "rojo", "lisa"),
    b4(4, "violeta", "lisa"),
    b5(5, "naranja", "lisa"),
    b6(6, "verde", "lisa"),
    b7(7, "granate", "lisa"),
    b8(8, "negro", "negra"),
    b9(9, "amarillo", "rayada"),
    b10(10, "azul", "rayada"),
    b11(11, "rojo", "rayada"),
    b12(12, "violeta", "rayada"),
    b13(13, "naranja", "rayada"),
    b14(14, "verde", "rayada"),
    b15(15, "granate", "rayada");

    private final int numero;
    private final String color;
    private final String tipo;

    BolaBillar(int numero, String color, String tipo) {
        this.numero = numero;
        this.color = color;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

}
