#define FIN_CARRERA  8
#define IR_TX 9
#define LED 10
int entrada;
int estadoAnterior = HIGH;

void setup() {
  // put your setup code here, to run once:
  pinMode(FIN_CARRERA, INPUT);
  pinMode(IR_TX,OUTPUT);
  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);
  digitalWrite(IR_TX, HIGH);
  Serial.begin(115200); // inicio el puerto serie
  Serial.println("\n");

}

void loop() {
  // put your main code here, to run repeatedly:
  entrada = digitalRead(FIN_CARRERA);
  
  if(entrada == LOW) {
//    estadoAnterior = entrada;
//    delay(10);
//    entrada = digitalRead(FIN_CARRERA);
//    if(entrada == estadoAnterior) {
      Serial.println("Fin de carrera accionado");
      digitalWrite(LED, LOW);
//    }
  }
  if(entrada == HIGH) digitalWrite(LED, HIGH);
  //estadoAnterior = entrada;

//  if( (entrada == LOW) && (entradaAnterior == HIGH)) {
//    entradaAnterior = entrada;
//    delay(10);
//    entrada = digitalRead(PULSADOR);
//    if(entradaAnterior == entrada)
//      Serial.println("Pulsador presionado");
//  }
//  entradaAnterior = entrada;

//  if(entrada == LOW) {
//    if(entradaAnterior == HIGH) {
//      contador ++;
//      //Serial.println("Pulsador presionado");
//      Serial.print(contador);
//    }
//    entradaAnterior = entrada;
//  }
//  else
//   entradaAnterior = HIGH;
  //entradaAnterior = entrada;
}

