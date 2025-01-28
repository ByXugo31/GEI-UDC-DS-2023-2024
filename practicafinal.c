#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <sys/time.h>
#include <math.h>
#define TAM 256000
#define NTEST 10
#define N 100
#define INTERCAMBIAR(A, B) { int aux = A; A = B; B = aux; }


double microsegundos() {
  struct timeval t;
  if (gettimeofday(&t, NULL) < 0 )
    return 0.0;
  return (t.tv_usec + t.tv_sec * 1000000.0);
}

void aleatorio(int v [], int n) {
  int i, m = 2*n + 1;
  for (i = 0; i < n; i++)
    v[i] = (rand() % m) - n;
}

void ascendente(int v [], int n) {
  int i;
  for (i = 0; i < n; i++)
    v[i] = i;
}

void descendente(int v [], int n) {
  int i;
  for (i = 0; i < n; i++)
    v[i]= n-i-1;
}

struct monticulo {
  int ultimo;
  int vector[TAM];
};

typedef struct monticulo * pmonticulo;

void iniMonticulo(pmonticulo m){
  m->ultimo = -1;
}

void flotar(pmonticulo m, int i){
  while (i > 0 && m->vector[(i - 1) / 2] > m->vector[i]){
    INTERCAMBIAR(m->vector[(i - 1) / 2], m->vector[i]);
    i = (i - 1)/2;
  }
}

void insertarMonticulo(pmonticulo m, int x){
  m->ultimo++;
  m->vector[m->ultimo] = x;
  flotar(m, m->ultimo);
}

void hundir(pmonticulo m, int i){
  int j;
  int h_izq, h_der;
  do{
    h_izq = 2 * i + 1;
    h_der = 2 * i + 2;
    j = i;
      if ((h_der) <= m->ultimo && m->vector[h_der] < m->vector[i]){
        i = h_der;
      }
      if ((h_izq) <= m->ultimo && m->vector[h_izq] < m->vector[i]){
        i = h_izq;
      }
      INTERCAMBIAR(m->vector[i], m->vector[j]);
  } while (i != j);
}

void quitarMenor(pmonticulo m){
    if (m->ultimo == -1){
      perror("Monticulo vacio");
    }
    else {
      m->vector[0] = m->vector[m->ultimo];
      m -> ultimo = m-> ultimo - 1;
      if(m->ultimo >= 0)
        hundir(m, 0);
    }
}

int consultarMenor(const pmonticulo m){
  return m->vector[0];;
}
void mostrarMonticulo(pmonticulo m){
  int i = 0;
  while (i <= m->ultimo){
    printf("%d\t", m->vector[i]);
    i++;
  }
  printf("\n");
}

void crearMonticulo(pmonticulo m, int v [], int n){
  int i;
  for(i = 0; i < n; i++){
    m -> vector[i] = v[i];
  }
  m -> ultimo = n - 1;
  for(i = ((n - 1)/2); i >= 0; i--){
    hundir(m, i);
  }
}

int kesimoMayor (int v[], int n, int k) {
  int i, aux;
  pmonticulo M = malloc(512000 * sizeof(pmonticulo));
  crearMonticulo(M, v, k);
  for(i = k ; i < n; i++){
    if(v[i] > consultarMenor(M)){
      quitarMenor(M);
      insertarMonticulo(M, v[i]);
    }
  }
  aux = consultarMenor(M);
  free(M);
  return aux;
}

void imprimirVector(int v[], int n){
  int i;
  for(i = 0; i < n; i++)
    printf("%d\t", v[i]);
  printf("\n");
}

double f1 (int n) {return pow(n, 0.8);}
double g1 (int n) {return pow(n, 0.9);}
double h1 (int n) {return (double) n;}

double f2 (int n) {return (double) n;}
double g2 (int n) {return n*log(n);}
double h2 (int n) {return pow(n, 1.5);}

int nueve (int n) {return 9;}
int n_medios (int n) {return n/2;}

void mostrarTablas(int (*fun)(int), double (*sub)(int),
double (*aj)(int), double (*sob)(int), int min, int max, int crec){
  double t0, tF, t, t0aux, tFaux, taux;
  int i, j;
  int v[TAM];
  printf("%13c%18s%15s%15s%15s\n",
          'n', "t(n)", "t(n)/f(n)", "t(n)/g(n)", "t(n)/h(n)");
  for(i = min; i <= max; i = i * crec){
    aleatorio(v, i);
    t0 = microsegundos();
    kesimoMayor(v, i, fun(i));
    tF = microsegundos();
    t = tF - t0;
    if(t < 500){
      t0aux = microsegundos();
      for(j = 0; j < N; j++){
        aleatorio(v, i);
      }
      tFaux = microsegundos();
      taux = tFaux - t0aux;
      t0 = microsegundos();
      for(j = 0; j < N; j++){
        aleatorio(v, i);
        kesimoMayor(v, i, fun(i));
      }
      tF = microsegundos();
      t = (tF - t0 - taux) / N;
      printf("(*)");
    }
    else printf("   ");
    printf("%10d%18lf%15lf%15lf%15lf\n", 
            i, t, t/sub(i), t/aj(i), t/sob(i));
      
  }
}

void test(){
  int i, v[10];
  int r[10];
  aleatorio(v, 10);
  printf("Vector original:\t");
  imprimirVector(v, 10);
  for(i = 1; i <= 10; i++){
    r[i - 1] = kesimoMayor(v, 10, i);
  }
  printf("Elementos extraidos:\t");
  imprimirVector(r, 10);
}

void tablas(){
  int i;
  printf("Tablas buscando el 9o mayor:\n");
  for(i = 0; i < 5; i++){
    mostrarTablas(nueve, f1, g1, h1, 4000, 256000, 2);
    printf("\n");
  }
  printf("Tablas buscando el n/2 mayor:\n");
  for(i = 0; i < 5; i++){
    mostrarTablas(n_medios, f2, g2, h2, 2000, TAM, 2);
    printf("\n");
  }
}

int main(){
  srand(time(NULL));
  test();
  //tablas();
  return 0;
}
