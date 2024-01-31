package e2;
import java.util.Arrays;
public class ImmutableMatrix {
    private int columnas;
    private int filas;
    private int [][] matrix;

    public ImmutableMatrix(int[][] matrix) {
        for (int i = 1;i<matrix.length;i++){
            if (matrix[i-1].length != matrix[i].length) throw new IllegalArgumentException("La matriz es irregular");
        }
        this.matrix = matrix;
    }

    public ImmutableMatrix(int filas, int columnas){
        this.columnas = columnas;
        this.filas = filas;
        this.matrix = new int[this.filas][this.columnas];
        new ImmutableMatrix(matrix);
        int number = 0;
        for (int i = 0; i<filas;i++){
            for (int j = 0; j<columnas;j++){
                number++;
                if (number<=0) throw new IllegalArgumentException("Numero menor o igual que 0.");
                this.matrix[i][j] = number;
            }
        }
    }

    //Modificar
    @Override
    public String toString() {
        StringBuilder matrixStr = new StringBuilder();
        for (int i = 0; i < this.filas; i++) {
            matrixStr.append("[");
            for (int j = 0; j < this.columnas; j++) {
                if (j == this.columnas - 1) {
                    matrixStr.append(this.matrix[i][j]);
                } else {
                    matrixStr.append(this.matrix[i][j]).append(", ");
                }
            }
            matrixStr.append("]\n");
        }
        return matrixStr.toString();
    }


    public int at(int fila, int columna){
        if(fila < 0 || fila > this.filas || columna < 0 || columna > this.filas) throw new IllegalArgumentException("Coordenadas no válidas");
        return this.matrix[fila][columna];
    }

    public int rowCount(){
        return this.filas;
    }

    public int columnCount(){
        return this.columnas;
    }

    public int[][] toArray2D(){return Arrays.copyOf(this.matrix,this.matrix.length);}

    public ImmutableMatrix reverse(){
       int [][] auxMatrix = new int[this.filas][this.columnas];
       int l = 0;
        for (int i = this.filas-1; i>-1;i--){
            for (int j = this.columnas-1; j>-1;j--){
                auxMatrix[i][l] = this.matrix[i][j];
                l++;
            }
            l = 0;
        }
        ImmutableMatrix matrix1 = new ImmutableMatrix(auxMatrix);
        matrix1.filas = this.filas;
        matrix1.columnas = this.columnas;
        return matrix1;
    }

    public ImmutableMatrix transpose(){
        int[][] traspuesta= new int[this.columnas][this.filas];

        for(int i=0;i<this.filas;i++){
            for(int j=0;j<this.columnas;j++){
                traspuesta[j][i]=this.matrix[i][j];
            }
        }
        ImmutableMatrix matrix1 = new ImmutableMatrix(traspuesta);
        matrix1.filas = this.columnas;
        matrix1.columnas = this.filas;
        return matrix1;
    }

    public ImmutableMatrix reshape(int columnas){
        int i, j, k, l;
        if (this.columnas*this.filas % columnas == 0){
            int[][] reshaped = new int[this.columnas*this.filas / columnas][columnas];
            for (i = 0, j = 0, k= 0; k < (this.columnas*this.filas / columnas); k++) {
                for (l = 0; l < columnas; l++) {
                    reshaped[k][l] = this.matrix[i][j];
                    j++;
                    if(j==this.columnas){
                        j=0;
                        i++;
                    }
                }
            }
            ImmutableMatrix matrix1 = new ImmutableMatrix(reshaped);
            matrix1.filas = this.columnas*this.filas / columnas;
            matrix1.columnas = columnas;
            return matrix1;
        }
        else throw new IllegalArgumentException("Número de columnas no válido.");
    }
}