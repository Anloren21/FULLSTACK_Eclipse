const URL = 'api/v1/videos/';

const listadoVideos= document.querySelector('#listado-videos');

mostrar('listado');

const respuesta = await fetch(URL);
const videos = await respuesta.json();


for (const video of videos) {
    const card = document.createElement('div');

	card.className = 'col';
    card.innerHTML = `
		<div class="card h-100">
			<div class="w-100 ratio-16x9 card-img">
			  <iframe class="w-100 ratio-16x9" src="${video.url}" title="${video.titulo}" allowfullscreen></iframe>
			</div>
			<div class="card-body">
				<h5 class="card-title"><a href="javascript:detalle()">${video.titulo}</a></h5>
				<p class="card-text">${video.descripcion}</p>
			</div>
			<div class="card-footer">
				<small class="text-body-secondary">${video.fecha}</small>
			</div>
		</div>
	</div>`;

    listadoVideos.appendChild(card);
}

function mostrar(id){
	const sections = document.querySelectorAll('main>section');
	
	for (const section of sections){
		section.style.display = 'none'
	}	
	
	document.querySelector('#' + id).style.display = null;
}

window.detalle = function (){
	document.querySelector('#detalle iframe').src = 'https://www.youtube.com/embed/VhZiiVnmrEY?si=duOKbyMuuaJE5W-c';
	document.querySelector('#detalle .card-title').textContent = 'Video de Pedro';
	document.querySelector('#detalle .card-text').textContent = 'Prueba de que esto se ve';
	document.querySelector('#detalle .card-footer small').textContent = '2026-10-28';
	
	mostrar('detalle');
}