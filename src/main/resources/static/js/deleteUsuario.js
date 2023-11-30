function confirmarDeletar(id) {
    let confirmacao = confirm("Tem certeza que deseja excluir este cliente?");
    if (confirmacao) {
        window.location.href = '/deletarCliente?id=' + id;
    }
}