package e2.CODIGO.Nodos;

import e2.CODIGO.Flota;

public interface NodoOperaciones {
    default String imprimirRuta(){return "NODO INCOMPATIBLE";}
    default int rutaMasCorta(){return 1;}
    String avanzar(Flota f);
}
