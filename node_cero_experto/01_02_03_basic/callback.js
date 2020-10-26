// setTimeout(() => {
//     console.log("hola");
// }, 1000);


let getUsuarioById = (id, callback) => {

    let usuario = {
        //id: id si la propiedad es igual al parametro no hace falta asignarla
        id,
        nombre: 'Cesar'
    }

    if( id === 20 ) {
        callback(`Usuario con id ${ id }, no existe`);
    } else {
        callback(null, usuario);
    }
}


getUsuarioById(20, (err, usuario2) => {
    if (err) {
        return console.log(err);
    }
    console.log('Usuario de base de datos', usuario2);
});
