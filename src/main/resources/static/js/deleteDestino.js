function confirmarDeletar(id) {
    let confirmacao = confirm("Tem certeza que deseja excluir esta viagem?");
    if (confirmacao) {
        window.location.href = '/deletarViagem?id=' + id;
    }
}