
<!DOCTYPE html>
<html lang="es">
    <%@include file="componentes/head.jsp"%>
    <body>   
        <%@include file="componentes/header.jsp"%>
        <div class="error-container d-flex justify-content-center align-items-center">
            <div class="error-card bg-white rounded p-4">
                <img src="https://img.freepik.com/vector-gratis/ilustracion-concepto-error-404_114360-1811.jpg?w=996&t=st=1701338021~exp=1701338621~hmac=e4907fc2b4b406f5630ad3339d13d005bf15f36ff871776512d6eb9579f4859e" class="img-fluid" alt="error 404">
                  <p class="lead text-center">Página no encontrada</p>
                <div class="container d-flex justify-content-center">   
                    <a href="index.jsp" class="btn btn-danger">Volver a la página principal</a>
                </div>
            </div> 
        </div>
        <%@include file="componentes/footer.jsp"%> 
    </body>
</html>