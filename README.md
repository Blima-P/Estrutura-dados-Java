# Sistema hospitalar em Java

Projeto de estudo de programacao orientada a objetos e colecoes.
Simula cadastro de pacientes e inicio de atendimentos em memoria.
Nao e um sistema para uso hospitalar real.

## O que esta implementado

- Cadastro de pacientes com verificacao de CPF duplicado.
- Listagem de pacientes.
- Inicio de atendimento por CPF, com mensagem quando o paciente nao existe.
- Historico de atendimentos com data, hora e status.
- Exemplo executavel com dois pacientes ficticios em `SistemaPrincipal.java`.

## Estruturas e conceitos

| Elemento | Uso |
|---|---|
| `Pessoa` | Classe abstrata com nome e idade |
| `Paciente` | Heranca de `Pessoa`, com CPF e prioridade |
| `Atendimento` | Associacao a um paciente, data e status |
| `SistemaHospitalar` | Operacoes de cadastro, consulta e atendimento |
| `List` / `ArrayList` | Armazenamento de pacientes e atendimentos |

As buscas por CPF percorrem a lista: complexidade O(n).
A prioridade e apenas um atributo; nao existe fila de prioridade implementada.

## Como executar

Requer um JDK instalado. O exemplo foi executado com Java 17.
Nao utiliza Maven, Gradle ou bibliotecas externas.

No PowerShell, dentro da pasta do repositorio:

```powershell
javac -encoding UTF-8 SistemaPrincipal.java
java SistemaPrincipal
```

O programa executa um roteiro fixo: registra os pacientes, lista o cadastro,
inicia um atendimento valido, tenta atender um CPF inexistente e mostra o
historico. Nao possui menu interativo.

## Limitacoes

- Os dados sao perdidos ao encerrar o programa; nao ha banco de dados.
- A verificacao de duplicidade compara strings, sem validar os digitos do CPF.
- Nao ha ordenacao por prioridade, API, interface grafica ou autenticacao.
- O exemplo nao coleta dados de pacientes reais.

## Licenca

[MIT](LICENSE).
