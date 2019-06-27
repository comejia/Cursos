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

let getEmpleado = (id) => {

    return new Promise((resolve, reject) => {
        let empleadoDB = empleados.find(empleado => empleado.id === id)

        if(!empleadoDB) {
            reject(`No existe el empleado con id ${id}`)
        } else {
            resolve(empleadoDB)
        }
    });
}

let getSalario = (empleado) => {

    return new Promise( (resolve, reject) => {
        let salarioDB = salarios.find(salario => salario.id === empleado.id);

        if(!salarioDB) {
            reject(`No se encontro un salario para el usuario ${empleado.nombre}`)
        } else {
            resolve({
                id: empleado.id,
                nombre: empleado.nombre,
                salario: salarioDB.salario,
            })
        }
    });
}


getEmpleado(1).then( (empleado) => {
    console.log('Empleado de DB', empleado);
}, (err) => {
    console.log(err);
});

getEmpleado(1).then( (empleado) => {
    getSalario(empleado).then((res) => {
        console.log('Empleado de DB con salario', res);
    }, (err) => console.log(err));

}, (err) => console.log(err));


getEmpleado(2).then( empleado => {
    return getSalario(empleado);
}).then( res => console.log('Empleado de DB con salario', res) )
.catch( err => console.log(err) )
