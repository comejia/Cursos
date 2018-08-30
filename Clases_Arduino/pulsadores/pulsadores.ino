#define PULSADOR  8

int entrada;
int entradaAnterior = HIGH;
int contador = 0;
void setup() {
  // put your setup code here, to run once:
  pinMode(PULSADOR, INPUT);

  Serial.begin(115200);
  Serial.println("\n");

}

void loop() {
  // put your main code here, to run repeatedly:
  entrada = digitalRead(PULSADOR);

//  if( (entrada == LOW) && (entradaAnterior == HIGH)) {
//    entradaAnterior = entrada;
//    delay(10);
//    entrada = digitalRead(PULSADOR);
//    if(entradaAnterior == entrada)
//      Serial.println("Pulsador presionado");
//  }
//  entradaAnterior = entrada;

  if(entrada == LOW) {
    if(entradaAnterior == HIGH) {
      contador ++;
      //Serial.println("Pulsador presionado");
      Serial.print(contador);
    }
    entradaAnterior = entrada;
  }
  else
   entradaAnterior = HIGH;
  //entradaAnterior = entrada;
}

