package eventos.dominio;

public class Organizador {
    private Long id;
    private String nome;
    private String email;
    private String setor;
    
    public Organizador() {
    }

    public Organizador(String nome, String email, String setor) {
        setNome(nome);
        setEmail(email);    
        setSetor(setor);
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (nome.length() > 100) {
            throw new IllegalArgumentException("Nome não pode ter mais de 100 caracteres.");
        }
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
        }
        if (email.length() > 120) {
            throw new IllegalArgumentException("Email não pode ter mais de 120 caracteres.");
        }
        if (!email.matches("^[^\\s@]+@[^\\s@]+$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email.trim();
    }
    public String getSetor() {
        return setor;
    }
    
    public void setSetor(String setor) {
        if (setor == null || setor.trim().isEmpty()) {
            throw new IllegalArgumentException("Setor não pode ser nulo ou vazio.");
        }
        if (setor.length() > 80) {
            throw new IllegalArgumentException("Setor não pode ter mais de 80 caracteres.");
        }
        this.setor = setor.trim();
    }
}
