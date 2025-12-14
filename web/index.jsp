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

        .cine-subtitle {
            font-size: 0.85rem;
            letter-spacing: 6px;
            color: #9ca3af;
            margin-left: 70px;
        }

        .btn-cine {
            background: linear-gradient(to right, #e50914, #ff4141);
            color: white;
            font-weight: bold;
        }

        #my_modal_1 input {
            background-color: #fff !important;
            color: #111 !important;
        }
    </style>
</head>

<body class="min-h-screen text-white">

<main class="max-w-7xl mx-auto px-6 py-8">

    <!-- HEADER -->
    <header class="flex flex-col md:flex-row justify-between items-center gap-6 mb-12">
        <div>
            <h1 class="cine-title">
                <i data-lucide="clapperboard"></i>
                <span>CINESkAPE</span>
                <i data-lucide="clapperboard"></i>
            </h1>
            <p class="cine-subtitle">CINE · SERIES · STREAMING</p>
        </div>

        <div class="flex gap-4">
            <input id="buscador" type="text"
                   placeholder="Buscar película..."
                   class="input input-bordered w-96 bg-white text-black">

            <button class="btn btn-cine px-6" onclick="abrirNuevo()">
                + Película
            </button>
        </div>
    </header>

    <!-- GRID -->
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">

        <%
            List<Pelicula> lista = (List<Pelicula>) request.getAttribute("ListaPelicula");
            if (lista != null) {
                for (Pelicula p : lista) {
        %>

        <div class="pelicula-card card bg-neutral shadow-xl">

            <figure class="relative h-80 overflow-hidden group">
                <img src="<%= p.getUrl_portada() %>"
                     class="w-full h-full object-cover"/>

                <div class="absolute inset-0 bg-black/70 opacity-0 group-hover:opacity-100
                            flex items-center justify-center gap-4 transition">

                    <!-- DETALLE -->
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

                <p class="text-yellow-400 font-semibold mt-2">
                    S/ <%= p.getPrecio_alquiler() %>
                </p>
            </div>
        </div>

        <%
                }
            }
        %>
    </div>
</main>

<!-- MODAL -->
<dialog id="my_modal_1" class="modal">
    <div class="modal-box bg-neutral text-white max-w-lg">
        <h3 class="text-xl font-bold mb-4" id="tituloModal">Nueva Película</h3>

        <form id="formularioPelicula" method="post" action="PeliculaServlet">
            <input type="hidden" name="id_pelicula" id="id_pelicula">

            <label>Título</label>
            <input name="titulo" id="titulo" class="input input-bordered w-full mb-2" required>

            <label>Descripción</label>
            <input name="descripcion" id="descripcion" class="input input-bordered w-full mb-2" required>

            <label>Duración</label>
            <input type="number" name="duracion" id="duracion"
                   class="input input-bordered w-full mb-2" required>

            <label>URL Portada</label>
            <input name="url_portada" id="url_portada"
                   class="input input-bordered w-full mb-2" required>

            <label>Año</label>
            <input type="number" name="anio" id="anio"
                   class="input input-bordered w-full mb-2" required>

            <label>Precio</label>
            <input type="number" step="0.01" name="precio_alquiler" id="precio_alquiler"
                   class="input input-bordered w-full mb-4" required>

            <div class="modal-action">
                <button type="button" class="btn" onclick="my_modal_1.close()">Cancelar</button>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
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
            alert(
                btn.dataset.titulo + "\n" +
                btn.dataset.descripcion + "\n" +
                "Año: " + btn.dataset.anio +
                " | Duración: " + btn.dataset.duracion + " min"
            );
        };
    });
</script>

</body>
</html>






