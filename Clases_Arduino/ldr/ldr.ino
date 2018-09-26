const int led = 9
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  pinMode(led,OUTPUT);
  digitalWrite(led,LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  int luminosidad = analogRead(A0);
  Serial.println(luminosidad);
  if(luminosidad > 300) {
    digitalWrite(led, HIGH);
  }
  else {
    digitalWrite(led, LOW)
  }
  delay(1000);
}
