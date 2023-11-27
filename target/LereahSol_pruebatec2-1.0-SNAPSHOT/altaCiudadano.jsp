
<%@include file="componentes/head.jsp"%>
<%@include file="componentes/header.jsp"%>
<!DOCTYPE html>


<section class="p-5">
    <!-- Form -->
    <div class="container-md shadow p-3 mb-5 bg-body rounded" style="background-color: #e3f2fd;">
        <h3 class="mb-4">Formulario para Sacar Turno</h3>
        <p>Para obtener una cita se deben introducir los datos de la persona que va a reservar la cita. Todos los campos son obligatorios.</p>
        <form action="SvCiudadano" method="POST" class="row g-3" accept-charset="ISO-8859-1">
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

            <div class="col-12">
                <button type="submit" class="btn btn-primary">Enviar Datos</button>
            </div>
        </form>
       
    </div>
</section>

<%@include file="componentes/footer.jsp"%> 