const axios = require('axios');

const getLugarLatLng = async (direccion) => {
    const encodeUrl = encodeURI(direccion)

    const instance = axios.create({
      baseURL: 'https://devru-latitude-longitude-find-v1.p.rapidapi.com/latlon.php?location='+encodeUrl,
      headers: {'X-RapidAPI-Key': '25e16ddd84msh68e44ccc062fdcfp1316bejsna25b1f4b0795'}
    });

    const res = await instance.get()

    if( res.data.Results.length === 0) {
        throw new Error('No hay resultados para ' + direccion)
    }

    const data = res.data.Results[0]
    const dir = data.name
    const lat = data.lat
    const lon = data.lon

    return {
        dir,
        lat,
        lon
    }
}

module.exports = {
    getLugarLatLng
}
