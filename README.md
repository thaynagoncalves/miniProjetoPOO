# Sistema de Cadastro e Vendas em Java

Este projeto consiste em um sistema simples de gerenciamento de clientes, produtos e emissão de notas fiscais, utilizando o paradigma de **programação orientada a objetos (POO)** em Java. Ele funciona por meio de menus interativos no console, com estrutura modular e separação de responsabilidades.

## Participantes

- **Luan Dantas Melo**
- **Natanael dos Santos**
- **Thayná Luzia Gonçalves Lima**

---

## Funcionalidades

- Cadastro de clientes (Pessoa Física e Pessoa Jurídica)
- Cadastro de produtos (Digitais, Físicos e Perecíveis)
- Emissão de notas fiscais
- Listagem de clientes, produtos e notas
- Alteração e exclusão de registros

---

## Conceitos de Programação Utilizados

### Classe Abstrata
- Cliente.java e Produto.java são classes abstratas.
  - Elas definem atributos e métodos comuns, mas não podem ser instanciadas diretamente.
  - Subclasses concretas como PessoaFisica, PessoaJuridica, ProdutoFisico, ProdutoPerecivel e ProdutoDigital herdam e implementam comportamentos específicos.

### Cast (Verificação Estática de Tipos)
- Usa instanceof ao verificar se um objeto definido no array superclasse é um objeto da subclasse.
- Exemplo:
  if (clientes[i] instanceof PessoaFisica) {
    (...)
  }
- Usado ao acessar métodos específicos de subclasses.
- Exemplo:
  PessoaFisica pf = (PessoaFisica) clientes[i];
- Esse cast permite acessar métodos como setCpf() que não existem na superclasse Cliente.

### Upcast
- Conversão implícita de uma subclasse para uma superclasse.
- Exemplo:
  Cliente cliente = new PessoaFisica(...);
- Usado para armazenar diferentes tipos de clientes no mesmo array (Cliente[] clientes), facilitando o polimorfismo.


### Downcast
- Conversão explícita de uma superclasse para uma subclasse, usada com instanceof para garantir segurança.
- Exemplos:
  if (clientes[i] instanceof PessoaFisica) {
    PessoaFisica pf = (PessoaFisica) clientes[i];
    pf.setCpf(...);
  }
- Necessário para acessar métodos específicos da subclasse, como setCpf() ou setCnpj().

--

## Observações Finais

O projeto aplica conceitos fundamentais de POO como herança, abstração, polimorfismo e encapsulamento, promovendo um código reutilizável e organizado. O uso de classes abstratas e casting foi essencial para tratar diferentes tipos de clientes e produtos de forma genérica, mas mantendo comportamentos específicos quando necessário.
