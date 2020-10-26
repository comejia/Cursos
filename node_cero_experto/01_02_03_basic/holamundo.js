let nombre2 = 'cesar mejia';

console.log(`${nombre2} is rule`);
console.log();
function cesar() {
    let var1 = 20;
}
let obj = {
    nombre: "clase",
    apellido: "master",
    getNombre() {
        return `${this.nombre} ${this.apellido}`
    }
};

let{ nombre, apellido } = obj;

console.log(obj.getNombre());
console.log(`${nombre} ${apellido}`);
