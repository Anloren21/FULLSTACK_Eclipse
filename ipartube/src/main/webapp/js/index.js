const URL = 'api/v1/videos/';

const listadoVideos= document.querySelector('#listado-videos');

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
				<h5 class="card-title">${video.titulo}</h5>
				<p class="card-text">${video.descripcion}</p>
			</div>
			<div class="card-footer">
				<small class="text-body-secondary">${video.fecha}</small>
			</div>
		</div>
	</div>`;

    listadoVideos.appendChild(card);
}