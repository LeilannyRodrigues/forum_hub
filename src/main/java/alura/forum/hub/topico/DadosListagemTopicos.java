package alura.forum.hub.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {
    // Construtor que transforma a Entidade Topico neste DTO enxuto
    public DadosListagemTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(), // Vai na tabela de usuários e pega só o nome!
                topico.getCurso().getNome()  // Vai na tabela de cursos e pega só o nome!
        );
    }
}
