$(document).ready(function() {
  //on
});

 async function crearUsuario(){
 let usuario = {};

usuario.nombre = document.getElementById('txtNombre').value
usuario.apellido = document.getElementById('txtApellido').value
usuario.membresia = document.getElementById('txtMembresia').value
usuario.fecha = document.getElementById('txtFecha').value
usuario.precio = document.getElementById('txtPrecio').value

  await fetch('/usuario/crear', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
     body: JSON.stringify(usuario)
  });
}

