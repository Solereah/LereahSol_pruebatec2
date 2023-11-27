

<%@include file="componentes/head.jsp"%>
<%@include file="componentes/header.jsp"%>
<section>
    <!<!-- Tabla de resultados -->
    <div class="container mt-5 shadow p-3 mb-5 bg-body rounded">

        <h3>Lista de Turnos</h3>
        <p>Puede filtrar los turnos según su fecha y estado:</p>

        <!-- Formulario para seleccionar la fecha -->
        <form action="mostrarDatos.jsp"method="POST" class=" mb-3  row g-3">
            <div class="col-md-6">
                <label for="inputFecha" class="form-label">Fecha:</label>
                <input type="date" class="form-control" id="inputFecha">
            </div>
            <div class="col-md-6">
                 <label for="inputEstado" class="form-label">Estado</label>
                <select class="form-select"  name="estado" aria-label="Seleccion el estado del turno">
                    <option selected value="enEspera">En Espera</option>
                    <option value="atendido">Atendido</option>
                </select>
            </div>
            <div class="col-md-6 mt-3">
                <button type="submit" class="btn btn-primary ml-2 mt-3">Buscar</button>
            </div>
        </form>

        <!-- Tabla de Turnos -->
        <table class="table table-bordered rounded table-success table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Turno</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Ciudadano</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Cancelar</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"></th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form action="" method="POST">
                            <select class="form-select" aria-label="Default select example">
                                <option selected value="enEspera">En Espera</option>
                                <option value="atendido">Atendido</option>
                            </select>
                        </form>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                            Eliminar
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Eliminar Turno</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Está a punto de cancelar el turno y la acción no se puede deshacer. 
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <form action="" method="POST">
                        <button type="button" class="btn btn-primary">Aceptar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</section>


<%@include file="componentes/footer.jsp"%> 




