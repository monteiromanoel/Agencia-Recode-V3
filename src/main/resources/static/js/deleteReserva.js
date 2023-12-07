function confirmarDeletar(id) {
    let confirmacao = confirm("Tem certeza que deseja cancelar esta reserva?");
    if (confirmacao) {
        window.location.href = '/deletarReserva?id=' + id;
    }
}