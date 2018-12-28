#include <DHT.h>

// Pin Vcc a +5V
// Pin GND a masa
// Pin OUT a pin 2

const int pin_dht11 = 2;

DHT mi_dht(pin_dht11, DHT11);

void setup() {
  Serial.begin(115200);
  Serial.println("DHT11");

  dht.begin();

  delay(2000); // Delay inicial para que termine de configurar el dht
}

void loop() {
  // Reading temperature or humidity takes about 250 milliseconds!
  // Sensor readings may also be up to 2 seconds 'old' (its a very slow sensor)
  float humedad = mi_dht.readHumidity();
  // Read temperature as Celsius (the default)
  float temperatura = mi_dht.readTemperature();
  // Read temperature as Fahrenheit (isFahrenheit = true)
  float f = mi_dht.readTemperature(true);

  // Check if any reads failed and exit early (to try again).
  if (isnan(humedad) || isnan(temperatura) || isnan(f)) {
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  // Compute heat index in Fahrenheit (the default)
  float hif = dht.computeHeatIndex(f, humedad);
  // Compute heat index in Celsius (isFahreheit = false)
  float hic = dht.computeHeatIndex(temperatura, humedad, false);

  Serial.print("Humidity: ");
  Serial.print(humedad);
  Serial.print(" %\t");
  Serial.print("Temperature: ");
  Serial.print(temperatura);
  Serial.print(" *C ");
  Serial.print(f);
  Serial.print(" *F\t");
  Serial.print("Heat index: ");
  Serial.print(hic);
  Serial.print(" *C ");
  Serial.print(hif);
  Serial.println(" *F");

  // Wait a few seconds between measurements.
  delay(5000);
}
