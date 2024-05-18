package school.sptech.atividaderelacionamento.dto.projeto;

import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class ProjetoMapper {

    public static ProjetoListagemDto toDto(Projeto entity) {

        ProjetoListagemDto dto = new ProjetoListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());

        List<ProjetoListagemDto.TarefaListagemDTO> listaTarefas = new ArrayList<ProjetoListagemDto.TarefaListagemDTO>();

        for(Tarefa tarefaAtual : entity.getTarefas()) {
            ProjetoListagemDto.TarefaListagemDTO tarefaDTO = new ProjetoListagemDto.TarefaListagemDTO();
            tarefaDTO.setId(tarefaAtual.getId());
            tarefaDTO.setNome(tarefaAtual.getNome());
            tarefaDTO.setDescricao(tarefaAtual.getDescricao());
            tarefaDTO.setConcluida(tarefaAtual.isConcluida());
            tarefaDTO.setPrioridade(tarefaAtual.getPrioridade());
            listaTarefas.add(tarefaDTO);
        }
        dto.setTarefas(listaTarefas);

        return dto;
    }

    public static List<ProjetoListagemDto> toDto(List<Projeto> entityList) {
        return entityList.stream().map(ProjetoMapper::toDto).toList();
    }

    public static Projeto toEntity(ProjetoCriacaoDto dto) {
        Projeto projeto = new Projeto();
        projeto.setNome(dto.getNome());
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());
        projeto.setTarefas(new ArrayList<>());
        return projeto;
    }

}
