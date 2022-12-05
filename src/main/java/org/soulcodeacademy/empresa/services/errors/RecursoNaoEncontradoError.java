package org.soulcodeacademy.empresa.services.errors;

// Esta classe representa o erro de regra de negócio
// quando não encontramos cargos, clientes, funcionarios, chamados
// no Banco
public class RecursoNaoEncontradoError extends RuntimeException {
    public RecursoNaoEncontradoError(String message) {
        super(message); // Passamos a mensagem para a Runtime
    }
}

/*1)
RecursoNaoEncontradoError precisa estar vinculado ao if de um dos Services (no RunTime).
Na aula estava vinculado ao cargo, chamado, cliente, funcionário. É a regra de negócio.*/
