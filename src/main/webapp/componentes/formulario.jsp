
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <section class="p-5">
       <!-- Form -->
      <div class="container-md p-3 rounded" style="background-color: #e3f2fd;">
    <h3 class="mb-4">Formulario para Sacar Turno</h3>
    <form class="row g-3">
        <div class="col-md-6">
            <label for="inputNombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre"  required>
        </div>
        <div class="col-md-6">
            <label for="inputApellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="inputApellido" name="inputApellido" placeholder="Apellido" required>
        </div>

        <div class="col-md-6">
            <label for="inputDNI" class="form-label">DNI</label>
            <input type="text" class="form-control" id="inputDNI"  name="inputDNI" placeholder="DNI" required>
        </div>
        <div class="col-md-6">
            <label for="inputTel" class="form-label">Teléfono</label>
            <input type="tel" class="form-control" id="inputTel"  name="inputTel" placeholder="Teléfono" required>
        </div>

        <div class="col-md-6">
            <label for="inputDate" class="form-label">Fecha Turno</label>
            <input type="date" class="form-control" id="inputDate" name="inputDate"required>
        </div>
        <div class="col-md-6">
            <label for="inputTramite" class="form-label">Trámites</label>
            <select id="inputTramite" class="form-select" required>
                <option selected disabled>Elija un trámite...</option>
                <option value="Alumbrado">Alumbrado</option>
                <option value="Caída Árboles">Caída Árboles</option>
                <option value="Servicios Públicos">Servicios Públicos</option>
                <option value="Sistema de Salud">Sistema de Salud</option>
                <option value="Autos Abandonados">Autos Abandonados</option>
                <option value="Empadronamiento">Empadronamiento</option>
            </select>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</div>
    </section>