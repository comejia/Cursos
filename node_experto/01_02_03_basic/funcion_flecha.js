function sumar1(a, b) {
    return a+b;
}

let sumar2 = (a,b) => {
    return a+b;
}

let sumar = (a,b) => a+b

let saludar = () => 'Hola';

let obj = {
    nombre: "clase",
    apellido: "master",
    //getNombre: () => `${this.nombre} ${this.apellido}` //no se puede dentro de un obj
    getNombre() {
        return `${this.nombre} ${this.apellido}`;
    }
};

console.log(sumar(10, 20))

console.log(saludar());

console.log(obj.getNombre());
