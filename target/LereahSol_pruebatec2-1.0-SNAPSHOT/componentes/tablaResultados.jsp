
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <!<!-- Tabla de resultados -->
    <div class="container mt-5">
        <h3>Lista de Turnos</h3>
        <p>Ingrese la fecha para visualizar los turnos:</p>

        <!-- Formulario para seleccionar la fecha -->
        <form class="form-inline mb-3 col-md-4">
            <label for="inputFecha" class="mr-2">Fecha:</label>
            <input type="date" class="form-control" id="inputFecha">
            <button type="submit" class="btn btn-primary ml-2 mt-3">Buscar</button>
        </form>

        <!-- Tabla de Turnos -->
        <table class="table table-bordered  table-success table-striped">
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
                    <th scope="row">1</th>
                    <td>2023-11-27</td>
                    <td>John Doe</td>
                    <td>12345678</td>
                    <td>
                        <select class="form-select" aria-label="Default select example">
                            <option selected value="espera">En Espera</option>
                            <option value="atendido">Atendido</option>
                        </select>
                    </td>
                    <td><button type="button" class="btn btn-danger btn-sm">Eliminar</button></td>

                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>2023-11-28</td>
                    <td>Jane Smith</td>
                    <td>87654321</td>
                    <td>
                        <select class="form-select" aria-label="Default select example">
                            <option selected value="espera">En Espera</option>
                            <option value="atendido">Atendido</option>
                        </select>
                    </td>
                    <td><button type="button" class="btn btn-danger btn-sm">Eliminar</button></td>


                </tr>
            </tbody>
        </table>
    </div>

</section>