import java.util.*;

// Classe base para pessoas
abstract class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

// Classe Paciente herda Pessoa
class Paciente extends Pessoa {
    private String cpf;
    private String prioridade;

    public Paciente(String nome, int idade, String cpf, String prioridade) {
        super(nome, idade);
        this.cpf = cpf;
        this.prioridade = prioridade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ", Idade: " + idade + ", Prioridade: " + prioridade + ")";
    }
}

// Classe Atendimento
class Atendimento {
    private Paciente paciente;
    private Date dataHora;
    private String status;

    public Atendimento(Paciente paciente, String status) {
        this.paciente = paciente;
        this.status = status;
        this.dataHora = new Date();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return "Atendimento de " + paciente.getNome() + " em " + dataHora + " - Status: " + status;
    }
}

// Classe Sistema
class SistemaHospitalar {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

    public void registrarPaciente(Paciente paciente) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(paciente.getCpf())) {
                System.out.println("CPF já cadastrado!");
                return;
            }
        }
        pacientes.add(paciente);
        System.out.println("Paciente registrado com sucesso.");
    }

    public void listarPacientes() {
        System.out.println("=== Lista de Pacientes ===");
        for (Paciente p : pacientes) {
            System.out.println(p);
        }
    }

    public void iniciarAtendimento(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                Atendimento atendimento = new Atendimento(p, "Em andamento");
                atendimentos.add(atendimento);
                System.out.println("Atendimento iniciado: " + atendimento);
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public void listarAtendimentos() {
        System.out.println("=== Histórico de Atendimentos ===");
        for (Atendimento a : atendimentos) {
            System.out.println(a);
        }
    }
}

// Classe Main
public class SistemaPrincipal {
    public static void main(String[] args) {
        SistemaHospitalar sistema = new SistemaHospitalar();

        Paciente p1 = new Paciente("João Silva", 45, "12345678900", "Alta");
        Paciente p2 = new Paciente("Maria Oliveira", 30, "09876543210", "Média");

        sistema.registrarPaciente(p1);
        sistema.registrarPaciente(p2);
        sistema.listarPacientes();

        sistema.iniciarAtendimento("12345678900");
        sistema.iniciarAtendimento("11111111111"); // CPF não cadastrado

        sistema.listarAtendimentos();
    }
}
