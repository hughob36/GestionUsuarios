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

let boton = '<a href="#" onclick="borrarUsuario(' + usuario.id + ');" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>'

  let usuarioHtml = '<tr><td>' + usuario.id +
                    '</td><td>' + usuario.nombre +
                    '</td><td>' + usuario.apellido +
                    '</td><td>' + usuario.membresia +
                    '</td><td>' + fechaFormateada +
                    '</td><td>' + precioFormateado  +
                    '</td><td>' + boton +
                    '</td></tr>';
  listaHtml += usuarioHtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listaHtml;
}

async function borrarUsuario(id){

   if(!confirm('¡Estas seguro que quieres eliminar! ')){
    return;
   }
     const request = await fetch(`/usuario/delete/${id}`, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });

   location.reload();
}