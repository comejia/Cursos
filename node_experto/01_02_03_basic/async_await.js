let getNombre = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('Cesar')
        }, 3000)
    })
}

let saludo = async() => {
    let nombre = await getNombre();

    return `Hola ${nombre}`
}

saludo().then( mensaje => {
    console.log(mensaje);
}).catch( err => {
    console.log('ERROR', err);
})


// resolucion del ejercicio con async-await
let empleados = [{
    id: 1,
    nombre: 'Cesar'
}, {
    id: 2,
    nombre: 'Octavio'
}, {
    id: 3,
    nombre: 'Debora'
}]

let salarios = [{
    id: 1,
    salario: 1000
}, {
    id: 2,
    salario: 2000
}]

let getEmpleado = async(id) => {
    let empleadoDB = empleados.find(empleado => empleado.id === id)

    if(!empleadoDB) {
        throw new Error(`No existe el empleado con id ${id}`);
    } else {
        return empleadoDB;
    }
}

let getSalario = async(empleado) => {
    let salarioDB = salarios.find(salario => salario.id === empleado.id);

    if(!salarioDB) {
        throw new Error(`No se encontro un salario para el usuario ${empleado.nombre}`);
    } else {
        return {
            id: empleado.id,
            nombre: empleado.nombre,
            salario: salarioDB.salario,
        }
    }
}


let getInformacion = async(id) => {
    let empleado = await getEmpleado(id);
    let res = await getSalario(empleado);

    return `${res.nombre} tiene un salario de ${res.salario}`
}


getInformacion(3).then( mensaje => console.log(mensaje))
    .catch(err => console.log(err))
