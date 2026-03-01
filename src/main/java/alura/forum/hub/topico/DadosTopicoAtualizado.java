package alura.forum.hub.topico;

import java.time.LocalDateTime;

public record DadosTopicoAtualizado(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {
    // O construtor que converte a Entidade neste formato enxuto
    public DadosTopicoAtualizado(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}
