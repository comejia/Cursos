const axios = require('axios');

const getClima = async (lat, lon) => {

    const instance = axios.create({
      baseURL: `https://community-open-weather-map.p.rapidapi.com/weather?lat=${lat}&lon=${lon}&units=metric`,
      headers: {'X-RapidAPI-Key': '25e16ddd84msh68e44ccc062fdcfp1316bejsna25b1f4b0795'}
    });

    const res = await instance.get()

    return res.data.main.temp
}

module.exports = {
    getClima
}
