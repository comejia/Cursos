const int pin_red = 9;
const int pin_green = 10;
const int pin_blue = 11;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  pinMode(pin_red, OUTPUT);
  pinMode(pin_green, OUTPUT);
  pinMode(pin_blue, OUTPUT);

  digitalWrite(pin_red, LOW);
  digitalWrite(pin_green, HIGH);
  digitalWrite(pin_blue, LOW);

  tone(A0,100);
noTone(A0);
}

void loop() {
  // put your main code here, to run repeatedly:  

}
