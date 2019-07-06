const lugar = require('./lugar/lugar');
const clima = require('./clima/clima');

const argv = require('yargs').options({
    direccion: {
        alias: 'd',
        desc: 'Direccion de la ciudad para obtener el clima',
        demand: true
    }
}).argv;

/*lugar.getLugarLatLng(argv.direccion)
    .then((res) => console.log(res))
    .catch((err) => console.log(err))


clima.getClima(-34.610001, -58.369999)
    .then((res) => console.log('Temperatura', res))
    .catch((err) => console.log('ERROR: ', err))
*/

const getInfo = async (direccion) => {
    const data = await lugar.getLugarLatLng(direccion)
    const temp = await clima.getClima(data.lat, data.lon)

    return `La temperatura de ${data.dir} es ${temp}`
}

getInfo(argv.direccion)
    .then((res) => console.log("RES: ", res))
    .catch((err) => console.log("ERROR: ", err))
