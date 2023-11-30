
<!DOCTYPE html>
<html lang="es">
<%@include file="componentes/head.jsp"%>
<body class="bg-light">   
<%@include file="componentes/header.jsp"%>

<div class="container d-flex align-items-center justify-content-center min-vh-100">
        <div class="card p-4">
            <h1 class="text-danger">Error</h1>
            <p class="lead">${requestScope.errorMensaje}</p>
            <p><a href="altaCiudadano.jsp" class="btn btn-primary">Volver a la página principal</a></p>
        </div>
    </div>

<%@include file="componentes/footer.jsp"%> 
    
</body>
</html>