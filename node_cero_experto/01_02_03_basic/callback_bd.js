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

let getEmpleado = (id, callback) => {
    let empleadoDB = empleados.find(empleado => empleado.id === id)

    if(!empleadoDB) {
        callback(`No existe el empleado con id ${id}`)
    } else {
        callback(null, empleadoDB)
    }
}

let getSalario = (empleado, callback) => {
    let salarioDB = salarios.find(salario => salario.id === empleado.id);

    if(!salarioDB) {
        callback(`No se encontro un salario para el usuario ${empleado.nombre}`)
    } else {
        callback(null, {
            id: empleado.id,
            nombre: empleado.nombre,
            salario: salarioDB.salario,
        })
    }

}

getEmpleado(2, (err, empleado) => {
    if(err) {
        return console.log(err);
    }
    getSalario(empleado, (err, res) => {
        if (err) {
            return console.log(err);
        }
        console.log(res);
    });

});
