
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


    <header>
        <nav class="navbar sticky-top navbar-light navbar-expand-lg"  style="background-color: #e3f2fd;">

            <div class="container-fluid">

                <a class="navbar-brand" href="index.jsp">
                   <i class="fa-regular fa-calendar-days"></i>
                    CitaÁgil
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Turno
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="altaCiudadano.jsp">Pedir Turno</a></li>
                                <li><a class="dropdown-item" href="mostrarTurnos.jsp">Mostrar Turnos</a></li>                        
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

