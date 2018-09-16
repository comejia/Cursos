#define PIN_SEGUIDOR 8

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
 
  pinMode(PIN_SEGUIDOR, INPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  int entrada = digitalRead(PIN_SEGUIDOR);
  if (entrada == LOW) {
    Serial.println("Seguidor");
  }
  else {
    Serial.println("Sin seguir");
  }
}
