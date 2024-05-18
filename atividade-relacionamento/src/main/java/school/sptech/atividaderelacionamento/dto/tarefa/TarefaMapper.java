package school.sptech.atividaderelacionamento.dto.tarefa;

import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;

public class TarefaMapper {

    public static TarefaListagemDto toDto(Tarefa entity) {
        TarefaListagemDto tarefaDTO = new TarefaListagemDto();
        tarefaDTO.setId(entity.getId());
        tarefaDTO.setNome(entity.getNome());
        tarefaDTO.setDescricao(entity.getDescricao());
        tarefaDTO.setPrioridade(entity.getPrioridade());
        tarefaDTO.setConcluida(entity.isConcluida());

        TarefaListagemDto.ProjetoListagemDTO projetoDTO = new TarefaListagemDto.ProjetoListagemDTO();
        projetoDTO.setId(entity.getProjeto().getId());
        projetoDTO.setNome(entity.getProjeto().getNome());
        projetoDTO.setDescricao(entity.getProjeto().getDescricao());
        projetoDTO.setDataInicio(entity.getProjeto().getDataInicio());
        projetoDTO.setDataFim(entity.getProjeto().getDataFim());
        tarefaDTO.setProjeto(projetoDTO);

        return tarefaDTO;
    }

    public static List<TarefaListagemDto> toDto(List<Tarefa> entities) {
        return entities.stream().map(TarefaMapper::toDto).toList();
    }

    public static Tarefa toEntity(TarefaCriacaoDto dto) {

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setConcluida(false);
        return tarefa;
    }
}
