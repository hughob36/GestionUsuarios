// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();
  $('#usuarios').DataTable();
});


 async function cargarUsuarios(){

  const request = await fetch('/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();

  console.log(usuarios);

let listaHtml = '';
for(let usuario of usuarios){
let fechaFormateada = new Date(usuario.fechaNacimiento).toISOString().split('T')[0]; // "YYYY-MM-DD"
let precioFormateado = usuario.precio.toString(); // Convierte el precio a string por seguridad

  let usuarioHtml = '<tr><td>' + usuario.id +
                    '</td><td>' + usuario.nombre +
                    '</td><td>' + usuario.apellido +
                    '</td><td>' + usuario.membresia +
                    '</td><td>' + fechaFormateada +
                    '</td><td>' + precioFormateado  +
                    '</td><td></td></tr>';
  listaHtml += usuarioHtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listaHtml;
}