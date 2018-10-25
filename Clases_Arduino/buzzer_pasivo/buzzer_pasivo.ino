const int buzzer = 6
void setup() {
  // put your setup code here, to run once:
    Serial.begin(115200);
}

void loop() {
  // put your main code here, to run repeatedly:
  tone(buzzer, 300,2000); // La funcion utiliza los pines de PWM
  delay(5000);
  tone(buzzer, 700,2000);
  delay(5000);
  tone(buzzer, 1000,2000);
  delay(5000);
}
