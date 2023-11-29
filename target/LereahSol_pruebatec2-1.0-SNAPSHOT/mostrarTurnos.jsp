
<%@page import="com.HackABoss.LereahSol_pruebatec2.logica.Turno"%>
<%@page import="java.util.List"%>

<%@include file="componentes/head.jsp"%>
<%@include file="componentes/header.jsp"%>


<!DOCTYPE html>
<section>
    <!-- Tabla de resultados -->
    <div class="container mt-5 shadow p-3 mb-5 bg-body rounded">

        <h4>Turnos</h4>
        <p>Puede filtrar los turnos según su fecha y estado:</p>

        <!-- Formulario para seleccionar la fecha -->
        <form action= "SvTurnosFiltrados" method="GET" class="mb-3  row g-3">

            <div class="col-md-6">
                <label for="inputFecha" class="form-label">Fecha:</label>
                <input type="date" class="form-control"  id="inputDate" name="inputDate">
            </div>

            <div class="col-md-6 mt-2">
                <button type="submit" class="btn btn-primary ml-2 mt-3">Buscar</button>
            </div>
        </form>
    </div> 

    <!-- Tabla de Turnos -->
    <div class="container mt-5 shadow p-3 mb-5 bg-body rounded">
        <h5>Lista de Turnos</h5>
        <table class="table table-bordered rounded table-success table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Turno</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>            
                    <th scope="col">DNI</th>
                    <th scope="col">Trámite</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Cancelar</th>
                </tr>
            </thead>
            <% List<Turno> turnosFiltrados = (List) request.getSession().getAttribute("turnosFiltrados");
                if (turnosFiltrados != null && !turnosFiltrados.isEmpty()) {%> 
            <tbody>
                <%for (Turno turno : turnosFiltrados) {%>
                <tr>
                    <th scope="row"><%=turno.getIdTurno()%></th>
                    <td><%=turno.getFecha()%></td>
                    <td><%=turno.getUnCiudadano().getNombre()%></td>
                    <td><%=turno.getUnCiudadano().getApellido()%></td>
                    <td><%=turno.getUnCiudadano().getDni()%></td>
                    <td><%=turno.getTramite()%></td>
                    <td> 
                        <!-- Button trigger modal -->
                        <button class="btn btn-warning btn-sm" type="button"  data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                            <%=turno.getEstado()%> <i class="fa-solid fa-pencil"></i>
                        </button>
                    </td>
                    <td>
                        <form action="SvElimTurno" method="POST" id="eliminarTurnoForm">
                            <input type="hidden" name="idTurn" id="idTurn" value="<%=turno.getIdTurno()%>">
                            <button type="submit" class="btn btn-danger btn-sm">
                                Eliminar <i class="fa-solid fa-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr> 
            </tbody>
                <%}%>
        </table>
             <%}%>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Editar Estado Trámite</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="SvEditTurno" method="POST">
                    <div class="modal-body">
                        Seleccione el estado del trámite
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox"  value="En Espera" name="estado"  id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                                En Espera
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox"  value="Atendido" name="estado" id="flexCheckChecked">
                            <label class="form-check-label" for="flexCheckChecked">
                                Atendido
                            </label>
                        </div>
                        <input type="hidden" name="idTurnEdit">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                
                </form>
            </div>
       
        </div>
    </div>
</section>


<%@include file="componentes/footer.jsp"%> 




