#include <AFMotor.h>

AF_DCMotor motor(1);


void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  motor.run(RELEASE);
  motor.setSpeed(200);

}

void loop() {
  Serial.println("MOTOR");
  // put your main code here, to run repeatedly:
  motor.run(FORWARD);
  delay(2000);

}
