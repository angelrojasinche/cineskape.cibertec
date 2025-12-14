<%-- 
    Document   : index
    Created on : 28 nov 2025, 14:00:03
    Author     : RS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Pelicula"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CINESkAPE</title>

    <!-- Tailwind + DaisyUI -->
    <link href="https://cdn.jsdelivr.net/npm/daisyui@5" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>

    <!-- Iconos -->
    <script src="https://unpkg.com/lucide@latest"></script>

    <style>
        body {
            background: linear-gradient(180deg, #141414, #0b0b0b);
        }

        h1 {
    font-size: 2.8rem;
    font-weight: 900;
    color: #e50914;
    letter-spacing: 4px;
    text-shadow:
        0 0 6px rgba(229,9,20,.6),
        0 0 12px rgba(229,9,20,.4),
        2px 2px 10px rgba(0,0,0,.8);
}

        .btn-cine {
            background: linear-gradient(to right, #e50914, #ff4141);
            color: white;
            font-weight: bold;
        }

        /* Inputs visibles en modal */
        #my_modal_1 input {
            background-color: #fff !important;
            color: #111 !important;
        }

        #my_modal_1 label {
            color: #facc15;
            font-weight: bold;
        }
        
        .cine-header {
    display: flex;
    flex-direction: column;
    gap: 6px;
}

.cine-title {
    display: flex;
    align-items: center;
    gap: 18px;
    font-size: 3.8rem;
    font-weight: 900;
    letter-spacing: 7px;
    color: #e50914;
    text-transform: uppercase;

    text-shadow:
        0 0 10px rgba(229,9,20,.9),
        0 0 20px rgba(229,9,20,.6),
        0 0 35px rgba(229,9,20,.4),
        4px 4px 14px rgba(0,0,0,.95);
}

.cine-title i {
    width: 52px;
    height: 52px;
    filter: drop-shadow(0 0 8px rgba(229,9,20,.8));
}

.cine-subtitle {
    font-size: 0.85rem;
    letter-spacing: 6px;
    color: #9ca3af;
    margin-left: 70px; /* alinea con el texto, no con el ícono */
}

    </style>
</head>

<body class="min-h-screen text-white">

<main class="max-w-7xl mx-auto px-6 py-8">

    <!-- HEADER -->
    <header class="flex flex-col md:flex-row justify-between items-center gap-6 mb-12">
        <div class="cine-header">
    <h1 class="cine-title">
        <i data-lucide="clapperboard"></i>
        <span>CINESkAPE</span>
        <i data-lucide="clapperboard"></i>
    </h1>
    <p class="cine-subtitle">CINE · SERIES · STREAMING</p>
</div>


        <div class="flex gap-4">
            <input
                id="buscador"
                type="text"
                placeholder="Buscar película..."
                class="input input-bordered w-96 bg-white text-black"
            >

            <button class="btn btn-cine px-6 text-base" onclick="abrirNuevo()">
                + Película
            </button>
        </div>
    </header>

    <!-- GRID DE PELÍCULAS -->
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">

        <%
            List<Pelicula> lista = (List<Pelicula>) request.getAttribute("ListaPelicula");
            if (lista != null) {
                for (Pelicula p : lista) {
        %>

        <div class="pelicula-card card bg-neutral shadow-2xl hover:scale-105 transition duration-300">

            <figure class="relative h-80 overflow-hidden group">
                <img src="<%= p.getUrl_portada() %>"
                     class="w-full h-full object-cover"/>

                <!-- Overlay -->
                <div class="absolute inset-0 bg-black/70 opacity-0 group-hover:opacity-100
                            flex items-center justify-center gap-4 transition">

                    <!-- VER DETALLE -->
                    <button class="btn btn-circle btn-primary btn-detalle"
                        data-titulo="<%= p.getTitulo() %>"
                        data-descripcion="<%= p.getDescripcion() %>"
                        data-anio="<%= p.getAnio() %>"
                        data-duracion="<%= p.getDuracion() %>"
                        data-precio="<%= p.getPrecio_alquiler() %>"
                        data-img="<%= p.getUrl_portada() %>">
                        <i data-lucide="eye"></i>
                    </button>

                    <!-- EDITAR -->
                    <button class="btn btn-circle btn-warning btn-edit"
                        data-id="<%= p.getId_pelicula() %>"
                        data-titulo="<%= p.getTitulo() %>"
                        data-descripcion="<%= p.getDescripcion() %>"
                        data-duracion="<%= p.getDuracion() %>"
                        data-url="<%= p.getUrl_portada() %>"
                        data-anio="<%= p.getAnio() %>"
                        data-precio="<%= p.getPrecio_alquiler() %>">
                        <i data-lucide="pencil"></i>
                    </button>

                    <!-- ELIMINAR -->
                    <a href="PeliculaDelete?id_pelicula=<%= p.getId_pelicula() %>"
                       class="btn btn-circle btn-error">
                        <i data-lucide="trash-2"></i>
                    </a>
                </div>
            </figure>

            <div class="card-body p-4">
                <h2 class="pelicula-titulo font-bold text-lg">
                    <%= p.getTitulo() %>
                </h2>

                <p class="text-sm text-gray-400">
                    <%= p.getAnio() %> · <%= p.getDuracion() %> min
                </p>

                <!-- RATING + PRECIO -->
                <div class="flex items-center gap-3 mt-2">
                    <div class="rating rating-sm">
                        <input type="radio" class="mask mask-star-2 bg-yellow-400" checked />
                        <input type="radio" class="mask mask-star-2 bg-yellow-400" checked />
                        <input type="radio" class="mask mask-star-2 bg-yellow-400" checked />
                        <input type="radio" class="mask mask-star-2 bg-yellow-400" />
                        <input type="radio" class="mask mask-star-2 bg-yellow-400" />
                    </div>

                    <span class="text-yellow-400 font-semibold">
                        S/ <%= p.getPrecio_alquiler() %>
                    </span>
                </div>
            </div>
        </div>

        <%
                }
            }
        %>
    </div>
</main>

<!-- MODAL CREAR / EDITAR -->
<dialog id="my_modal_1" class="modal">
    <div class="modal-box bg-neutral text-white max-w-lg">
        <h3 class="text-xl font-bold mb-4" id="tituloModal">Nueva Película</h3>

        <form id="formularioPelicula" method="post" action="PeliculaServlet">
            <input type="hidden" name="id_pelicula" id="id_pelicula">

            <label>Título</label>
            <input name="titulo" id="titulo" class="input input-bordered w-full mb-2">

            <label>Descripción</label>
            <input name="descripcion" id="descripcion" class="input input-bordered w-full mb-2">

            <label>Duración</label>
            <input name="duracion" id="duracion" class="input input-bordered w-full mb-2">

            <label>URL Portada</label>
            <input name="url_portada" id="url_portada" class="input input-bordered w-full mb-2">

            <label>Año</label>
            <input name="anio" id="anio" class="input input-bordered w-full mb-2">

            <label>Precio</label>
            <input name="precio_alquiler" id="precio_alquiler" class="input input-bordered w-full mb-4">

            <div class="modal-action">
                <button type="button" class="btn" onclick="my_modal_1.close()">Cancelar</button>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </div>
</dialog>

<!-- MODAL DETALLE -->
<dialog id="modalDetalle" class="modal">
    <div class="modal-box bg-neutral text-white max-w-4xl">
        <img id="d_img" class="w-full h-96 object-cover rounded mb-6">
        <h2 id="d_titulo" class="text-3xl font-bold"></h2>
        <p id="d_desc" class="mt-3 text-gray-300"></p>

        <p class="mt-2 text-gray-400">
            <span id="d_anio"></span> · <span id="d_duracion"></span> min
        </p>

        <p class="mt-4 text-yellow-400 text-xl font-bold">
            S/ <span id="d_precio"></span>
        </p>

        <div class="modal-action">
            <button class="btn" onclick="modalDetalle.close()">Cerrar</button>
        </div>
    </div>
</dialog>

<!-- JS -->
<script>
    lucide.createIcons();

    buscador.addEventListener("keyup", () => {
        const f = buscador.value.toLowerCase();
        document.querySelectorAll(".pelicula-card").forEach(card => {
            card.style.display =
                card.querySelector(".pelicula-titulo").innerText.toLowerCase().includes(f)
                ? "block" : "none";
        });
    });

    function abrirNuevo() {
        tituloModal.innerText = "Nueva Película";
        formularioPelicula.action = "PeliculaServlet";
        formularioPelicula.reset();
        my_modal_1.showModal();
    }

    document.querySelectorAll(".btn-edit").forEach(btn => {
        btn.onclick = () => {
            tituloModal.innerText = "Editar Película";
            id_pelicula.value = btn.dataset.id;
            titulo.value = btn.dataset.titulo;
            descripcion.value = btn.dataset.descripcion;
            duracion.value = btn.dataset.duracion;
            url_portada.value = btn.dataset.url;
            anio.value = btn.dataset.anio;
            precio_alquiler.value = btn.dataset.precio;
            formularioPelicula.action = "PeliculaEditServlet";
            my_modal_1.showModal();
        };
    });

    document.querySelectorAll(".btn-detalle").forEach(btn => {
        btn.onclick = () => {
            d_img.src = btn.dataset.img;
            d_titulo.innerText = btn.dataset.titulo;
            d_desc.innerText = btn.dataset.descripcion;
            d_anio.innerText = btn.dataset.anio;
            d_duracion.innerText = btn.dataset.duracion;
            d_precio.innerText = btn.dataset.precio;
            modalDetalle.showModal();
        };
    });
</script>

</body>
</html>





