package eventos.dominio;

import java.time.LocalTime;

public class Programacao {
private Long id;
private String titulo;
private LocalTime horario;
private String responsavel;
private Evento evento;

public Programacao() {
}

public Programacao(String titulo, LocalTime horario, String responsavel, Evento evento) {
    setTitulo(titulo);
    setHorario(horario);
    setResponsavel(responsavel);
    this.evento = evento;

}

public Long getId() {
    return id;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty()) {
        throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
    }
    if (titulo.length() > 120) {
        throw new IllegalArgumentException("Título não pode ter mais de 120 caracteres.");
    }
    this.titulo = titulo.trim();
}

public LocalTime getHorario() {
    return horario;
}

public void setHorario(LocalTime horario) {
    if (horario == null) {
        throw new IllegalArgumentException("Horário não pode ser nulo.");
    }
    this.horario = horario;
}

public String getResponsavel() {
    return responsavel;
}
public void setResponsavel(String responsavel) {
    if (responsavel == null || responsavel.trim().isEmpty()) {
        this.responsavel= "a definir";
        return; 
    }
}

public Evento getEvento() {
    return evento;
}

}
