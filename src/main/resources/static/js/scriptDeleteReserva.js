function confirmarDeletar(idReserva) {
    var confirmacao = confirm("Tem certeza que deseja cancelar esta reserva?");
    if (confirmacao) {
        window.location.href = 'deletarReservaCliente?idReserva=' + idReserva;
    }
}