package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<Time>();


	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		List<Long> list = new ArrayList<>();
		list = buscarTimes();
		if (!list.contains(id)) {
			times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		} else {
			throw new IdentificadorUtilizadoException("indentificador já utilizado!");
		}
	}

	public static void main(String[] args) {
		final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
//		desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
		desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		Time time = buscarTime(idTime);
		if (time!=null) {
			for (Jogador jogador : time.getJodadorList()) {
				if (jogador.getId() == id) {
					throw new IdentificadorUtilizadoException("indentificador já utilizado!");
				}

			}
			time.setJogadorList(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
		} else {
			throw new TimeNaoEncontradoException("Time não encontrado");
		}

	}

	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		if (jogador == null) {
			throw new JogadorNaoEncontradoException("Jogador não encontrado");
		} else {

			Time time = buscarTime(jogador.getIdTime());
			time.setCapitao(idJogador);

		}

	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		if (time == null) {
			throw new TimeNaoEncontradoException("Time não exisite");
		} else if (time.getCapitao() == null) {
			throw new CapitaoNaoInformadoException("Capitao nao informado!");
		}
		return time.getCapitao();
	}

	public String buscarNomeJogador(Long idJogador) {

		Jogador jogador = buscarJogador(idJogador);
		if (jogador == null) {
			throw new JogadorNaoEncontradoException("Jogador nao encontrado!");
		} else {
			return jogador.getNome();
		}

	}

	public String buscarNomeTime(Long idTime) {
		String resposta = null;
		for (Time time : times) {
			if (time.getId() == idTime) {
				resposta = time.getNome();
				break;
			}
		}
		if (resposta==null) {
			throw new TimeNaoEncontradoException("Time não encontrado!");
		} else {
			return resposta;
		}

	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		if (!(time == null)) {
			return time.getIdJodadorList();
		} else {
			throw new TimeNaoEncontradoException("Time não encontrado!");
		}
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = buscarTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException("Time não encontrado!");
		} else {
			Jogador melhor = buscarJogador(buscarJogadoresDoTime(idTime).get(0));
			for (Jogador jogador : time.getJodadorList()) {
				if (jogador.getNivelHabilidade() > melhor.getNivelHabilidade()) {
					melhor = jogador;
				}
			}
			return melhor.getId();
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = buscarTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException("Time não encontrado!");
		} else {
			Jogador maisvelho = buscarJogador(buscarJogadoresDoTime(idTime).get(0));
			for (Jogador jogador : time.getJodadorList()) {
				if (0 > jogador.getDataNascimento().compareTo(maisvelho.getDataNascimento())) {
					maisvelho = jogador;
				}
			}
			return maisvelho.getId();
		}
	}

	public List<Long> buscarTimes() {

		List<Long> buscaIdTimes = new ArrayList<>();
		for (Time time : times) {
			buscaIdTimes.add(time.getId());
		}

		return buscaIdTimes;
//		throw new UnsupportedOperationException();
	}

	public Time buscarTime(Long idTime) {
		for (Time time : times) {
			if (time.getId() == idTime) {
				return time;
			}
		}
		return null;
	}

	public List<Jogador> buscarTodosJogador() {
		List<Jogador> jogadores = new ArrayList<>();
		for (Time time : times) {
			for (Jogador jogador : time.getJodadorList()) {
				jogadores.add(jogador);

			}
		}
		if(jogadores.isEmpty()){
			return null;
		}else{
			return jogadores;
		}

	}


	public Jogador buscarJogador(Long id) {
		for (Time time : times) {
			for (Jogador jogador : time.getJodadorList()) {
				if (jogador.getId() == id) {
					return jogador;
				}
			}
		}
		return null;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscarTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException("Time não encontrado!");
		} else {
			Jogador maior = buscarJogador(buscarJogadoresDoTime(idTime).get(0));
			for (Jogador jogador : time.getJodadorList()) {
				if (1 == jogador.getSalario().compareTo(maior.getSalario())) {
					maior = jogador;
				}
			}
			return maior.getId();
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		if (jogador == null) {
			throw new JogadorNaoEncontradoException("Jogador nao encontrado!");
		} else {
			return jogador.getSalario();
		}

	}

	public List<Long> buscarTopJogadores(Integer top) {


		List<TopJogador> topsList = new ArrayList<>();
		List<Long> idjogadore = new ArrayList<>();
		if(buscarTodosJogador()==null){
			return idjogadore;
		}else {

			for (Time time : times) {
				for (Jogador jogador : time.getJodadorList()) {
					topsList.add(new TopJogador(jogador.getId(), jogador.getNivelHabilidade()));
					System.out.println("Jogador: " + jogador.getId() + " poder:" + jogador.getNivelHabilidade());
				}
			}

//		topsList.sort(Comparator.comparingLong(TopJogador::getId).reversed());
			topsList.sort(Comparator.comparingInt(TopJogador::getNivelHabilidade).reversed());


			for (Integer i = 0; i < top; i++) {
				idjogadore.add(topsList.get(i).getId());

			}
			System.out.println(idjogadore);
//		throw new UnsupportedOperationException();
			return idjogadore;
		}
	}
}
