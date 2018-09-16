#include <Keypad.h>

const byte cant_filas = 4;
const byte cant_columnas = 4;

char teclas[cant_filas][cant_columnas] = {
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'}
};

byte pines_fila [cant_filas] = {0,1,2,3};
byte pines_columna [cant_columnas] = {4,5,6,7};

Keypad teclado = Keypad( makeKeymap(teclas), pines_fila, pines_columna, cant_filas, cant_columnas); 

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);

}

void loop() {
  // put your main code here, to run repeatedly:
  char tecla_presionada = teclado.getKey();
  
  if (tecla_presionada != NO_KEY){
    Serial.println(tecla_presionada);
  }

}
